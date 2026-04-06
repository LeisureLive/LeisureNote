package com.leisure.note.algorithm.week4.day25;

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
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是有向图判环或拓扑排序，复杂度尽量做到 {@code O(V + E)}</li>
 * <li>课程编号范围为 {@code [0, numCourses - 1]}</li>
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
    throw new UnsupportedOperationException("TODO: implement canFinish");
  }
}
