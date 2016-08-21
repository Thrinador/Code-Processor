package code_processor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.GridLayout;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
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
        PROJECT_NAME = "/test.java";
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(textAreaPanel);

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

        newButton.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        newButton.setForeground(new Color(51, 51, 255));
        newButton.setText("New");
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }

            private void newButtonActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        openButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        openButton.setForeground(new java.awt.Color(51, 51, 255));
        openButton.setText("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                openButtonActionPerformed(evt);
            }

            private void openButtonActionPerformed(ActionEvent evt) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Java", "java");
                chooser.setFileFilter(filter);
                File dir = new File(System.getProperty("user.dir") + PROJECT_NAME);
                chooser.setCurrentDirectory(dir);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileReader fileReader = new FileReader(chooser.getSelectedFile());
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        StringBuilder text = new StringBuilder();
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            text.append(line).append("\n");
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
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }

            private void saveButtonActionPerformed(ActionEvent evt) {
                try {
                    Files.deleteIfExists(Paths.get(System.getProperty("user.dir"), PROJECT_NAME));
                    FileWriter save = new FileWriter(System.getProperty("user.dir") + PROJECT_NAME, true);
                    try (PrintWriter write = new PrintWriter(save)) {
                        editTextArea.write(write);
                        write.flush();
                    }
                } catch (FileNotFoundException ex) {
                    //Error Message
                } catch (IOException ex) {
                    //Error Message
                }
            }
        });

        runButton.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        runButton.setForeground(new Color(51, 51, 255));
        runButton.setText("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                runButtonActionPerformed(evt);
            }

            private void runButtonActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        stopButton.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        stopButton.setForeground(new Color(51, 51, 255));
        stopButton.setText("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }

            private void stopButtonActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        this.setLayout(new BorderLayout());


        buttonPanel.setLayout(new GridLayout(1, 5));

        buttonPanel.setLayout(new GridLayout(1, 5));
        buttonPanel.add(newButton);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(runButton);
        buttonPanel.add(stopButton);

        editTextArea.setEditable(true);
 
        editTextArea.setFont(new Font("Courier", PLAIN, 14)); // NOI18N
        editTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Courier", PLAIN, 14)); // NOI18N
        outputTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        textAreaPanel.setLayout(new GridLayout(1, 2));

        textAreaPanel.add(editTextArea);
        textAreaPanel.add(outputTextArea);
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
