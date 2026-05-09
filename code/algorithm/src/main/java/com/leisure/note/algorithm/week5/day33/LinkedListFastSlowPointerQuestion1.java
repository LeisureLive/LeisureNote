package com.leisure.note.algorithm.week5.day33;

/**
 * Day33 链表模式题：快慢指针。
 *
 * <p>这组题聚焦两类高频用法：
 *
 * <ul>
 * <li>通过速度差或步数差定位特殊节点，例如中点、倒数节点、环入口。</li>
 * <li>先建立“相对位置关系”，再利用这层关系做推导，而不是死记固定模板。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class LinkedListFastSlowPointerQuestion1 {

  /**
   * 876. 链表的中间结点
   *
   * <p>题目描述：
   *
   * <p>给定一个头结点为 {@code head} 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public ListNode middleNode(ListNode head)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [1,2,3,4,5]
   * 输出：[3,4,5]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [1,2,3,4,5,6]
   * 输出：[4,5,6]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>重点解释为什么当快指针走到尾部时，慢指针正好停在中点</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>快慢指针模式的基础定位题。</li>
   * <li>它比判环更简单，但更适合训练“速度差为什么能定位目标节点”的解释能力。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先明确题目要返回的是前中点还是后中点，本题要求偶数长度时返回后中点。</li>
   * <li>定义 {@code slow} 和 {@code fast} 的步长，并据此设计循环条件。</li>
   * <li>先口头解释一次：快指针每轮多走一步，所以当它到终点时，慢指针正好走了一半。</li>
   * <li>最后检查长度为 1、2 的边界是否符合题意。</li>
   * </ol>
   */
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    // 这里 fast 和 slow 都从 head 出发，且 fast 每轮比 slow 多走一步。
    // 当 fast 走到链表尾部时，slow 正好停在中点；偶数长度时会自然停在“后中点”。
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  /**
   * 142. 环形链表 II
   *
   * <p>题目描述：
   *
   * <p>给定一个链表的头节点 {@code head}，返回链表开始入环的第一个节点。如果链表无环，则返回 {@code null}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public ListNode detectCycle(ListNode head)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [3,2,0,-4], pos = 1
   * 输出：返回索引为 1 的链表节点
   * 解释：链表尾部连接到第二个节点。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [1,2], pos = 0
   * 输出：返回索引为 0 的链表节点
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>重点说明“相遇后一个指针回到头节点，再同步前进为何会在入口相遇”</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>快慢指针模式的进阶代表题。</li>
   * <li>它是 `141` 判环题的升级版，重点已经从“能否相遇”变成“如何利用相遇关系定位入口”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先判断是否有环，没有环时直接返回 {@code null}。</li>
   * <li>有环后，不要直接背结论，先把“头到入口距离”“入口到相遇点距离”“环长度”画出来。</li>
   * <li>再说明为什么一个指针回到头部、另一个留在相遇点后，同速前进会在入口相遇。</li>
   * <li>最后检查空链表、单节点、自环这几类边界。</li>
   * </ol>
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    // 第一阶段先做 Floyd 判环：有环时快慢指针会在环内相遇。
    ListNode slow = head;
    ListNode fast = head;
    ListNode node = null;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        node = slow;
        break;
      }
    }

    if (node == null) {
      return null;
    }

    // 第二阶段定位环入口：
    // 一个指针回到头节点，另一个留在相遇点，两者同速前进，会在入口再次相遇。
    ListNode cur = head;
    while (true) {
      if (cur == node) {
        break;
      }
      cur = cur.next;
      node = node.next;
    }
    return cur;
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
