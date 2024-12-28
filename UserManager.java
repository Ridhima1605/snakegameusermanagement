import java.io.*;
import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> users = new HashMap<>();
    private static final String DATA_FILE = "users.dat";

    public UserManager() {
        loadUsers();
    }

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, new User(username, password));
        saveUsers();
        return true;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    private void saveUsers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            users = (HashMap<String, User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous user data found. Starting fresh.");
        }
    }
}
