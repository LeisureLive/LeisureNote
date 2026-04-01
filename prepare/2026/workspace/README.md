# workspace 目录说明

这个目录放“长期稳定、跨岗位复用、偏协作管理”的文件。

它和 `tracks/` 的区别是：

- `workspace/`
  - 管理准备过程
  - 管理长期背景
  - 管理对话同步和面试记录
- `tracks/`
  - 管理某条具体岗位主线下的计划、专题复习正文和日复盘

## 1. 文件职责

### `00_interview_master.md`

作用：

- 面试主档案
- 放长期稳定的背景信息

适合放：

- 目标岗位
- 背景经历
- 项目清单
- 优势短板
- 求职策略

这份文件不应该频繁大改，只有背景发生变化时才更新。

### `01_weekly_progress.md`

作用：

- 每周进展记录

适合放：

- 本周计划
- 本周完成情况
- 本周薄弱点
- 下周优先级

它解决的是“阶段性追踪”，不是“当天复盘”。

### `02_chat_sync_template.md`

作用：

- 新对话快速同步模板

适合场景：

- 想在最短时间里，把当前准备状态同步给 AI

这份文件偏“单模板、快速使用”。

### `03_interview_log.md`

作用：

- 模拟面试 / 真实面试记录

适合放：

- 每场面试的题目
- 追问
- 暴露出的薄弱点
- 后续行动

它记录的是“场次级事件”，不是按天的学习复盘。

### `04_daily_execution_checklist.md`

作用：

- 每日执行清单

适合场景：

- 当天做一个轻量记录
- 记录计划完成情况和基本衔接信息

这份文件偏“最小执行层记录”，重点是：

- 今天做了什么
- 今天完成了没有
- 明天接什么
- 是否需要进一步补详细日复盘

补充说明：

- 技术主线和算法专项现在可以都通过这份清单做轻量记录
- 但算法题目的规划、题目台账和去重信息，不放在这里维护，而统一放在：
  - `prepare/2026/tracks/xiaomi_java_data_service/algorithms/`

它不替代 `reviews/weekN/daily/` 里的详细日复盘。

你可以这样区分：

- `04_daily_execution_checklist.md`
  - 更轻
  - 更像执行清单
- `reviews/weekN/daily/*.md`
  - 更重
  - 更像基于真实表现的复盘文档

推荐配合方式：

- 先写 `04_daily_execution_checklist.md`
- 如果当天出现明显卡点、答题讲散、算法没做出，再补 `reviews/weekN/daily/*.md`

### `05_session_sync_templates.md`

作用：

- 多场景对话同步模板集合

和 `02_chat_sync_template.md` 的区别是：

- `02_chat_sync_template.md`
  - 单一快速模板
- `05_session_sync_templates.md`
  - 按场景拆分的模板集合
  - 包括日常推进、知识点复盘、算法复盘、模拟面试、周复盘等

## 2. 推荐使用顺序

1. 先维护 `00_interview_master.md`
2. 每周更新 `01_weekly_progress.md`
3. 新开对话时：
   - 时间紧就看 `02_chat_sync_template.md`
   - 需要按场景切模板就看 `05_session_sync_templates.md`
4. 每天推进时先记 `04_daily_execution_checklist.md`
5. 每场模拟 / 真实面试后记 `03_interview_log.md`

如果当天主要在做算法，建议额外同步看：

- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/problem_ledger_and_dedup_index.md`

## 3. 和 tracks 的边界

下面这些内容不要继续塞进 `workspace/`：

- 某个岗位专属的知识正文
- 某周的专题复习长文
- 某天的详细模拟问答复盘

这些应该进入对应 `tracks/<track>/` 下。
