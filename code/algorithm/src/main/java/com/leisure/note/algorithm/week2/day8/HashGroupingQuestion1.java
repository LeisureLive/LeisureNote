package com.leisure.note.algorithm.week2.day8;

import java.util.List;

/**
 * 题目：49. 字母异位词分组
 *
 * <p>题目描述：
 *
 * <p>给你一个字符串数组 {@code strs}，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
 *
 * <p>字母异位词指字母相同，但排列不同的字符串。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<List<String>> groupAnagrams(String[] strs)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：strs = ["eat","tea","tan","ate","nat","bat"]
 * 输出：[["bat"],["nat","tan"],["ate","eat","tea"]]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：strs = [""]
 * 输出：[[""]]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>允许使用额外空间</li>
 * <li>结果中的分组顺序、组内字符串顺序都不作要求</li>
 * <li>需要把“如何构造稳定分组 key”说清楚</li>
 * <li>默认字符集按小写英文字母处理；如果放宽到通用字符集，要能说明方案如何调整</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day8：
 *
 * <ul>
 * <li>Day8 对应“哈希计数 / 分组 1 题”</li>
 * <li>这题正好训练哈希分组归类和稳定 key 设计</li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>先判断题型，并说明为什么这是“分组归类 + HashMap”题</li>
 * <li>先口头说明如何构造稳定 key</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和 key 设计取舍</li>
 * </ol>
 */
public class HashGroupingQuestion1 {

  public List<List<String>> groupAnagrams(String[] strs) {
    throw new UnsupportedOperationException("TODO: implement groupAnagrams");
  }
}
