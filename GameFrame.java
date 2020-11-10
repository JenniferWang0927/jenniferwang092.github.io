package main.java.ui;

import main.java.auxiliary.*;
import main.java.content.GameContent;
import main.java.content.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Jennifer
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        this.setTitle("Click to play with Marshmallow");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = new Dimension(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        int width = toolkit.getScreenSize().width;
        int height = toolkit.getScreenSize().height;
        this.setBounds((int) (width - size.getWidth()) / 2,
                (int) (height - size.getHeight()) / 3, (int) size.getWidth(), (int) size.getHeight());

        
        this.init();

    }

    private void init() {
        ElementBean.init();
        
        Player player = new Player();
        
        GameContent gameContent = new GameContent(player);
        
        GamePanel panel = new GamePanel(gameContent, player);
        
        this.add(panel);
        this.setVisible(true);

        
        CommonUtils.task(5, () -> {
            panel.repaint();
            if (player.gameOver()) {
                Constant.TIMER_STOP_ON_OFF = true;
                Audio.GameOver.play();
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.dispose();
                System.exit(0);
            }
        });

        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Keys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Keys.remove(e.getKeyCode());
            }
        });
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
