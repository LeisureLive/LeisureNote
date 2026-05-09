package com.leisure.note.algorithm.week5.day32;

/**
 * 题目：380. O(1) 时间插入、删除和获取随机元素
 *
 * <p>题目描述：
 *
 * <p>实现 {@code RandomizedSet} 类：
 *
 * <ul>
 * <li>{@code RandomizedSet()} 初始化 {@code RandomizedSet} 对象</li>
 * <li>{@code boolean insert(int val)} 当元素不存在时，向集合中插入该项，并返回 {@code true}；否则返回 {@code false}</li>
 * <li>{@code boolean remove(int val)} 当元素存在时，从集合中移除该项，并返回 {@code true}；否则返回 {@code false}</li>
 * <li>{@code int getRandom()} 随机返回现有集合中的一项。每个元素应该有相同的概率被返回。</li>
 * </ul>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>所有函数都应满足平均 {@code O(1)}</li>
 * <li>重点说清为什么这题要“数组 / List + HashMap”一起用</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>和 `146` 一样，属于哈希专题里的高价值结构设计题</li>
 * <li>它很适合训练“哈希表解决定位，数组解决随机访问”的结构配合思维</li>
 * </ul>
 */
public class HashStructureDesignQuestion2 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：结构设计</li>
   * <li>特征：既要 O(1) 定位和删除，又要 O(1) 随机访问</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>哈希表负责维护 {@code 值 -> 下标} 映射。</li>
   * <li>动态数组负责支持 O(1) 随机访问。</li>
   * <li>删除时通常通过“和最后一个元素交换，再删除尾部”的方式保证 O(1)。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题最值得解释的是“为什么删除不能直接从数组中间删，而要交换到尾部”。</li>
   * </ul>
   */
  public static class RandomizedSet {

    public RandomizedSet() {
    }

    public boolean insert(int val) {
      throw new UnsupportedOperationException("TODO: implement 380. RandomizedSet insert");
    }

    public boolean remove(int val) {
      throw new UnsupportedOperationException("TODO: implement 380. RandomizedSet remove");
    }

    public int getRandom() {
      throw new UnsupportedOperationException("TODO: implement 380. RandomizedSet getRandom");
    }
  }
}
