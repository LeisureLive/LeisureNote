package com.leisure.note.algorithm.week4.day25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目：207. 课程表
 *
 * <p>题目描述：
 *
 * <p>你这个学期必须选修 {@code numCourses} 门课程，记为 {@code 0} 到 {@code numCourses - 1}。
 * 给你一个数组 {@code prerequisites}，其中 {@code prerequisites[i] = [a, b]} 表示学课程 a 之前必须先学课程 b。
 * 判断是否可能完成所有课程学习。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean canFinish(int numCourses, int[][] prerequisites)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * </pre>
 *
 * <p>示例 3：
 *
 * <pre>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：true
 * 解释：课程 3 有两个前置课程 1 和 2，所以要拆成两条依赖 [3,1] 和 [3,2]，不能写成 [3,1,2]。
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是有向图判环或拓扑排序，复杂度尽量做到 {@code O(V + E)}</li>
 * <li>课程编号范围为 {@code [0, numCourses - 1]}</li>
 * <li>{@code prerequisites[i]} 固定只包含两个元素，表示一条依赖边；如果一门课有多个前置课程，需要拆成多条二元依赖</li>
 * <li>只要依赖图中存在环，就不可能完成所有课程</li>
 * <li>允许使用额外空间，例如邻接表和入度数组</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练拓扑排序认知</li>
 * <li>重点说清入度和有向图依赖关系</li>
 * </ul>
 */
public class GraphQuestion1 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // 本题定位：图 / 拓扑排序 / 有向图判环。
    // 题型特征：输入给的是课程依赖关系，问题在问“是否存在合法学习顺序”，所以不是最短路，而是依赖顺序问题。
    // 解题思路：
    // 1. 把 prerequisites[i] = [a, b] 翻译成一条有向边 b -> a，表示“学 a 之前必须先学 b”。
    // 2. 用 inDegree[a] 统计课程 a 还有多少门前置课没完成。
    // 3. 先把所有入度为 0 的课程入队，它们表示“当前没有任何前置依赖，可以先学”。
    // 4. 每弹出一门课，就相当于把它从图里删掉，同时把它指向的后继课程入度减 1。
    // 5. 如果某门后继课入度减到 0，就说明它的前置条件都满足了，可以继续入队。
    // 6. 最后看处理过的课程数是否等于 numCourses：
    //    - 相等：无环，可以学完
    //    - 不相等：有环，学不完
    // 易错点：
    // 1. prerequisites[i] = [a, b] 的方向非常容易写反，正确是 b -> a，不是 a -> b。
    // 2. 一个课程有多个前置课时，要拆成多条依赖边分别统计入度，例如 [3,1] 和 [3,2]。
    // 3. 入度的含义不是“有多少后继课程”，而是“这门课还剩多少个前置条件没完成”。
    // 4. 队列里放的是“当前可学的课程”，不是“当前扫描到的所有课程”。
    // 5. 判断是否有环，不是看队列是否为空，而是看最终 count 是否等于课程总数。
    if (prerequisites == null || prerequisites.length == 0) {
      return true;
    }

    int[] inDegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int course = prerequisites[i][0];
      int prerequisite = prerequisites[i][1];
      // [course, prerequisite] 要翻译成 prerequisite -> course。
      graph.get(prerequisite).add(course);
      inDegree[course]++;
    }

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int courseNum = queue.poll();
      count++;
      // 当前课程学完后，它能“解锁”的就是它的所有后继课程。
      for (Integer courseNumber : graph.get(courseNum)) {
        inDegree[courseNumber]--;
        if (inDegree[courseNumber] == 0) {
          queue.offer(courseNumber);
        }
      }
    }
    return count == numCourses;
  }

  public static void main(String[] args) {
    GraphQuestion1 graphQuestion1 = new GraphQuestion1();
    System.out.println(graphQuestion1.canFinish(4, new int[][] {
      {1, 0},
      {2, 0},
      {3, 1},
      {3, 2}
    }));
  }

}
