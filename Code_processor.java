package code_processor;

import java.awt.Color;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Polina
 * @author Ben
 */
public class Code_processor extends JFrame {

    private JPanel buttonPanel;
    private javax.swing.JPanel textAreaPanel;
    private javax.swing.JButton newButton;
    private javax.swing.JButton openButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton runButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTextArea editTextArea;
    private javax.swing.JTextArea outputTextArea;
    private final String PROJECT_NAME;

    public Code_processor() {
        initComponents();
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        buttonPanel.setBackground(Color.red);
        PROJECT_NAME = "/test.java";
        this.add(buttonPanel);
        //this.add(textAreaPanel);

    }

    private void initComponents() {
        buttonPanel = new JPanel();
        textAreaPanel = new JPanel();
        newButton = new JButton();
        openButton = new JButton();
        saveButton = new JButton();
        runButton = new JButton();
        stopButton = new JButton();
        editTextArea = new JTextArea();
        outputTextArea = new JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CODE PROCESSOR");
        setResizable(false);

        newButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newButton.setForeground(new java.awt.Color(51, 51, 255));
        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }

            private void newButtonActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        openButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        openButton.setForeground(new java.awt.Color(51, 51, 255));
        openButton.setText("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }

            private void openButtonActionPerformed(ActionEvent evt) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Java", "java");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileReader fileReader = new FileReader(chooser.getSelectedFile());
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        StringBuilder text = new StringBuilder();
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            text.append(line);
                        }
                        editTextArea.setText(text.toString());
                    } catch (FileNotFoundException ex) {

                    } catch (IOException ex) {

                    }
                }
            }
        });

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(51, 51, 255));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }

            private void saveButtonActionPerformed(ActionEvent evt) {
                try {
                    FileWriter save = new FileWriter("/" + System.getProperty("user.dir") + PROJECT_NAME, true);
                    PrintWriter write = new PrintWriter(save);
                    write.write(editTextArea.getText());
                    write.flush();
                    write.close();
                } catch (FileNotFoundException ex) {
                    //Error Message
                } catch (IOException ex) {
                    //Error Message
                }
            }
        });

        runButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        runButton.setForeground(new java.awt.Color(51, 51, 255));
        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }

            private void runButtonActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        stopButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stopButton.setForeground(new java.awt.Color(51, 51, 255));
        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }

            private void stopButtonActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        buttonPanel.setLayout(new java.awt.GridLayout(1, 5));
        buttonPanel.add(newButton);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(runButton);
        buttonPanel.add(stopButton);

        editTextArea.setEditable(false);
        editTextArea.setColumns(20);
        editTextArea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editTextArea.setRows(5);
        editTextArea.setBorder(null);

        outputTextArea.setEditable(false);
        outputTextArea.setColumns(20);
        outputTextArea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outputTextArea.setRows(5);
        outputTextArea.setBorder(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Code_processor().setVisible(true);
        });
    }

}
