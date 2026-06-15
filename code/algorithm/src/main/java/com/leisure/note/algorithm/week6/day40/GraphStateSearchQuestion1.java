package com.leisure.note.algorithm.week6.day40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Day40 图模式题：3.4 建图与状态搜索。
 *
 * <p>本文件对应 `10_graphs.md` 的 `3.4 建图与状态搜索：图题真正的入口常常在“抽象”`，
 * 只保留题目描述和方法骨架。
 */
public class GraphStateSearchQuestion1 {

  /**
   * 752. 打开转盘锁
   *
   * <p>题目描述：
   *
   * <p>你有一个带有四个圆形拨轮的转盘锁。每个拨轮上有 {@code 10} 个数字：{@code '0'} 到 {@code '9'}。
   * 每次只能旋转一个拨轮的一位数字，并且可以向前转一格或向后转一格；
   * 例如 {@code '0'} 向前转一格变成 {@code '1'}，向后转一格变成 {@code '9'}。
   *
   * <p>锁的初始状态为 {@code "0000"}。给定一些死亡数字组合 {@code deadends}，
   * 一旦锁的状态变成其中任意一个组合，锁就会永久锁死，无法继续旋转。
   *
   * <p>再给定目标组合 {@code target}，请返回从初始状态到达目标状态所需的最少旋转次数；
   * 如果无法打开锁，返回 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int openLock(String[] deadends, String target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
   * 输出：6
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：deadends = ["8888"], target = "0009"
   * 输出：1
   * </pre>
   *
   * <p>示例 3：
   *
   * <pre>
   * 输入：deadends = ["0000"], target = "8888"
   * 输出：-1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>初始状态固定为 {@code "0000"}</li>
   * <li>每次操作只能改变一位拨轮，且变化幅度只能是一格</li>
   * <li>如果初始状态就是死亡状态，答案为 {@code -1}</li>
   * </ul>
   */
  public int openLock(String[] deadends, String target) {
    if (target.equals("0000")) {
      return 0;
    }
    Set<String> dead = new HashSet<>();
    for (String deadend : deadends) {
      dead.add(deadend);
    }
    if (dead.contains("0000")) {
      return -1;
    }

    Queue<String> queue = new ArrayDeque<>();
    queue.offer("0000");
    Set<String> seen = new HashSet<>();
    seen.add("0000");
    int step = 0;
    while (!queue.isEmpty()) {
      step++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String str = queue.poll();
        for (String next : getNext(str)) {
          if (target.equals(next)) {
            return step;
          }
          if (dead.contains(next) || seen.contains(next)) {
            continue;
          }
          queue.offer(next);
          seen.add(next);
        }
      }
    }

    return -1;
  }

  private List<String> getNext(String str) {
    char[] charArr = str.toCharArray();
    List<String> res = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      char ch = charArr[i];
      char prev = numPrev(ch);
      char next = numSucc(ch);
      charArr[i] = prev;
      res.add(new String(charArr));
      charArr[i] = next;
      res.add(new String(charArr));
      charArr[i] = ch;
    }
    return res;
  }

  public char numPrev(char x) {
    return x == '0' ? '9' : (char) (x - 1);
  }

  public char numSucc(char x) {
    return x == '9' ? '0' : (char) (x + 1);
  }

  /**
   * 433. 最小基因变化
   *
   * <p>题目描述：
   *
   * <p>一条基因序列由长度固定为 {@code 8} 的字符串表示，且每个字符只能是
   * {@code 'A'}、{@code 'C'}、{@code 'G'}、{@code 'T'} 之一。
   *
   * <p>给定两个基因序列 {@code startGene} 和 {@code endGene}，一次基因变化是指改变其中恰好一个字符。
   * 变化后的新基因序列必须存在于基因库 {@code bank} 中，才被认为是合法变化。
   *
   * <p>请返回从 {@code startGene} 变化到 {@code endGene} 所需的最少变化次数；
   * 如果无法变化到目标基因，返回 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int minMutation(String startGene, String endGene, String[] bank)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
   * 输出：1
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：startGene = "AACCGGTT", endGene = "AAACGGTA",
   *      bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
   * 输出：2
   * </pre>
   *
   * <p>示例说明：
   *
   * <pre>
   * 一种合法变化路径是：
   * AACCGGTT -> AACCGGTA -> AAACGGTA
   * 每一步都只变化一个字符，且中间结果都在 bank 中。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>每次变化只能修改一个字符</li>
   * <li>中间状态和最终状态都必须出现在 {@code bank} 中才合法</li>
   * <li>基因字符串长度固定为 {@code 8}</li>
   * </ul>
   */
  public int minMutation(String startGene, String endGene, String[] bank) {
    Set<String> valid = new HashSet<>();
    for (String str : bank) {
      valid.add(str);
    }

    if (!valid.contains(endGene)) {
      return -1;
    }

    Set<String> seen = new HashSet<>();
    seen.add(startGene);
    Queue<String> queue = new ArrayDeque<>();
    queue.offer(startGene);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      step++;
      for (int i = 0; i < size; i++) {
        String gene = queue.poll();
        for (String next : getNextGene(gene)) {
          if (next.equals(endGene)) {
            return step;
          }

          if (!valid.contains(next) || seen.contains(next)) {
            continue;
          }

          queue.offer(next);
          seen.add(next);
        }
      }
    }

    return -1;
  }

  private char[] chars = new char[] {'A', 'C', 'G', 'T'};
  private List<String> getNextGene(String gene) {
    List<String> ans = new ArrayList<>();
    char[] charArr = gene.toCharArray();
    for (int i = 0; i < charArr.length; i++) {
      char ch = charArr[i];
      for (char chr : chars) {
        if (chr != ch) {
          charArr[i] = chr;
          ans.add(new String(charArr));
        }
      }
      charArr[i] = ch;
    }
    return ans;
  }

  private char nextGene(char ch) {
    if (ch == 'A') {
      return 'C';
    } else if (ch == 'C') {
      return 'G';
    } else if (ch == 'G') {
      return 'T';
    } else {
      return 'A';
    }
  }

  public static void main(String[] args) {
    GraphStateSearchQuestion1 question1 = new GraphStateSearchQuestion1();
    System.out.println(question1.minMutation("AACCGGTT", "AAACGGTA",
      new String[] {"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"}));
  }

}
