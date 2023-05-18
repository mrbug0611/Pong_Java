/**
 * creates the paddles for the pong game.
 * including all their important properties
 * @author Matthew Williams
 *
  **/

public class Paddle{





    /**
     * x location for paddle
     **/
    private int x;
    /**
     * y location for paddle
     **/
    private int y;
    /**
     * speed of paddle
     **/
    private int speed = 10;

    /**
     * constructor for paddle.
     * @param x location of paddle
     * @param y location of paddle
     **/

    public Paddle(int x, int y){
        this.x = x;
        this.y = y;

    }

    /**
     * gets x of paddle
     * @return x of paddle
     **/
    public int getX(){
        return this.x;
    }

    /**
     * gets y of paddle
     * @return y of paddle
     **/

    public int getY(){
        return this.y;
    }

    /**
     * gets speed of paddle
     * @return speed of paddle
     **/

    public int getSpeed(){
        return this.speed;
    }





}



