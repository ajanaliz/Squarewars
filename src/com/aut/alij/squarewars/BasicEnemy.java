package com.aut.alij.squarewars;

import java.awt.*;

/**
 * Created by Ali J on 2/21/2015.
 */
public class BasicEnemy extends GameObject{

    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        VelX = 5;
        VelY = 5;

    }


    public void tick() {
        x += VelX;
        y += VelY;

        if (y <= 0 || y >= Game.HEIGHT - 32) VelY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) VelX *= -1;

        handler.addObject(new Trail( x , y,ID.Trail, Color.red , 16 , 16 , 0.02f , handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x,(int) y,16,16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x ,(int) y , 16 , 16);
    }
}
