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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>链表专题：快慢指针判环模板</li>
   * <li>核心信号：链表可能成环，要求在不使用额外空间的前提下判断是否有环</li>
   * <li>模板主线：`slow` 每次走一步，`fast` 每次走两步</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>如果链表无环，快指针最终会先走到 {@code null}，循环结束直接返回 {@code false}。</li>
   * <li>如果链表有环，快指针每轮都比慢指针多走一步，二者在环内的距离会不断缩小。</li>
   * <li>一旦两者指向同一个节点，就说明链表存在环。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>循环条件必须先判断 {@code fast != null && fast.next != null}，否则快指针可能空指针。</li>
   * <li>判断相遇时比较的是“节点引用是否相同”，不是节点值是否相同。</li>
   * <li>如果快慢指针都从 {@code head} 出发，通常要先移动再比较，否则一开始就会误判相遇。</li>
   * </ul>
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
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
