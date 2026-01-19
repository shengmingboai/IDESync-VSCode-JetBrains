# IDE Sync - VSCode-JetBrains Sync

[中文](./README.md) | **English**

> **Note:** This synchronization system is suitable for VSCode, VSCode forks like Cursor or Windsurf as well as JetBrains IntelliJ-based IDEs like Rider, IntelliJ IDEA, and WebStorm.

This extension enables synchronization between VS Code and JetBrains IDEs. It automatically synchronizes cursor position and active file between both editors.

## Features

- **Real-time synchronization** - Automatic cursor position and active file synchronization
- **Status bar toggle** - Easy enable/disable toggle in the status bar
- **Auto sync on startup** - Automatically start sync when VSCode launches (configurable)
- **One-way sync mode** - Receive-only mode for VSCode (only receive changes from JetBrains)
- **Non-preview mode** - Files always open in persistent tabs

## Installation

1. Install the extension from VS Code Marketplace called `IDE Sync - Connect to JetBrains IDE`
2. Install the corresponding JetBrains plugin in JetBrains IDE called `IDE Sync - Connect to VSCode`

## Usage

1. After installation, you'll find a toggle button in the VS Code status bar
2. Click the button to enable/disable synchronization
3. The button shows the current status:
   - `Turn IDE Sync On` - Sync disabled
   - `IDE Sync On` - Sync enabled

## Settings

You can configure the extension in VS Code settings:

1. Open VS Code settings
2. Search for "IDE Sync - Connect to JetBrains IDE"
3. Available settings:
   - **Port** - WebSocket port number (default: 3000, must match JetBrains plugin)
   - **Auto Sync On Startup** - Automatically start sync when VS Code launches (default: false)
   - **Receive Only** - Only receive changes from JetBrains IDE, don't send VSCode changes (default: false)

## Troubleshooting

If you can't establish a connection:
1. Make sure both plugins are installed
2. Check if the IDE Sync is turned on in both IDEs
3. Verify that the port settings match in both plugins
4. Restart both editors

## Feedback & Issues

Please report issues or suggestions on [GitHub](https://github.com/shengmingboai/IDESync-VSCode-JetBrains/issues).
