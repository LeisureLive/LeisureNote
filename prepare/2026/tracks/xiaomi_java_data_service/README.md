# 小米 Java 数据服务 track 说明

这个目录对应一条具体的面试准备主线：

- 目标岗位：小米 Java 研发工程师（数据服务）

这里放的是和这条岗位主线强绑定的内容：

- 技术主线冲刺计划
- 知识地图
- 算法专题与算法专项计划
- 按周的专题复习文档和每日复盘

## 1. 目录结构

```text
xiaomi_java_data_service/
├── README.md
├── 00_high_frequency_knowledge_map.md
├── 01_1month_plan.md
├── 02_merged_role_requirements_and_prep_focus.md
├── 03_gap_review_and_adjustments.md
├── 04_project_story_stable_draft.md
├── 05_project_followup_checklist.md
├── 06_troubleshooting_qa_outline.md
├── 07_engineering_quality_and_collaboration_outline.md
├── algorithms/
└── reviews/
```

## 2. 各文件 / 目录职责

### `01_1month_plan.md`

作用：

- 这条主线的技术准备总计划
- 解决“技术主线 4 周怎么推进”的问题

适合先看它，明确：

- 周目标
- 每日安排
- 每周输出物

补充说明：

- 算法练习现已独立规划
- `01_1month_plan.md` 里保留的是技术主线安排，算法部分从 `Week1 Day7` 起统一改按 `algorithms/90_1month_algorithm_plan.md` 执行

### `00_high_frequency_knowledge_map.md`

作用：

- 高频知识导航图
- 解决“今天这个模块到底该掌握到什么深度”的问题

它不是专题正文，而是：

- 每天进入专题前的知识导航层

### `02_merged_role_requirements_and_prep_focus.md`

作用：

- 汇总当前已收集的小米相关岗位要求
- 提炼统一的岗位准备重点

适合先看它，明确：

- 这些岗位真正共同要求什么
- 哪些是当前主线
- 哪些只是加分项
- 后续为什么要调整知识地图和月计划

### `03_gap_review_and_adjustments.md`

作用：

- 基于目标岗位要求，对当前主线材料做系统 review
- 显式指出哪些要求已覆盖、哪些覆盖不足、哪些安排需要调整

适合在正式推进计划前先看它，明确：

- 当前准备是否和岗位要求真正对齐
- 技术主线、算法训练、项目表达和排障准备哪里还有缺口
- 后续优先应该调整什么

### `04_project_story_stable_draft.md`

作用：

- 把核心项目整理成可直接面试使用的稳定稿
- 提供 1 分钟版、3 分钟版和展开重点

### `05_project_followup_checklist.md`

作用：

- 收口项目面高频追问
- 防止项目故事能讲主线，但一追问就散

### `06_troubleshooting_qa_outline.md`

作用：

- 收口排障、Linux、网络、线上问题定位这条主线
- 提供资深岗常见排障题的答题提纲

### `07_engineering_quality_and_collaboration_outline.md`

作用：

- 收口工程质量、测试意识、发布回滚、跨团队协作这条表达线
- 弥补当前计划里“提到过但没有稳定输出”的缺口

### `algorithms/`

作用：

- 算法专题材料与算法专项计划

适合放：

- 算法总路线图
- 按数据结构 / 模式拆分的专题文档
- 算法专项月计划
- 已做题台账与去重索引

### `reviews/`

作用：

- 承载这条岗位主线下的复习输出

当前已经按角色拆成：

- `rules/`
  - 复习文档写作规范
- `templates/`
  - 周导航、专题正文、每日复盘模板
- `week1/hubs/`
  - Week1 导航文档
- `week1/topics/`
  - Week1 专题正文
- `week1/daily/`
  - Week1 每日复盘

## 3. 推荐使用顺序

如果你是第一次进入这条主线，建议按下面顺序：

1. 先看 `02_merged_role_requirements_and_prep_focus.md`
2. 再看 `03_gap_review_and_adjustments.md`
3. 再看：
   - `04_project_story_stable_draft.md`
   - `05_project_followup_checklist.md`
   - `06_troubleshooting_qa_outline.md`
   - `07_engineering_quality_and_collaboration_outline.md`
4. 再进入 `01_1month_plan.md`
5. 然后看 `00_high_frequency_knowledge_map.md`
6. 如果要推进算法，进入：
   - `algorithms/00_algorithm_roadmap.md`
   - `algorithms/90_1month_algorithm_plan.md`
7. 然后进入 `reviews/README.md`
8. 按周导航进入：
   - `reviews/week1/hubs/00_week1_review_hub.md`
9. 再进入当天对应的：
   - 专题正文
   - 每日复盘

## 4. 这层结构的边界

这层目录只放“小米 Java 数据服务”这条主线的内容。

不建议继续放进来的内容：

- 跨岗位通用的主档案
- 跨岗位通用的周进展
- 通用聊天同步模板

这些应该继续放在：

- `prepare/2026/profile/`
- `prepare/2026/records/`
- `prepare/common/templates/`
