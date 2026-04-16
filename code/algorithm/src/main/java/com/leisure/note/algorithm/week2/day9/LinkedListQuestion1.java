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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>链表专题：原地反转模板</li>
   * <li>核心信号：当前节点的 next 会被改写，所以必须先保存旧的 next</li>
   * <li>模板主线：`prev` 表示已经反转好的前半段，`cur` 表示当前待处理节点</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>每一轮先保存 {@code cur.next}，避免链表断开后丢失后续节点。</li>
   * <li>把当前节点反向指向 {@code prev}，表示把它接到已反转链表头部。</li>
   * <li>整体向前推进：{@code prev = cur}，{@code cur = next}。</li>
   * <li>循环结束时，{@code prev} 指向新的头节点，直接返回。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>循环条件要写成 {@code cur != null}，因为最后一个节点也需要参与反转。</li>
   * <li>返回值要是 {@code prev}，而不是退出循环时的 {@code cur}。</li>
   * <li>链表题一旦要改指针，优先检查“有没有先保存 next”。</li>
   * </ul>
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }

    return prev;
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
