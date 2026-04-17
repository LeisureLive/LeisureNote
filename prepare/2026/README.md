# 2026 面试准备工作台

这一层只服务 2026 这一轮具体准备，不再承载全部长期复用框架。

当前结构：

```text
prepare/2026/
├── README.md
├── profile/
│   ├── README.md
│   └── 00_interview_master.md
├── records/
│   ├── README.md
│   ├── 00_weekly_progress.md
│   ├── 01_interview_log.md
│   └── 02_daily_execution_checklist.md
└── tracks/
    ├── README.md
    └── xiaomi_java_data_service/
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

年度层职责：

- `profile/`
  - 2026 这一轮准备的长期背景画像
- `records/`
  - 2026 这一轮准备的周记录、面试记录和每日执行记录
- `tracks/`
  - 具体岗位或公司主线的计划、知识地图、算法和复习材料

长期复用模板已经上移到：

- `prepare/common/templates/`

建议按下面顺序使用：

1. 先看年度画像：
   - `prepare/2026/profile/00_interview_master.md`
2. 再看当前岗位主线：
   - `prepare/2026/tracks/xiaomi_java_data_service/README.md`
3. 进入岗位要求与 gap review：
   - `02_merged_role_requirements_and_prep_focus.md`
   - `03_gap_review_and_adjustments.md`
4. 再用专项输出文档补足表达类短板：
   - `04_project_story_stable_draft.md`
   - `05_project_followup_checklist.md`
   - `06_troubleshooting_qa_outline.md`
   - `07_engineering_quality_and_collaboration_outline.md`
5. 再推进技术主线和算法主线：
   - `01_1month_plan.md`
   - `algorithms/90_1month_algorithm_plan.md`
6. 日常推进时回到年度记录：
   - 周级：`prepare/2026/records/00_weekly_progress.md`
   - 每日：`prepare/2026/records/02_daily_execution_checklist.md`
   - 面试后：`prepare/2026/records/01_interview_log.md`
7. 每次新开对话时，按场景使用：
   - `prepare/common/templates/00_chat_sync_template.md`
   - `prepare/common/templates/01_session_sync_templates.md`

建议维护节奏：

- 年度画像：背景变化时更新
- 周进展：每周更新 1 次
- 面试记录：每场模拟 / 真实面试后更新
- 每日执行清单：每天更新
- track 文档：只在计划、知识结构或复习输出发生变化时更新
