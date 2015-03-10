package fi.jamk;

import javazoom.jl.player.Player; 

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author h8599
 */
public class GraphicsTesting extends JFrame implements Runnable {
    private Font f1;
    private Image bgImage;
    private MediaTracker mt;
    private ArrayList<Ball> balls;
    private Thread thread;
    
    public GraphicsTesting() {
        super("Graphics Testing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        this.f1 = new Font("Verdana",Font.BOLD,20);
        this.bgImage = getToolkit().createImage("bg.jpg");
        this.mt = new MediaTracker(this);
        this.mt.addImage(bgImage, 0);
        try {
        this.mt.waitForAll();
        }catch (InterruptedException e) {
            // Nothing..
        }
        //this.ball = new Ball(800,600);
        this.balls = new ArrayList<>();
        for (int i=1; i<=10000;i++) {
            balls.add( new Ball(800,600));
        }
        
        getContentPane().add( new DrawPanel() );
        //alustetaan säie
        this.thread = new Thread(this);
        this.thread.start();
    }
    public static void main(String args[]) {
        new GraphicsTesting().setVisible(true);
    }
    
    // metodi toteuttaa tälle luokalle oman säikeen
    @Override
    public void run() {
        while(true) {
            // siirretään
            for (Ball ball : balls) {
            ball.move();
            }
            // piirretään
            repaint();
            // huilataan
            try {
            thread.sleep(10);
            } catch (InterruptedException e) {
                // nothing
            }
            
        }
    }
    
    // toteutetaan sovelluksen piirtäminen oman
    // JPanelista periytyvän luokan avulla
    class DrawPanel extends JPanel {
        
        @Override
        public void paintComponent(Graphics g) {
           //bg
           g.drawImage(bgImage, 0, 0, this);
           // ball
           for (Ball ball : balls) {
           g.setColor(ball.getColor());
           g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
                      // text
           g.setColor(Color.black);
           g.setFont(f1);
           g.drawString("EPILEPSIA PALLOT", 300, 300);
        }
        }
    }
}
