/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import org.newdawn.slick.Image;

/**
 * General class for a moving object in the game world
 * @author AMD
 */
public class Sprite {
    private Image texture;
    private float x,y;
    private int width, height;
    
    public Sprite(Image srcTex){
        texture = srcTex;
        width = texture.getWidth();
        height = texture.getHeight();
    }
    
    public Sprite(Image srcTex, int targetWidth, int targetHeight){
        texture = srcTex;
        width = targetWidth;
        height = targetHeight;
    }
    
    public void move(float vectorx, float vectory){
        x = vectorx;
        y = vectory;
    }
    
    public void shift(float vectorx, float vectory){
        x += vectorx;
        y += vectory;
    }
    
    public void rotate(float angleDeg){
        texture.setRotation(angleDeg);
    }
    
    
    public void changePivot(float pivotx, float pivoty){
        texture.setCenterOfRotation(pivotx, pivoty);
    }
    
    public void render(){
        texture.draw(x, y, width, height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
