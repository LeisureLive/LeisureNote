package com.leisure.note.algorithm.week1.day2;

import java.util.Arrays;

/**
 * @author jie.he
 * @version 1.0.0
 * @since 2026/03/24 00:07
 */
public class ArrayQuestion2 {

  public int[] sumTwoNumber(int[] arr, int target) {
    int i = 1;
    int j = arr.length;
    while (true) {
      if (arr[i-1] + arr[j-1] > target) {
        j--;
      } else if (arr[i-1] + arr[j-1] < target) {
        i++;
      } else {
        break;
      }
    }

    return new int[]{i, j};
  }


  public static void main(String[] args) {
    ArrayQuestion2 arrayQuestion2 = new ArrayQuestion2();
    int[] numbers = new int[]{2, 7, 11, 15};
    int[] result = arrayQuestion2.sumTwoNumber(numbers, 9);
    System.out.println(Arrays.toString(result));
  }

}
