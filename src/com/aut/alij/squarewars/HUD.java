package com.aut.alij.squarewars;

import java.awt.*;

/**
 * Created by Ali J on 2/21/2015.
 */
public class HUD/*heads up display----->the health bar*/ {


    public static float HEALTH = 100;/*its not usual to use static methods or variables in your program but since we are not going to have any other health variable in our game whatsoever and this just makes an ease of access
    to that so instead of having to initialize the variable of HUD or initialize that instance of the class we can now just use HUD.HEALTH,we dont need to initialize it nor do we need to say HUD = new HUD-->which is very handy*/

    private static float greenValue = 255f;

    private static int score = 0;
    private static int level = 1;

    public static void tick(){//where the process is done
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);

        greenValue = HEALTH*2;
        score++;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getlevel(){
        return level;
    }

    public static void render(Graphics g){//where we draw the graphics for our object
        g.setColor(Color.gray);
        g.fillRect(15 , 15, 200 , 32);
        g.setColor(new Color(75 ,(int) greenValue  , 0));
        g.fillRect(15 , 15, (int)HEALTH * 2 , 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score , 15, 64);
        g.drawString("Level: " + level , 15 , 80);
    }

}
