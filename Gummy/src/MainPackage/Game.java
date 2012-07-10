/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


 /**
 *
 * @author AMD
 */
public class Game extends BasicGame
{
     static int height = 480;
     static int width = 640;
 
     static boolean fullscreen = false;
 
     static boolean showFPS = true;
 
     static String title = "Slick Basic Game Template";
 
     static int fpslimit = 60;
 
     public Game(String title)
     {
          super(title);
     }
 
    @Override
     public void init(GameContainer gc) throws SlickException
     {
 
     }
 
    @Override
     public void update(GameContainer gc, int delta) throws SlickException
     {
 
     }
 
    @Override
     public void render(GameContainer gc, Graphics g) throws SlickException
     {
 
     }
 
     public static void main(String[] args) throws SlickException
     {
          AppGameContainer app = new AppGameContainer(new Game(title));
          app.setDisplayMode(width, height, fullscreen);
          app.setSmoothDeltas(true);
          app.setTargetFrameRate(fpslimit);
          app.setShowFPS(showFPS);
          app.start();
     }
}
