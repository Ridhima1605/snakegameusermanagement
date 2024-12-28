import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private final int TILE_SIZE = 30;
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private final int ALL_TILES = (WIDTH * HEIGHT) / (TILE_SIZE * TILE_SIZE);

    private final int[] x = new int[ALL_TILES];
    private final int[] y = new int[ALL_TILES];

    private int bodyParts = 3;
    private int appleX;
    private int appleY;
    private int score = 0;

    private boolean running = false;
    private Timer timer;
    private char direction = 'R';

    private User currentUser;

    public SnakeGame(User user) {
        this.currentUser = user;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> {
                        if (direction != 'R') direction = 'L';
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if (direction != 'L') direction = 'R';
                    }
                    case KeyEvent.VK_UP -> {
                        if (direction != 'D') direction = 'U';
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (direction != 'U') direction = 'D';
                    }
                }
            }
        });
        startGame();
    }

    private void startGame() {
        running = true;
        spawnApple();
        timer = new Timer(100, this);
        timer.start();
    }

    private void spawnApple() {
        Random random = new Random();
        appleX = random.nextInt(WIDTH / TILE_SIZE) * TILE_SIZE;
        appleY = random.nextInt(HEIGHT / TILE_SIZE) * TILE_SIZE;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (running) {
            g.setColor(Color.RED);
            g.fillRect(appleX, appleY, TILE_SIZE, TILE_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                g.setColor(i == 0 ? Color.GREEN : Color.LIGHT_GRAY);
                g.fillRect(x[i], y[i], TILE_SIZE, TILE_SIZE);
            }

            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 10, 10);
        } else {
            endGame(g);
        }
    }

    private void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U' -> y[0] -= TILE_SIZE;
            case 'D' -> y[0] += TILE_SIZE;
            case 'L' -> x[0] -= TILE_SIZE;
            case 'R' -> x[0] += TILE_SIZE;
        }
    }

    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            score++;
            spawnApple();
        }
    }

    private void checkCollision() {
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }

        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    private void endGame(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Game Over! Score: " + score, WIDTH / 2 - 50, HEIGHT / 2);
        if (currentUser.getHighScore() < score) {
            currentUser.setHighScore(score);
            g.drawString("New High Score: " + score, WIDTH / 2 - 50, HEIGHT / 2 + 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }
}
