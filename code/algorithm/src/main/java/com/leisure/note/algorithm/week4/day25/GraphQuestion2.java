package com.leisure.note.algorithm.week4.day25;

import java.util.List;

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
    throw new UnsupportedOperationException("TODO: implement ladderLength");
  }
}
