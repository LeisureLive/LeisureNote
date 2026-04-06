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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>链表专题：快慢指针制造间距 + {@code dummy node}</li>
   * <li>核心信号：题目要求删除倒数第 {@code n} 个节点，本质上是在找“目标节点的前一个节点”</li>
   * <li>模板主线：先让 {@code fast} 和 {@code slow} 拉开固定间距，再同步前进</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>先准备哑节点 {@code dummy}，这样即使删除头节点，也能统一用“删前驱的 next”处理。</li>
   * <li>先让 {@code fast} 从 {@code dummy} 出发走 {@code n} 步，制造固定间距。</li>
   * <li>之后让 {@code fast}、{@code slow} 一起移动，直到 {@code fast} 走到链表尾节点。</li>
   * <li>此时 {@code slow} 正好停在待删除节点的前一个位置，执行 {@code slow.next = slow.next.next} 即可。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>这题删除的不是“倒数第 n 个节点本身”，而是要先找到它的前驱节点。</li>
   * <li>使用 {@code dummy node} 的关键价值是统一删除头节点和删除中间节点两种情况。</li>
   * <li>快慢指针间距是从 {@code dummy} 开始制造的，最后删除时改的是 {@code slow.next}。</li>
   * </ul>
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 1; i <= n; i++) {
      if (fast.next == null) {
        throw new RuntimeException("ListNode size error");
      }
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
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
