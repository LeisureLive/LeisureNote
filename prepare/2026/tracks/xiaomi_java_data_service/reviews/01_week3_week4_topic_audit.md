# Week3-Week4 专题审查记录

对应 change：

- `openspec/changes/audit-xiaomi-review-docs-after-week3/`

审查范围：

- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/02_spark_dag_shuffle_and_data_skew_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/03_hdfs_hive_impala_and_query_engine_selection_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/04_realtime_subscription_system_design_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/05_realtime_query_system_design_and_multi_engine_selection_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/06_high_availability_idempotency_consistency_and_distributed_transaction_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/07_data_platform_metadata_scheduling_monitoring_permission_multitenancy_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/08_project_architecture_upgrade_from_function_to_platform_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/09_bigdata_pipeline_component_roles_summary_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week4/topics/01_troubleshooting_performance_linux_network_system_review.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week4/topics/02_project_story_highlights_and_followups_system_review.md`

审查基线：

- `prepare/2026/tracks/xiaomi_java_data_service/02_merged_role_requirements_and_prep_focus.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`
- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/README.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/rules/00_review_doc_writing_rules.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/hubs/00_week3_review_hub.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week4/hubs/00_week4_review_hub.md`

## 1. 总体结论

结论先说：

- `reviews/` 目录的主结构是合理的，`README / rules / templates / week*/hubs|topics|daily` 这一套边界基本成立，不需要做目录级重组。
- Week3 从 `02_spark...` 之后到 Week4 的大多数专题文档，已经符合“问题驱动、先回答问题、再展开机制和边界”的写法，能够支撑系统化复习，不是浮在概念层。
- 当前最需要修的不是大面积技术内容缺口，而是少数文档的定位偏移：
  - `reviews/README.md` 仍然偏 Week1 视角，且没有把“按需补 daily”和“Week4 含项目表达专题”说明清楚。
  - `week3/topics/08_project_architecture_upgrade_from_function_to_platform_system_review.md` 混入了较多“怎么讲项目”的表达语气，削弱了它作为架构演进专题正文的稳定性。
  - `week4/topics/02_project_story_highlights_and_followups_system_review.md` 本质上是项目复盘与表达专题，不应被误读成和技术机制专题同一种正文。

## 2. 目录治理 Findings

### Findings

1. 目录边界整体成立。
   - `README` 负责目录说明。
   - `rules` 负责写作规范。
   - `templates` 负责模板。
   - `hubs` 负责周导航。
   - `topics` 负责本周需要长期复用的专题正文。
2. `README` 的展示视角仍然停留在 `week1`，容易给后续使用造成两个误导：
   - 误导一：仿佛当前结构只稳定服务 Week1。
   - 误导二：仿佛每周都必须预置 `daily/`，而当前实际做法是按需补复盘。
3. Week4 当前已经引入“项目复盘/表达专题”，但 `README` 与 `week4/hubs` 没有把它和技术机制专题的差异说明清楚。

### Actions

- 继续保留现有目录结构，不做目录迁移。
- 更新 `reviews/README.md`：
  - 从 Week1 视角改为通用结构视角。
  - 补充 `topics` 的真实职责边界。
  - 明确 `daily` 为按需补，不强制每周预置。
  - 增加当前专项审查记录入口。
- 更新 `week4/hubs/00_week4_review_hub.md`：
  - 明确 `02_project_story...` 是项目复盘与表达专题，依赖 Week3 技术专题，不替代技术正文。

## 3. 专题逐篇审查结论

| 文档 | 岗位匹配度 | 计划匹配度 | 学习导向 | 深度充分度 | 结论 | 说明 |
| --- | --- | --- | --- | --- | --- | --- |
| `week3/topics/02_spark_dag_shuffle_and_data_skew_system_review.md` | 高 | 高 | 系统学习导向明确 | 高 | 匹配 | 运行模型、Stage/Task、Shuffle 成本、倾斜与 AQE 解释充分，适合当前岗位的大数据开发主线。 |
| `week3/topics/03_hdfs_hive_impala_and_query_engine_selection_system_review.md` | 高 | 高 | 系统学习导向明确 | 高 | 匹配 | 能把存储、表语义、交互式查询和分析服务分层讲清，和周计划、知识地图一致。 |
| `week3/topics/04_realtime_subscription_system_design_system_review.md` | 高 | 高 | 系统学习导向明确 | 高 | 匹配 | 场景、规模估算、链路拆分、元数据、幂等与治理闭环完整，符合目标岗位系统设计要求。 |
| `week3/topics/05_realtime_query_system_design_and_multi_engine_selection_system_review.md` | 高 | 高 | 系统学习导向明确 | 高 | 匹配 | 查询模型、规模估算、多引擎角色和缓存/预计算/冷热分层边界比较完整。 |
| `week3/topics/06_high_availability_idempotency_consistency_and_distributed_transaction_system_review.md` | 高 | 高 | 系统学习导向明确 | 高 | 匹配 | 把高可用、幂等、一致性和事务放回同一条业务链，符合当前阶段优先级。 |
| `week3/topics/07_data_platform_metadata_scheduling_monitoring_permission_multitenancy_system_review.md` | 高 | 高 | 系统学习导向明确 | 高 | 匹配 | 平台能力闭环完整，适合作为数据平台能力抽象专题正文。 |
| `week3/topics/08_project_architecture_upgrade_from_function_to_platform_system_review.md` | 高 | 高 | 部分偏向项目表达 | 中高 | 部分匹配 | 核心主题正确，但局部语句更像“如何讲项目平台化”，弱化了对系统演进本身的理解。 |
| `week3/topics/09_bigdata_pipeline_component_roles_summary_system_review.md` | 高 | 高 | 基本正确，少量表达提示 | 中高 | 匹配 | 适合作为 Week3 收口摘要；少量“面试准备”语句可接受，不影响主线。 |
| `week4/topics/01_troubleshooting_performance_linux_network_system_review.md` | 高 | 高 | 系统学习导向明确 | 高 | 匹配 | 现象、范围、链路、根因、止损主线稳定，符合排障专题定位。 |
| `week4/topics/02_project_story_highlights_and_followups_system_review.md` | 中高 | 高 | 明显偏项目表达训练 | 中 | 部分匹配 | 这篇文档本质上是项目复盘与表达专题，不应按技术机制专题的深度标准硬判；需补清定位，避免误用。 |

## 4. 高优先级调整

### P0

1. 更新 `reviews/README.md`，修正 Week1 视角和 `daily` 预置误导。
2. 更新 `week4/hubs/00_week4_review_hub.md`，明确 Week4 的 `02_project_story...` 是项目复盘与表达专题。
3. 调整 `week3/topics/08_project_architecture_upgrade_from_function_to_platform_system_review.md`，把重点从“怎么讲平台化”收回到“为什么系统会走向平台化，以及平台化真正改变了什么”。

### P1

1. 在 `week4/topics/02_project_story_highlights_and_followups_system_review.md` 顶部补充定位说明，明确它依赖 Week3 技术专题，不替代技术正文。
2. 保留 `week3/topics/09_bigdata_pipeline_component_roles_summary_system_review.md` 现状，不做立即改写。

## 5. 当前不建议做的事

- 不回头大改 `week3/topics/02` 之前的技术专题。
- 不为了统一风格，把 Week4 的项目表达专题强行改写成纯技术机制文档。
- 不新增新的目录层级来放“审查记录”或“项目表达”专题，先用说明文档把边界写清楚。

## 6. 信息边界与未处理项

- 当前岗位要求基线来自仓库里的合并整理文档，不是完整原始 JD；如果后续补了新的 JD 或真实面试反馈，这份审查记录需要增量更新。
- Week4 还列了“高频题最终版清单”“设计题提纲清单”等输出目标，但这些不在本次专题审查范围内。
- `week4/topics/02_project_story...` 的目标本来就不是替代技术正文，因此这里只要求澄清定位，不要求把它重写成一篇大而全的技术文档。
