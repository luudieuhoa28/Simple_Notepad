
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class MyTextEditor extends javax.swing.JFrame {

    /**
     * Creates new form MyTextEditor
     */
    File currentFile = null;
    boolean isSaved = false;
    String preText = "";
    final UndoManager undo = new UndoManager();

    public MyTextEditor() {
        initComponents();
        addUnDoRedo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        MainMenu = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        newItem = new javax.swing.JMenuItem();
        openItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        saveAsItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        selectAllItem = new javax.swing.JMenuItem();
        cutItem = new javax.swing.JMenuItem();
        copyItem = new javax.swing.JMenuItem();
        pasteItem = new javax.swing.JMenuItem();
        undoItem = new javax.swing.JMenuItem();
        redoItem = new javax.swing.JMenuItem();
        findItem = new javax.swing.JMenuItem();
        replaceItem = new javax.swing.JMenuItem();
        changeFontItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        FileMenu.setText("File");

        newItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newItem.setText("New");
        newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
        FileMenu.add(newItem);

        openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        FileMenu.add(openItem);

        saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveItem);

        saveAsItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsItem.setText("Save as");
        saveAsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveAsItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        FileMenu.add(exitItem);

        MainMenu.add(FileMenu);

        EditMenu.setText("Edit");

        selectAllItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectAllItem.setText("Select all");
        selectAllItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllItemActionPerformed(evt);
            }
        });
        EditMenu.add(selectAllItem);

        cutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutItem.setText("Cut");
        cutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemActionPerformed(evt);
            }
        });
        EditMenu.add(cutItem);

        copyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyItem.setText("Copy");
        copyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyItemActionPerformed(evt);
            }
        });
        EditMenu.add(copyItem);

        pasteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteItem.setText("Paste");
        pasteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteItemActionPerformed(evt);
            }
        });
        EditMenu.add(pasteItem);

        undoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoItem.setText("Undo");
        undoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoItemActionPerformed(evt);
            }
        });
        EditMenu.add(undoItem);

        redoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoItem.setText("Redo");
        redoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoItemActionPerformed(evt);
            }
        });
        EditMenu.add(redoItem);

        findItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        findItem.setText("Find");
        findItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findItemActionPerformed(evt);
            }
        });
        EditMenu.add(findItem);

        replaceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        replaceItem.setText("Replace");
        replaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceItemActionPerformed(evt);
            }
        });
        EditMenu.add(replaceItem);

        changeFontItem.setText("Change font");
        changeFontItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontItemActionPerformed(evt);
            }
        });
        EditMenu.add(changeFontItem);

        MainMenu.add(EditMenu);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        // TODO add your handling code here:
        if (!isSaved) {
            File f = chooseSaveFile();
            if (f != null) {
                if (f.exists()) {
                    int ans = JOptionPane.showConfirmDialog(null, "Do you to repalce this file?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        saveFile(f);
                        isSaved = true;
                        preText = jTextArea1.getText();
                        currentFile = f;
                    }
                } else {
                    saveFile(f);
                    isSaved = true;
                    preText = jTextArea1.getText();
                    currentFile = f;
                }
            }
        } else {
            if (currentFile != null) {
                saveFile(currentFile);
                preText = jTextArea1.getText();
                isSaved = true;
            }
        }
    }//GEN-LAST:event_saveItemActionPerformed

    private void cutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutItemActionPerformed
        // TODO add your handling code here:
        jTextArea1.cut();
    }//GEN-LAST:event_cutItemActionPerformed

    private void newItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemActionPerformed
        // TODO add your handling code here:
        if (!isSaved && !jTextArea1.getText().equals("")) {
            int ans = JOptionPane.showConfirmDialog(null, "Do you save?", "Warning", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                File f = chooseSaveFile();
                if (f != null) {
                    if (f.exists()) {
                        ans = JOptionPane.showConfirmDialog(null, "Do you to repalce this file?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (ans == JOptionPane.YES_OPTION) {
                            saveFile(f);
                            newFile();
                        }
                    } else {
                        saveFile(f);
                        newFile();
                    }
                }
            } else {
                newFile();
            }
        } else {
            if (jTextArea1.getText().equals(preText)) {
                jTextArea1.setText("");
                newFile();
            } else {
                if (currentFile != null) {
                    int ans = JOptionPane.showConfirmDialog(null, "Do you want "
                            + "to save changes to" + currentFile + "?", "Warning",
                            JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        saveFile(currentFile);
                    }
                    newFile();
                }
            }
        }

    }//GEN-LAST:event_newItemActionPerformed

    public void newFile() {
        jTextArea1.setText("");
        currentFile = null;
        preText = "";
        isSaved = false;
    }

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        // TODO add your handling code here:
        if (!isSaved) {
            if (!jTextArea1.getText().equals("")) {
                int ans = JOptionPane.showConfirmDialog(null, "Do you save?", "Warning", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    File f = chooseSaveFile();
                    if (f != null) {
                        if (f.exists()) {
                            ans = JOptionPane.showConfirmDialog(null, "Do you to repalce this file?", "Warning", JOptionPane.YES_NO_OPTION);
                            if (ans == JOptionPane.YES_OPTION) {
                                saveFile(f);
                                f = chooseFile();
                                if (f != null) {
                                    openFile(f);
                                }
                            }
                        } else {
                            saveFile(f);
                            f = chooseFile();
                            if (f != null) {
                                openFile(f);
                            }
                        }
                    }
                } else {
                    File f = chooseFile();
                    if (f != null) {
                        openFile(f);
                    }
                }
            } else {
                File f = chooseFile();
                if (f != null) {
                    openFile(f);
                }
            }
        } else {
            if (jTextArea1.getText().equals(preText)) {
                File f = chooseFile();
                if (f != null) {
                    openFile(f);
                }
            } else {
                if (currentFile != null) {
                    int ans = JOptionPane.showConfirmDialog(null, "Do you want "
                            + "to save changes to" + currentFile + "?", "Warning",
                            JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        openFile(currentFile);
                    }
                    File f = chooseFile();
                    if (f != null) {
                        openFile(f);
                    }
                }
            }
        }
    }//GEN-LAST:event_openItemActionPerformed

    public void openFile(File f) {
        currentFile = f;
        showFile(currentFile);
        isSaved = true;
        preText = jTextArea1.getText();
    }

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        // TODO add your handling code here:
        if (!isSaved) {
            if (!jTextArea1.getText().equals("")) {
                int ans = JOptionPane.showConfirmDialog(null, "Do you save?", "Warning", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    File f = chooseFile();
                    if (f != null) {
                        if (f.exists()) {
                            ans = JOptionPane.showConfirmDialog(null, "Do you to repalce this file?", "Warning", JOptionPane.YES_NO_OPTION);
                            if (ans == JOptionPane.YES_OPTION) {
                                saveFile(f);
                                System.exit(0);
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        } else {
            if (jTextArea1.getText().equals(preText)) {
                System.exit(0);
            } else {
                if (currentFile != null) {
                    int ans = JOptionPane.showConfirmDialog(null, "Do you want "
                            + "to save changes to" + currentFile + "?", "Warning",
                            JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        saveFile(currentFile);
                    }
                    System.exit(0);
                }
            }
        }
    }//GEN-LAST:event_exitItemActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        exitItemActionPerformed(null);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void saveAsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsItemActionPerformed
        // TODO add your handling code here:
        File f = chooseSaveFile();
        if (f != null) {
            if (f.exists()) {
                int ans = JOptionPane.showConfirmDialog(null, "Do you to repalce this file?", "Warning", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    saveFile(f);
                    isSaved = true;
                    preText = jTextArea1.getText();
                    currentFile = f;
                }
            } else {
                saveFile(f);
                isSaved = true;
                preText = jTextArea1.getText();
                currentFile = f;
            }
        }
    }//GEN-LAST:event_saveAsItemActionPerformed

    private void selectAllItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllItemActionPerformed
        // TODO add your handling code here:
        jTextArea1.selectAll();
    }//GEN-LAST:event_selectAllItemActionPerformed

    private void copyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyItemActionPerformed
        // TODO add your handling code here:
        jTextArea1.copy();
    }//GEN-LAST:event_copyItemActionPerformed

    private void pasteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteItemActionPerformed
        // TODO add your handling code here:
        jTextArea1.paste();
    }//GEN-LAST:event_pasteItemActionPerformed

    private void undoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoItemActionPerformed
        // TODO add your handling code here:
        if (undo.canUndo()) {
            undo.undo();
        }
    }//GEN-LAST:event_undoItemActionPerformed

    private void redoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoItemActionPerformed
        // TODO add your handling code here:
        if (undo.canRedo()) {
            undo.redo();
        }
    }//GEN-LAST:event_redoItemActionPerformed

    private void changeFontItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontItemActionPerformed
        ChangeFontDialog fontDialog = new ChangeFontDialog(this, true);
        fontDialog.setVisible(true);
    }//GEN-LAST:event_changeFontItemActionPerformed

    private void findItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findItemActionPerformed
        FindDialog findDialog = new FindDialog(this, true);
        findDialog.setVisible(true);
    }//GEN-LAST:event_findItemActionPerformed

    private void replaceItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceItemActionPerformed
        ReplaceDialog replaceDialog = new ReplaceDialog(this, true);
        replaceDialog.setVisible(true);
    }//GEN-LAST:event_replaceItemActionPerformed
    public void addUnDoRedo() {

        Document doc = jTextArea1.getDocument();

        // Listen for undo and redo events
        doc.addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent evt) {
                undo.addEdit(evt.getEdit());
            }
        });

        // Create an undo action and add it to the text component
        jTextArea1.getActionMap().put("Undo",
                new AbstractAction("Undo") {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undo.canUndo()) {
                        undo.undo();
                    }
                } catch (CannotUndoException e) {
                }
            }
        });

        // Create a redo action and add it to the text component
        jTextArea1.getActionMap().put("Redo",
                new AbstractAction("Redo") {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undo.canRedo()) {
                        undo.redo();
                    }
                } catch (CannotRedoException e) {
                }
            }
        });

    }

    public File chooseSaveFile() {
        File f = null;
        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            f = fc.getSelectedFile();
        }
        return f;
    }

    public File chooseFile() {
        File f = null;

        JFileChooser fc = new JFileChooser();
        int option = fc.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            f = fc.getSelectedFile();
        }
        return f;
    }

    public void saveFile(File f) {
        PrintWriter w = null;
        try {
            w = new PrintWriter(f);
            w.print(jTextArea1.getText());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void showFile(File f) {
        String text = "", line;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while (((line = br.readLine()) != null)) {
                text += line + "\n";
            }
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);
            }
            jTextArea1.setText(text);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public int FindNext(String txtFind, boolean isMatchCase, int position) {
        String txt = jTextArea1.getText();
        if (!isMatchCase) {
            txtFind = txtFind.toLowerCase();
            txt = txt.toLowerCase();
        }
        int index = txt.indexOf(txtFind, position + 1);
        if (index >= 0) {
            jTextArea1.setSelectionStart(index);
            jTextArea1.setSelectionEnd(index + txtFind.length());
        }
        return index;
    }

    public int FindPrevious(String txtFind, boolean isMatchCase, int position) {
        String txt = jTextArea1.getText();
        if (!isMatchCase) {
            txtFind = txtFind.toLowerCase();
            txt = txt.toLowerCase();
        }
        int index = -1;
        for (int i = txt.length() - 1; i >= 0; i--) {
            index = txt.indexOf(txtFind, i);
            System.out.println("Index: " + index);
            if (index >= 0 && index < position) {
                break;
            } else {
                index = -1;
            }
        }
        if (index >= 0) {
            jTextArea1.setSelectionStart(index);
            jTextArea1.setSelectionEnd(index + txtFind.length());
        }
        return index;
    }

    public void changeFont(Font f) {
        jTextArea1.setFont(f);
    }

    public void replace(String findText, int position, String replaceText) {
        if (position >= 0) {
            jTextArea1.replaceRange(replaceText, position, position + findText.length());
        }
    }

    public void replaceAll(String findText, String replaceText, boolean isMatchCase) {
        String tmpText = jTextArea1.getText();
        if (!isMatchCase) {
            findText = findText.toLowerCase();
            tmpText = tmpText.toLowerCase();
        }
        tmpText = tmpText.replaceAll(findText, replaceText);
        jTextArea1.setText(tmpText);

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
            java.util.logging.Logger.getLogger(MyTextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyTextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyTextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyTextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyTextEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenuItem changeFontItem;
    private javax.swing.JMenuItem copyItem;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenuItem findItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem newItem;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem pasteItem;
    private javax.swing.JMenuItem redoItem;
    private javax.swing.JMenuItem replaceItem;
    private javax.swing.JMenuItem saveAsItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JMenuItem selectAllItem;
    private javax.swing.JMenuItem undoItem;
    // End of variables declaration//GEN-END:variables
}
