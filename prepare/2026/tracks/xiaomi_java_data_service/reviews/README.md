# reviews 目录说明

这个目录按“规则 / 模板 / 周次 / 文档角色”拆分，目标不是只服务某一周，而是把整个 `xiaomi_java_data_service` track 的复习正文、导航和复盘边界稳定下来。

你进入这个目录时，应该一眼分清：

- 哪些文件负责写作规范
- 哪些文件负责模板
- 哪些文件负责周导航
- 哪些文件负责专题正文
- 哪些文件负责日复盘
- 哪些文件负责专项审查记录

## 1. 目录结构

```text
reviews/
├── README.md
├── 01_week3_week4_topic_audit.md
├── rules/
│   └── 00_review_doc_writing_rules.md
├── templates/
│   ├── 00_week_review_hub_template.md
│   ├── 01_topic_system_review_template.md
│   └── 02_daily_review_template.md
└── weekN/
    ├── hubs/
    ├── topics/
    └── daily/   # 按需补，不要求每周预置
```

说明：

- `weekN/` 只是周次占位，当前已经扩展到 Week1-Week4。
- `daily/` 的角色一直保留，但是否提前创建取决于这一周是否已经发生了真实复盘输入。

## 2. 各目录职责

### `README.md`

负责目录入口说明。

作用：

- 说明整个 `reviews/` 的结构和推荐使用顺序
- 解释各层目录分别该放什么
- 提供专项审查记录入口

### 专项审查记录

当前文件：

- `01_week3_week4_topic_audit.md`

作用：

- 记录当前阶段对目录结构和 Week3-Week4 专题正文的专项审查结论
- 区分 findings 和 actions，避免后续整理时重复判断

### `rules/`

放复习文档写作规范。

当前文件：

- `00_review_doc_writing_rules.md`

作用：

- 约束专题正文和周导航的写法
- 避免再次出现“只列重点、不讲怎么理解”的问题

### `templates/`

放可复用模板。

当前文件：

- `00_week_review_hub_template.md`
- `01_topic_system_review_template.md`
- `02_daily_review_template.md`

作用：

- 周导航文档起稿
- 专题系统复习文档起稿
- 日复盘文档起稿

### `weekN/hubs/`

放每周导航文档，不承载完整知识正文。

作用：

- 说明这一周的目标、模块划分和每日映射
- 指向对应专题正文
- 说明复盘方式和最小达标标准

### `weekN/topics/`

放本周需要长期复用的专题正文。

默认以技术 / 系统专题为主，但如果某一周的目标本身包含项目复盘、排障收口或表达训练，对应专题也可以放在这里。前提是：

- 它必须在周导航里被明确标出定位
- 它不能冒充目录规则文档
- 它也不能替代对应技术专题的机制正文

### `weekN/daily/`

放你某天真实练习后产生的复盘文档。

作用：

- 记录当天暴露出的最弱点
- 记录下一步补救动作
- 不替代专题正文

## 3. 推荐使用顺序

每天建议这样用：

1. 先看对应 `weekN/hubs/` 里的周导航，确认当天目标和入口
2. 再看 `weekN/topics/` 里的对应专题正文
3. 当天如果有真实输出或模拟问答，再回到 `weekN/daily/` 做复盘

## 4. 当前整理结论

当前 `reviews/` 的主结构已经可用，不需要做目录级重组；当前最主要的工作是：

- 继续沿用 `hubs / topics / daily` 的边界
- 对少数定位偏移的专题补充说明或修正文案
- 用专项审查记录持续追踪 Week3-Week4 的整理结论
