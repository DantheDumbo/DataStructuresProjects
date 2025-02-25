import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleGame extends JFrame implements ActionListener {
    private int col = 0;
    private int row = 0;
    private JLabel[] cells = new JLabel[30];
    private String secretWord;
    private List<String> wordList = new ArrayList<>();

    public WordleGame() {
        setSize(900, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout(9, 1));

        JPanel[] rowPanels = new JPanel[9];
        for (int i = 0; i < 6; i++) {
            rowPanels[i] = new JPanel(new GridLayout(1, 5));
            add(rowPanels[i]);
        }
        for (int i = 6; i < 9; i++) {
            rowPanels[i] = new JPanel(new GridLayout(1, 10));
            add(rowPanels[i]);
        }

        for (int i = 0; i < 30; i++) {
            cells[i] = new JLabel("", SwingConstants.CENTER);
            cells[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            cells[i].setFont(new Font("Arial", Font.PLAIN, 24));
            cells[i].setOpaque(true);
            rowPanels[i / 5].add(cells[i]);
        }

        String keyboard = "QWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0; i < keyboard.length(); i++) {
            JButton keyButton = new JButton(String.valueOf(keyboard.charAt(i)));
            keyButton.addActionListener(this);
            rowPanels[(i / 10) + 6].add(keyButton);
        }

        JButton backspaceButton = new JButton("Backspace");
        backspaceButton.addActionListener(this);
        rowPanels[8].add(backspaceButton);

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        rowPanels[8].add(enterButton);

        loadWords();
        secretWord = getRandomWord();
        setVisible(true);
    }

    private void loadWords() {
        try (Scanner scanner = new Scanner(new File("wordFile"))) {
            while (scanner.hasNextLine()) {
                wordList.add(scanner.nextLine().trim().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Word list file was not found.");
            System.exit(1);
        }
    }

    private String getRandomWord() {
        int randomIndex = (int) (Math.random() * wordList.size());
        return wordList.get(randomIndex);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Enter")) {
            if (col == 5) {
                String guess = "";
                for (int i = 0; i < 5; i++) {
                    guess += cells[row * 5 + i].getText().toLowerCase();
                }
                if (wordList.contains(guess)) {
                    for (int i = 0; i < 5; i++) {
                        if (guess.charAt(i) == secretWord.charAt(i)) {
                            cells[row * 5 + i].setBackground(Color.GREEN);
                        } else if (secretWord.contains(String.valueOf(guess.charAt(i)))) {
                            cells[row * 5 + i].setBackground(Color.YELLOW);
                        } else {
                            cells[row * 5 + i].setBackground(Color.LIGHT_GRAY);
                        }
                    }
                    if (guess.equals(secretWord)) {
                        JOptionPane.showMessageDialog(this, "You guessed the word!", "", JOptionPane.PLAIN_MESSAGE);
                    } else if (++row == 6) {
                        JOptionPane.showMessageDialog(this, "You've run out of attempts. The word was: " + secretWord, "", JOptionPane.PLAIN_MESSAGE);
                    }
                    col = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Not in word list.", "", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Word must be 5 letters.", "", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (command.equals("Backspace")) {
            if (col > 0) {
                cells[row * 5 + --col].setText("");
            }
        } else {
            if (col < 5) {
                cells[row * 5 + col++].setText(command);
            }
        }
    }

    public static void main(String[] args) {
        new WordleGame();
    }
}
