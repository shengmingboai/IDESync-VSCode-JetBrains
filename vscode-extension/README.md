# IDE Sync - VSCode-JetBrains 同步

**简体中文** | [English](./README_EN.md)

> **注意：** 此同步系统适用于 VSCode、VSCode 分支（如 Cursor、Windsurf）以及 JetBrains IntelliJ 系列 IDE（如 Rider、IntelliJ IDEA、WebStorm）。

此扩展可在 VS Code 和 JetBrains IDE 之间实现同步。它会自动同步两个编辑器之间的光标位置和活动文件。

## 功能特性

- **实时同步** - 自动光标位置和活动文件同步
- **状态栏切换** - 状态栏中便捷的启用/禁用切换按钮
- **启动时自动同步** - VSCode 启动时自动开始同步（可配置）
- **单向同步模式** - VSCode 仅接收模式（仅接收来自 JetBrains 的更改）
- **非预览模式** - 文件始终在持久标签页中打开

## 安装

1. 从 VS Code 市场安装名为 `IDE Sync - Connect to JetBrains IDE` 的扩展
2. 在 JetBrains IDE 中安装相应的插件 `IDE Sync - Connect to VSCode`

## 使用方法

1. 安装后，你会在 VS Code 状态栏中看到一个切换按钮
2. 点击按钮以启用/禁用同步
3. 按钮显示当前状态：
   - `Turn IDE Sync On` - 同步已禁用
   - `IDE Sync On` - 同步已启用

## 设置

你可以在 VS Code 设置中配置此扩展：

1. 打开 VS Code 设置
2. 搜索 "IDE Sync - Connect to JetBrains IDE"
3. 可用设置：
   - **Port（端口）** - WebSocket 端口号（默认：3000，必须与 JetBrains 插件匹配）
   - **Auto Sync On Startup（启动时自动同步）** - VS Code 启动时自动开始同步（默认：false）
   - **Receive Only（仅接收）** - 仅接收来自 JetBrains IDE 的更改，不发送 VSCode 的更改（默认：false）

## 故障排除

如果无法建立连接：
1. 确保两个插件都已安装
2. 检查两个 IDE 中的 IDE Sync 是否都已开启
3. 验证两个插件中的端口设置是否匹配
4. 重启两个编辑器

## 反馈与问题

请在 [GitHub](https://github.com/shengmingboai/IDESync-VSCode-JetBrains/issues) 上报告问题或提出建议。