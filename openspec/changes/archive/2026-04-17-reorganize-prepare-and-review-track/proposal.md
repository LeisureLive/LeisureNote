## Why

`prepare/2026/` 当前同时承担了长期复用框架、年度准备入口、具体岗位主线和执行记录等多种职责，目录层级和文件边界已经开始变得分散，导致进入路径不清、复用层和本次岗位主线混杂，也增加了后续扩展到其他年份或其他岗位时的维护成本。与此同时，`prepare/2026/tracks/xiaomi_java_data_service/` 下的计划和复习材料是逐步生成的，当前缺少一次面向目标岗位要求的系统性复核，存在计划安排与岗位要求不完全对齐、技术复习与算法训练覆盖不足的风险。

## What Changes

- 重新梳理 `prepare/` 目录职责，明确长期复用层、年度入口层、具体岗位 track 层和执行记录层的边界。
- 调整 `prepare/2026/` 尤其是 `workspace/` 与 `tracks/` 的组织方式和入口说明，使结构更清晰、命名更稳定、后续年份与岗位更易扩展。
- 针对 `prepare/2026/tracks/xiaomi_java_data_service/` 现有材料做一次面向目标岗位要求的系统 review，核对准备计划、知识复习和算法练习是否覆盖充分。
- 基于 review 结果补充或调整计划文档、导航文档和结构说明，显式标出不合理安排、缺口项和后续优先级。

## Capabilities

### New Capabilities
- `prepare-structure-governance`: 定义面试准备目录的分层规则、入口说明和调整原则，使长期复用框架与具体年度/岗位内容边界清晰。
- `interview-track-gap-review`: 定义如何基于目标岗位要求复核具体 track 的计划完整性、能力覆盖度与缺口调整输出。

### Modified Capabilities

## Impact

- Affected directories:
  - `prepare/2026/`
  - `prepare/2026/workspace/`
  - `prepare/2026/tracks/`
  - `prepare/2026/tracks/xiaomi_java_data_service/`
- Likely affected files:
  - 年度入口 README、workspace 说明文件、track README、月计划、岗位要求汇总、知识导航与相关索引文档
- No code module, API, or dependency changes are expected.
