package com.leisure.note.algorithm.week5.day35;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Day35 栈 / 队列模式题：队列的顺序处理与窗口推进。
 *
 * <p>这组题对应 `04_stack_queue_monotonic_stack.md` 里的 `3.2 队列：顺序处理与窗口推进`。
 * 当前专题里原有已完成题没有覆盖这一类，所以这里补出三个高频代表题骨架，先把题面、方法签名和训练重点收口好：
 *
 * <ul>
 * <li>`232`：双栈模拟队列，训练 FIFO 语义如何延迟搬运实现。</li>
 * <li>`225`：双队列 / 单队列模拟栈，训练 LIFO 语义如何通过队列重排实现。</li>
 * <li>`239`：滑动窗口最大值，训练窗口推进和单调队列的结合。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class QueueOrderedProcessingQuestion1 {

  /**
   * 232. 用栈实现队列
   *
   * <p>题目描述：
   *
   * <p>请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作：
   * {@code push}、{@code pop}、{@code peek} 和 {@code empty}。
   *
   * <p>实现类签名：
   *
   * <pre>
   * class MyQueue {
   *   public MyQueue()
   *   public void push(int x)
   *   public int pop()
   *   public int peek()
   *   public boolean empty()
   * }
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：
   * ["MyQueue", "push", "push", "peek", "pop", "empty"]
   * [[], [1], [2], [], [], []]
   * 输出：
   * [null, null, null, 1, 1, false]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>只能使用栈的标准操作</li>
   * <li>目标是把队列的 FIFO 语义稳定模拟出来</li>
   * <li>重点思考什么时候需要把输入栈的数据倒到输出栈</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>队列模式：双结构语义转换基础题。</li>
   * <li>重点不在 API，而在“延迟搬运”能否把整体均摊复杂度控制住。</li>
   * </ul>
   */
  public static class MyQueue {

    // inStack 负责接收新入队元素。
    private Deque<Integer> inStack = new ArrayDeque<>();
    // outStack 负责真正出队；当它不为空时，栈顶就是当前队头。
    private Deque<Integer> outStack = new ArrayDeque<>();

    public MyQueue() {
    }

    public void push(int x) {
      // 入队时只压入输入栈，先不急着调整顺序。
      inStack.push(x);
    }

    public int pop() {
      if (!outStack.isEmpty()) {
        return outStack.pop();
      } else if (!inStack.isEmpty()) {
        // 只有当输出栈为空时，才把输入栈整体倒过去。
        // 这样最早进入 inStack 的元素会翻转到 outStack 栈顶，正好变成队头。
        while (!inStack.isEmpty()) {
          outStack.push(inStack.pop());
        }
        return outStack.pop();
      } else {
        throw new NoSuchElementException();
      }
    }

    public int peek() {
      if (!outStack.isEmpty()) {
        return outStack.peek();
      } else if (!inStack.isEmpty()) {
        // peek 和 pop 的前置逻辑完全一样：
        // 都要先保证 outStack 栈顶就是当前队头。
        while (!inStack.isEmpty()) {
          outStack.push(inStack.pop());
        }
        return outStack.peek();
      } else {
        throw new NoSuchElementException();
      }
    }

    public boolean empty() {
      return inStack.isEmpty() && outStack.isEmpty();
    }
  }


  /**
   * 225. 用队列实现栈
   *
   * <p>题目描述：
   *
   * <p>请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部操作：
   * {@code push}、{@code pop}、{@code top} 和 {@code empty}。
   *
   * <p>实现类签名：
   *
   * <pre>
   * class MyStack {
   *   public MyStack()
   *   public void push(int x)
   *   public int pop()
   *   public int top()
   *   public boolean empty()
   * }
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：
   * ["MyStack", "push", "push", "top", "pop", "empty"]
   * [[], [1], [2], [], [], []]
   * 输出：
   * [null, null, null, 2, 2, false]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>只能使用队列的标准操作</li>
   * <li>重点想清“谁保留最后入队元素，谁负责搬运其余元素”</li>
   * <li>可以自行选择单队列旋转或双队列搬运思路，但本地先只保留骨架</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>队列模式：与 `232` 对照的反向语义转换题。</li>
   * <li>它很适合训练“底层结构限制”和“目标接口语义”之间如何做桥接。</li>
   * </ul>
   */
  public static class MyStack {

    private Queue<Integer> queue = new ArrayDeque<>();

    public MyStack() {
    }

    public void push(int x) {
      int size = queue.size();
      queue.offer(x);
      // 新元素先入队尾，再把前面的旧元素依次轮转到队尾。
      // 轮转完成后，新元素就会来到队头，后续 pop/top 都能直接拿到它。
      while (size > 0) {
        queue.offer(queue.poll());
        size--;
      }
    }

    public int pop() {
      // 经过 push 阶段的轮转后，当前队头始终就是“栈顶”。
      return queue.poll();
    }

    public int top() {
      // top 不需要再搬运，直接看队头即可。
      return queue.peek();
    }

    public boolean empty() {
      return queue.isEmpty();
    }
  }

  /**
   * 239. 滑动窗口最大值
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code nums}，有一个大小为 {@code k} 的滑动窗口从数组的最左侧移动到最右侧。
   * 你只可以看到在滑动窗口内的 {@code k} 个数字。滑动窗口每次只向右移动一位。
   * 请你返回滑动窗口中的最大值。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] maxSlidingWindow(int[] nums, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
   * 输出：[3,3,5,5,6,7]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1], k = 1
   * 输出：[1]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>不能对每个窗口都重新扫描最大值</li>
   * <li>重点说清队列里为什么通常存下标，以及何时弹出过期元素</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>队列模式：窗口推进 + 单调队列主战题。</li>
   * <li>它是区分“普通队列”和“维护窗口最值的队列”的核心代表题。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认这题不是普通滑动窗口计数，而是“窗口内最值维护”。</li>
   * <li>再明确队列里存下标而不是值，这样才能判断元素是否过期。</li>
   * <li>每次右边进一个新元素后，先弹掉队尾无用候选，再处理队头过期，再记录答案。</li>
   * <li>最后检查 {@code k == 1}、数组长度等于 {@code k} 这些边界。</li>
   * </ol>
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length < k) {
      return new int[0];
    }

    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(a -> nums[(int) a]).reversed());
    int i = 0;
    while (queue.size() != k) {
      queue.add(i++);
    }
    int[] ans = new int[nums.length - k + 1];
    ans[i - k] = nums[queue.peek()];
    for (; i < nums.length; i++) {
      queue.offer(i);
      int num = nums[i];
      while (!queue.isEmpty() && (queue.peek() < i - k + 1 || nums[queue.peek()] < num)) {
        queue.poll();
      }
      ans[i - k + 1] = nums[queue.peek()];
    }
    return ans;
  }

  public int[] maxSlidingWindow2(int[] nums, int k) {
    if (nums == null || nums.length < k) {
      return new int[0];
    }

    // 双端队列里存的是下标，不是值。
    // 这样既能比较 nums 大小，也能判断队头下标是否已经滑出窗口。
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      // 维护单调递减队列：队尾比当前值小的下标都不可能再成为最大值候选。
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }

    int[] ans = new int[nums.length - k + 1];
    // 首个窗口准备完成后，队头就是窗口最大值下标。
    ans[0] = nums[deque.peekFirst()];

    for (int i = k; i < nums.length; i++) {
      // 右侧新元素入窗前，先清理掉队尾所有更小的候选。
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);

      // 当前窗口左边界是 i - k + 1，因此 <= i - k 的下标都已经过期。
      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }

      // 队头始终保存当前窗口的最大值下标。
      ans[i - k + 1] = nums[deque.peekFirst()];
    }

    return ans;
  }


  public static void main(String[] args) {
    QueueOrderedProcessingQuestion1 queueOrderedProcessingQuestion1 = new QueueOrderedProcessingQuestion1();
    System.out.println(
      Arrays.toString(queueOrderedProcessingQuestion1.maxSlidingWindow2(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
  }
}
