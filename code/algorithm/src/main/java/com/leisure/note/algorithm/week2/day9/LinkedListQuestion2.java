package com.leisure.note.algorithm.week2.day9;

/**
 * 题目：21. 合并两个有序链表
 *
 * <p>题目描述：
 *
 * <p>将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <p>方法签名：
 *
 * <pre>
 * public ListNode mergeTwoLists(ListNode list1, ListNode list2)
 * </pre>
 *
 * <p>这道题为什么放在 Day9：
 *
 * <ul>
 * <li>作为 `206. 反转链表` 的加练题</li>
 * <li>训练 `dummy node` 和链表拼接模板</li>
 * </ul>
 */
public class LinkedListQuestion2 {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    throw new UnsupportedOperationException("TODO: implement mergeTwoLists");
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
