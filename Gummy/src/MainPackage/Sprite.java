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
    private float x,y, speed;
    private int width, height;
    
    public Sprite(Image srcTex){
        texture = srcTex;
        width = texture.getWidth();
        height = texture.getHeight();
    }

    public Sprite(Image srcTex, float spriteSpeed) {
        texture = srcTex;
        speed = spriteSpeed/1000;
        width = texture.getWidth();
        height = texture.getHeight();
    }
    
    public Sprite(Image srcTex, int targetWidth, int targetHeight){
        texture = srcTex;
        width = targetWidth;
        height = targetHeight;
    }
    
    public Sprite(Image srcTex, int targetWidth, int targetHeight, float spriteSpeed){
        texture = srcTex;
        width = targetWidth;
        height = targetHeight;
        speed = spriteSpeed / 1000;
    }
    
    public void move(float vectorx, float vectory){
        x = vectorx;
        y = vectory;
    }
    
    //normalized x component [-1,1]
    public void shift(float vectorx, float vectory, int timems){
        double hypotenuse = Math.sqrt((vectorx*vectorx)+ (vectory*vectory));
        x += Game.speedmodifier * speed * timems * vectorx / hypotenuse;
        y += Game.speedmodifier * speed * timems * vectory / hypotenuse;
        x = (x < 0)?0:x;
        x = (x > Game.width - width)?Game.width - width:x;
        y = (y < 0)?0:y;
        y = (y > Game.height - height)?Game.height - height:y;
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
    
    public float getSpeed() {
        return speed;
    }
    
    public float getCenterX(){
        return x+(width/2f);
    }
    
    public float getCenterY(){
        return y+(height/2f);
    }
    
    public float getBoundingDist(float angle){
        return ((width/2f)+(height/2f))/2;
    }
    
    public boolean collided(Sprite other){
        double hypotenuse = Math.sqrt(((other.getCenterX()-getCenterX())*(other.getCenterX()-getCenterX()))
                + ((other.getCenterY()-getCenterY())*(other.getCenterY()-getCenterY())));
        return (hypotenuse-getBoundingDist(0)-other.getBoundingDist(0))<= 0;
    }
    
    public void boundsCheck(){
        
    }
}
