/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteoinfo.laboratory.gui;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.meteoinfo.laboratory.application.Application;
import org.meteoinfo.laboratory.application.AppCollection;
import org.meteoinfo.global.util.GlobalUtil;
import org.meteoinfo.plugin.IPlugin;
import org.meteoinfo.ui.CheckBoxListEntry;

/**
 *
 * @author yaqiang
 */
public class FrmAppsManager extends javax.swing.JDialog {

    private final FrmMain parent;
    private AppCollection apps = new AppCollection();

    /**
     * Creates new form FrmPluginManager
     * @param parent
     * @param modal
     */
    public FrmAppsManager(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.parent = (FrmMain) parent;
        initialize();
    }

    private void initialize() {
        this.apps = parent.getApplications();
        this.updatePluginCheckList();
    }

    private void updatePluginCheckList() {
        DefaultListModel listModel = new DefaultListModel();
        for (Application plugin : apps) {
            listModel.addElement(new CheckBoxListEntry(plugin, plugin.isLoad()));
        }
        this.checkBoxList_Plugin.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkBoxList_Plugin = new org.meteoinfo.ui.JCheckBoxList();
        jButton_UpdateList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_PluginDetails = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Application Manager");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Applications"));

        checkBoxList_Plugin.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        checkBoxList_Plugin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxList_PluginMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(checkBoxList_Plugin);

        jButton_UpdateList.setText("Update List");
        jButton_UpdateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton_UpdateList)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_UpdateList))
        );

        jLabel1.setText("Application:");

        jTextArea_PluginDetails.setColumns(20);
        jTextArea_PluginDetails.setRows(5);
        jScrollPane2.setViewportView(jTextArea_PluginDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxList_PluginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxList_PluginMouseClicked
        // TODO add your handling code here:
        DefaultListModel listModel = (DefaultListModel) this.checkBoxList_Plugin.getModel();
        int idx = this.checkBoxList_Plugin.getSelectedIndex();
        CheckBoxListEntry item = (CheckBoxListEntry) listModel.getElementAt(idx);
        Application plugin = (Application) item.getValue();
        if (item.isSelected()) {
            parent.loadApplication(plugin);
            parent.validate();
        } else {
            parent.unloadApplication(plugin);
            parent.validate();
        }

        String detailStr = "Name: " + plugin.getName()
                + System.getProperty("line.separator") + "Author: " + plugin.getAuthor()
                + System.getProperty("line.separator") + "Version: " + plugin.getVersion()
                + System.getProperty("line.separator") + "Description: " + plugin.getDescription()
                + System.getProperty("line.separator") + "Jar Path: " + plugin.getJarPath()
                + System.getProperty("line.separator") + "Class Name: " + plugin.getClassName();
        this.jTextArea_PluginDetails.setText(detailStr);
    }//GEN-LAST:event_checkBoxList_PluginMouseClicked

    private void jButton_UpdateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateListActionPerformed
        // TODO add your handling code here:
        List<Application> plugins = new ArrayList<>();

        String pluginPath = parent.getApplications().getPluginPath();
        if (new File(pluginPath).isDirectory()) {
            List<String> fileNames = GlobalUtil.getFiles(pluginPath, ".jar");
            for (String fn : fileNames) {
                Application plugin = this.readApplication(fn);
                if (plugin != null) {
                    plugins.add(plugin);
                }
            }

            List<String> pluginNames = new ArrayList<>();
            for (Application plugin : apps) {
                pluginNames.add(plugin.getName());
            }

            List<String> newPluginNames = new ArrayList<>();
            for (Application plugin : plugins) {
                newPluginNames.add(plugin.getName());
            }

            for (int i = 0; i < apps.size(); i++) {
                if (!newPluginNames.contains(apps.get(i).getName())) {
                    apps.remove(i);
                    i -= 1;
                }
            }

            for (Application plugin : plugins) {
                if (!pluginNames.contains(plugin.getName())) {
                    apps.add(plugin);
                }
            }

            this.updatePluginCheckList();
        }
    }//GEN-LAST:event_jButton_UpdateListActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            // TODO add your handling code here:
            this.parent.getApplications().saveConfigFile();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FrmAppsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    public Application readApplication(String jarFileName) {
        try {
            Application plugin = new Application();
            plugin.setJarFileName(jarFileName);
            String className = GlobalUtil.getPluginClassName(jarFileName);
            if (className == null){
                return null;
            } else {
                plugin.setClassName(className);
                URL url = new URL("file:" + plugin.getJarFileName());
                URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
                Class<?> clazz = urlClassLoader.loadClass(plugin.getClassName());
                IPlugin instance = (IPlugin) clazz.newInstance();
                plugin.setPluginObject(instance);
                return plugin;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAppsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAppsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAppsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAppsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrmAppsManager dialog = new FrmAppsManager(new FrmMain(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.meteoinfo.ui.JCheckBoxList checkBoxList_Plugin;
    private javax.swing.JButton jButton_UpdateList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_PluginDetails;
    // End of variables declaration//GEN-END:variables
}
