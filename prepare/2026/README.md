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
│   ├── README.md
│   ├── 00_interview_master.md
│   ├── 01_weekly_progress.md
│   ├── 02_chat_sync_template.md
│   ├── 03_interview_log.md
│   ├── 04_daily_execution_checklist.md
│   └── 05_session_sync_templates.md
└── tracks/
    ├── README.md
    └── xiaomi_java_data_service/
        ├── README.md
        ├── 00_high_frequency_knowledge_map.md
        ├── 01_1month_plan.md
        ├── algorithms/
        │   └── ...
        └── reviews/
            ├── README.md
            ├── rules/
            ├── templates/
            └── week1/
                ├── hubs/
                ├── topics/
                └── daily/
```

分层原则：

- `workspace/`：长期稳定、跨岗位复用的协作文件
- `tracks/`：按岗位或公司拆分的准备主线
- `tracks/<track>/algorithms/`：按专题沉淀算法复习材料
- `tracks/<track>/reviews/`：按规则、模板、周次和文档角色组织复习输出

进一步建议按下列入口理解：

- `workspace/README.md`
  - 看通用协作文件怎么用
- `tracks/README.md`
  - 看 track 这一层的职责
- `tracks/xiaomi_java_data_service/README.md`
  - 看当前这条岗位主线怎么进入
- `tracks/xiaomi_java_data_service/reviews/README.md`
  - 看复习文档体系怎么进入

建议使用顺序：

1. 先填写 `prepare/2026/workspace/00_interview_master.md`
2. 每周更新 `prepare/2026/workspace/01_weekly_progress.md`
3. 每次开启新对话前，基于 `prepare/2026/workspace/02_chat_sync_template.md` 贴给 AI
4. 每次模拟面试或真实面试后，记录到 `prepare/2026/workspace/03_interview_log.md`
5. 进入 `prepare/2026/tracks/xiaomi_java_data_service/README.md`
6. 技术主线按 `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md` 推进
7. 算法主线按 `prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md` 推进
8. 每天先用 `prepare/2026/workspace/04_daily_execution_checklist.md` 做最小执行记录
9. 再进入 `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/hubs/00_week1_review_hub.md` 看当天要读的专题正文和日复盘
10. 每次开启新对话或复盘时，按场景使用 `prepare/2026/workspace/05_session_sync_templates.md`

建议维护节奏：

- 主档案：信息变化时更新
- 周进展：每周更新 1 次
- 对话同步：每次新对话使用
- 面试记录：每场模拟/真实面试后更新
- 每日执行清单：每天更新
- 专题正文：只在需要补充知识时更新
- 日复盘：在当天完成技术主线或算法专项练习后更新

你也可以后续再按岗位拆分子目录，例如：

- `prepare/2026/tracks/java_backend/`
- `prepare/2026/tracks/bigdata/`
- `prepare/2026/tracks/interview_company_a/`
