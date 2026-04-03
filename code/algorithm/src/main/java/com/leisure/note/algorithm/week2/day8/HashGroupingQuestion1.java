package com.leisure.note.algorithm.week2.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
    if (strs == null || strs.length == 0) {
      return Collections.emptyList();
    }
    List<Map<Character, Integer>> mapList = new ArrayList<>();
    for (String str : strs) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
        map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
      }
      mapList.add(map);
    }

    // 保存已经归类的字符串索引下标
    Set<Integer> set = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < mapList.size(); i++) {
      if (set.contains(i)) {
        continue;
      }
      List<String> list = new ArrayList<>();
      list.add(strs[i]);
      Map<Character, Integer> baseMap = mapList.get(i);
      for (int j = i + 1; j < mapList.size(); j++) {
        Map<Character, Integer> tempMap = mapList.get(j);
        if (baseMap.size() != tempMap.size()
          || !baseMap.keySet().equals(tempMap.keySet())) {
          continue;
        }
        boolean flag = true;
        for (Character key : baseMap.keySet()) {
          if (!Objects.equals(tempMap.getOrDefault(key, 0), baseMap.getOrDefault(key, 0))) {
            flag = false;
            break;
          }
        }

        if (flag) {
          list.add(strs[j]);
          set.add(j);
        }
      }

      result.add(list);
    }

    return result;
  }


  public static void main(String[] args) {
    HashGroupingQuestion1 hashGroupingQuestion1 = new HashGroupingQuestion1();
    System.out.println(hashGroupingQuestion1.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }
}
