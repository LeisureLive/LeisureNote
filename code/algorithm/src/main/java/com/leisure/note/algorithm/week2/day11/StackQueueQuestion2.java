package com.leisure.note.algorithm.week2.day11;

/**
 * 题目：155. 最小栈
 *
 * <p>题目描述：
 *
 * <p>设计一个支持 {@code push}、{@code pop}、{@code top} 操作，并能在常数时间内检索到最小元素的栈。
 *
 * <p>这道题为什么放在 Day11：
 *
 * <ul>
 * <li>作为 `20. 有效的括号` 的加练题</li>
 * <li>训练“栈中保存辅助状态”的思路</li>
 * </ul>
 */
public class StackQueueQuestion2 {

  public static class MinStack {

    private ListNode dummyHead;

    public MinStack() {
      dummyHead = new ListNode(0, 0);
    }

    /**
     * 本题在专题中的定位：
     *
     * <ul>
     * <li>栈专题：辅助状态栈</li>
     * <li>核心信号：除了正常栈操作，还要求 {@code getMin()} 始终为 {@code O(1)}</li>
     * <li>这版实现采用“单栈节点扩展法”，每个节点额外保存“到当前节点为止的最小值”</li>
     * </ul>
     *
     * <p>思路：
     *
     * <ol>
     * <li>普通栈只存当前值，无法在弹出最小值后仍然 {@code O(1)} 得到新的最小值。</li>
     * <li>所以入栈时，除了存当前值 {@code val}，还同步存一个 {@code curMin}。</li>
     * <li>{@code curMin} 的含义是：从当前栈顶走到这个节点时，这一层对应的最小值是多少。</li>
     * <li>这样 {@code top()} 看栈顶值，{@code getMin()} 看栈顶节点的 {@code curMin}，弹栈也只需要移动指针。</li>
     * </ol>
     *
     * <p>易错点：
     *
     * <ul>
     * <li>这题不能在 {@code pop()} 时重新扫描整栈求最小值，否则复杂度就退化了。</li>
     * <li>辅助状态必须和节点一起入栈、一起出栈，不能只在外部维护一个最小值变量。</li>
     * <li>要区分这题和普通栈题：普通栈只关心元素顺序，这题还要关心历史最小值信息。</li>
     * </ul>
     */
    public void push(int val) {
      int min = Integer.MAX_VALUE;
      if (dummyHead.next != null) {
        min = dummyHead.next.curMin;
      }

      min = Math.min(min, val);
      ListNode newNode = new ListNode(val, min);
      newNode.next = dummyHead.next;
      dummyHead.next = newNode;
    }

    public void pop() {
      if (dummyHead.next == null) {
        return;
      }

      dummyHead.next = dummyHead.next.next;
    }

    public int top() {
      if (dummyHead.next == null) {
        return -1;
      }
      return dummyHead.next.val;
    }

    public int getMin() {
      if (dummyHead.next == null) {
        throw new  IllegalStateException("stack is empty");
      }
      return dummyHead.next.curMin;
    }
  }


  public static class ListNode {
    int val;
    int curMin;
    ListNode next;

    ListNode() {
    }

    ListNode(int val, int curMin) {
      this.val = val;
      this.curMin = curMin;
    }

    ListNode(int val, int curMin, ListNode next) {
      this.val = val;
      this.curMin = curMin;
      this.next = next;
    }
  }
}
