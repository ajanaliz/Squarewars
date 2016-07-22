package com.aut.alij.squarewars;

import java.awt.*;

/**
 * Created by Ali J on 2/22/2015.
 */
public class FastEnemy extends GameObject{

    private Handler handler;
    public void tick() {
        x += VelX;
        y += VelY;

        if (y <= 0 || y >= Game.HEIGHT - 32) VelY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) VelX *= -1;

        handler.addObject(new Trail( x , y,ID.Trail, Color.cyan , 16 , 16 , 0.02f , handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int) x,(int) y,16,16);
    }

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        VelX = 2;
        VelY = 9;

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x ,(int) y , 16 , 16);
    }
}
