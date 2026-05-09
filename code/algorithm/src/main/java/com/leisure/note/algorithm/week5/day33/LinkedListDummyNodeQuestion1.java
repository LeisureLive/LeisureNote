package com.leisure.note.algorithm.week5.day33;

/**
 * Day33 链表模式题：{@code dummy node}。
 *
 * <p>这组题聚焦两件事：
 *
 * <ul>
 * <li>头节点可能变化时，如何用 {@code dummy node} 统一前驱处理逻辑。</li>
 * <li>链表局部拼接时，如何稳定维护“前驱节点 - 当前片段 - 后续片段”的连接关系。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现，便于按 `00_algorithm_problem_rules.md` 的答题顺序自行作答。
 */
public class LinkedListDummyNodeQuestion1 {

  /**
   * 203. 移除链表元素
   *
   * <p>题目描述：
   *
   * <p>给你一个链表的头节点 {@code head} 和一个整数 {@code val}，请你删除链表中所有满足
   * {@code Node.val == val} 的节点，并返回新的头节点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public ListNode removeElements(ListNode head, int val)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [1,2,6,3,4,5,6], val = 6
   * 输出：[1,2,3,4,5]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [], val = 1
   * 输出：[]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>优先用原地改指针完成，不新建结果链表</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>{@code dummy node} 模式的入门代表题。</li>
   * <li>核心点不是“删除值等于 val 的节点”本身，而是“头节点也可能被删时，如何统一处理前驱”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认头节点是否也可能被删除，如果会，就优先引入 {@code dummy node}。</li>
   * <li>定义清楚当前遍历指针到底是“当前节点”还是“当前节点的前驱”。</li>
   * <li>先说清删除条件成立时怎么改指针，再写循环。</li>
   * <li>最后检查连续删除、空链表、全部删除这几类边界。</li>
   * </ol>
   */
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    // 这题的关键不是“找到值等于 val 的节点”，而是统一处理“头节点也可能被删”的场景。
    // 用 dummyHead 后，删除头节点和删除中间节点都变成了“改前驱的 next”这一种操作。
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode pre = dummyHead;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val == val) {
        ListNode temp = cur.next;
        // 删除当前节点时，只移动 cur，不移动 pre。
        // 因为删完以后，pre 的下一个节点变成了新的待检查节点，连续删除时仍然要从这个位置继续判断。
        pre.next = temp;
        // 主动断开被删除节点和原链表的连接，方便本地调试时观察链路是否正确。
        cur.next = null;
        cur = temp;
      } else {
        // 当前节点保留时，pre 和 cur 才同步向后推进。
        cur = cur.next;
        pre = pre.next;
      }
    }

    return dummyHead.next;
  }

  /**
   * 24. 两两交换链表中的节点
   *
   * <p>题目描述：
   *
   * <p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部值的情况下完成本题，
   * 只能进行节点交换。
   *
   * <p>方法签名：
   *
   * <pre>
   * public ListNode swapPairs(ListNode head)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [1,2,3,4]
   * 输出：[2,1,4,3]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = []
   * 输出：[]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>不能通过交换节点值来规避指针操作</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>{@code dummy node} 模式下的局部拼接题。</li>
   * <li>它很适合训练“前驱、第一节点、第二节点、后继片段”四段关系的重连顺序。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先画出一组待交换节点：{@code pre -> first -> second -> nextPair}。</li>
   * <li>先保存后续片段，再思考本轮交换后四段链路如何重连。</li>
   * <li>写完一轮交换后，明确下一轮的 {@code pre} 应该推进到哪里。</li>
   * <li>最后检查奇数长度链表时，最后一个节点是否被正确保留。</li>
   * </ol>
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    // dummy 负责统一处理“第一组交换后头节点变化”的情况。
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // pre 始终指向“当前待交换这一组”的前驱节点。
    ListNode pre = dummy;
    while (pre != null && pre.next != null && pre.next.next != null) {
      ListNode node1 = pre.next;
      ListNode node2 = pre.next.next;
      // 先保存下一组的起点，避免当前两节点重连后丢失后续链路。
      ListNode next = node2.next;

      // 当前一组重连成：pre -> node2 -> node1 -> next。
      pre.next = node2;
      node2.next = node1;
      node1.next = next;
      // 一轮交换后，node1 会变成这一组的尾节点，下一轮要从它后面继续处理。
      pre = pre.next.next;
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
