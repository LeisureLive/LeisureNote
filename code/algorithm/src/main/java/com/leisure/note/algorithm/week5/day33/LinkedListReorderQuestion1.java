package com.leisure.note.algorithm.week5.day33;

/**
 * Day33 链表模式题：合并与重排。
 *
 * <p>这组题的重点不是某一个孤立动作，而是把多条基础主线组合起来：
 *
 * <ul>
 * <li>找中点</li>
 * <li>局部反转</li>
 * <li>按规则交替拼接或分段重连</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class LinkedListReorderQuestion1 {

  /**
   * 143. 重排链表
   *
   * <p>题目描述：
   *
   * <p>给定一个单链表 {@code L} 的头节点 {@code head}，请将其重排后变为：
   * {@code L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...}
   *
   * <p>你不能只是单纯地改变节点内部的值，而是需要实际进行节点交换。
   *
   * <p>方法签名：
   *
   * <pre>
   * public void reorderList(ListNode head)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [1,2,3,4]
   * 输出：[1,4,2,3]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [1,2,3,4,5]
   * 输出：[1,5,2,4,3]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>重点训练“找中点 + 反转后半段 + 交替合并”的组合能力</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>合并与重排模式的高频主战题。</li>
   * <li>它几乎把链表专题里的三条核心主线串到了一起，是非常典型的综合题。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先把整题拆成三个子问题，而不是直接硬写整段重排逻辑。</li>
   * <li>先找到中点，再断开前后两段，避免后续反转和合并时形成环。</li>
   * <li>反转后半段后，再按“前一段一个、后一段一个”的顺序交替拼接。</li>
   * <li>最后检查奇数长度链表时，中点是否被正确保留在结尾。</li>
   * </ol>
   */
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    // 第一步：找前半段尾节点。
    // 如果节点总数为偶数，这里要停在“靠前中点”，这样后半段长度不会比前半段更长，
    // 后面的交替拼接才更自然。
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // 第二步：反转后半段。
    // 这里一定要先把 slow.next 置为 null，显式断开前后两段。
    // 这是重排题里最容易漏的动作之一；如果不断开，后面交替合并时很容易把链表接成环。
    ListNode cur = slow.next;
    slow.next = null;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    // 第三步：交替合并两段链表。
    // prev 是反转后的后半段头节点，head 是前半段头节点。
    ListNode node1 = head;
    ListNode node2 = prev;
    while (node1 != null && node2 != null) {
      ListNode next1 = node1.next;
      ListNode next2 = node2.next;
      node1.next = node2;
      node2.next = next1;
      node1 = next1;
      node2 = next2;
    }

  }

  /**
   * 328. 奇偶链表
   *
   * <p>题目描述：
   *
   * <p>给定单链表的头节点 {@code head}，请将所有索引为奇数的节点和索引为偶数的节点分别分组，
   * 保持各自原有相对顺序，并返回重新排序后的链表。
   *
   * <p>这里的“奇偶”指的是节点编号而不是节点值。
   *
   * <p>方法签名：
   *
   * <pre>
   * public ListNode oddEvenList(ListNode head)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [1,2,3,4,5]
   * 输出：[1,3,5,2,4]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [2,1,3,5,6,4,7]
   * 输出：[2,3,6,7,1,5,4]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>保持奇数组和偶数组内部的相对顺序不变</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>合并与重排模式下的分段拼接题。</li>
   * <li>它不像 `143` 那样需要反转，但非常适合训练“拆成两条子链，再拼回去”的稳定写法。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认题目要求按“节点位置”分奇偶，不是按节点值分奇偶。</li>
   * <li>定义奇链尾和偶链尾分别是谁，并思考每轮推进后谁负责接下一个节点。</li>
   * <li>拆分过程中就保持各自相对顺序，不要最后再额外排序。</li>
   * <li>最后把奇链尾接回偶链头，并检查空链表、单节点、双节点边界。</li>
   * </ol>
   */
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }

    // dummy.next 作为偶数位子链表的头节点，最后再拼回奇数位子链表尾部。
    ListNode dummy = new ListNode(0);
    ListNode cur = head;
    ListNode prev = null;
    ListNode node2 = dummy;
    while (cur != null && cur.next != null) {
      // node 是当前要摘出来的偶数位节点。
      ListNode node = cur.next;
      // cur 跳过偶数位，直接接到下一个奇数位节点上。
      cur.next = cur.next.next;
      prev = cur;
      cur = cur.next;
      node.next = null;
      // 偶数位子链表要保持原相对顺序，所以每次都是尾插。
      node2.next = node;
      node2 = node;
    }

    // 当总共奇数个节点时， cur!=null, 为奇数链表的最后一个节点。
    // 当总共偶数个节点时， cur == null, prev 是奇数链表最后一个节点
    ListNode tail = cur;
    if (tail == null) {
      tail = prev;
    }

    tail.next = dummy.next;
    return head;
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
