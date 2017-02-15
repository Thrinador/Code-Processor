package code_processor;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.*;
import javax.swing.text.*;

/**
 * @author Ben
 * @author Polina
 */
public class JTextAreaNumbers extends JTextPane {

    private final JTextPane textArea;
    private final String[] JAVA_KEY_WORDS = {"abstract", "continue", "for", "new",
        "switch", "assert", "default", "goto", "package", "synchronized", 
        "boolean", "do", "if", "private", "this", "break", "double",
        "implements", "protected", "throw", "byte", "else", "import", 
        "public", "throws", "case", "enum", "instanceof", "return", 
        "transient", "catch", "extends", "int", "short", "try", "char", 
        "final", "interface", "static", "void", "class", "finally", "long", 
        "strictfp", "volatile", "const", "float", "native", "super", "while"};

    public JTextAreaNumbers(JTextPane textArea) {
        this.textArea = textArea;
        setBackground(Color.LIGHT_GRAY);
        setEditable(false);
        this.setText("1");
        this.setFont(new Font("Courier", PLAIN, 14));

    }
    
    public void checkForNewWord(){
        String[] words = textArea.getText().split(" ");
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < JAVA_KEY_WORDS.length; j++){
                if(JAVA_KEY_WORDS[j].equals(words[i])){
                    //Set color
                    Document document = textArea.getDocument();
                    //document.
                    StyleContext context = new StyleContext();
                    Style style = context.addStyle("test", null);
                    StyleConstants.setForeground(style, Color.BLUE);
                    try {
                        document.insertString(0, words[i], style);
                    } catch(BadLocationException e){
                        System.err.print("Something went Wrong");
                    }
                    textArea.setDocument(document);
                }
            }
        }
    }

    public void updateLineNumbers() {
        String lineNumbersText = getLineNumbersText();
        setText(lineNumbersText);
    }

    private String getLineNumbersText() {
        int caretPosition = textArea.getDocument().getLength();
        Element root = textArea.getDocument().getDefaultRootElement();
        StringBuilder lineNumbersTextBuilder = new StringBuilder();
        lineNumbersTextBuilder.append("1").append(System.lineSeparator());
        for (int elementIndex = 2; elementIndex < root.getElementIndex(caretPosition) + 2; elementIndex++) {
            lineNumbersTextBuilder.append(elementIndex).append(System.lineSeparator());
        }
        return lineNumbersTextBuilder.toString();
    }
}
