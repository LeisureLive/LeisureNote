package com.leisure.note.algorithm.week5.day33;

import java.util.HashMap;
import java.util.Map;

/**
 * Day33 链表模式题：链表 + 哈希表。
 *
 * <p>这一类题的核心不是单纯改指针，而是：
 *
 * <ul>
 * <li>链表本身不擅长随机访问。</li>
 * <li>当题目需要“旧节点 -> 新节点”的快速映射，或需要快速判断历史节点信息时，往往需要引入哈希表补足能力。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class LinkedListHashQuestion1 {

  /**
   * 138. 随机链表的复制
   *
   * <p>题目描述：
   *
   * <p>给你一个长度为 {@code n} 的链表，每个节点包含一个额外增加的随机指针 {@code random}，
   * 该指针可以指向链表中的任何节点或空节点。
   *
   * <p>请你构造这个链表的深拷贝。深拷贝应该正好由 {@code n} 个全新节点组成，其中每个新节点的值都设为其对应原节点的值。
   * 新节点的 {@code next} 和 {@code random} 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
   *
   * <p>方法签名：
   *
   * <pre>
   * public Node copyRandomList(Node head)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
   * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：head = [[1,1],[2,1]]
   * 输出：[[1,1],[2,1]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点说清哈希表里到底存的是什么映射关系</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>链表 + 哈希表模式的代表题。</li>
   * <li>它最能体现“链表只靠顺序遍历不够，还需要借助哈希表完成节点关系重建”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认这是“深拷贝”，所以新链表中的节点不能复用原链表节点。</li>
   * <li>再明确哈希表的职责通常是“原节点 -> 新节点”的映射，而不是只存值。</li>
   * <li>优先把问题拆成两步：先建节点，再补 {@code next/random} 关系。</li>
   * <li>最后检查 {@code random == null}、自指、交叉指向等边界。</li>
   * </ol>
   */
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    // map 里存的是“原节点 -> 新节点”的映射，不是“节点值 -> 新节点”。
    // 这是这题最容易说错的点：节点值可能重复，只有节点对象本身才能唯一标识一份关系。
    Map<Node, Node> map = new HashMap<>();
    Node dummy = new Node(0);
    Node node1 = head;
    Node node2 = dummy;
    // 第一轮：只负责复制节点本身和 next 链路，同时建立映射关系。
    while (node1 != null) {
      Node node = new Node(node1.val);
      node2.next = node;
      node2 = node;
      map.put(node1, node);

      node1 = node1.next;
    }

    node1 = head;
    node2 = dummy.next;
    // 第二轮：再根据映射表补 random 指针。
    // 这里 map.get(null) 会自然返回 null，正好覆盖 random 为空的场景。
    while (node1 != null) {
      node2.random = map.get(node1.random);
      node1 = node1.next;
      node2 = node2.next;
    }

    return dummy.next;
  }

  public static class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
      this.val = val;
    }
  }
}
