package com.leisure.note.algorithm.week6.day40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Day40 图模式题：3.3 依赖顺序。
 *
 * <p>本文件对应 `10_graphs.md` 的 `3.3 依赖顺序：拓扑排序与环检测`，
 * 只保留题目描述和方法骨架。
 */
public class GraphTopologicalSortQuestion1 {

  /**
   * 210. 课程表 II
   *
   * <p>题目描述：
   *
   * <p>现在你总共有 {@code numCourses} 门课程，课程编号为 {@code 0} 到 {@code numCourses - 1}。
   * 给定一个数组 {@code prerequisites}，其中 {@code prerequisites[i] = [ai, bi]}
   * 表示如果要学习课程 {@code ai}，必须先完成课程 {@code bi}。
   *
   * <p>请你返回一种可行的课程学习顺序，使得你可以完成全部课程。
   * 如果不存在这样的顺序，返回一个空数组。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] findOrder(int numCourses, int[][] prerequisites)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：numCourses = 2, prerequisites = [[1,0]]
   * 输出：[0,1]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
   * 输出：[0,1,2,3]
   * </pre>
   *
   * <p>示例说明：
   *
   * <pre>
   * [0,2,1,3] 也是合法答案，因为 1 和 2 都只依赖 0，
   * 它们之间的先后顺序并不固定。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>返回任意一种合法顺序即可</li>
   * <li>如果存在环，必须返回空数组</li>
   * <li>课程编号使用 {@code 0-based} 下标</li>
   * </ul>
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] arr : prerequisites) {
      Set<Integer> set = map.getOrDefault(arr[0], new HashSet<>());
      set.add(arr[1]);
      map.put(arr[0], set);
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (map.containsKey(i)) {
        continue;
      }
      queue.add(i);
    }

    int[] ans = new int[numCourses];
    int index = 0;
    while (!queue.isEmpty()) {
      int course = queue.poll();
      ans[index++] = course;

      // 更新其他其他依赖此课程的课程
      for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
        if (entry.getValue().contains(course)) {
          entry.getValue().remove(course);

          // 如果完成此课程后，其他课程依赖就绪，加入队列
          if (entry.getValue().size() == 0) {
            queue.offer(entry.getKey());
          }
        }
      }
    }

    if (index != numCourses) {
      return new int[] {};
    }
    return ans;
  }

  /**
   * 1462. 课程表 IV
   *
   * <p>题目描述：
   *
   * <p>你总共有 {@code numCourses} 门课，编号为 {@code 0} 到 {@code numCourses - 1}。
   * 给定数组 {@code prerequisites}，其中 {@code prerequisites[i] = [ai, bi]}
   * 表示学习课程 {@code bi} 之前，必须先完成课程 {@code ai}。
   *
   * <p>再给定数组 {@code queries}，其中 {@code queries[j] = [uj, vj]}。
   * 对于每个查询，请判断课程 {@code uj} 是否是课程 {@code vj} 的先修课程。
   *
   * <p>如果是，返回 {@code true}；否则返回 {@code false}。最终请按查询顺序返回布尔结果列表。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
   * 输出：[false,true]
   * </pre>
   *
   * <p>示例说明：
   *
   * <pre>
   * [0,1] 表示判断 0 是否是 1 的先修课，答案是否；
   * [1,0] 表示判断 1 是否是 0 的先修课，答案是。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
   * 输出：[true,true]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>需要按 {@code queries} 的原顺序返回结果</li>
   * <li>如果课程之间不存在先修关系，返回 {@code false}</li>
   * <li>课程编号使用 {@code 0-based} 下标</li>
   * </ul>
   */
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites,
    int[][] queries) {
    // g[i] 表示所有 i 的后继课程
    List<Integer>[] g = new List[numCourses];
    for (int i = 0; i < numCourses; i++) {
      g[i] = new ArrayList<>();
    }

    int[] indegree = new int[numCourses];
    for (int[] p : prerequisites) {
      indegree[p[1]] += 1;
      g[p[0]].add(p[1]);
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0;i< numCourses;i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    boolean[][] isPre = new boolean[numCourses][numCourses];
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (Integer nx : g[cur]) {
        isPre[cur][nx] = true;
        for (int i = 0; i < numCourses; i++) {
          isPre[i][nx] = isPre[i][nx] | isPre[i][cur];
        }

        indegree[nx] -= 1;
        if (indegree[nx] == 0) {
          queue.offer(nx);
        }
      }

    }

    List<Boolean> res = new ArrayList<>();
    for (int[] query: queries) {
      res.add(isPre[query[0]][query[1]]);
    }
    return res;
  }

}
