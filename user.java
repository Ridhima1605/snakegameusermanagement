import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private int highScore;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.highScore = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
