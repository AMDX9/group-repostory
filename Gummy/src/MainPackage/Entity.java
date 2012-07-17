/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import org.newdawn.slick.Image;

/**
 *  This class deals with the health, status effects and other attributes that
 * are common to both the player and the enemy
 * @author AMD
 */
public class Entity extends Sprite {
    private boolean alive = true;
    private int health;

    public Entity(int health, Image srcTex, int targetWidth, int targetHeight) {
        super(srcTex, targetWidth, targetHeight);
        this.health = health;
    }

    public Entity(int health, Image srcTex) {
        super(srcTex);
        this.health = health;
    }

    public Entity(int health, Image srcTex, int targetWidth, int targetHeight, float spriteSpeed) {
        super(srcTex, targetWidth, targetHeight, spriteSpeed);
        this.health = health;
    }

    public Entity(int health, Image srcTex, float spriteSpeed) {
        super(srcTex, spriteSpeed);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void update(){
        alive = (health <= 0)?false:alive;
    }

    public boolean isAlive() {
        return alive;
    }
    
    
}
