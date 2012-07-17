/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author AMD
 */
public interface Ability {
    public void fire(float targetx, float targety);
    public void update(int timems);
    public void render();
}
