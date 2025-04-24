import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




class CSExplorer {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private HashMap<String, JPanel> panels = new HashMap<>();
    private JLabel explanationLabel;
    private JPanel explanationPanel;
    private List<String> trainedAnimals = new ArrayList<>();
    private JLabel aiStatusLabel;
    private JTextField[] animalInputs;
    private JButton[] emailButtons;
    private JPanel sortingPanel;
    private JLabel[] numberLabels;
    private int[] numbers;
    private int currentIndex = 0;
    private int pass = 0;
    private boolean sorted = false;

    private JLayeredPane conveyorPanel;
    private JLabel robot;
    private JLabel[] containers;
    private int[] containerCounts;
    private List<JLabel> boxes;
    private JLabel currentHeldBox;
    private Timer conveyorTimer;
    private JLabel statusLabel;
    private JPanel statusPanel;

    private JButton startConveyorBtn;
    private JButton stopConveyorBtn;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CSExplorer().createAndShowGUI());
    }




    private void createAndShowGUI() {
        frame = new JFrame("KSD CS Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);




        cardLayout = new CardLayout(); // Can switch between different screens
        mainPanel = new JPanel(cardLayout);




        createMainMenu(); // Creates all the main menus
        createAIPanel(); // Creates AI section
        createCybersecurityPanel(); // Creates Cybersecurity section
        createSoftwareEngineeringPanel();
        createWhyCSPanel();
        createOtherFieldsPanel(); // NEW: Creates the Other Fields panel
        createThankYouPanel(); // Creates the thank you screen


        frame.add(mainPanel);
        frame.setVisible(true);




        frame.add(mainPanel);
        frame.setVisible(true);
    }


    private void createMainMenu() {
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(new Color(10, 10, 26));
        panels.put("menu", menuPanel);


        //Left Image Panel
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(new Color(10, 10, 26));


        ImageIcon vikingIconLeft = new ImageIcon("/Users/sakshambehl/Downloads/viking.jpeg");
        Image vikingImageLeft = vikingIconLeft.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JLabel vikingLabelLeft = new JLabel(new ImageIcon(vikingImageLeft));

        leftPanel.add(vikingLabelLeft);
        menuPanel.add(leftPanel, BorderLayout.WEST);


        //Right Image Panel
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(new Color(10, 10, 26));

        ImageIcon vikingIconRight = new ImageIcon("/Users/sakshambehl/Downloads/viking.jpeg");
        Image vikingImageRight = vikingIconRight.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JLabel vikingLabelRight = new JLabel(new ImageIcon(vikingImageRight));

        rightPanel.add(vikingLabelRight);
        menuPanel.add(rightPanel, BorderLayout.EAST);


        //Center Panel (Text & Buttons)
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(10, 10, 26));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 0, 20, 0);


        JLabel title = new JLabel("TumaBehl Computer Science Explorer!");
        title.setForeground(new Color(0, 255, 204));
        title.setFont(new Font("Arial", Font.BOLD, 32));
        centerPanel.add(title, gbc);

        JLabel explore = new JLabel("Explore the different fields in CS!");
        explore.setForeground(new Color(200, 200, 200));
        explore.setFont(new Font("Arial", Font.PLAIN, 18));
        centerPanel.add(explore, gbc);

        //Buttons
        JButton aiButton = new JButton("🤖🧠 Artificial Intelligence");
        aiButton.setBackground(new Color(102, 0, 0));
        aiButton.setForeground(Color.BLACK);
        aiButton.setFont(new Font("Arial", Font.PLAIN, 18));
        aiButton.setPreferredSize(new Dimension(300, 60));

        aiButton.addActionListener(e -> {
            resetAIPanel();
            cardLayout.show(mainPanel, "ai");
        });

        JButton cybersecurityButton = new JButton("🛡️ Cybersecurity");
        cybersecurityButton.setBackground(new Color(0, 51, 102));
        cybersecurityButton.setForeground(Color.BLACK);
        cybersecurityButton.setFont(new Font("Arial", Font.PLAIN, 18));
        cybersecurityButton.setPreferredSize(new Dimension(300, 60));


        cybersecurityButton.addActionListener(e -> {
            resetCybersecurityPanel();
            cardLayout.show(mainPanel, "cybersecurity");
        });


        JButton whyCSButton = new JButton("💡 Why Computer Science?");
        whyCSButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "whyCS");
        });
        centerPanel.add(whyCSButton, gbc);
        whyCSButton.setBackground(new Color(0, 51, 102));
        whyCSButton.setForeground(Color.BLACK);
        whyCSButton.setFont(new Font("Arial", Font.PLAIN, 18));
        whyCSButton.setPreferredSize(new Dimension(300, 60));


        JButton softwareEngineeringButton = new JButton("💻 Software Engineering");
        softwareEngineeringButton.addActionListener(e -> cardLayout.show(mainPanel, "softwareEngineering"));
        centerPanel.add(softwareEngineeringButton, gbc);
        softwareEngineeringButton.setBackground(new Color(0, 51, 102));
        softwareEngineeringButton.setForeground(Color.BLACK);
        softwareEngineeringButton.setFont(new Font("Arial", Font.PLAIN, 18));
        softwareEngineeringButton.setPreferredSize(new Dimension(300, 60));

        JButton roboticsButton = new JButton("🦾🤖 Robotics");
        roboticsButton.setBackground(new Color(102, 51, 0));
        roboticsButton.setForeground(Color.BLACK);
        roboticsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        roboticsButton.setPreferredSize(new Dimension(300, 60));
        roboticsButton.addActionListener(e -> {
            if (!panels.containsKey("robotics")) {
                createRoboticsPanel();
            }
            stopConveyor();
            resetRoboticsPanel();
            cardLayout.show(mainPanel, "robotics");
        });
        centerPanel.add(roboticsButton, gbc);

        JButton otherFieldsButton = new JButton("🌐 Other Fields Using CS");
        otherFieldsButton.setBackground(new Color(0, 51, 102));
        otherFieldsButton.setForeground(Color.BLACK);
        otherFieldsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        otherFieldsButton.setPreferredSize(new Dimension(300, 60));
        otherFieldsButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "otherFields");
        });
        centerPanel.add(otherFieldsButton, gbc);


        JButton thankYouButton = new JButton("🌟 Thank You!");
        thankYouButton.setBackground(new Color(255, 215, 0)); // Gold color
        thankYouButton.setForeground(Color.BLACK);
        thankYouButton.setFont(new Font("Arial", Font.BOLD, 18));
        thankYouButton.setPreferredSize(new Dimension(300, 60));
        thankYouButton.addActionListener(e -> cardLayout.show(mainPanel, "thankYou"));


        centerPanel.add(thankYouButton, gbc);


        centerPanel.add(aiButton, gbc);
        centerPanel.add(cybersecurityButton, gbc); //adding Buttons to center


        menuPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(menuPanel, "menu");
    }




    private void createAIPanel() {
        JPanel panel = new JPanel(new BorderLayout()); //can put stuff NORTH SOUTH EAST AND WEST
        panel.setBackground(new Color(20, 20, 50));
        panels.put("ai", panel); //adds to the map of panels




        JLabel label = new JLabel("Train the AI to recognize animals!", SwingConstants.CENTER); //TOP CENTER
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH); //PUTTING IT ON TOP




        JPanel contentPanel = new JPanel(new GridLayout(2, 1)); //GRID OF ROWS AND COLUMNS
        contentPanel.setBackground(new Color(20, 20, 50));
        panel.add(contentPanel, BorderLayout.CENTER);




        JPanel trainingPanel = new JPanel(new GridLayout(2, 6, 10, 10));
        trainingPanel.setBackground(new Color(30, 30, 60));
        contentPanel.add(trainingPanel);




        explanationPanel = new JPanel(new BorderLayout());
        explanationPanel.setBackground(new Color(50, 50, 100));
        aiStatusLabel = new JLabel("Type the correct animal names", SwingConstants.CENTER);
        aiStatusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        aiStatusLabel.setForeground(Color.WHITE);
        explanationPanel.add(aiStatusLabel, BorderLayout.CENTER);
        contentPanel.add(explanationPanel);




        explanationLabel = new JLabel("", SwingConstants.CENTER);
        explanationLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        explanationLabel.setForeground(Color.BLACK);
        explanationPanel.add(explanationLabel, BorderLayout.SOUTH);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Aligns to the right
        buttonPanel.setBackground(new Color(20, 20, 50)); // Keeps the background consistent




        JButton aiInfoButton = new JButton("How does this apply?");
        aiInfoButton.setFont(new Font("Arial", Font.BOLD, 12));  // change font size
        aiInfoButton.setBackground(new Color(0, 150, 0));
        aiInfoButton.setForeground(Color.BLACK);
        aiInfoButton.setPreferredSize(new Dimension(200, 40));  // Small button size
        aiInfoButton.addActionListener(e -> showAIExplanation());




        buttonPanel.add(aiInfoButton); // Add button to the panel
        panel.add(buttonPanel, BorderLayout.NORTH);




        String[] animalEmojis = {"🐶", "🐱", "🐘", "🦁", "🐬", "🦘"};
        String[] correctNames = {"Dog", "Cat", "Elephant", "Lion", "Dolphin", "Kangaroo"};
        animalInputs = new JTextField[animalEmojis.length];




        for (int i = 0; i < animalEmojis.length; i++) {
            JLabel emojiLabel = new JLabel(animalEmojis[i], SwingConstants.CENTER); //puts all of these into a label
            emojiLabel.setFont(new Font("Arial", Font.PLAIN, 40));
            trainingPanel.add(emojiLabel);




            JTextField inputField = new JTextField();
            inputField.setHorizontalAlignment(SwingConstants.CENTER);
            int index = i;
            inputField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    updateAIStatus(correctNames);
                }
            });
            animalInputs[i] = inputField;
            trainingPanel.add(inputField);
        }




        JButton trainButton = new JButton("Train AI");
        trainButton.setFont(new Font("Arial", Font.BOLD, 18));
        trainButton.setBackground(new Color(0, 102, 102));
        trainButton.setForeground(Color.BLACK);
        trainButton.addActionListener(e -> trainAI(correctNames));
        panel.add(trainButton, BorderLayout.SOUTH);




        JButton backButton = new JButton("Back to Menu"); //BACK TO MAIN MENU
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(new Color(50, 50, 100));
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        panel.add(backButton, BorderLayout.SOUTH);




        mainPanel.add(panel, "ai");
    }




    private void updateAIStatus(String[] correctNames) {
        trainedAnimals.clear();
        boolean allCorrect = true;




        for (int i = 0; i < correctNames.length; i++) {
            String userInput = animalInputs[i].getText().trim();
            if (userInput.equalsIgnoreCase(correctNames[i])) { //ignores upper and lower case (POWERFUL)
                trainedAnimals.add(correctNames[i]);
                animalInputs[i].setBackground(Color.WHITE);
            } else {
                allCorrect = false;
                animalInputs[i].setBackground(new Color(255, 102, 102));
            }
        }




        if (allCorrect) {
            aiStatusLabel.setText("GOOD JOB! The AI has successfully learned: " + trainedAnimals);
            explanationPanel.setBackground(new Color(0, 150, 0));
        } else {
            aiStatusLabel.setText("The AI has learned: " + trainedAnimals);
            explanationPanel.setBackground(new Color(150, 0, 0));
            explanationLabel.setText("");
        }
    }




    private void trainAI(String[] correctNames) {
        updateAIStatus(correctNames);
    }




    private void showAIExplanation() {
        aiStatusLabel.setText("This is how AI training works in real life:");
        aiStatusLabel.setText("<html><ul>" +
                "<li>In the real world, AI is trained the exact same way! By training AI to recognize datasets, it creates schemas of its own and learns!</li>" +
                "<li>Using a similar technique (more complicated) than the one you just did, AI learns new things every day!</li>" +
                "<li>AI is one of the biggest computer science fields and requires a lot of problem-solving and math!</li>" +
                "<li>If you are good at either, this would be an amazing field for you!</li>" +
                "</ul></html>");
        aiStatusLabel.setText("<html><ul>" +
                "<li>In the real world, AI is trained the exact same way! By training AI to recognize datasets, it creates schemas of its own and learns!</li>" +
                "<li>Using a similar technique (more complicated) than the one you just did, AI learns new things every day!</li>" +
                "<li>AI is one of the biggest computer science fields and requires a lot of problem-solving and math!</li>" +
                "<li>If you are good at either, this would be an amazing field for you!</li>" +
                "</ul></html>");
    }




    private void resetAIPanel() {
        trainedAnimals.clear();
        aiStatusLabel.setText("Type the correct animal names below");
        explanationPanel.setBackground(new Color(50, 50, 100));
        explanationLabel.setText("");
        for (JTextField field : animalInputs) {
            field.setText("");
            field.setBackground(Color.WHITE);
        }
    }


    private void createCybersecurityPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(20, 20, 50));
        panels.put("cybersecurity", panel);


        JLabel label = new JLabel("Select the emails that are phishing(scams)", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);


        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.setBackground(new Color(20, 20, 50));
        panel.add(contentPanel, BorderLayout.CENTER);


        JPanel emailPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        emailPanel.setBackground(new Color(30, 30, 60));
        contentPanel.add(emailPanel);


        explanationPanel = new JPanel(new BorderLayout());
        explanationPanel.setBackground(new Color(50, 50, 100));


        // Create a styled label for explanations
        JLabel eLabel = new JLabel("<html><div style='width:300px;text-align:center;'>Select an email to analyze</div></html>", SwingConstants.CENTER);
        eLabel.setFont(new Font("Arial", Font.BOLD, 22)); // Larger font size
        eLabel.setForeground(Color.WHITE);
        explanationPanel.add(eLabel, BorderLayout.CENTER);
        contentPanel.add(explanationPanel);


        String[] emails = {
                "Urgent! Reset your password now! Click here.",
                "Congratulations! You've won a free trip to Dubai! Reply with your details.",
                "Your bank account has been compromised! Click the link to verify.",
                "Westhill High School- Please Reset your password",
                "Verify your purchase for Amazon.com!"
        };


        boolean[] isPhishing = {true, true, true, false, false};
        String[] explanations = {
                "SCAM! Scammers use urgency and fake links to trick you.",
                "SCAM! Fake lottery wins ask for personal details.",
                "SCAM! Banks never ask you to verify your account via email.",
                "Safe! This is a normal school email.",
                "Safe! A real verified email from a legitimate purchase."
        };


        emailButtons = new JButton[5];
        for (int i = 0; i < emails.length; i++) {
            int index = i;
            emailButtons[i] = new JButton(emails[i]);
            emailButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            emailButtons[i].setBackground(Color.LIGHT_GRAY);
            emailButtons[i].setFocusPainted(false);
            emailButtons[i].addActionListener(e -> {
                // Reset all buttons first
                for (JButton button : emailButtons) {
                    button.setBackground(Color.LIGHT_GRAY);
                }


                // Update explanation label and background color
                if (isPhishing[index]) {
                    emailButtons[index].setBackground(Color.RED);
                    eLabel.setText(explanations[index]);
                    explanationPanel.setBackground(new Color(150, 0, 0)); // Darker red
                } else {
                    emailButtons[index].setBackground(Color.GREEN);
                    eLabel.setText("<html><div style='width:300px;text-align:center;color:white;'>" + explanations[index] + "</div></html>");
                    explanationPanel.setBackground(new Color(0, 150, 0)); // Darker green
                }
            });
            emailPanel.add(emailButtons[i]);
        }


        JButton realWorldButton = new JButton("What is Cybersecurity?");
        realWorldButton.setFont(new Font("Arial", Font.BOLD, 18));
        realWorldButton.setBackground(new Color(0, 51, 102));
        realWorldButton.setForeground(Color.BLACK);
        realWorldButton.addActionListener(e -> {
            eLabel.setText("<html><div style='text-align: left;'>" +
                    "<b>What is Cybersecurity?</b><br>" +
                    "Cybersecurity is the practice of protecting systems, networks, and data from digital attacks, unauthorized access, and damage. It ensures confidentiality, integrity, and availability of information.<br><br>" +


                    "<b>Why is Cybersecurity Important?</b><br>" +
                    "• Phishing scams affect millions daily—cybersecurity helps prevent fraud.<br>" +
                    "• Protects sensitive personal, financial, and business data from theft.<br>" +
                    "• Essential for all digital systems, from smartphones to government networks.<br>" +
                    "• Combines technology, processes, and human problem-solving to mitigate risks.<br><br>" +


                    "<b>Key Skills for Cybersecurity Professionals:</b><br>" +
                    "• <b>Technical Skills:</b> Networking, encryption, malware analysis, and penetration testing.<br>" +
                    "• <b>Problem-Solving:</b> Identifying vulnerabilities and developing secure solutions.<br>" +
                    "• <b>Attention to Detail:</b> Detecting anomalies in system behavior.<br>" +
                    "• <b>Programming:</b> Knowledge of Python, Bash, or C/C++ for scripting and automation.<br>" +
                    "• <b>Risk Management:</b> Assessing threats and implementing safeguards.<br>" +
                    "• <b>Ethical Hacking:</b> Understanding attacker methods to strengthen defenses.<br>" +
                    "• <b>Communication:</b> Explaining security risks to non-technical stakeholders.</div></html>");
            explanationPanel.setBackground(new Color(50, 50, 100)); // Keep original cybersecurity color
        });
        emailPanel.add(realWorldButton);


        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(new Color(50, 50, 100));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        panel.add(backButton, BorderLayout.SOUTH);


        mainPanel.add(panel, "cybersecurity");
    }


    private void resetCybersecurityPanel() {
        explanationLabel.setText("<html><div style='width:300px;text-align:center;color:white;'>Select an email to analyze</div></html>");
        explanationPanel.setBackground(new Color(50, 50, 100));
        for (JButton button : emailButtons) {
            button.setBackground(Color.LIGHT_GRAY);
        }
    }


    private void createSoftwareEngineeringPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLUE);


        JLabel label = new JLabel("Learn Bubble Sort", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);


        // Main content panel with sorting visualization and explanation
        JPanel contentPanel = new JPanel(new BorderLayout());


        // Sorting panel (made smaller by using GridLayout with 2 rows)
        sortingPanel = new JPanel();
        sortingPanel.setBackground(new Color(100, 149, 237));
        sortingPanel.setLayout(new GridLayout(2, 4, 10, 10)); // Changed to 2 rows, 4 columns


        initializeSorting();


        // Explanation panel at the bottom with blue background
        explanationLabel = new JLabel("Click 'Next Step' to begin the sorting process.", SwingConstants.CENTER);
        explanationLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        explanationLabel.setForeground(Color.WHITE);
        explanationLabel.setBackground(new Color(70, 130, 180));
        explanationLabel.setOpaque(true);
        explanationLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        contentPanel.add(sortingPanel, BorderLayout.CENTER);
        contentPanel.add(explanationLabel, BorderLayout.SOUTH);


        // Control panel with buttons
        JPanel controlPanel = new JPanel();
        JButton instructionsButton = new JButton("Instructions");
        JButton stepButton = new JButton("Next Step");
        JButton backButton = new JButton("Back to Menu");
        JButton realWorldButton = new JButton("Real World Applications");


        instructionsButton.addActionListener(e -> showInstructions());
        stepButton.addActionListener(e -> performSortingStep());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        realWorldButton.addActionListener(e -> showRealWorldApplications());


        controlPanel.add(instructionsButton);
        controlPanel.add(stepButton);
        controlPanel.add(realWorldButton);
        controlPanel.add(backButton);


        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);


        mainPanel.add(panel, "softwareEngineering");
    }


    private void initializeSorting() {
        numbers = new Random().ints(8, 1, 100).toArray(); // Changed to 8 numbers to fit the 2x4 grid
        numberLabels = new JLabel[numbers.length];
        sortingPanel.removeAll();


        for (int i = 0; i < numbers.length; i++) {
            numberLabels[i] = new JLabel(String.valueOf(numbers[i]), SwingConstants.CENTER);
            numberLabels[i].setFont(new Font("Arial", Font.BOLD, 18)); // Smaller font
            numberLabels[i].setOpaque(true);
            numberLabels[i].setBackground(Color.WHITE);
            numberLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numberLabels[i].setPreferredSize(new Dimension(60, 60)); // Smaller size
            sortingPanel.add(numberLabels[i]);
        }
        sortingPanel.revalidate();
        sortingPanel.repaint();
    }


    private void showInstructions() {
        String instructions = "<html><div style='text-align:center;'><h2>Bubble Sort Instructions</h2>" +
                "<ol style='text-align:left;'>" +
                "<li>Bubble Sort works by repeatedly comparing adjacent elements</li>" +
                "<li>If the left element is larger than the right element, they are swapped</li>" +
                "<li>This process continues until the entire array is sorted</li>" +
                "<li>Each complete pass through the array moves the largest unsorted element to its correct position</li>" +
                "<li>The algorithm stops when a complete pass makes no swaps</li>" +
                "</ol><br>" +
                "<p>Click 'Next Step' to see each comparison and swap operation.</p></div></html>";


        JOptionPane.showMessageDialog(frame, instructions, "Step-by-Step Instructions", JOptionPane.INFORMATION_MESSAGE);
    }


    private void showRealWorldApplications() {
        String applications = "<html><div style='text-align:center;'><h2>Real World Applications of Sorting</h2>" +
                "<ul style='text-align:left;'>" +
                "<li><b>Bubble Sort:</b> Bubble sort's excelllent for teaching sorting concepts which are used in the everyday lives of software engineers</li>" +
                "<li><b>Sorting Algorithms in General:</b> Used in databases (ORDER BY), e-commerce (sorting products), " +
                "file systems (sorting files), and more</li>" +
                "<li><b>Efficient Sorts:</b> Real-world applications typically use more efficient sorts like " +
                "QuickSort, MergeSort, or TimSort (used in Python and Java)</li>" +
                "<li><b>Specialized Sorts:</b> One of the most important elements of sorting and searching is to sort elements. like bubble Sort for numbers " +
                "or Counting Sort when range is limited</li>" +
                "</ul><br>" +
                "<p>Understanding sorting helps in choosing the right algorithm for specific data patterns.</p></div></html>";


        JOptionPane.showMessageDialog(frame, applications, "Real World Applications", JOptionPane.INFORMATION_MESSAGE);
    }


    private void performSortingStep() {
        if (sorted) {
            explanationLabel.setText("Sorting complete! The array is now fully sorted.");
            JOptionPane.showMessageDialog(frame, "Sorting Complete!", "Bubble Sort", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        if (currentIndex < numbers.length - pass - 1) {
            // Reset all colors first
            for (JLabel label : numberLabels) {
                label.setBackground(Color.WHITE);
            }


            // Highlight current elements being compared
            numberLabels[currentIndex].setBackground(Color.YELLOW);
            numberLabels[currentIndex + 1].setBackground(Color.YELLOW);


            if (numbers[currentIndex] > numbers[currentIndex + 1]) {
                // Swap elements
                int temp = numbers[currentIndex];
                numbers[currentIndex] = numbers[currentIndex + 1];
                numbers[currentIndex + 1] = temp;


                numberLabels[currentIndex].setText(String.valueOf(numbers[currentIndex]));
                numberLabels[currentIndex + 1].setText(String.valueOf(numbers[currentIndex + 1]));


                numberLabels[currentIndex].setBackground(Color.ORANGE);
                numberLabels[currentIndex + 1].setBackground(Color.ORANGE);


                explanationLabel.setText(String.format("Swapped %d and %d (because %d > %d)",
                        numbers[currentIndex + 1], numbers[currentIndex],
                        numbers[currentIndex + 1], numbers[currentIndex]));
            } else {
                explanationLabel.setText(String.format("No swap needed (%d ≤ %d)",
                        numbers[currentIndex], numbers[currentIndex + 1]));
            }
            currentIndex++;
        } else {
            // Mark the sorted element
            numberLabels[numbers.length - pass - 1].setBackground(Color.GREEN);
            explanationLabel.setText(String.format("Pass %d complete. Element %d is now in its final position.",
                    pass + 1, numbers[numbers.length - pass - 1]));


            pass++;
            currentIndex = 0;


            // Check if sorting is complete
            if (pass == numbers.length - 1) {
                sorted = true;
                for (JLabel label : numberLabels) {
                    label.setBackground(Color.GREEN);
                }
                explanationLabel.setText("Sorting complete! All elements are in their correct positions.");
            }
        }
    }
    private void createWhyCSPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(10, 10, 26)); // Dark blue background
        panels.put("whyCS", panel);


        // Title with emoji
        JLabel title = new JLabel("🌟 Why Computer Science? 🌟", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE); // Teal color
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(title, BorderLayout.NORTH);


        // Main content panel with scroll
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(10, 10, 26));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));


        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(new Color(10, 10, 26));
        panel.add(scrollPane, BorderLayout.CENTER);


        // Add the 10 reasons with emojis
        String[][] reasons = {
                {"🔍 Problem-Solving Skills", "Computer science teaches you to think critically and solve complex problems efficiently."},
                {"💰 High Demand Careers", "Tech jobs are among the fastest-growing and highest-paying in various industries."},
                {"🤖 Automation and AI", "Understanding how computers work allows you to automate tasks and work with artificial intelligence."},
                {"🛡️ Cybersecurity Awareness", "Learning CS helps protect personal and business data from cyber threats."},
                {"💻 Software Development", "You can build applications, games, or tools that solve real-world problems."},
                {"🌐 Versatility", "CS knowledge is useful in fields like healthcare, finance, entertainment, and education."},
                {"🎨 Creativity and Innovation", "Coding allows you to bring creative ideas to life, from websites to robotics."},
                {"🧠 Logical Thinking", "Programming strengthens logical and structured thinking, useful in all aspects of life."},
                {"🌍 Understanding of Digital World", "Almost everything runs on software today, and CS helps you understand how it all works."},
                {"🚀 Entrepreneurship Opportunities", "Many successful startups are built on computer science principles."}
        };


        for (String[] reason : reasons) {
            JPanel reasonPanel = new JPanel(new BorderLayout());
            reasonPanel.setBackground(new Color(20, 20, 50));
            reasonPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));


            JLabel emojiLabel = new JLabel(reason[0]);
            emojiLabel.setFont(new Font("Arial", Font.BOLD, 22));
            emojiLabel.setForeground(new Color(0, 255, 204));


            JTextArea descArea = new JTextArea(reason[1]);
            descArea.setFont(new Font("Arial", Font.PLAIN, 18));
            descArea.setForeground(Color.WHITE);
            descArea.setBackground(new Color(20, 20, 50));
            descArea.setLineWrap(true);
            descArea.setWrapStyleWord(true);
            descArea.setEditable(false);
            descArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));


            reasonPanel.add(emojiLabel, BorderLayout.NORTH);
            reasonPanel.add(descArea, BorderLayout.CENTER);
            contentPanel.add(reasonPanel);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }


        // Back button
        JButton backButton = new JButton("⬅ Back to Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(new Color(50, 50, 100));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        panel.add(backButton, BorderLayout.SOUTH);


        mainPanel.add(panel, "whyCS");
    }


    private void createOtherFieldsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(10, 10, 26));
        panels.put("otherFields", panel);


        // Title
        JLabel title = new JLabel("🚀 Other Fields That Use Computer Science 🚀", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        panel.add(title, BorderLayout.NORTH);


        // Main content panel with fields on left and explanation on right
        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.setBackground(new Color(10, 10, 26));


        // Fields selection panel (left side)
        JPanel fieldsPanel = new JPanel(new GridLayout(10, 1, 10, 10));
        fieldsPanel.setBackground(new Color(20, 20, 50));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        // Explanation panel (right side)
        JPanel explanationPanel = new JPanel(new BorderLayout());
        explanationPanel.setBackground(new Color(30, 30, 70));
        explanationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JTextArea explanationArea = new JTextArea("Select a field to see how Computer Science is involved!");
        explanationArea.setFont(new Font("Arial", Font.PLAIN, 20));
        explanationArea.setForeground(Color.WHITE);
        explanationArea.setBackground(new Color(30, 30, 70));
        explanationArea.setLineWrap(true);
        explanationArea.setWrapStyleWord(true);
        explanationArea.setEditable(false);
        explanationPanel.add(explanationArea, BorderLayout.CENTER);


        // Create buttons for different fields
        String[][] fields = {
                {"🎮 Gaming Industry", "Computer Science is fundamental in game development:\n\n" +
                        "• Game engines (Unity, Unreal) are built with C++/C#\n" +
                        "• Physics simulations require advanced algorithms\n" +
                        "• AI controls non-player characters (NPCs)\n" +
                        "• Networking enables multiplayer experiences\n" +
                        "• Graphics programming uses linear algebra\n\n" +
                        "Game developers need strong CS fundamentals in data structures, algorithms, and optimization."},


                {"🏥 Healthcare", "CS revolutionizes healthcare:\n\n" +
                        "• Medical imaging (MRI, CT scans) uses image processing\n" +
                        "• Electronic health records manage patient data\n" +
                        "• Machine learning helps diagnose diseases\n" +
                        "• Robotics assists in surgeries\n" +
                        "• Bioinformatics analyzes genetic data\n\n" +
                        "CS helps save lives through technology!"},


                {"🎬 Film & Animation", "Hollywood relies on CS:\n\n" +
                        "• CGI and special effects use rendering algorithms\n" +
                        "• 3D modeling software depends on computational geometry\n" +
                        "• Motion capture technology processes movement data\n" +
                        "• Video editing software uses signal processing\n" +
                        "• Animation tools automate in-between frames\n\n" +
                        "Your favorite movies wouldn't look the same without CS!"},


                {"🚗 Automotive", "Modern cars are computers on wheels:\n\n" +
                        "• Self-driving cars use machine learning and sensors\n" +
                        "• Engine control units run real-time software\n" +
                        "• Navigation systems process map data\n" +
                        "• Safety systems (ABS, traction control) use algorithms\n" +
                        "• Electric vehicles optimize battery performance\n\n" +
                        "CS is driving the future of transportation!"},


                {"🏦 Finance", "Wall Street runs on code:\n\n" +
                        "• Algorithmic trading executes millions of trades/second\n" +
                        "• Blockchain technology secures cryptocurrencies\n" +
                        "• Risk analysis uses statistical models\n" +
                        "• Fraud detection employs machine learning\n" +
                        "• High-frequency trading requires low-latency systems\n\n" +
                        "Money moves at the speed of code!"},


                {"🌾 Agriculture", "Farming goes high-tech with CS:\n\n" +
                        "• Precision agriculture uses sensors and drones\n" +
                        "• Automated irrigation systems conserve water\n" +
                        "• Crop monitoring uses computer vision\n" +
                        "• Robotics harvests fruits and vegetables\n" +
                        "• Machine learning predicts crop yields\n\n" +
                        "CS helps feed the world more efficiently!"},


                {"🎵 Music Industry", "CS transforms music creation:\n\n" +
                        "• Digital audio workstations process sound\n" +
                        "• Auto-tune and effects use signal processing\n" +
                        "• Music recommendation systems (Spotify) use ML\n" +
                        "• Synthesizers generate sounds algorithmically\n" +
                        "• Streaming services compress and deliver audio\n\n" +
                        "Your favorite songs are powered by code!"},


                {"🚀 Space Exploration", "CS takes us to the stars:\n\n" +
                        "• Rocket guidance systems require precise calculations\n" +
                        "• Satellite communication uses networking protocols\n" +
                        "• Mars rovers run autonomous software\n" +
                        "• Telescope data analysis finds exoplanets\n" +
                        "• Spacecraft simulations test mission scenarios\n\n" +
                        "CS helps humanity explore the cosmos!"},


                {"🛍️ Retail & E-commerce", "Shopping revolutionized by CS:\n\n" +
                        "• Recommendation systems suggest products\n" +
                        "• Inventory management uses databases\n" +
                        "• Fraud detection protects transactions\n" +
                        "• Price optimization algorithms adjust in real-time\n" +
                        "• Augmented reality lets you 'try before you buy'\n\n" +
                        "CS creates seamless shopping experiences!"},


                {"🏈 Sports", "CS enhances athletic performance:\n\n" +
                        "• Player tracking analyzes movement patterns\n" +
                        "• Equipment design uses simulations\n" +
                        "• Instant replay systems process video\n" +
                        "• Statistics and analytics inform strategy\n" +
                        "• Wearable tech monitors athlete health\n\n" +
                        "CS is changing how we play and watch sports!"}
        };


        for (String[] field : fields) {
            JButton fieldButton = new JButton(field[0]);
            fieldButton.setFont(new Font("Arial", Font.BOLD, 25));
            fieldButton.setBackground(new Color(50, 50, 100));
            fieldButton.setForeground(Color.BLACK);
            fieldButton.setFocusPainted(false);
            fieldButton.addActionListener(e -> {
                explanationArea.setText(field[1]);
                explanationArea.setFont(new Font("Arial", Font.PLAIN, 30));
            });
            fieldsPanel.add(fieldButton);
        }


        contentPanel.add(fieldsPanel);
        contentPanel.add(explanationPanel);
        panel.add(contentPanel, BorderLayout.CENTER);


        // Back button
        JButton backButton = new JButton("⬅ Back to Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(new Color(50, 50, 100));
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        panel.add(backButton, BorderLayout.SOUTH);


        mainPanel.add(panel, "otherFields");
    }










    private void createThankYouPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(10, 10, 26));
        panels.put("thankYou", panel);


        // Main content panel with animation
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(10, 10, 26));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 0, 20, 0);


        //  thank you message
        JLabel thankYouLabel = new JLabel("Thank You For Exploring Computer Science!");
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 36));
        thankYouLabel.setForeground(new Color(255, 215, 0)); // Gold color
        contentPanel.add(thankYouLabel, gbc);


        // Heart animation
        JLabel heartLabel = new JLabel("❤️");
        heartLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        contentPanel.add(heartLabel, gbc);


        // Message about pursuing CS
        JTextArea messageArea = new JTextArea(
                "We hope this exploration has inspired you to consider\n" +
                        "Computer Science as a future path!\n\n" +
                        "As you can see computer science is everywhere\n" +
                        "Whether you choose AI, Cybersecurity, Software Engineering,\n" +
                        "or any other field, CS skills will open opportunities to amazing things.\n\n" +
                        "For more lessons, information, resources, and inspiration:\n" +
                        "• Contact: westhillcs on gmail\n" +
                        "• YouTube: Westhillcs\n" +
                        "• Keep coding and exploring!"
        );
        messageArea.setFont(new Font("Arial", Font.PLAIN, 20));
        messageArea.setForeground(Color.WHITE);
        messageArea.setBackground(new Color(10, 10, 26));
        messageArea.setEditable(false);
        messageArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(messageArea, gbc);


        // Animation for the heart
        Timer heartTimer = new Timer(500, e -> {
            if (heartLabel.getText().equals("❤️")) {
                heartLabel.setText("💙");
                heartLabel.setForeground(Color.BLUE);
            } else {
                heartLabel.setText("❤️");
                heartLabel.setForeground(Color.RED);
            }
        });
        heartTimer.start();


        // Sparkle animation
        JLabel sparkleLabel = new JLabel("✨✨✨");
        sparkleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        sparkleLabel.setForeground(Color.YELLOW);
        contentPanel.add(sparkleLabel, gbc);




        panel.add(contentPanel, BorderLayout.CENTER);


        // Back button
        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(new Color(50, 50, 100));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        panel.add(backButton, BorderLayout.SOUTH);


        mainPanel.add(panel, "thankYou");
    }


    private JButton createDirectionButton(String text, String action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(80, 40, 40));
        button.setForeground(Color.WHITE);
        button.addActionListener(e -> handleRobotAction(action));
        return button;
    }


    private void handleRobotAction(String action) {
        if (robot == null) return;

        Rectangle robotBounds = robot.getBounds();
        int moveAmount = 20; // Pixels to move each step

        switch (action) {
            case "UP":
                if (robotBounds.y - moveAmount >= 0) {
                    robot.setLocation(robotBounds.x, robotBounds.y - moveAmount);
                }
                break;
            case "DOWN":
                if (robotBounds.y + moveAmount + robotBounds.height <= conveyorPanel.getHeight() - 50) {
                    robot.setLocation(robotBounds.x, robotBounds.y + moveAmount);
                }
                break;
            case "LEFT":
                if (robotBounds.x - moveAmount >= 0) {
                    robot.setLocation(robotBounds.x - moveAmount, robotBounds.y);
                }
                break;
            case "RIGHT":
                if (robotBounds.x + moveAmount + robotBounds.width <= conveyorPanel.getWidth()) {
                    robot.setLocation(robotBounds.x + moveAmount, robotBounds.y);
                }
                break;
            case "GRAB":
                handleGrabAction();
                break;
        }
        conveyorPanel.revalidate();
        conveyorPanel.repaint();
    }

    private void handleGrabAction() {
        if (conveyorPanel == null || robot == null) return;

        if (currentHeldBox == null) {
            // Try to grab a box
            for (JLabel box : new ArrayList<>(boxes)) {
                if (box != null && robot.getBounds().intersects(box.getBounds())) {
                    currentHeldBox = box;
                    boxes.remove(box);
                    conveyorPanel.remove(box);
                    statusLabel.setText("Box grabbed! Move to container and press GRAB");
                    break;
                }
            }
            if (currentHeldBox == null) {
                statusLabel.setText("No box in range to grab!");
            }
        } else {
            // Try to drop in container
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] != null && robot.getBounds().intersects(containers[i].getBounds())) {
                    // Update container count
                    containerCounts[i]++;
                    containers[i].setText(containers[i].getText().replaceAll("\\(\\d+\\)", "(" + containerCounts[i] + ")"));
                    currentHeldBox = null;
                    statusLabel.setText("Box delivered to container " + (i+1) + "!");
                    break;
                }
            }
            if (currentHeldBox != null) {
                statusLabel.setText("Not close enough to container!");
            }
        }
        conveyorPanel.revalidate();
        conveyorPanel.repaint();
    }


    private JButton createMovementButton(String text, String action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(80, 40, 40));
        button.setForeground(Color.WHITE);
        button.addActionListener(e -> handleRobotAction(action));
        return button;
    }


    private void resetRoboticsPanel() {
        // Clear all boxes from conveyor
        boxes.clear();
        conveyorPanel.removeAll();

        // Reset robot position
        robot = new JLabel("🤖");
        robot.setFont(new Font("Arial", Font.PLAIN, 40));
        robot.setHorizontalAlignment(SwingConstants.CENTER);
        robot.setBounds(50, 100, 50, 50); // Initial position
        conveyorPanel.add(robot, JLayeredPane.PALETTE_LAYER);

        // Reset containers and counts
        JPanel containersPanel = new JPanel(new GridLayout(1, 3));
        containersPanel.setOpaque(false);
        containersPanel.setBounds(100, 250, 300, 50);

        String[] containerTypes = {"📦", "📫", "🧺"};
        for (int i = 0; i < 3; i++) {
            containerCounts[i] = 0;
            containers[i] = new JLabel(containerTypes[i] + " (0)", SwingConstants.CENTER);
            containers[i].setFont(new Font("Arial", Font.PLAIN, 30));
            containers[i].setForeground(Color.WHITE); // Bright text
            containersPanel.add(containers[i]);
        }

        conveyorPanel.add(containersPanel, JLayeredPane.DEFAULT_LAYER);
        currentHeldBox = null;

        // Reset status message
        statusLabel.setText("Use the controls to move the robot and sort boxes");
        statusPanel.setBackground(new Color(150, 50, 50)); // Brighter red

        conveyorPanel.revalidate();
        conveyorPanel.repaint();
    }

    private void startConveyor() {
        if (conveyorTimer != null && conveyorTimer.isRunning()) {
            conveyorTimer.stop();
        }

        conveyorTimer = new Timer(2000, e -> {
            if (boxes.size() < 3) { // Max 3 boxes on conveyor
                JLabel box = new JLabel("⬛"); // Black box
                box.setFont(new Font("Arial", Font.PLAIN, 30));
                box.setForeground(Color.BLACK);
                box.setBounds(0, 160, 30, 30);
                boxes.add(box);
                conveyorPanel.add(box, JLayeredPane.PALETTE_LAYER);

                // Animate box movement
                Timer boxTimer = new Timer(50, evt -> {
                    if (box.getParent() == null) {
                        ((Timer)evt.getSource()).stop();
                        return;
                    }

                    box.setLocation(box.getX() + 2, box.getY());

                    // Check if box reached end
                    if (box.getX() > conveyorPanel.getWidth()) {
                        ((Timer)evt.getSource()).stop();
                        boxes.remove(box);
                        conveyorPanel.remove(box);
                        statusLabel.setText("Box missed the robot!");
                        conveyorPanel.revalidate();
                        conveyorPanel.repaint();
                    }

                    // Auto-grab if robot is in path
                    if (currentHeldBox == null && robot != null && robot.getBounds().intersects(box.getBounds())) {
                        ((Timer)evt.getSource()).stop();
                        currentHeldBox = box;
                        boxes.remove(box);
                        conveyorPanel.remove(box);
                        statusLabel.setText("Box auto-grabbed! Move to container");
                        conveyorPanel.revalidate();
                        conveyorPanel.repaint();
                    }
                });
                boxTimer.start();
            }
        });
        conveyorTimer.start();
        statusLabel.setText("Conveyor started - boxes incoming!");
        startConveyorBtn.setEnabled(false);
        stopConveyorBtn.setEnabled(true);
    }

    private void stopConveyor() {
        if (conveyorTimer != null) {
            conveyorTimer.stop();
            conveyorTimer = null;
            statusLabel.setText("Conveyor stopped");
            startConveyorBtn.setEnabled(true);
            stopConveyorBtn.setEnabled(false);
        }
    }

    private void createRoboticsPanel() {


            // ... (previous code remains the same until containers setup)

            // Initialize containers with better visibility
            JPanel containersPanel = new JPanel(new GridLayout(1, 3, 10, 0));
            containersPanel.setBounds(100, 280, 300, 60); // Lower position
            containersPanel.setOpaque(false);

            String[] containerTypes = {"📦", "📫", "🧺"}; // Keep emojis if possible
            Color[] containerColors = {Color.RED, Color.BLUE, Color.GREEN};

            for (int i = 0; i < 3; i++) {
                containers[i] = new JLabel(containerTypes[i] + " (0)", SwingConstants.CENTER);
                containers[i].setFont(new Font("Arial", Font.BOLD, 24));
                containers[i].setForeground(Color.WHITE);
                containers[i].setOpaque(true);
                containers[i].setBackground(containerColors[i]);
                containers[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                containersPanel.add(containers[i]);
            }
        // Initialize variables
        containers = new JLabel[3];
        containerCounts = new int[3];
        boxes = new ArrayList<>();

        // Create main panel with brighter colors
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(80, 40, 40));
        panels.put("robotics", panel);

        // Title
        JLabel titleLabel = new JLabel("Control the Robot to Sort Boxes!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Main content area
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        contentPanel.setBackground(new Color(80, 40, 40));

        // Control panel (left side)
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.setBackground(new Color(100, 60, 60));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Movement buttons grid
        JPanel directionPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        directionPanel.setBackground(new Color(100, 60, 60));

        // Add buttons with proper spacing
        directionPanel.add(new JLabel(""));
        directionPanel.add(createMovementButton("↑", "UP"));
        directionPanel.add(new JLabel(""));

        directionPanel.add(createMovementButton("←", "LEFT"));
        directionPanel.add(createMovementButton("GRAB", "GRAB"));
        directionPanel.add(createMovementButton("→", "RIGHT"));

        directionPanel.add(new JLabel(""));
        directionPanel.add(createMovementButton("↓", "DOWN"));
        directionPanel.add(new JLabel(""));

        controlPanel.add(directionPanel, BorderLayout.CENTER);

        // Conveyor panel (right side)
        conveyorPanel = new JLayeredPane();
        conveyorPanel.setBackground(new Color(120, 120, 120)); // Brighter conveyor
        conveyorPanel.setPreferredSize(new Dimension(500, 350));
        conveyorPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        // Initialize containers
        JPanel containersPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        containersPanel.setBounds(100, 250, 300, 50);
        containersPanel.setOpaque(false);

        String[] containerTypes = {"📦", "📫", "🧺"};
        for (int i = 0; i < 3; i++) {
            containers[i] = new JLabel(containerTypes[i] + " (0)", SwingConstants.CENTER);
            containers[i].setFont(new Font("Arial", Font.PLAIN, 30));
            containers[i].setForeground(Color.WHITE);
            containersPanel.add(containers[i]);
        }
        conveyorPanel.add(containersPanel, JLayeredPane.DEFAULT_LAYER);

        // Initialize robot
        robot = new JLabel("🤖");
        robot.setFont(new Font("Arial", Font.PLAIN, 40));
        robot.setBounds(50, 150, 50, 50);
        conveyorPanel.add(robot, JLayeredPane.PALETTE_LAYER);

        // Add components to main panel
        contentPanel.add(controlPanel);
        contentPanel.add(conveyorPanel);
        panel.add(contentPanel, BorderLayout.CENTER);

        // Status panel
        statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(new Color(150, 50, 50));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        statusLabel = new JLabel("Use the controls to move the robot", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setForeground(Color.WHITE);
        statusPanel.add(statusLabel, BorderLayout.CENTER);

        // Control buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        startConveyorBtn = new JButton("Start Conveyor");
        startConveyorBtn.setBackground(new Color(80, 120, 80));
        startConveyorBtn.setForeground(Color.WHITE);
        startConveyorBtn.addActionListener(e -> startConveyor());
        buttonPanel.add(startConveyorBtn);

        stopConveyorBtn = new JButton("Stop Conveyor");
        stopConveyorBtn.setBackground(new Color(120, 80, 80));
        stopConveyorBtn.setForeground(Color.WHITE);
        stopConveyorBtn.setEnabled(false);
        stopConveyorBtn.addActionListener(e -> stopConveyor());
        buttonPanel.add(stopConveyorBtn);

        statusPanel.add(buttonPanel, BorderLayout.SOUTH);

        panel.add(statusPanel, BorderLayout.SOUTH);

        // Back button
        JButton backButton = new JButton("Back to Menu");
        backButton.setBackground(new Color(100, 100, 100));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            stopConveyor();
            cardLayout.show(mainPanel, "menu");
        });
        panel.add(backButton, BorderLayout.NORTH);

        mainPanel.add(panel, "robotics");
    }
}