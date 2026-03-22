# 2026 面试准备工作台

这套模板用于解决和 AI 长期协作时“上下文容易丢失”的问题。

核心原则：

- 用固定文件保存长期稳定信息，而不是依赖单次对话记忆
- 每周更新阶段进展，每次对话前快速同步
- 每次结束沉淀结论和下一步，保证准备过程连续

## 目录结构

```text
prepare/2026/
├── README.md
├── workspace/
│   ├── 00_interview_master.md
│   ├── 01_weekly_progress.md
│   ├── 02_chat_sync_template.md
│   ├── 03_interview_log.md
│   ├── 04_daily_execution_checklist.md
│   └── 05_session_sync_templates.md
└── tracks/
    └── xiaomi_java_data_service/
        ├── algorithms/
        │   ├── 00_algorithm_roadmap.md
        │   ├── 01_arrays.md
        │   └── 02_hashing.md
        ├── 01_1month_plan.md
        └── reviews/
            └── week1/
                └── day1_threadpool_lock_review.md
```

分层原则：

- `workspace/`：长期稳定、跨岗位复用的协作文件
- `tracks/`：按岗位或公司拆分的准备主线
- `tracks/<track>/algorithms/`：按专题沉淀算法复习材料
- `tracks/<track>/reviews/weekN/`：按周沉淀单日复盘和专项提纲，避免根目录堆积日更文件

建议使用顺序：

1. 先填写 `prepare/2026/workspace/00_interview_master.md`
2. 每周更新 `prepare/2026/workspace/01_weekly_progress.md`
3. 每次开启新对话前，基于 `prepare/2026/workspace/02_chat_sync_template.md` 贴给 AI
4. 每次模拟面试或真实面试后，记录到 `prepare/2026/workspace/03_interview_log.md`
5. 按 `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md` 执行小米这条 1 个月冲刺计划
6. 每天用 `prepare/2026/workspace/04_daily_execution_checklist.md` 做最小复盘
7. 每次开启新对话或复盘时，直接复制 `prepare/2026/workspace/05_session_sync_templates.md` 中的模板
8. 对单日重点主题做专项沉淀时，统一放到对应岗位目录下，例如 `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/day1_threadpool_lock_review.md`
9. 对算法做体系化沉淀时，统一放到对应岗位目录下，例如 `prepare/2026/tracks/xiaomi_java_data_service/algorithms/00_algorithm_roadmap.md`

建议维护节奏：

- 主档案：信息变化时更新
- 周进展：每周更新 1 次
- 对话同步：每次新对话使用
- 面试记录：每场模拟/真实面试后更新

你也可以后续再按岗位拆分子目录，例如：

- `prepare/2026/tracks/java_backend/`
- `prepare/2026/tracks/bigdata/`
- `prepare/2026/tracks/interview_company_a/`
