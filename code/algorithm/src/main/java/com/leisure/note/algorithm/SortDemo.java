package com.leisure.note.algorithm;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jie.he
 * @version 1.0.0
 * @since 2025/06/23 22:33
 */
public class SortDemo {

  /**
   * 冒泡排序
   * <p>
   * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
   * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
   * 针对所有的元素重复以上的步骤，除了最后一个；
   * 重复步骤 1~3，直到排序完成。
   */
  private static int[] bubbleSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    for (int i = arr.length - 1; i > 0; i--) {
      boolean flag = true;
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          flag = false;
        }
      }

      if (flag) {
        break;
      }
    }
    return arr;
  }

  /**
   * 选择排序
   * <p>
   * 工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
   * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
   * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
   * <p>
   * 步骤
   * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
   * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
   * 重复第 2 步，直到所有元素均排序完毕。
   */
  private static int[] selectionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }

    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        swap(arr, i, minIndex);
      }
    }
    return arr;
  }

  private static int[] insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int current = arr[i];
      int prev = i - 1;
      while (prev >= 0 && arr[prev] > current) {
        arr[prev + 1] = arr[prev];
        prev -= 1;
      }
      arr[prev + 1] = current;
    }
    return arr;
  }

  /**
   * 希尔排序
   * <p>
   * 实际变种的插入排序
   * 1、先取 arr.lenth / 2 作为 gap， 将数组切分为 N 个子数组，进行插入排序
   * 2、缩小 gap = gap / 2, 再次对子数组进行插入排序
   * 3、直到 gap = 1 即为常规的插入排序，最终 gap = 0 时结束
   */
  private static int[] shellSort(int[] arr) {
    int gap = arr.length / 2;
    while (gap > 0) {
      for (int i = 0; i < gap; i++) {
        for (int j = i + gap; j < arr.length; j += gap) {
          int current = arr[j];
          int prev = j - gap;
          while (prev >= 0 && arr[prev] > current) {
            arr[prev + gap] = arr[prev];
            prev -= gap;
          }
          arr[prev + gap] = current;
        }
      }
      gap = gap / 2;
    }
    return arr;
  }

  /**
   * 归并排序。
   * <p>
   * 采用分治法：
   * 1、如果输入内只有一个元素，则直接返回，否则将长度为 $n$ 的输入序列分成两个长度为 $n/2$ 的子序列；
   * 2、分别对这两个子序列进行归并排序，使子序列变为有序状态；
   * 3、设定两个指针，分别指向两个已经排序子序列的起始位置；
   * 4、比较两个指针所指向的元素，选择相对小的元素放入到合并空间（用于存放排序结果），并移动指针到下一位置；
   * 5、重复步骤 3 ~ 4 直到某一指针达到序列尾；
   * 6、将另一序列剩下的所有元素直接复制到合并序列尾。
   */
  private static int[] mergeSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    int middle = arr.length / 2;
    int[] arr_1 = Arrays.copyOfRange(arr, 0, middle);
    int[] arr_2 = Arrays.copyOfRange(arr, middle, arr.length);
    return merge(mergeSort(arr_1), mergeSort(arr_2));
  }

  private static int[] merge(int[] arr1, int[] arr2) {
    int[] sorted_arr = new int[arr1.length + arr2.length];
    int idx = 0, idx_1 = 0, idx_2 = 0;
    while (idx_1 < arr1.length && idx_2 < arr2.length) {
      if (arr1[idx_1] <= arr2[idx_2]) {
        sorted_arr[idx] = arr1[idx_1];
        idx++;
        idx_1++;
      } else {
        sorted_arr[idx] = arr2[idx_2];
        idx++;
        idx_2++;
      }
    }
    if (idx_1 < arr1.length) {
      while (idx_1 < arr1.length) {
        sorted_arr[idx] = arr1[idx_1];
        idx++;
        idx_1++;
      }
    }

    if (idx_2 < arr2.length) {
      while (idx_2 < arr2.length) {
        sorted_arr[idx] = arr2[idx_2];
        idx++;
        idx_2++;
      }
    }
    return sorted_arr;
  }

  /**
   * 快速排序，分治法。与归并排序不同
   * 归并排序：先递归到最小子数组开始处理，然后对2个子数组进行合并。逐渐合并到最终的结果
   * 快速排序: 先整体处理，然后按 pivot 分隔分别处理左右子数组，处理到最后子数组只有1个元素就是最终结果
   * <p>
   * <p>
   * 1、从序列中随机挑出一个元素，做为 “基准”(pivot)；
   * 2、重新排列序列，将所有比基准值小的元素摆放在基准前面，所有比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个操作结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
   * 3、递归地把小于基准值元素的子序列和大于基准值元素的子序列进行快速排序。
   */
  private static int[] quickSort(int[] arr) {
    sortArray(arr, 0, arr.length - 1);
    return arr;
  }

  private static void sortArray(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int p = partition(arr, left, right);
    sortArray(arr, left, p - 1);
    sortArray(arr, p + 1, right);
  }

  private static int partition(int[] arr, int left, int right) {
    // 随机数， 【0, right-left】 + left
    int pivot = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
    swap(arr, left, pivot);
    int pv = arr[left];
    int i = left + 1;
    int j = right;
    while (i <= j) {
      while (arr[i] < pv) {
        i++;
      }
      while (arr[j] > pv) {
        j--;
      }
      if (i <= j) {
        swap(arr, i, j);
        i++;
        j--;
      }
    }
    swap(arr, left, j);
    return j;
  }

  /**
   * 堆排序。
   * <p>
   * 堆可以用数组存储
   * 每个非叶子节点的左右子节点索引分别是 2i+1 2i+2
   * 每个非根节点的父节点为 (i - 1) / 2
   * <p>
   * 堆排序步骤
   * 1、构建最大堆
   * 2、将第一个元素和不稳定区最后一个元素交换，然后不稳定区长度-1
   * 3、将交换后的不稳定区进行 siftdown 构建最大堆
   * 4、继续执行 23两步，直到不稳定区长度为 0
   *
   * @param arr
   * @return
   */
  private static int[] heapSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }

    // 构建大顶堆
    for (int i = (arr.length - 2) / 2; i >= 0; i--) {
      siftdown(arr, i, arr.length);
    }

    int right = arr.length - 1;
    while (right > 0) {
      swap(arr, 0, right);
      siftdown(arr, 0, right);
      right--;
    }
    return arr;
  }

  private static void siftdown(int[] arr, int i, int len) {
    int next = i;
    while (i * 2 + 1 < len) {
      if (arr[i] < arr[i * 2 + 1]) {
        swap(arr, i, i * 2 + 1);
        next = i * 2 + 1;
      }
      if (i * 2 + 2 < len && arr[i] < arr[i * 2 + 2]) {
        swap(arr, i, i * 2 + 2);
        next = i * 2 + 2;
      }

      if (next != i) {
        i = next;
      } else {
        break;
      }
    }

  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {10, 66, 39, 26, 58, 36, 37, 41, 77, 2, 59, 3};
    int[] sortedArr = heapSort(arr);
    System.out.println(Arrays.toString(sortedArr));
  }

}
