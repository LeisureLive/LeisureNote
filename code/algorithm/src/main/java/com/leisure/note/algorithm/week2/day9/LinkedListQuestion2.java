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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>链表专题：拼接 / {@code dummy node} 模板</li>
   * <li>核心信号：有两个有序链表，需要持续取“当前更小”的节点接到结果链表尾部</li>
   * <li>模板主线：`dummy` 统一处理头节点，`cur` 永远指向结果链表的尾节点</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>先准备一个哑节点 {@code dummy}，避免单独处理新链表头节点。</li>
   * <li>双指针分别指向两条链表头部，每轮把值更小的节点接到 {@code cur.next}。</li>
   * <li>被接走的链表向后移动一位，结果链表尾指针 {@code cur} 也同步后移。</li>
   * <li>其中一条链表耗尽后，另一条剩余部分可以整体直接挂到尾部。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>题目要求升序，比较时要先接较小值，而不是较大值。</li>
   * <li>每次接完节点后，都要同步移动 {@code cur}，否则后续会覆盖链表。</li>
   * <li>最后返回的是 {@code dummy.next}，因为 {@code dummy} 本身不属于结果。</li>
   * </ul>
   */
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    ListNode l1 = list1, l2 = list2;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }

    if (l1 != null) {
      cur.next = l1;
    } else {
      cur.next = l2;
    }

    return dummy.next;
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
