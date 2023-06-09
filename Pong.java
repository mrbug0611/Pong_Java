import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * creates the window for the pong game.
 * including all its important properties
 * @author Matthew Williams
 *
 **/

public class Pong{

    /**
     * main for Pong window.
     * @param args to get what is entered into the command line
     * @throws FileNotFoundException for if something goes wrong
     *
     **/
    public static void main(String[] args) throws FileNotFoundException {
        Random rand = new Random();
        

        int height = 1000;
        int width = 1000;
        int diff = rand.nextInt(2);

        JFrame frame = new JFrame("Pong");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        PongGame pg = new PongGame(diff);





        frame.add(pg);
        frame.setVisible(true);

        try{
            pg.run();} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }}
