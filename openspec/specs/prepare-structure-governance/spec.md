# prepare-structure-governance Specification

## Purpose
TBD - created by archiving change reorganize-prepare-and-review-track. Update Purpose after archive.
## Requirements
### Requirement: Prepare 目录必须区分长期复用层与年度执行层
面试准备目录结构 MUST 明确区分“可跨年份复用的长期框架”与“某一年度或某一岗位主线的执行内容”，避免把长期模板、协作规范和一次性年度材料混放在同一层级中。

#### Scenario: 识别长期复用内容
- **WHEN** 用户审视 `prepare/` 下的结构和入口文档
- **THEN** 长期复用的框架性内容可以被识别为跨年份复用资产，而不是仅绑定到 `prepare/2026/`

#### Scenario: 保留年度执行内容边界
- **WHEN** 用户进入某个年份目录查看当年的准备材料
- **THEN** 年度准备计划、岗位 track、阶段记录等内容仍然保持在该年份上下文内，不会与长期模板层混杂

### Requirement: Prepare 目录必须提供清晰的入口说明与职责边界
目录入口文档 MUST 用一致且易懂的方式说明各层目录的职责、推荐使用顺序、适用范围以及不应放入该层的内容，帮助用户快速判断文件应该放在哪里。

#### Scenario: 从 prepare 根目录进入
- **WHEN** 用户首次从 `prepare/` 或某个入口 README 进入面试准备体系
- **THEN** 用户可以理解长期复用层、年份层、track 层和执行记录层之间的关系与进入路径

#### Scenario: 判断文件归属
- **WHEN** 用户准备新增或调整某份面试准备文档
- **THEN** 文档说明可以帮助用户判断该内容应该放在通用框架、年度目录还是具体 track 目录中

### Requirement: 结构调整必须保持现有材料可迁移且可追踪
当目录结构或文件命名发生调整时，变更方案 MUST 给出迁移映射或更新后的入口关系，避免出现孤立文档、失效入口或难以发现的历史内容。

#### Scenario: 调整 README 或目录入口
- **WHEN** 某个入口目录、README 或索引文档被修改
- **THEN** 相关的上层入口文档也会同步更新，确保新路径和使用顺序仍然可追踪

#### Scenario: 迁移现有文档
- **WHEN** 既有面试准备文档需要被移动、重命名或重新归类
- **THEN** 变更结果中会明确保留文档语义，并说明迁移后的归属和目的

### Requirement: reviews 目录必须明确 README、rules、templates 与 week 子目录的职责边界
`prepare/2026/tracks/xiaomi_java_data_service/reviews/` 的内部结构 MUST 明确区分目录说明、写作规范、模板、周导航、专题正文和日复盘的职责，避免单个文件同时承担规则、正文、导航和复盘等多种角色。

#### Scenario: 判断 reviews 内文件归属
- **WHEN** 用户审视 `reviews/README.md`、`rules/`、`templates/`、`week*/hubs/`、`week*/topics/` 与 `week*/daily/`
- **THEN** 能够明确判断每类文件分别负责目录说明、规范、模板、周导航、专题正文或日复盘，而不会把不同职责混写在同一层

#### Scenario: 发现职责混淆
- **WHEN** 某个 `hubs/` 或 `README.md` 文件开始承载大量专题正文，或某个 `topics/` 文档开始承担目录规则说明
- **THEN** 结构审查输出会将其判定为职责边界问题，并指出应回归到哪个目录角色

### Requirement: reviews 目录必须提供稳定的使用顺序与扩展方式
`reviews/` 的入口说明和周导航 MUST 让用户能够理解推荐使用顺序，并在新增周目录或专题文档时继续沿用 `hubs / topics / daily` 的稳定结构，而不是临时混入新的同层角色。

#### Scenario: 从 reviews 入口进入
- **WHEN** 用户从 `prepare/2026/tracks/xiaomi_java_data_service/reviews/README.md` 进入复习体系
- **THEN** 用户可以理解先看目录说明和规则，再进入周导航、专题正文和日复盘的推荐使用顺序

#### Scenario: 扩展新的周次内容
- **WHEN** 后续继续新增 Week 文档或调整现有周次内容
- **THEN** 扩展方式仍然保持在 `week*/hubs/`、`week*/topics/`、`week*/daily/` 的边界内，并通过入口说明或周导航维持可追踪关系
