package com.aut.alij.squarewars;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Ali J on 2/20/2015.
 */

//this handler class is going to maintain or update and render all of our objects in our room(it has a sort of game-maker functionality
//since we're going to have more than one object in the game we need to handle and process each of those objects,its not something that happens automatically
//so this handler class is going to loop through all of our objects in the game and individually update them and render them to the screen
public class Handler {
    /*here in the handler class we need to make a list of all the objects within our game and because we dont know how many game objects we're going to have we're going
    * to make a linked list of GameObject typed objects*/

    private LinkedList<GameObject> object = new LinkedList<GameObject>();
//in our handler class we're going to need the basic methods so:
    public void tick(){
        for(int i = 0; i < object.size(); i++ ) {//what this for is going to do is basically loop through every1 of our gameobjects
            GameObject tempObject = object.get(i);/*what this does is we're setting the tempObject wich is of type GameObject to object.get(i) which is a function within our linked list
            which allows us to get the ID of what object we are at*/

            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < object.size(); i++ ){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    //now we need to handle how we are going to add and remove objects from our linked list of GameObjects
    public synchronized void addObject(GameObject object){
        this.object.add(object);
    }

    public synchronized void removeObject(GameObject object){
        this.object.remove(object);
    }

    public synchronized LinkedList<GameObject> getObject(){
        return object;
    }
}
