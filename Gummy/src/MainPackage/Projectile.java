/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import org.newdawn.slick.Image;

/**
 *
 * @author AMD
 */
public class Projectile extends Sprite{
    private float initialx, initialy, vectorx, vectory, destinationx, destinationy;
    private boolean finished;

    public Projectile(Image srcTex, float x, float y) {
        super(srcTex,1000);
        initialx = x;
        initialy = y;
    }
    
    public Projectile(Image srcTex, int targetWidth, int targetHeight, float x, float y) {
        super(srcTex, targetWidth, targetHeight);
        initialx = x;
        initialy = y;
    }

    public void fire(float targetx, float targety){
        move(initialx, initialy);
        destinationx = targetx;
        destinationy = targety;
        double hypotenuse = Math.sqrt((destinationx - initialx)*(destinationx - initialx) + 
                (destinationy - initialy)*(destinationy - initialy));
        
        //check if the distance between where the projectile stated and the target is greater then speed
        if(hypotenuse > getSpeed()){
            vectorx = (float)(getSpeed() * (destinationx - initialx) / hypotenuse);
            vectory = (float)(getSpeed() * (destinationy - initialy) / hypotenuse);
        } else {
            finished = true;
        }
    }
    
    public void update(int timems){
        double hypotenuse = Math.sqrt((vectorx*vectorx)+ (vectory*vectory));
        move((float)(getX() + Game.speedmodifier * getSpeed() * timems * vectorx / hypotenuse),
        (float)(getY() + Game.speedmodifier * getSpeed() * timems * vectory / hypotenuse));
        finished = (getX() < 0)?true:finished;
        finished = (getX() > Game.width)?true:finished;
        finished = (getY() < 0)?true:finished;
        finished = (getY() > Game.height)?true:finished;
    }
    
    public void checkCollision(Entity other){
        if(!finished&&other.isAlive()&&collided(other)){
            other.setHealth(other.getHealth()-1);
            finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }
    
    
}
