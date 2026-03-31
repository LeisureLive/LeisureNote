# reviews 目录说明

这个目录现在按“规则 / 模板 / 周次 / 文档角色”拆分，目标是让你一眼能分清：

- 哪些是写作规范
- 哪些是模板
- 哪些是每周导航
- 哪些是专题知识正文
- 哪些是每天实际练习后的复盘

## 1. 目录结构

```text
reviews/
├── README.md
├── rules/
│   └── 00_review_doc_writing_rules.md
├── templates/
│   ├── 00_week_review_hub_template.md
│   └── 01_topic_system_review_template.md
└── week1/
    ├── hubs/
    ├── topics/
    └── daily/
```

## 2. 各目录职责

### `rules/`

放复习文档写作规范。

当前文件：

- `00_review_doc_writing_rules.md`

作用：

- 约束后续 Week2 及之后的复习文档写法
- 避免再次出现“只列重点、不讲怎么理解”的问题

### `templates/`

放可复用模板。

当前文件：

- `00_week_review_hub_template.md`
- `01_topic_system_review_template.md`
- `02_daily_review_template.md`

作用：

- 周导航文档的起稿模板
- 专题系统复习文档的起稿模板
- 每日复盘文档的起稿模板

### `week1/hubs/`

放 Week1 的导航文档，不承载完整知识正文。

当前文件：

- `00_week1_review_hub.md`

作用：

- 告诉你这一周有哪些专题
- 每天应该看哪份文档
- 复盘时应该怎么回看

### `week1/topics/`

放 Week1 的专题知识正文。

当前文件：

- `01_1_threadpool_lock_system_review.md`
- `01_2_jmm_and_lockfree_system_review.md`
- `02_1_jvm_runtime_classloading_system_review.md`
- `02_2_jvm_gc_troubleshooting_system_review.md`
- `03_mysql_system_review.md`
- `04_redis_system_review.md`
- `05_kafka_system_review.md`

作用：

- 承担真正的系统复习正文
- 每个重点都要求讲清：
  - 是什么
  - 为什么
  - 怎么理解
  - 怎么讲

### `week1/daily/`

放你每天实际练习后的日复盘文档。

当前文件：

- `day1_threadpool_lock_review.md`
- `day2_jmm_cas_aqs_review.md`
- `day3_jvm_memory_classloading_review.md`

作用：

- 基于当天真实问答和算法表现做复盘
- 突出当天最弱的点和第二天修正动作
- 不替代专题正文

## 3. 推荐使用顺序

每天建议这样用：

1. 先看 `week1/hubs/` 里的周导航或模块导航
2. 再看 `week1/topics/` 里的对应专题正文
3. 最后回到 `week1/daily/` 做当天输出和复盘

## 4. 后续默认规则

从 Week2 开始，默认按这个结构继续扩展：

- 每周一个目录
- 每周目录下继续区分：
  - `hubs/`
  - `topics/`
  - `daily/`

这样可以保证：

- 导航文档不会越来越长
- 专题正文不会和日复盘混在一起
- 模板和规范也不会和每周内容混在同一层
