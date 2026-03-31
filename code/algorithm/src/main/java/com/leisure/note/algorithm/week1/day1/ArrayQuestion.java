package com.leisure.note.algorithm.week1.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author jie.he
 * @version 1.0.0
 * @since 2026/03/22 23:25
 */
public class ArrayQuestion {

  public int[] productExceptSelf(int[] arr) {
    // arr1[i] 表示 arr[0..i] 的乘积（包含 arr[i]）
    // arr2[j] 表示 arr[j..n-1] 的乘积（包含 arr[j]）
    int[] arr1 = new int[arr.length];
    int[] arr2 = new int[arr.length];

    arr1[0] = arr[0];
    arr2[arr.length - 1] = arr[arr.length -1];
    for (int i = 1; i < arr.length; i++) {
      arr1[i] = arr1[i - 1] * arr[i];
    }

    for (int j = arr.length - 2; j >= 0; j--) {
      arr2[j] = arr2[j + 1] * arr[j];
    }

    int[] result = new int[arr.length];
    for (int k = 0; k < arr.length; k++) {
      if (k -1 < 0) {
        result[k] = arr2[k + 1];
      } else if (k + 1 >= arr.length) {
        result[k] = arr1[k - 1];
      } else {
        result[k] = arr1[k - 1] * arr2[k + 1];
      }
    }
    return result;
  }

  public int maxContinuousSequence(int[] arr) {
    if (arr.length <= 1) {
      return arr.length;
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    int maxSequenceLength = 1;
    for (int j = 0; j < arr.length; j++) {
     int base = arr[j];
     if (set.contains(base -1)) {
        continue;
     }

     int tempSequenceLength = 1;
     while (set.contains(base + 1)) {
       base = base +1;
       tempSequenceLength++;
     }
     if (tempSequenceLength > maxSequenceLength) {
       maxSequenceLength = tempSequenceLength;
     }
    }

    return maxSequenceLength;
  }

  public static void main(String[] args) {
    ArrayQuestion question = new ArrayQuestion();
    int[] arr2 = {100, 4, 200, 1, 3, 2};
    System.out.println(question.maxContinuousSequence(arr2));
  }


}
