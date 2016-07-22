package com.aut.alij.squarewars;

import java.awt.*;

/**
 * Created by Ali J on 2/22/2015.
 */
public class Trail extends GameObject {/*we're going to make this trail every step or every tick in our basic enemy and this trail is not going to move or anything but all its going to do is take its alpha value of one and
slowly subtract that so it looks like its fading out into the distance once it finally fades out then we just destroy it completely since we don't need it anymore*/

    private float alpha = 1;
    private Handler handler;
    private Color color;// we're adding a color variable to our Trail constructor just so we can use trail over and over again cause we're going to add different enemies with different colors that do different things
    private int width, height;//these two will come in handy if we want to make custom sexy enemies
    private float life;
/*we can say like life can be a value between 0.001 and 0.1*/

    public void tick() {
        if (alpha > life ){
            alpha -= (life - 0.0001f);
    }else {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int) x ,(int) y , width, height);
//        g2d.setComposite(makeTransparent(1));//if we dont do this statement its going to make alot of other stuff transparent that we dont want transparent
    }

    private AlphaComposite makeTransparent(float alpha){
     //   int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
    }//this is the method that is going to be able to render out these transparencies in the objects

    public Rectangle getBounds() {
        return null;
    }

    public Trail(float x, float y, ID id , Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }
}
