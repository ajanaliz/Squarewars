package com.aut.alij.squarewars;

import java.awt.*;

/**
 * Created by Ali J on 2/23/2015.
 */
public class SmartEnemy extends GameObject{
/*this is an enemy that has a bit of A.I setup into it,what we're going to do is we're going to calculate the distance between SmartEnemy and Player and set the VelX and VelY(we can divide it and multiply its difference)*/
    private Handler handler;
    private GameObject player;


    public void tick() {
        x += VelX;
        y += VelY;

        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;// the -16 is so the very middle of the object isnt set to the top left corner
        float distance = (float)Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        VelX = (int) (((-1.0/distance) * diffX) *2);
        VelY = (int) (((-1.0/distance) * diffY) *2);

        if (y <= 0 || y >= Game.HEIGHT - 32) VelY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) VelX *= -1;

        handler.addObject(new Trail( x , y,ID.Trail, Color.orange , 16 , 16 , 0.02f , handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect((int) x,(int)y,16,16);
    }

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        for (int i = 0; i < handler.getObject().size(); i++){
            if (handler.getObject().get(i).getId() == ID.Player ) player = handler.getObject().get(i);/*basically we're running through the for loop of our array and checking if our certain variable gets the id of player
            then we're kind of setting the gameobject to player-->then we use this player variable*/
        }

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x ,(int) y , 16 , 16);
    }
}
