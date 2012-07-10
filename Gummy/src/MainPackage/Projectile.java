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
    private float initialx, initialy, vectorx, vectory, destinationx, destinationy,
            speed;
    private boolean finished;

    public Projectile(Image srcTex, float x, float y) {
        super(srcTex);
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
        speed = 10;
        destinationx = targetx;
        destinationy = targety;
        double hypotenuse = Math.sqrt(Math.pow((destinationx - initialx), 2) + 
                Math.pow(destinationy - initialy, 2));
        
        //check if the distance between where the projectile stated and the target is greater then speed
        if(hypotenuse > speed){
            vectorx = (float)(speed * (destinationx - initialx) / hypotenuse);
            vectory = (float)(speed * (destinationy - initialy) / hypotenuse);
        } else {
            finished = true;
        }
    }
    
    public void update(){
        shift(vectorx,vectory);
        if(Math.sqrt(Math.pow((destinationx - getX()), 2) + 
                Math.pow(destinationy - getY(), 2)) < speed){
            finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }
    
    
}
