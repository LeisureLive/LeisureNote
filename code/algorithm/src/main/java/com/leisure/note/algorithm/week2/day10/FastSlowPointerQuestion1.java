package com.leisure.note.algorithm.week2.day10;

/**
 * 题目：141. 环形链表
 *
 * <p>题目描述：
 *
 * <p>给你一个链表的头节点 {@code head}，判断链表中是否有环。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean hasCycle(ListNode head)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练快慢指针判环模板</li>
 * <li>重点说清为什么快慢指针最终会相遇</li>
 * </ul>
 */
public class FastSlowPointerQuestion1 {

  public boolean hasCycle(ListNode head) {
    throw new UnsupportedOperationException("TODO: implement hasCycle");
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
