
/**
 * creates the ball for the pong game.
 * including all their important properties
 * @author Matthew Williams
 *
 **/


public class Ball{






    /**
     * x location for ball
     **/
    private int x;

    /**
     * y location for ball
     **/
    private int y;

    /**
     * speed of ball
     **/

    private int speed = 2;

    /**
     * constructor for ball.
     * @param x location of ball
     * @param y location of ball
     **/

    public Ball(int x, int y){
        this.x = x;
        this.y = y;

    }

    /**
     * gets x of ball
     * @return x of ball
     **/
    public int getX(){
        return this.x;
    }

    /**
     * get y of ball
     * @return y of ball
     **/

    public int getY(){
        return this.y;
    }

    /**
     * gets speed of ball
     * @return speed of ball
     **/

    public int getSpeed(){
        return this.speed;
    }





}



