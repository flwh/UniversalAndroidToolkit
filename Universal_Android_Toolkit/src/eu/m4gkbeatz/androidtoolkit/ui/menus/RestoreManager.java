/*
 * Copyright (C) 2014 beatsleigher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package eu.m4gkbeatz.androidtoolkit.ui.menus;


import JDroidLib.android.controllers.*;
import JDroidLib.android.device.*;

import eu.m4gkbeatz.androidtoolkit.language.*;
import eu.m4gkbeatz.androidtoolkit.logging.*;
import static eu.m4gkbeatz.androidtoolkit.logging.Logger.Level;
import eu.m4gkbeatz.androidtoolkit.settings.*;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class RestoreManager extends javax.swing.JFrame {
    
    private final LangFileParser parser;
    private final Logger logger;
    private final ADBController adbController;
    private final Device device;
    private final SettingsManager settings;
    private final boolean debug;

    public RestoreManager(Logger logger, ADBController adbController, SettingsManager settings, Device device, boolean debug, LangFileParser parser) {
        initComponents();
        this.parser = parser;
        this.logger = logger;
        this.adbController = adbController;
        this.settings = settings;
        this.device = device;
        this.debug = debug;
        this.setIconImage(new ImageIcon(this.getClass().getResource("/eu/m4gkbeatz/androidtoolkit/resources/UniversalAndroidToolkit_logo.png")).getImage());
        this.setLocationRelativeTo(null);
        loadTranslations();
        //jList1.setCellRenderer(new BackupCellRenderer());
        loadBackups();
    }
    
    private void loadTranslations() {
        new Thread() {
            @Override
            public void run() {
                setTitle("Universal Android Toolkit | " + parser.parse("restoreManager:title"));
                selectBackupLabel.setText(parser.parse("restoreManager:selectBackupLabel"));
                restoreDeviceButton.setText(parser.parse("restoreManager:restoreDeviceButton"));
                restoreSystemButton.setText(parser.parse("restoreManager:restoreSystemButton"));
                restoreSystemButton.setToolTipText(parser.parse("restoreManager:restoreSystemButtonToolTip"));
                restoreStorageButton.setText(parser.parse("restoreManager:restoreStorageButton"));
                restoreStorageButton.setToolTipText(parser.parse("restoreManager:restoreStorageButtonToolTip"));
                restoreEFSButton.setText(parser.parse("restoreManager:restoreEFSButton"));
                restoreEFSButton.setToolTipText(parser.parse("restoreManager:restoreEFSButtonToolTip"));
                restoreAppsButton.setText(parser.parse("restoreManager:restoreAppsButton"));
                restoreAppsButton.setToolTipText(parser.parse("restoreManager:restoreAppsButtonToolTip"));
                interrupt();
            }
        }.start();
    }
    
    private void loadBackups() {
        new Thread() {
            @Override
            public void run() {
                DefaultListModel model = new DefaultListModel();
                File backupDir = new File(System.getProperty("user.home") + "/.androidtoolkit/backups");
                if (debug)
                    logger.log(Level.DEBUG, "Loading backups from: " + backupDir.getAbsolutePath() + " for device: " + device.toString());
                if (!backupDir.exists()) {
                    backupDir.mkdirs();
                    interrupt();
                }

                // List backups
                for (File f : backupDir.listFiles(new ABFilter())) {
                    model.addElement(f.getName());
                }
                jList1.setModel(model);
                interrupt();
            }
        }.start();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        selectBackupLabel = new javax.swing.JLabel();
        restoreDeviceButton = new javax.swing.JButton();
        restoreSystemButton = new javax.swing.JCheckBox();
        restoreStorageButton = new javax.swing.JCheckBox();
        restoreEFSButton = new javax.swing.JCheckBox();
        restoreAppsButton = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setCellRenderer(new BackupCellRenderer());
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        selectBackupLabel.setText("Select a backup below:");

        restoreDeviceButton.setText("Restore Device...");
        restoreDeviceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreDeviceButtonActionPerformed(evt);
            }
        });

        restoreSystemButton.setText("Restore System");

        restoreStorageButton.setText("Restore Storage");

        restoreEFSButton.setText("Restore EFS");

        restoreAppsButton.setText("Restore Apps");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectBackupLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(restoreDeviceButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restoreSystemButton)
                            .addComponent(restoreEFSButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restoreAppsButton)
                            .addComponent(restoreStorageButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restoreSystemButton)
                    .addComponent(restoreStorageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restoreEFSButton)
                    .addComponent(restoreAppsButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectBackupLabel)
                        .addComponent(restoreDeviceButton))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restoreDeviceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreDeviceButtonActionPerformed
        if (jList1.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, parser.parse("restoreManager:noBackupSelectedMsg"), parser.parse("restoreManager:noBackupSelectedMsgTitle"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!(restoreSystemButton.isSelected() || restoreStorageButton.isSelected() || restoreEFSButton.isSelected() || restoreAppsButton.isSelected())) {
            JOptionPane.showMessageDialog(null, parser.parse("restoreManager:noOptionsSelectedMsg"), parser.parse("restoreManager:noOptionsSelectedMsgTitle"), JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        if (debug)
            logger.log(Level.DEBUG, "Restoring files to device: " + device.toString() + ". Backup selected: " + jList1.getSelectedValue());
        
    }//GEN-LAST:event_restoreDeviceButtonActionPerformed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE && jList1.getSelectedValue() != null) {
            logger.log(Level.INFO, "Resetting backup selection...");
            jList1.clearSelection();
        }
            
    }//GEN-LAST:event_jList1KeyPressed
    
    private class BackupCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setIcon(new ImageIcon(this.getClass().getResource("/eu/m4gkbeatz/androidtoolkit/resources/backups/backup.png")));
            return label;
        }

    }
    
    private class ABFilter implements FileFilter {

        @Override
        public boolean accept(File f) {
            return (f.isDirectory()) || (f.getAbsolutePath().toLowerCase().endsWith(".ab") && f.getAbsolutePath().toLowerCase().contains(device.getSerial().toLowerCase()));
        }

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox restoreAppsButton;
    private javax.swing.JButton restoreDeviceButton;
    private javax.swing.JCheckBox restoreEFSButton;
    private javax.swing.JCheckBox restoreStorageButton;
    private javax.swing.JCheckBox restoreSystemButton;
    private javax.swing.JLabel selectBackupLabel;
    // End of variables declaration//GEN-END:variables
}
