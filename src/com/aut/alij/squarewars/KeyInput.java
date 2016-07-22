package com.aut.alij.squarewars;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Ali J on 2/21/2015.
 */
public class KeyInput implements KeyListener {//this class is going to handle the keyboard inputs

    private Handler handler;
    private boolean[] KeyDown = new boolean[4];


    public KeyInput(Handler handler) {
        this.handler = handler;

        KeyDown[0] = false;//w key
        KeyDown[1] = false;//s key
        KeyDown[2] = false;//d key
        KeyDown[3] = false;//a key
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();//when we press a key on the keyboard its going to release a number value corresponding to the key pressed
/*now we get to the point where we need to differentiate the players in our key input,how do we know if we hit the W key,we only want Player1 to go up,not Player2-->what we need to do is
* we need to loop through all of our objects in the game and say:which one has the ID of Player and that if it has the ID of player,then move the Player Object --> thats why we need the handler here*/
        for (int i = 0; i < handler.getObject().size(); i++) {
            GameObject tempObject = handler.getObject().get(i);
            if (tempObject.getId() == ID.Player) {
                //all of the key events for Player
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                    KeyDown[0] = true;
                }
                if (key == KeyEvent.VK_S){
                    tempObject.setVelY(5);
                    KeyDown[1] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    KeyDown[2] = true;
                }
                if (key == KeyEvent.VK_A){
                    tempObject.setVelX(-5);
                    KeyDown[3] = true;
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getObject().size(); i++) {
            GameObject tempObject = handler.getObject().get(i);
            if (tempObject.getId() == ID.Player) {
                //all of the key events for Player
                if (key == KeyEvent.VK_W) KeyDown[0] = false; //tempObject.setVelY(0);
                else if (key == KeyEvent.VK_S) KeyDown[1] = false; //tempObject.setVelY(0);
                else if (key == KeyEvent.VK_D) KeyDown[2] = false; //tempObject.setVelX(0);
                else if (key == KeyEvent.VK_A) KeyDown[3] = false; //tempObject.setVelX(0);

                //Vertical Movement

                if ( !KeyDown[0] && !KeyDown[1] )
                    tempObject.setVelY(0);
                if ( !KeyDown[2] && !KeyDown[3])
                    tempObject.setVelX(0);
            }
        }
    }
}
