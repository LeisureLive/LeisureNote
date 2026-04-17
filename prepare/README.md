# 面试准备总入口

`prepare/` 用来组织长期复用的面试准备框架，以及某一轮具体面试准备的年度材料。

当前目录按三层来组织：

```text
prepare/
├── README.md
├── common/
│   ├── README.md
│   └── templates/
└── 2026/
    ├── README.md
    ├── profile/
    ├── records/
    └── tracks/
```

三层职责如下：

- `common/`
  - 放跨年份、跨岗位复用的协作模板和方法框架
- `<year>/`
  - 放某一轮面试准备的年度上下文
- `<year>/tracks/`
  - 放具体岗位、公司或专项主线的计划和复习材料

推荐进入顺序：

1. 先看 [common/README.md](/Users/jie.he/Workspace/GitHub/LeisureNote/prepare/common/README.md)，了解哪些内容是长期复用框架。
2. 再进入 [2026/README.md](/Users/jie.he/Workspace/GitHub/LeisureNote/prepare/2026/README.md)，了解这一轮准备的年度结构。
3. 最后进入具体 track，例如：
   - [xiaomi_java_data_service/README.md](/Users/jie.he/Workspace/GitHub/LeisureNote/prepare/2026/tracks/xiaomi_java_data_service/README.md)

放置规则：

- 任何只要“未来每次准备都可能复用”的模板，优先放 `common/`
- 任何只属于 2026 这一轮准备的画像、记录、阶段进展，放 `2026/`
- 任何只属于某个岗位方向的计划、知识地图、算法专题和复习输出，放到对应 `track/`
