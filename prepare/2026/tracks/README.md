# tracks 目录说明

这个目录用于按“岗位 / 公司 / 面试主线”拆分准备内容。

你可以把每个 `track` 理解成一条独立的备战线路。

例如：

- 一个 `track` 对应某个目标岗位
- 一个 `track` 对应某家公司
- 一个 `track` 对应某条专项求职方向

## 1. 为什么要有这一层

年度画像、执行记录和通用模板不属于 `track`。

更适合放在其他层的内容包括：

- 年度画像：
  - `prepare/2026/profile/`
- 年度执行记录：
  - `prepare/2026/records/`
- 通用协作模板：
  - `prepare/common/templates/`

但真正和某个岗位强绑定的内容，例如：

- 1 个月冲刺计划
- 知识地图
- 专题复习文档
- 按周的日复盘

就不应该继续混在年度画像、年度记录或通用模板层里，而应该放进具体 `track/`。

## 2. 当前已有的 track

- `xiaomi_java_data_service/`

它对应：

- 目标岗位：小米 Java 研发工程师（数据服务）

## 3. 每个 track 里通常应该有什么

建议每个 `track` 至少包含：

- `README.md`
  - 该 track 的入口说明
- `00_xxx_map.md`
  - 知识地图 / 高频知识导航
- `01_xxx_plan.md`
  - 阶段计划 / 冲刺计划
- `algorithms/`
  - 算法专题材料
- `reviews/`
  - 周导航、专题复习文档、每日复盘

## 4. 后续扩展建议

后续如果有新的方向，直接在这一层继续加子目录即可，例如：

- `java_backend_common/`
- `bigdata_platform/`
- `company_x_backend/`

原则是：

- 一条求职主线一个 `track`
- 不要把多个岗位方向的复习正文混在同一个 `track` 里
