# IDE Sync - VSCode-JetBrains IDE Sync

[中文](./README.md) | **English**

> **Note:** This synchronization system is suitable for VSCode, VSCode forks like Cursor or Windsurf as well as JetBrains IntelliJ-based IDEs like Rider, IntelliJ IDEA and WebStorm.

A synchronization system that allows seamless switching between VSCode and JetBrains IntelliJ-based IDEs while maintaining the current file and cursor position.

## Installation via Marketplace

### VSCode Extension
Install directly from the [Visual Studio Code Marketplace](https://marketplace.visualstudio.com/items?itemName=denisbalber.vscode-jetbrains-sync)

- Open VSCode
- Go to Extensions (Ctrl+Shift+X)
- Search for "IDE Sync - Connect to JetBrains IDE"
- Click Install

### JetBrains IDE Plugin
Install directly from the [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/26201-ide-sync--connect-to-vscode)
- Open JetBrains IDE
- Go to Settings > Plugins
- Search for "IDE Sync - Connect to VSCode"
- Click Install

## Version Compatibility

### VSCode
- Supported versions: VSCode 1.84.0 and newer

### JetBrains IDE
- Supported versions: 2023.3 and newer

## Configuration

The default port is 3000, this can be changed in the respective settings and must be the same:
- In VSCode: Settings > Extensions > IDE Sync - Connect to JetBrains IDE > Port
- In JetBrains IDE: Settings > Tools > IDE Sync - Connect to VSCode > WebSocket Port

### Auto Sync on Startup

You can now configure the sync to start automatically when the IDE launches:

**VSCode:**
- Go to Settings > Extensions > IDE Sync - Connect to JetBrains IDE
- Enable "Auto Sync On Startup" checkbox
- Restart VSCode for the setting to take effect

**JetBrains IDE:**
- Go to Settings > Tools > IDE Sync - Connect to VSCode
- Enable "自动启动同步" checkbox
- Restart the IDE for the setting to take effect

*Note: Auto sync is disabled by default to maintain backward compatibility.*

### One-Way Sync Mode

**VSCode Receive-Only Mode:**
- Go to Settings > Extensions > IDE Sync - Connect to JetBrains IDE
- Enable "Receive Only" checkbox
- VSCode will only receive sync from JetBrains IDE without sending changes back

*Perfect for scenarios where you primarily edit in JetBrains and want VSCode to mirror your changes.*

## Usage

1. Start both IDEs
2. Make sure that the sync is activated in the status bar of both IDEs
3. When you switch between IDEs, the current file and cursor position will be synchronized automatically

## Features

- **Real-time synchronization** - Instant file opening and cursor position sync between IDEs
- **Automatic reconnection** - Smart reconnection on port changes or network interruptions
- **Status bar indicator** - Visual connection status in both IDEs
- **Auto sync on startup** - Configure sync to start automatically when IDE launches (configurable in settings, disabled by default)
- **One-way sync mode** - Configure VSCode to only receive sync from JetBrains IDE without sending back (JetBrains → VSCode direction)
- **Non-preview mode** - Files always open in persistent mode, not preview tabs

## Components

### VSCode Extension
- Located in `/vscode-extension`
- Monitors current file and cursor position in VSCode
- Communicates with JetBrains plugin via WebSocket

### JetBrains IDE Plugin
- Located in `/jetbrains-plugin`
- Monitors current file and cursor position in JetBrains IDE
- Communicates with VSCode extension via WebSocket

## Building

### Prerequisites
- Node.js and npm for VSCode extension
- JDK 17+ and Gradle for JetBrains IDE plugin

### Build Steps

1. Clone the repository
```bash
git clone https://github.com/shengmingboai/IDESync-VSCode-JetBrains.git
cd IDESync-VSCode-JetBrains
```

2. Build VSCode extension
```bash
cd vscode-extension
npm install
npm run build
npm run package
cd ..
```

3. Build JetBrains plugin
```bash
cd jetbrains-plugin
gradle wrapper
./gradlew buildPlugin
cd ..
```

## Manual Installation

### VSCode Extension
1. Install the VSCode extension: `Ctrl+Shift+P` > `Extensions: Install from VSIX...` > Select `IDESync-VSCode-JetBrains/vscode-extension/vscode-jetbrains-sync-1.0.19.vsix`
2. Restart VSCode

### JetBrains IDE Plugin
1. Install the JetBrains IDE plugin: `Settings` > `Plugins` > `Manage Repositories,... (Settings symbol)` > `Install Plugin from Disk...` > Select  `IDESync-VSCode-JetBrains/jetbrains-plugin/build/distributions/vscode-jetbrains-sync-1.0.19.zip`
2. Restart JetBrains IDE

## License

This project is licensed under the AGPL-3.0 License - see the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

If you encounter any issues or have suggestions, please [open an issue](https://github.com/shengmingboai/IDESync-VSCode-JetBrains/issues) on GitHub.
