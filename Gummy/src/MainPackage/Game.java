/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.util.LinkedList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author AMD
 */
public class Game extends BasicGame {
    static int height = 480;
    static int width = 640;
    private static boolean fullscreen = false;
    private static boolean showFPS = true;
    private static String title = "Slick Basic Game Template";
    private static int fpslimit = 60;
    static Player helicopter;
    static Gummy gummyBoss;
    private static Input input;
    static float speedmodifier = 1;
    
    //temporary
    private LinkedList<Projectile>bullets = new LinkedList<Projectile>();

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        try {
            helicopter = new Player(new Image("assets/player.png"), 250);
            gummyBoss = new Gummy(new Image("assets/gummy.png"));
        } catch (SlickException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        gummyBoss.move(width / 2 - gummyBoss.getWidth() / 2, height / 2);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        input = gc.getInput();
        int x = 0,y = 0;
        if (input.isKeyDown(Input.KEY_W)) {
            y -= 1;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            x -= 1;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            y += 1;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            x += 1;
        }
        if((x != 0)||(y != 0)){
            helicopter.shift(x,y, delta);
        }
        
        if(input.isMouseButtonDown(0)){
            Projectile temp = new Projectile(new Image("assets/bullet.png"),helicopter.getX(),helicopter.getY());
            bullets.add(temp);
            temp.fire(input.getMouseX(), input.getMouseY());
        }
        
        for(Projectile temp:bullets){
            temp.update(delta);
            temp.checkCollision(gummyBoss);
        }
        
        for(int i = 0; i < bullets.size(); ++i){
            if(bullets.get(i).isFinished()){
                bullets.remove(i);
                --i;
            }
        }
        helicopter.update();
        gummyBoss.update();
        
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if(gummyBoss.isAlive())gummyBoss.render();
        for(Projectile temp:bullets){
            temp.render();
        }
        if(helicopter.isAlive())helicopter.render();
        g.drawString("Boss " + gummyBoss.getHealth() + " HP", 200, 10);
        g.drawString("Player " + helicopter.getHealth() + " HP", 400, 10);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game(title));
        app.setDisplayMode(width, height, fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
        app.start();
    }
}
