import javax.swing.*;
import java.io.FileNotFoundException;

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
        int height = 1000;
        int width = 1000;
        String diff = args[0];

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