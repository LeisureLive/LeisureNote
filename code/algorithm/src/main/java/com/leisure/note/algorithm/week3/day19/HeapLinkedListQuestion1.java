package com.leisure.note.algorithm.week3.day19;

import java.util.Comparator;
import java.util.PriorityQueue;

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
    // 这题本质是“多路有序链表归并”：堆里只放每条链表当前最小的候选节点。
    // 易错点：
    // 1. 我一开始想到过把所有节点一次性入堆，但那样没有利用“每个链表本身有序”这个条件。
    // 2. 正确做法是只把每条链表的头节点入堆，弹出一个，再把它的 next 入堆。
    if (lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(node -> node.val));
    for (ListNode node : lists) {
      if (node != null) {
        heap.add(node);
      }
    }

    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    while (!heap.isEmpty()) {
      ListNode node = heap.poll();
      // 这个节点出堆后，它所在链表里下一个节点才有资格参与全局最小值竞争。
      if (node.next != null) {
        heap.add(node.next);
      }

      cur.next = node;
      cur = cur.next;
    }

    return dummyHead.next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
