package com.aut.alij.squarewars;

import java.awt.*;

/**
 * Created by Ali J on 2/21/2015.
 */
public class Player extends GameObject{

    private Handler handler;

    private int direction;
    public Rectangle getBounds() {
        return new Rectangle((int) x ,(int) y , 32 , 32);
    }

    public Player(int x, int y, ID id , Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {//where the process's of player happen-->how the player moveson the screen,that the player does not exit the game boarders,that the player has a trail that follows it(for the games sexiness)
        x += VelX;
        y += VelY;
        handler.addObject(new Trail( x , y,ID.Trail, Color.white , 32 , 32 , 0.05f , handler));
        collision();
        x = Game.clamp(x, 0, Game.WIDTH - 38);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
    }

    private void collision(){//the collision between the enemy and the player
        for (int i = 0; i < handler.getObject().size(); i++){
            GameObject tempObject = handler.getObject().get(i);
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.FastEnemyV2 ){//if the object we're checking now is the enemy(tempobject has an enemy ID)
                if (getBounds().intersects(tempObject.getBounds())){//if getbounds wich is a rectangle intersects with temp object(the enemy rectangle)
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }

        }
    }
    public void render(Graphics g) {//where i draw the player object
        if (id == ID.Player) g.setColor(Color.white);
        g.fillRect((int) x , (int) y , 32 , 32);
    }
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
