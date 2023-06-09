import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.awt.event.ActionListener;
import  java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * creates the frame for the pong game.
 * including all its important properties
 * @author Matthew Williams
 *
 **/



public class PongGame extends JPanel implements ActionListener, KeyListener {

    /**
     * height of window
     **/
    public static final int HEIGHT = 1000;

    /**
     * width of window
     **/
    public static final int WIDTH = 1000;

    /**
     * x location of obstacle
     **/
    public static final int OX = 600;

    /**
     * y location of obstacle
     **/
    public static final int OY = 400;




    Timer t = new Timer(5, this);
    String file = "Scores.txt";
    FileOutputStream fos = new FileOutputStream(file);
    PrintStream out = new PrintStream(fos);




    /**
     * paddle 1
     **/
    private Paddle p1 = new Paddle(HEIGHT-900, HEIGHT-500);

    /**
     * paddle 2
     **/
    private Paddle p2 = new Paddle(HEIGHT-100, HEIGHT-500);

    /**
     * ball of game
     **/

    private Ball b = new Ball(HEIGHT-500, HEIGHT-500);

    /**
     * x of paddle 1
     **/


    private int p1X = p1.getX();

    /**
     * y of paddle 1
     **/
    private int p1Y = p1.getY();

    /**
     * x of paddle 2
     **/

    private int p2X = p2.getX();

    /**
     * y of paddle 2
     **/
    private int p2Y = p2.getY();

    /**
     * x of ball
     **/

    private int bX = b.getX();

    /**
     * y of ball
     **/
    private int bY = b.getY();

    /**
     * x speed of ball
     **/
    private int bSX = b.getSpeed();

    /**
     * y speed of ball
     **/
    private int bSY = b.getSpeed();

    /**
     * player 1 score
     **/
    private int p1Score = 0;

    /**
     * player 2 score
     **/

    private int p2Score = 0;


    /**
     * difficulty of the game
     **/


    private int diff = 0;



   /**
     * constructor for PongGame frame.
     * @param diff is the difficulty of the game
     * @throws FileNotFoundException for if something goes wrong
     *
     **/

    public PongGame(int diff) throws FileNotFoundException {
        setSize(WIDTH, HEIGHT);
        this.diff = diff;

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    /**
     * runs the main functions of the PongGame frame
     **/

    public void run() throws InterruptedException{
        while (true){
            this.bX += bSX;
            this.bY -= bSY;



            if (this.bX > HEIGHT){
                this.bSX *= -1;
                this.p2Score += 1;
                System.out.println(this.p2Score);
                this.bX = HEIGHT - 500;
                this.bY = HEIGHT - 500;
            }

            if (this.bX < 0){
                this.p1Score += 1;
                System.out.println(this.p1Score);
                this.bSX *= -1;
                this.bX = HEIGHT - 500;
                this.bY = HEIGHT - 500; }
            if (this.bY > HEIGHT-220 || this.bY < 0){
                this.bSY *= -1;
            }

            if (this.bY < this.p1Y){
                this.p1Y -= p1.getSpeed()-4;
            }

            if (this.bY > this.p1Y){
                this.p1Y += p1.getSpeed()-4;
            }

            if (this.bX >= this.p2X-10 && this.bX <= this.p2X+10 && this.bY > this.p2Y && this.bY < this.p2Y + HEIGHT/17){
                this.bSX *= -1;


            }

            if (this.bX == 100 && this.bY < this.p1Y +10 && this.bY < this.p1Y + HEIGHT/17-10){
                this.bSX *= -1;


            }

            if (this.diff == 1){
                if (this.bX == 600 && this.bY > OY-10 && this.bY < OY + HEIGHT/17+10){
                    this.bSX *= -1;}}

            if (this.p1Score == 10 || this.p2Score == 10){
                out.println("p1: " + this.p1Score + " p2: " + this.p2Score);
                out.close();
                System.exit(1);
            }




            Thread.sleep(10);

            repaint();

        }
    }





    /**
     * draws the necessary shapes of program
     * @param g to draw the shapes
     **/
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(this.p1X, this.p1Y, WIDTH/100, HEIGHT/17);
        g.fillRect(this.p2X, this.p2Y, WIDTH/100, HEIGHT/17);
        g.fillRect(this.bX, this.bY, WIDTH/100, HEIGHT/100);

        if (this.diff == 1){
            g.setColor(Color.YELLOW);
            g.fillRect(OX, OY, WIDTH/100, HEIGHT/17);}

        setBackground(Color.BLACK);
        t.start();
    }


    /**
     * allows the programs and shapes to move and preform actions
     * @param e is a type of action event
     **/
    @Override
    public void actionPerformed(ActionEvent e) {


    }
    /**
     * allows the programs and shapes to move and preform actions when the value of a key is entered
     * @param e is a type of key event
     **/

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * allows the programs and shapes to move and preform actions when a key is pressed
     * @param e is a type of key event
     **/

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        int C = e.getKeyCode();

        switch (C) {
            case KeyEvent.VK_UP -> {
                this.p2Y -= p2.getSpeed();
                repaint();
            }
            case KeyEvent.VK_DOWN -> {
                this.p2Y += p2.getSpeed();
                repaint();
            }


        }

    }

    /**
     * allows the programs and shapes to move and preform actions when a key is released
     * @param e is a type of key event
     **/

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
