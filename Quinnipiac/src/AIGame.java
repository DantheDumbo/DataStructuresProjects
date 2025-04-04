import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AIGame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AIGame() {
        setTitle("AI & Cybersecurity Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1));

        JButton aiButton = new JButton("Viking AI Decision Maker");
        JButton phishingButton = new JButton("Email Phishing Detection");
        JButton exitButton = new JButton("Exit");

        aiButton.addActionListener(e -> cardLayout.show(mainPanel, "AI"));
        phishingButton.addActionListener(e -> cardLayout.show(mainPanel, "Phishing"));
        exitButton.addActionListener(e -> System.exit(0));

        menuPanel.add(aiButton);
        menuPanel.add(phishingButton);
        menuPanel.add(exitButton);

        JPanel aiPanel = new JPanel();
        aiPanel.add(new JLabel("Viking AI Decision Maker - Work in Progress"));
        JButton back1 = new JButton("Back");
        back1.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        aiPanel.add(back1);

        JPanel phishingPanel = new JPanel();
        phishingPanel.add(new JLabel("Email Phishing Detection - Work in Progress"));
        JButton back2 = new JButton("Back");
        back2.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        phishingPanel.add(back2);

        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(aiPanel, "AI");
        mainPanel.add(phishingPanel, "Phishing");

        add(mainPanel);
        cardLayout.show(mainPanel, "Menu");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AIGame().setVisible(true));
    }
}
