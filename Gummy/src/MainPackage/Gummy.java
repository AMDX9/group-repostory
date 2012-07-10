/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import org.newdawn.slick.Image;

/**
 * Describes the Enemy
 * @author AMD
 */
public class Gummy extends Entity{
    
    public static final int GUMMY_INITAL_HEALTH = 5000;

    public Gummy(Image srcTex) {
        super(GUMMY_INITAL_HEALTH, srcTex);
    }

    public Gummy(Image srcTex, int targetWidth, int targetHeight) {
        super(GUMMY_INITAL_HEALTH, srcTex, targetWidth, targetHeight);
    }

    
}
