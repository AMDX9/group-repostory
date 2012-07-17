/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author AMD
 */
public class Spray implements Ability{
    LinkedList<Projectile>ammo = new LinkedList<Projectile>();
    private float initialx, initialy;
    int count = 0, limit = 1000, interval = 500, currenttime, t;
    double srcangle, increments = Math.PI /6, hypotenuse;
    
    public Spray(float x, float y){
        initialx = x;
        initialy = y;
    }
    
    @Override
    public void fire(float targetx, float targety) {
        srcangle = Math.acos(targety/targetx);
        hypotenuse = Math.sqrt((targetx - initialx)*(targetx - initialx) + 
                (targety - initialy)*(targety - initialy));
        try {
            ammo.add(new Projectile(new Image("assets/bullet.png"), targetx, targety));
        } catch (SlickException ex) {
            Logger.getLogger(Spray.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int timems) {
        currenttime += timems;
        if((currenttime >= interval)&&count < limit){
            t += increments;
            try {
                ammo.add(new Projectile(new Image("assets/bullet.png"), (float)(Math.cos(Math.sin(t)+srcangle)*hypotenuse), 
                        (float)(Math.sin(Math.sin(t)+srcangle)*hypotenuse)));
                count++;
            } catch (SlickException ex) {
                Logger.getLogger(Spray.class.getName()).log(Level.SEVERE, null, ex);
            }
            currenttime = 0;
        }
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
