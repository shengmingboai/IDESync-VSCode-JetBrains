package com.vscode.jetbrainssync

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.components.service
import javax.swing.*
import java.awt.FlowLayout
import javax.swing.Box
import javax.swing.BoxLayout
import java.awt.Component

class VSCodeJetBrainsSyncConfigurable(private val project: Project) : Configurable {
    private var portSpinner: JSpinner? = null
    private var autoSyncCheckBox: JCheckBox? = null
    private var settings: VSCodeJetBrainsSyncSettings = VSCodeJetBrainsSyncSettings.getInstance(project)

    override fun getDisplayName(): String = "IDE Sync - Connect to VSCode"

    override fun createComponent(): JComponent {
        val model = SpinnerNumberModel(settings.state.port, 1000, 65535, 1)
        portSpinner = JSpinner(model)
        
        // Configure spinner to not use thousand separators
        val editor = portSpinner?.editor as? JSpinner.NumberEditor
        editor?.let {
            val format = it.format
            format.isGroupingUsed = false
            it.textField.columns = 5
        }

        autoSyncCheckBox = JCheckBox("自动启动同步", settings.state.autoSyncOnStartup)

        val panel = JPanel()
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        
        // Add description label
        val descriptionLabel = JLabel("Configure the WebSocket port for synchronization with VSCode.")
        descriptionLabel.alignmentX = Component.LEFT_ALIGNMENT
        panel.add(descriptionLabel)
        panel.add(Box.createVerticalStrut(10))
        
        // Add port input panel
        val portPanel = JPanel(FlowLayout(FlowLayout.LEFT, 0, 0))
        portPanel.alignmentX = Component.LEFT_ALIGNMENT
        portPanel.add(JLabel("Port: "))
        portPanel.add(Box.createHorizontalStrut(10))
        portPanel.add(portSpinner)
        panel.add(portPanel)
        panel.add(Box.createVerticalStrut(10))
          // Add auto sync checkbox
        autoSyncCheckBox?.alignmentX = Component.LEFT_ALIGNMENT
        panel.add(autoSyncCheckBox)

        reset()
        return panel
    }

    override fun isModified(): Boolean {
        return try {
            portSpinner?.value as? Int != settings.state.port ||
            autoSyncCheckBox?.isSelected != settings.state.autoSyncOnStartup
        } catch (e: NumberFormatException) {
            true
        }
    }

    override fun apply() {
        settings.state.port = portSpinner?.value as? Int ?: 3000
        settings.state.autoSyncOnStartup = autoSyncCheckBox?.isSelected ?: false
        project.service<VSCodeJetBrainsSyncService>().restartConnection()
    }

    override fun reset() {
        portSpinner?.value = settings.state.port
        autoSyncCheckBox?.isSelected = settings.state.autoSyncOnStartup
    }
} 