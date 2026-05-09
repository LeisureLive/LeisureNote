package com.leisure.note.algorithm.week5.day33;

/**
 * Day33 链表模式题：原地反转。
 *
 * <p>这组题聚焦“反转模板如何从整段推广到局部和分组”：
 *
 * <ul>
 * <li>{@code 92} 训练区间反转，重点是局部断开与重新拼接。</li>
 * <li>{@code 25} 训练分组反转，重点是多段反转的组织能力。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class LinkedListReverseQuestion1 {

  /**
   * 92. 反转链表 II
   *
   * <p>题目描述：
   *
   * <p>给你单链表的头指针 {@code head} 和两个整数 {@code left} 和 {@code right}，其中
   * {@code left <= right}。请你反转从位置 {@code left} 到位置 {@code right} 的链表节点，返回反转后的链表。
   *
   * <p>方法签名：
   *
   * <pre>
   * public ListNode reverseBetween(ListNode head, int left, int right)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [1,2,3,4,5], left = 2, right = 4
   * 输出：[1,4,3,2,5]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [5], left = 1, right = 1
   * 输出：[5]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>要求原地改指针，不借助栈或数组</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>原地反转模式的区间版代表题。</li>
   * <li>核心不再只是 `prev-cur-next` 三指针，而是“区间外前驱、区间头、区间尾、区间外后继”四段如何重接。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先定位到待反转区间的前一个节点，判断是否需要 {@code dummy node} 统一处理头部反转。</li>
   * <li>明确这题是“局部反转 + 前后拼接”，不要一上来把整段逻辑混在一起写。</li>
   * <li>先说清反转结束后，原区间头会变成新的区间尾。</li>
   * <li>最后检查 {@code left == right}、从头开始反转等边界。</li>
   * </ol>
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null) {
      return head;
    }

    if (left == right) {
      return head;
    }

    ListNode firstTail = null;
    ListNode secondHead = null;
    ListNode secondTail = null;
    ListNode thirdHead = null;

    ListNode prev = null;
    ListNode cur = head;
    int count = 1;
    while (cur != null) {
      // left 命中时，记录第二段头节点，以及它前面的尾节点。
      if (count == left) {
        firstTail = prev;
        secondHead = cur;
      }

      // right 命中时，记录第二段尾节点，以及第三段头节点。
      if (count == right) {
        secondTail = cur;
        thirdHead = cur.next;
      }

      count++;
      prev = cur;
      cur = cur.next;
    }

    // left 超出边界，第二段为空
    if (secondHead == null) {
      return head;
    }

    // right 超出边界，取最后一个节点为第二段的 tail
    if (secondTail == null) {
      secondTail = prev;
    }

    // 断开 3 段链表。
    // 这里 secondTail.next = null 一定要无条件执行，这是你之前做错过的地方：
    // 即使 left == 1，第二段和第三段也必须先断开，否则反转时会把第三段一起卷进去。
    if (firstTail != null) {
      firstTail.next = null;
    }
    secondTail.next = null;

    // 只反转第二段，反转结束后：
    // prev 指向新的第二段头节点，secondHead 会变成新的第二段尾节点。
    prev = null;
    cur = secondHead;
    while (cur != null) {
      ListNode node = cur.next;
      cur.next = prev;
      prev = cur;
      cur = node;
    }

    // 重新拼接 3 段链表：
    // 第一段尾 -> 反转后第二段头 -> 反转后第二段尾 -> 第三段头。
    ListNode newHead;
    if (firstTail != null) {
      newHead = head;
      firstTail.next = secondTail;
    } else {
      newHead = secondTail;
    }
    secondHead.next = thirdHead;

    return newHead;
  }

  /**
   * 25. K 个一组翻转链表
   *
   * <p>题目描述：
   *
   * <p>给你链表的头节点 {@code head}，每 {@code k} 个节点一组进行翻转，请你返回修改后的链表。
   * {@code k} 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 {@code k} 的整数倍，那么请将最后剩余的节点保持原有顺序。
   *
   * <p>方法签名：
   *
   * <pre>
   * public ListNode reverseKGroup(ListNode head, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [1,2,3,4,5], k = 2
   * 输出：[2,1,4,3,5]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [1,2,3,4,5], k = 3
   * 输出：[3,2,1,4,5]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>不能只交换节点值，必须真正改链表指针</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>原地反转模式的综合验收题。</li>
   * <li>它要求把“找分组边界、局部反转、前后拼接”三件事稳定地串起来。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认每一组是否凑够 {@code k} 个，不够就原样保留。</li>
   * <li>再思考“本组前驱、本组头、本组尾、下一组头”分别是谁。</li>
   * <li>可以先抽出一个“反转区间”的子过程，再决定外层如何按组推进。</li>
   * <li>最后检查最后一组不足 {@code k} 个时，是否误反转了部分节点。</li>
   * </ol>
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    if (k == 0 || k == 1) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode preTail = dummy;
    ListNode start = head;

    while (start != null) {
      ListNode end = findEnd(start, k);
      if (end == null) {
        // 剩余节点不足 k 个时，题目要求保持原顺序，直接把剩余部分接回去即可。
        preTail.next = start;
        break;
      } else {
        ListNode nextStart = end.next;
        // 先记住下一组起点，再反转当前这一整组。
        // 这里不需要显式断开链表，因为 reverse 的停止条件就是“已经把 end 也反转进去”，
        // 退出循环时 cur 会自然停在 end.next，也就是下一组起点。
        preTail.next = reverse(start, end);
        // 当前组反转后，start 会变成这一组的尾节点，下一轮它就是新的 preTail。
        preTail = start;
        start = nextStart;
      }

    }

    return dummy.next;
  }

  private ListNode findEnd(ListNode node, int k) {
    ListNode cur = node;
    while (cur != null) {
      k--;
      if (k == 0) {
        // 这里返回的是“当前组最后一个节点”，不是最后一个节点的 next。
        // 这也是你之前做错过的地方：一旦语义错成 next，外层分组和 reverse 的边界都会整体错位。
        break;
      }
      cur = cur.next;
    }

    if (k == 0) {
      return cur;
    } else {
      return null;
    }
  }

  private ListNode reverse(ListNode node, ListNode end) {
    ListNode cur = node;
    ListNode prev = null;
    // 这里用 prev != end，而不是 cur != end。
    // 原因是这题要把 end 本身也反转进去；当上一轮刚把 end 接到 prev 前面后，才算整组反转完成。
    // 这又是一个你之前踩过的点：reverse 的区间语义必须和 findEnd 返回的“组尾节点”保持一致。
    while (prev != end) {
      ListNode temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }

    // node 是原组头，反转后会变成组尾；此时 cur 正好停在下一组起点，把它接回去即可。
    node.next = cur;
    return prev;
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
