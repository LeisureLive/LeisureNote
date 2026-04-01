package com.leisure.note.algorithm.week2.day10;

/**
 * 题目：19. 删除链表的倒数第 N 个结点
 *
 * <p>题目描述：
 *
 * <p>给你一个链表，删除链表的倒数第 {@code n} 个结点，并且返回链表的头结点。
 *
 * <p>方法签名：
 *
 * <pre>
 * public ListNode removeNthFromEnd(ListNode head, int n)
 * </pre>
 *
 * <p>这道题为什么放在 Day10：
 *
 * <ul>
 * <li>作为 `141. 环形链表` 的加练题</li>
 * <li>训练快慢指针制造间距，以及 `dummy node` 的配合使用</li>
 * </ul>
 */
public class FastSlowPointerQuestion2 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    throw new UnsupportedOperationException("TODO: implement removeNthFromEnd");
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
