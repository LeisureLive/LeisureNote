package com.leisure.note.algorithm.week3.day19;

/**
 * 题目：23. 合并 K 个升序链表
 *
 * <p>题目描述：
 *
 * <p>给你一个链表数组，每个链表都已经按升序排列，请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * <p>方法签名：
 *
 * <pre>
 * public ListNode mergeKLists(ListNode[] lists)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：lists = []
 * 输出：[]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是优先队列，整体复杂度尽量做到 {@code O(N log k)}，其中 {@code N} 是总节点数</li>
 * <li>允许使用额外空间，例如最小堆</li>
 * <li>输入中的某些链表可能为空</li>
 * <li>返回的是合并后的新链表头节点；如果所有链表都为空，返回 {@code null}</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练堆和链表结合</li>
 * <li>重点说清为什么优先队列适合每次取当前最小节点</li>
 * </ul>
 */
public class HeapLinkedListQuestion1 {

  public ListNode mergeKLists(ListNode[] lists) {
    throw new UnsupportedOperationException("TODO: implement mergeKLists");
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
