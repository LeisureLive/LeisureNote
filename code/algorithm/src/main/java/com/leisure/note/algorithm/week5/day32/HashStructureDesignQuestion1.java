package com.leisure.note.algorithm.week5.day32;

/**
 * 题目：146. LRU 缓存
 *
 * <p>题目描述：
 *
 * <p>请你设计并实现一个满足 LRU（最近最少使用）缓存约束的数据结构。
 *
 * <p>实现 {@code LRUCache} 类：
 *
 * <ul>
 * <li>{@code LRUCache(int capacity)} 以正整数作为容量初始化缓存</li>
 * <li>{@code int get(int key)} 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 {@code -1}</li>
 * <li>{@code void put(int key, int value)} 如果关键字已存在，则变更其数据值；如果不存在，则向缓存中插入该组 key-value。
 * 如果插入操作导致关键字数量超过 capacity，则应该逐出最久未使用的关键字。</li>
 * </ul>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>{@code get} 和 {@code put} 都要做到平均 {@code O(1)}</li>
 * <li>重点说清为什么“哈希表 + 双向链表”是这题的标准组合</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>虽然不在 `02_hashing.md` 的 5 类基础模式里，但面试价值很高</li>
 * <li>它能训练“哈希结构设计”而不只是哈希题模板调用</li>
 * </ul>
 */
public class HashStructureDesignQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：结构设计</li>
   * <li>特征：需要同时解决“按 key O(1) 找节点”和“按使用顺序 O(1) 调整节点位置”</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>哈希表负责 {@code key -> 节点} 的快速定位。</li>
   * <li>双向链表负责维护最近使用顺序，并支持 O(1) 删除 / 插入节点。</li>
   * <li>{@code get} 和 {@code put} 的核心都不是查值本身，而是更新“最近使用”顺序。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题的难点不在 API，而在结构协同。</li>
   * </ul>
   */
  public static class LRUCache {

    public LRUCache(int capacity) {
    }

    public int get(int key) {
      throw new UnsupportedOperationException("TODO: implement 146. LRU 缓存 get");
    }

    public void put(int key, int value) {
      throw new UnsupportedOperationException("TODO: implement 146. LRU 缓存 put");
    }
  }
}
