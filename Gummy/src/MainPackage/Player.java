/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import org.newdawn.slick.Image;

/**
 * Describes the player
 * @author AMD
 */
public class Player extends Entity{

    public static final int PLAYER_INITIAL_HEALTH = 100;
    
    public Player(Image srcTex) {
        super(PLAYER_INITIAL_HEALTH, srcTex);
    }

    public Player(Image srcTex, int targetWidth, int targetHeight) {
        super(PLAYER_INITIAL_HEALTH, srcTex, targetWidth, targetHeight);
    }

    
}
