import javax.swing.*;

public class GUVIProject {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        User currentUser = null;

        while (true) {
            String[] options = {"Login", "Register", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome to GUVI Snake Game!", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) { // Login
                String username = JOptionPane.showInputDialog("Enter username:");
                String password = JOptionPane.showInputDialog("Enter password:");
                currentUser = userManager.login(username, password);

                if (currentUser != null) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    JFrame gameFrame = new JFrame("Snake Game");
                    gameFrame.add(new SnakeGame(currentUser));
                    gameFrame.pack();
                    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Try again.");
                }
            } else if (choice == 1) { // Register
                String username = JOptionPane.showInputDialog("Enter new username:");
                String password = JOptionPane.showInputDialog("Enter new password:");
                if (userManager.register(username, password)) {
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Username already exists!");
                }
            } else if (choice == 2) { // Exit
                break;
            }
        }
    }
}
