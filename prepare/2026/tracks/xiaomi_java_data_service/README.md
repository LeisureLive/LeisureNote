# 小米 Java 数据服务 track 说明

这个目录对应一条具体的面试准备主线：

- 目标岗位：小米 Java 研发工程师（数据服务）

这里放的是和这条岗位主线强绑定的内容：

- 冲刺计划
- 知识地图
- 算法专题
- 按周的专题复习文档和每日复盘

## 1. 目录结构

```text
xiaomi_java_data_service/
├── README.md
├── 00_high_frequency_knowledge_map.md
├── 01_1month_plan.md
├── 02_merged_role_requirements_and_prep_focus.md
├── algorithms/
└── reviews/
```

## 2. 各文件 / 目录职责

### `01_1month_plan.md`

作用：

- 这条主线的总计划
- 解决“4 周怎么推进”的问题

适合先看它，明确：

- 周目标
- 每日安排
- 每周输出物

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

### `algorithms/`

作用：

- 算法专题材料

适合放：

- 算法总路线图
- 按数据结构 / 模式拆分的专题文档

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

1. 先看 `01_1month_plan.md`
2. 再看 `00_high_frequency_knowledge_map.md`
3. 然后进入 `reviews/README.md`
4. 按周导航进入：
   - `reviews/week1/hubs/00_week1_review_hub.md`
5. 再进入当天对应的：
   - 专题正文
   - 每日复盘

## 4. 这层结构的边界

这层目录只放“小米 Java 数据服务”这条主线的内容。

不建议继续放进来的内容：

- 跨岗位通用的主档案
- 跨岗位通用的周进展
- 通用聊天同步模板

这些应该继续放在：

- `prepare/2026/workspace/`
