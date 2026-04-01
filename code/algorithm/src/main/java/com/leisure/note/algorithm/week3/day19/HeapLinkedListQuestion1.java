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
