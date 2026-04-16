package com.leisure.note.algorithm.week4.day25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目：127. 单词接龙
 *
 * <p>题目描述：
 *
 * <p>给你两个单词 {@code beginWord} 和 {@code endWord}，以及一个字典 {@code wordList}，
 * 找到从 {@code beginWord} 到 {@code endWord} 的最短转换序列中的单词数。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int ladderLength(String beginWord, String endWord, List<String> wordList)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>每次转换只能改变一个字符，且转换后的单词必须在 {@code wordList} 中</li>
 * <li>目标是最短转换序列长度，因此优先考虑 BFS</li>
 * <li>如果 {@code endWord} 不在字典中，直接返回 {@code 0}</li>
 * <li>允许使用额外空间，例如队列和访问标记集合</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练 BFS 扩展题感</li>
 * <li>重点说清为什么最短步数问题优先想到 BFS</li>
 * </ul>
 */
public class GraphQuestion2 {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // 本题定位：图 / 无权图最短路径 / 分层 BFS。
    // 题型特征：题目问“最短转换序列长度”，并且每次转换的代价都相同，所以优先想到 BFS。
    // 解题思路：
    // 1. 把每个单词看成图中的一个节点。
    // 2. 如果两个单词只差一个字符，并且新单词在字典里，就认为它们之间有一条边。
    // 3. 从 beginWord 开始做 BFS，队列的每一层表示“当前转换序列长度相同的一批单词”。
    // 4. 一旦在某一层第一次遇到 endWord，就说明已经走到了最短路径，当前层数就是答案。
    // 易错点：
    // 1. 这题是 BFS 找最短路，不是 DFS 找所有路径。
    // 2. 返回的是“序列中的单词数”，不是变换次数，所以 beginWord 自己也算 1。
    // 3. 生成邻居时，不是遍历 wordList 看谁只差一个字符，而是固定当前单词，枚举每一位替换成 a~z。
    // 4. visited 最稳的写法是在入队时就标记，而不是出队时标记；否则同一层里可能把同一个 nextWord 重复入队。
    if (beginWord.equals(endWord)) {
      return 1;
    }


    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return 0;
    }

    Deque<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();

        if (cur.equals(endWord)) {
          return level;
        }

        for (int j = 0; j < cur.length(); j++) {
          // 先确定“当前改哪一位”。
          // 例如 cur = "hit"：
          // j = 0 表示尝试改 h，j = 1 表示尝试改 i，j = 2 表示尝试改 t。
          char[] chars = cur.toCharArray();
          char oldChar = chars[j];
          for (char ch = 'a'; ch <= 'z'; ch++) {
            // 再枚举“这一位改成什么字母”。
            // 这一步本质上是在找当前节点的一步邻居：
            // 固定其它位置不变，只替换第 j 位，于是得到所有“只差一个字符”的候选单词。
            // 例如 "hit" 在 j = 1 时，会尝试得到 hat、hbt、hct ... hzt。
            if (ch != oldChar) {
              chars[j] = ch;
              String nextWord = String.valueOf(chars);
              if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                // 为什么应该在入队时就标记 visited：
                // 1. 只要 nextWord 已经入队，就说明我们已经找到了一条当前最短层级下到达它的路径。
                // 2. 如果等到出队时才标记，那么同一层中的其它单词也可能再次生成同一个 nextWord，
                //    这样它会被重复加入队列，既浪费空间，也容易把层数语义写乱。
                // 3. 所以 BFS 里更稳的习惯是：节点一旦决定入队，就立刻标记为已访问。
                queue.offer(nextWord);
                visited.add(nextWord);
              }
            }
          }
        }

      }

      if (!queue.isEmpty()) {
        level++;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    GraphQuestion2 graphQuestion2 = new GraphQuestion2();
    List<String> list = new ArrayList<>();
    list.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    System.out.println(graphQuestion2.ladderLength("hit", "cog", list));
  }
}
