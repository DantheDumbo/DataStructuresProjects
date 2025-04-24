import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class UserAuthApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton, loginButton;
    private static final String FILE_NAME = "users.txt";
    private HashMap<String, String> userDatabase;

    public UserAuthApp() {
        super("User Login & Registration");

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        userDatabase = new HashMap<>();
        loadUsers();

        setLayout(new GridLayout(4, 1));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        add(buttonPanel);

        registerButton.addActionListener(e -> register());
        loginButton.addActionListener(e -> login());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2)
                    userDatabase.put(parts[0], parts[1]);
            }
        } catch (IOException ignored) {}
    }

    private void saveUser(String username, String hashedPassword) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + hashedPassword);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving user.");
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(String.format("%02x", b));
            return hex.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private void register() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (userDatabase.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists.");
            return;
        }

        String hashed = hashPassword(password);
        if (hashed != null) {
            userDatabase.put(username, hashed);
            saveUser(username, hashed);
            JOptionPane.showMessageDialog(this, "Registration successful!");
        }
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String hashed = hashPassword(password);

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(hashed)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserAuthApp::new);
    }
}
