import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class WordleClass implements ActionListener {
    private int columnIndex = 0;
    private int rowIndex = 0;
    private JLabel[] labels;
    String random5LetterWord = "";


    public WordleClass() {
        // Creates all the buttons (keyboard)
        JButton[] buttons = new JButton[28];
        String letters = "QWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0; i < letters.length(); i++) {
            buttons[i] = new JButton(letters.substring(i, i + 1));
            buttons[i].addActionListener(this); // Add action listener
        }
        buttons[26] = new JButton("Backspace");
        buttons[26].addActionListener(this);
        buttons[27] = new JButton("Enter");
        buttons[27].addActionListener(this);


        // Creates all the labels
        labels = new JLabel[30];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setFont(new Font("Arial", Font.PLAIN, 24));
            labels[i].setOpaque(true);
        }


        // Create one frame
        JFrame frame = new JFrame();
        JPanel[] panels = new JPanel[9]; // Create 9 panels
        frame.setLayout(new GridLayout(9, 1)); // 9 rows 1 column


        // Create six panels for labels (5 blocks long)
        for (int i = 0; i < 6; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new GridLayout(1, 6)); // 1 row 6 columns
        }


        // Create three panels for buttons (10 blocks long)
        for (int i = 6; i < 9; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new GridLayout(1, 10)); // 1 row 10 columns
        }


        // Add labels to panels
        for (int i = 0; i < 30; i++) {
            panels[i / 5].add(labels[i]);
        }


        // Add buttons to panels
        for (int i = 0; i < 28; i++) {
            panels[(i / 10) + 6].add(buttons[i]);
        }


        // Add the panels to the frame
        for (int i = 0; i < 9; i++) {
            frame.add(panels[i]);
        }


        // Fix the size of the frame for the display
        frame.setSize(900, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);


        FileHandler fh = new FileHandler();
        fh.run();
        random5LetterWord = fh.getRandomWord();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String userString = "";


        FileHandler fileThing = new FileHandler();
        fileThing.run();


        JButton button = (JButton) e.getSource();
        String letter = button.getText();


        if (columnIndex < 6 && rowIndex < 6) {
            if (letter.equals("Enter") || letter.equals("Backspace")) {
                if (letter.equals("Enter")) {
                    if (columnIndex == 5) {
                        for (int i = 0; i < 5; i++) {
                            userString += labels[rowIndex * 5 + i].getText();
                        }
                        userString = userString.toLowerCase();

                        if (fileThing.checkIfWordInBank(userString)) {
                            changeLabelColors(userString);

                            rowIndex++;
                            columnIndex = 0;

                            if (userString.equals(random5LetterWord)) {
                                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the word!", "Victory", JOptionPane.INFORMATION_MESSAGE);
                            }
                            if (rowIndex == 6) {
                                JOptionPane.showMessageDialog(null, "You have run out of attempts. You have lost. If you want to try again rerun the program. The word was " + random5LetterWord, "You Lost", JOptionPane.INFORMATION_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Word not in word bank.", "Try Again", JOptionPane.PLAIN_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Word has to be 5 letters long.", "Try Again", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                if (letter.equals("Backspace")) {
                    if (columnIndex > 0) {
                        columnIndex--;
                        labels[rowIndex * 5 + columnIndex].setText("");
                    }
                }
            } else if (columnIndex < 5) {
                labels[rowIndex * 5 + columnIndex].setText(letter);
                columnIndex++;
            }
        }
    }


    public void changeLabelColors(String userWord) {
        String tempRandomWord = random5LetterWord;


        // Check for correct position (green)
        for (int i = 0; i < 5; i++) {
            if (userWord.charAt(i) == random5LetterWord.charAt(i)) {
                labels[rowIndex * 5 + i].setBackground(Color.GREEN);
                tempRandomWord = tempRandomWord.substring(0, i) + '*' + tempRandomWord.substring(i + 1);
            }
        }


        // Check for correct letter but wrong position (yellow)
        for (int i = 0; i < 5; i++) {
            if (labels[rowIndex * 5 + i].getBackground() != Color.GREEN) {
                char letter = userWord.charAt(i);
                int pos = tempRandomWord.indexOf(letter);
                if (pos != -1) {
                    labels[rowIndex * 5 + i].setBackground(Color.YELLOW);
                    tempRandomWord = tempRandomWord.substring(0, pos) + '*' + tempRandomWord.substring(pos + 1);
                } else {
                    labels[rowIndex * 5 + i].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new WordleClass();
    }
}
