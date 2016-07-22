package com.aut.alij.squarewars;

import java.awt.*;

/**
 * Created by Ali J on 2/20/2015.
 */
//this gameobject is going to be what we refer to as all the game objects
/*say we have our player object and our enemy object,they are both considered a gameobject(I.E this class)--->any and every object in the program basically*/
public abstract class GameObject {
    //what does every object need? an x and a y variable
    protected float x , y;//protected means it can only be accessed by which object inherits the game object
    /*since everything is going to be a game object we need something to identify what a player is and what an enemy is*/
    protected ID id;
    protected float VelX, VelY;//the speed in our X direction and the speed in our Y direction

    public GameObject(float x , float y, ID id){/*we're creating a constructor for our game object which when we create our player object,its going to need a constructor,so when we create an
    instance of our game object we're going to need these 3 components below and whatever we set into the parameters,its going to automatically set the variables above as what we've
    entered in this constructor*/
        this.x = x;
        this.y = y;
        this.id = id;
    }
    //we're going to make components that we're definently going to need within our class that we're going to need to write code in
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();/*basically we're going to be using rectangles to handle all of our collision because within our java libraries,we have a Rectangle class(within the JRE)-->that has a method in it called
    ".intersect" which basically handles if two rectangles intersect each other it will return true*/

    //now we can also do stuff that we don't need inside the player class like our get'er and set'et methods

    public void setX( int x ){
        this.x = x;//this.x here means the x we defined in our instance above at the very top(protected int x)
    //if i had said: x = x;-->it would do nothing more than set the parameter we defined here to what x's new value should become
    }

    public void setY( int y ){
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setId(ID id){
        this.id = id;
    }

    public ID getId(){
        return id;
    }

    public void setVelX(int velX){
        this.VelX = velX;
    }

    public void setVelY(int velY){
        this.VelY = velY;
    }

    public float getVelX(){
        return VelX;
    }

    public float getVelY(){
        return VelY;
    }

    /*what are get'ers and set'er methods???---> basically we can change our X position by calling the setX value and whatever we put into
    * the parameter it takes as an input,its going to then (just like our constructor) take what we gave to it and set the X to THAT value
    * we just implemented*/
}
