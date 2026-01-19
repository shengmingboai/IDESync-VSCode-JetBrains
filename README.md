# IDE Sync - VSCode-JetBrains IDE 同步工具

**简体中文** | [English](./README_EN.md)

> **注意：** 此同步系统适用于 VSCode、VSCode 分支（如 Cursor、Windsurf）以及 JetBrains IntelliJ 系列 IDE（如 Rider、IntelliJ IDEA、WebStorm）。

一个允许在 VSCode 和 JetBrains IntelliJ 系列 IDE 之间无缝切换的同步系统，同时保持当前文件和光标位置。

## 通过应用市场安装

### VSCode 扩展
直接从 [Visual Studio Code 市场](https://marketplace.visualstudio.com/items?itemName=denisbalber.vscode-jetbrains-sync) 安装

- 打开 VSCode
- 进入扩展（Ctrl+Shift+X）
- 搜索 "IDE Sync - Connect to JetBrains IDE"
- 点击安装

### JetBrains IDE 插件
直接从 [JetBrains 插件市场](https://plugins.jetbrains.com/plugin/26201-ide-sync--connect-to-vscode) 安装
- 打开 JetBrains IDE
- 进入 Settings > Plugins
- 搜索 "IDE Sync - Connect to VSCode"
- 点击安装

## 版本兼容性

### VSCode
- 支持版本：VSCode 1.84.0 及更新版本

### JetBrains IDE
- 支持版本：2023.3 及更新版本

## 配置

默认端口为 3000，可以在相应设置中更改，但两边必须保持一致：
- VSCode：Settings > Extensions > IDE Sync - Connect to JetBrains IDE > Port
- JetBrains IDE：Settings > Tools > IDE Sync - Connect to VSCode > WebSocket Port

### 启动时自动同步

你现在可以配置 IDE 启动时自动开始同步：

**VSCode：**
- 进入 Settings > Extensions > IDE Sync - Connect to JetBrains IDE
- 启用 "Auto Sync On Startup" 复选框
- 重启 VSCode 使设置生效

**JetBrains IDE：**
- 进入 Settings > Tools > IDE Sync - Connect to VSCode
- 启用 "自动启动同步" 复选框
- 重启 IDE 使设置生效

*注意：为保持向后兼容性，自动同步默认禁用。*

### 单向同步模式

**VSCode 仅接收模式：**
- 进入 Settings > Extensions > IDE Sync - Connect to JetBrains IDE
- 启用 "Receive Only" 复选框
- VSCode 将仅接收来自 JetBrains IDE 的同步，而不会回传更改

*非常适合主要在 JetBrains 中编辑并希望 VSCode 镜像更改的场景。*

## 使用方法

1. 启动两个 IDE
2. 确保两个 IDE 的状态栏中同步都已激活
3. 在 IDE 之间切换时，当前文件和光标位置将自动同步

## 功能特性

- **实时同步** - IDE 之间即时文件打开和光标位置同步
- **自动重连** - 端口变更或网络中断时智能重新连接
- **状态栏指示器** - 两个 IDE 中的可视化连接状态
- **启动时自动同步** - 配置 IDE 启动时自动开始同步（可在设置中配置，默认禁用）
- **单向同步模式** - 配置 VSCode 仅接收来自 JetBrains IDE 的同步而不回传（JetBrains → VSCode 方向）
- **非预览模式** - 文件始终以持久模式打开，而非预览标签页

## 组件

### VSCode 扩展
- 位于 `/vscode-extension` 目录
- 监控 VSCode 中的当前文件和光标位置
- 通过 WebSocket 与 JetBrains 插件通信

### JetBrains IDE 插件
- 位于 `/jetbrains-plugin` 目录
- 监控 JetBrains IDE 中的当前文件和光标位置
- 通过 WebSocket 与 VSCode 扩展通信

## 构建

### 先决条件
- VSCode 扩展需要 Node.js 和 npm
- JetBrains IDE 插件需要 JDK 17+ 和 Gradle

### 构建步骤

1. 克隆仓库
```bash
git clone https://github.com/shengmingboai/IDESync-VSCode-JetBrains.git
cd IDESync-VSCode-JetBrains
```

2. 构建 VSCode 扩展
```bash
cd vscode-extension
npm install
npm run build
npm run package
cd ..
```

3. 构建 JetBrains 插件
```bash
cd jetbrains-plugin
gradle wrapper
./gradlew buildPlugin
cd ..
```

## 手动安装

### VSCode 扩展
1. 安装 VSCode 扩展：`Ctrl+Shift+P` > `Extensions: Install from VSIX...` > 选择 `IDESync-VSCode-JetBrains/vscode-extension/vscode-jetbrains-sync-1.0.19.vsix`
2. 重启 VSCode

### JetBrains IDE 插件
1. 安装 JetBrains IDE 插件：`Settings` > `Plugins` > `Manage Repositories,... (设置符号)` > `Install Plugin from Disk...` > 选择 `IDESync-VSCode-JetBrains/jetbrains-plugin/build/distributions/vscode-jetbrains-sync-1.0.19.zip`
2. 重启 JetBrains IDE

## 许可证

本项目采用 AGPL-3.0 许可证 - 详见 [LICENSE](LICENSE) 文件。

## 贡献

欢迎贡献！请随时提交 Pull Request。

## 支持

如果你遇到任何问题或有建议，请在 GitHub 上[提交 issue](https://github.com/shengmingboai/IDESync-VSCode-JetBrains/issues)。