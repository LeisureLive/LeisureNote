package com.leisure.note.algorithm.week2.day9;

/**
 * 题目：206. 反转链表
 *
 * <p>题目描述：
 *
 * <p>给你单链表的头节点 {@code head}，请你反转链表，并返回反转后的链表。
 *
 * <p>方法签名：
 *
 * <pre>
 * public ListNode reverseList(ListNode head)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练链表原地反转模板</li>
 * <li>重点说清“先保存 next，再改指针”</li>
 * </ul>
 */
public class LinkedListQuestion1 {

  public ListNode reverseList(ListNode head) {
    throw new UnsupportedOperationException("TODO: implement reverseList");
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
