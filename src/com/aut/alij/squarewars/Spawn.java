package com.aut.alij.squarewars;

import java.util.Random;

/**
 * Created by Ali J on 2/22/2015.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;

        if (scoreKeep >= 500){
            scoreKeep = 0;
            hud.setLevel(hud.getlevel() + 1);

            if (hud.getlevel() == 2 ){
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.BasicEnemy , handler));
                handler.addObject(new FastEnemyV2( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.FastEnemyV2 , handler));
            } else if (hud.getlevel() == 3 ){
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.BasicEnemy , handler));
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.BasicEnemy , handler));
            } else if (hud.getlevel() == 4 ){
                handler.addObject(new FastEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.FastEnemy , handler));
            } else if (hud.getlevel() == 5 ){
                handler.addObject(new SmartEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.SmartEnemy , handler));
            } else if (hud.getlevel() == 6 ){
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.BasicEnemy , handler));
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.BasicEnemy , handler));
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.BasicEnemy , handler));
            } else if (hud.getlevel() == 7 ){
                handler.addObject(new FastEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.FastEnemy , handler));
                handler.addObject(new FastEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.FastEnemy , handler));
            } else if (hud.getlevel() == 8 ){
                handler.addObject(new SmartEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.SmartEnemy , handler));
                handler.addObject(new SmartEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.SmartEnemy , handler));
            } else if (hud.getlevel() == 9 ){
                handler.addObject(new FastEnemyV2( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.FastEnemyV2 , handler));
                handler.addObject(new FastEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.FastEnemy , handler));
                handler.addObject(new FastEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.FastEnemy , handler));
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.BasicEnemy , handler));
            } else if (hud.getlevel() == 10 ){
                handler.addObject(new SmartEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.SmartEnemy , handler));
                handler.addObject(new SmartEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.SmartEnemy , handler));
                handler.addObject(new SmartEnemy( r.nextInt(Game.WIDTH - 50) , r.nextInt(Game.HEIGHT - 50) , ID.SmartEnemy , handler));
            }

        }
    }
}
