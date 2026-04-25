package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 题目：636. 函数的独占时间
 *
 * <p>题目描述：
 *
 * <p>有一个单线程 CPU 正在执行 {@code n} 个函数，函数编号从 {@code 0} 到 {@code n - 1}。
 * 给定日志数组 {@code logs}，其中每条日志格式为 {@code "function_id:start_or_end:timestamp"}，
 * 表示某个函数在某一时刻开始或结束执行。请你返回一个长度为 {@code n} 的数组，
 * 其中 {@code ans[i]} 表示函数 {@code i} 的独占时间。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int[] exclusiveTime(int n, List<String> logs)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：n = 2,
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * 输出：[3,4]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：n = 1,
 * logs = ["0:start:0","0:end:0"]
 * 输出：[1]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>CPU 是单线程，同一时刻只会有一个函数真正运行</li>
 * <li>{@code end} 时间戳是闭区间，也就是结束时刻本身也算执行时间</li>
 * <li>函数之间可以嵌套调用，目标时间复杂度为 {@code O(m)}，其中 {@code m = logs.size()}</li>
 * <li>允许使用额外栈空间记录调用链</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练“调用栈 + 时间切片结算”题型</li>
 * <li>重点说清父函数什么时候先结算一段时间，子函数结束后父函数又从哪个时刻继续执行</li>
 * </ul>
 */
public class StackQuestion2 {

  public int[] exclusiveTime(int n, List<String> logs) {
    // 本题定位：栈 / 调用链模拟。
    // 题型特征：单线程、函数嵌套调用、要求独占时间，天然对应“调用栈”模型。
    //
    // 当前实现的栈元素含义：
    // stack 中每个 int[] 保存两个值：
    // 1. 函数 id
    // 2. 这个函数“下一段还没结算的起始时间”
    //
    // 解题主线：
    // 1. 遇到 start：
    //    - 如果当前已经有父函数在运行，先把父函数从“上次恢复执行时刻”到“当前 start 时刻前一刻”的时间结算掉。
    //    - 然后把新函数压栈，表示 CPU 切去执行子函数。
    // 2. 遇到 end：
    //    - 栈顶函数结束，结算它从“本段起始时间”到“end 时刻”的时间。
    //    - 注意这里是闭区间，所以要 +1。
    //    - 如果还有父函数，把父函数的下一段起始时间更新为 time + 1，
    //      因为 end 这个时刻已经被子函数占用了，父函数只能从下一时刻继续。
    //
    // 易错点：
    // 1. end 是闭区间，不是半开区间，所以结束结算一定是 time - start + 1。
    // 2. 父函数在子函数开始时要先结算一段，否则父函数总时间会把子函数运行时间也算进去。
    // 3. 子函数结束后，父函数不是从 time 继续，而是从 time + 1 继续。
    // 4. 这题不是统计“总调用时长”，而是统计“去掉子调用后的独占时长”。
    if (n <= 0) {
      return new int[0];
    }

    if (logs.size() % 2 == 1) {
      throw new IllegalArgumentException("logs invalid");
    }

    int[] ans = new int[n];
    Deque<int[]> stack = new ArrayDeque<>();
    for (String log : logs) {
      String[] split = log.split(":");
      int threadNum = Integer.parseInt(split[0]);
      String op = split[1];
      int time = Integer.parseInt(split[2]);

      if (op.equals("start")) {
        if (!stack.isEmpty()) {
          // 父函数先结算从“上次恢复执行时刻”到当前子函数开始前的这段独占时间。
          ans[stack.peek()[0]] += time - stack.peek()[1];
          // 父函数暂时被挂起，当前 time 之后由子函数接管。
          stack.peek()[1] = time;
        }
        // 新函数入栈，记录它当前这一段的起始时间。
        stack.push(new int[] {threadNum, time});
      } else {
        int[] pre = stack.pop();
        // end 是闭区间，所以当前函数这一段的执行时间要 +1。
        ans[threadNum] += time - pre[1] + 1;
        if (!stack.isEmpty()) {
          // 子函数把 time 这个时刻也占用了，所以父函数只能从 time + 1 开始继续跑。
          stack.peek()[1] = time + 1;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    StackQuestion2 stackQuestion = new StackQuestion2();
    System.out.println(Arrays.toString(stackQuestion.exclusiveTime(
      2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"))));
  }

}
