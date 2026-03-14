# LeisureNote

个人技术学习与面试准备仓库，主要用于：

- 沉淀后端研发相关知识点
- 记录自学过程中的问题、结论与排查经验
- 结合知识点进行针对性的代码训练
- 为后续面试复习做系统化整理

## 仓库结构

```text
LeisureNote
├── code/                    # 代码练习与示例
│   ├── algorithm/           # 算法练习
│   └── bigdata/             # 大数据相关示例
├── note/                    # 技术笔记
│   ├── problem_solving/     # 问题排查与经验归纳
│   └── technical_points/    # 按主题整理的知识点
└── prepare/                 # 面试准备材料
```

## 当前内容

### 1. 技术笔记

- Java：`note/technical_points/Java`
- 算法：`note/technical_points/algorithm`
- 数据库：`note/technical_points/database`
- 中间件：`note/technical_points/middleware`
- 计算机基础：`note/technical_points/compute_basics`
- 系统设计：`note/technical_points/system_design`
- 问题排查：`note/problem_solving`

### 2. 代码训练

- `code/algorithm`
  - 当前包含排序相关示例代码
- `code/bigdata`
  - 当前包含 Hadoop MapReduce `WordCount` 示例

## 使用方式

### 阅读笔记

按主题目录阅读即可，建议结合自己的学习节奏持续补充：

- 先看基础知识，再补问题排查
- 先整理知识框架，再补细节与案例

### 运行代码示例

算法模块：

```bash
cd code/algorithm
mvn test
```

大数据模块：

```bash
cd code/bigdata
mvn test
```

说明：

- 当前模块以学习示例为主
- 具体依赖、JDK 与运行环境请结合本地环境验证

## 推荐整理方向

这个仓库目前已经具备“笔记 + 代码练习 + 面试准备”的雏形，后续建议重点往下面几个方向优化：

### 1. 统一目录分层

建议长期固定为三层：

- `note/technical_points`：知识点主干
- `note/problem_solving`：排查经验与实战问题
- `prepare`：按年份或专题整理的面试准备材料

### 2. 强化笔记索引

建议逐步补充：

- 每个一级主题一个目录说明文件
- 面试高频题单与对应笔记链接
- 重点知识点之间的关联跳转

### 3. 强化代码与知识点映射

建议让代码目录和笔记目录建立对应关系，例如：

- 排序算法笔记 <-> `code/algorithm`
- 中间件/数据库知识点 <-> 后续新增 demo 或实验代码

### 4. 区分“学习笔记”和“面试答案”

建议后续在内容组织上区分两类材料：

- 学习笔记：强调理解过程、背景和原理
- 面试整理：强调结论、答题结构和高频追问

### 5. 清理非必要提交内容

建议后续逐步规范：

- 尽量不要提交 `.idea/` 下的环境性配置
- 尽量不要提交 `target/` 下的构建产物
- 代码练习优先补充源码与说明，减少二进制产物噪音

## 后续可以补充的内容

- 更完整的算法训练题单与测试用例
- 数据库、缓存、MQ、分布式相关实验代码
- 面试专题索引页
- 各主题的复习计划与完成进度

## 说明

本仓库以个人学习沉淀为主，内容会持续迭代。

如果你也在准备后端知识体系梳理或面试复习，希望这份仓库结构能提供一些参考。
