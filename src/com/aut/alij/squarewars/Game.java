package com.aut.alij.squarewars;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by Ali J on 2/20/2015.
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1366 , HEIGHT = WIDTH / 16 * 9;//a 16:9 ratio :))

    private Random r;
    private Thread thread;//the entire game is going to run within this thread(its going to be a single threaded game)
    private boolean running = false;

    private Handler handler;//an instance of our Handler class
    private HUD hud;
    private Spawn spawner;
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        hud = new HUD();
        spawner = new Spawn(handler , hud);

        new window(WIDTH,HEIGHT, "WAVE" ,this);

        r = new Random();
        handler.addObject(new Player(WIDTH/2-32 , HEIGHT/2-32, ID.Player , handler));
        handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH) , r.nextInt(Game.HEIGHT) , ID.BasicEnemy , handler));
    }

    public synchronized void start(){
        thread = new Thread(this);/*this is referring to this instance of our game class(this is where the thread is going to be ran)*/
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();//this statement basically kills off the thread
            running = false;
        }catch(Exception e){
            e.printStackTrace();//this is basically just going to tell us why it couldnt run the game
        }//try and catch statements are like if statements,its saying:if its gonna happen make it happen if not screw it
    }
    public void run(){//we're going to set up the game loop here ---> the heartbeat of the game
        this.requestFocus();
        long lasTtime = System.nanoTime();
        double amountofTicks = 60.0;
        double ns = 1000000000 / amountofTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){

            long now = System.nanoTime();
            delta += (now - lasTtime) / ns;
            lasTtime = now;

            while (delta >= 1){
                tick();
                delta--;
            }

            if (running) {
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
        HUD.tick();
        spawner.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();


        g.setColor(Color.DARK_GRAY.darker());
        g.fillRect(0, 0, WIDTH,HEIGHT);


        handler.render(g);
        HUD.render(g);
        g.dispose();//here we dispose of the graphics
        bs.show();
    }

    public static float clamp( float var, float min, float max ){/*this method is mainly for our player class and for our player to not go out of the window we've created,lets say for the var parameter i enter x and for the min and max
    i would enter (in order) 0 and WIDTH,then whenever x would become equal or greater than WIDTH then this method would return the value of WIDTH so that our objects X parameter would never go out of the windows boundaries*/
        if (var >= max )
            return var = max;
        else if (var <= min )
            return var = min;
        else
            return var;
     }

    public static void main(String[] args) {
        new Game();
    }
}
