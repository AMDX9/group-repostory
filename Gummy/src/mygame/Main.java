package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    protected float step = 0.1f;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Box gummy = new Box(Vector3f.ZERO, 1, 1, 1), helicopter = new Box(Vector3f.ZERO, 1, 1, 1);
        final Geometry gummyGeom = new Geometry("Box", gummy), heliGeom =  new Geometry("Box", helicopter);
        Material gummyMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md"),
                 heliMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        ActionListener actionListener = new ActionListener() {
            public void onAction(String name, boolean keyPressed, float tpf) {
                if (name.equals("Up") && !keyPressed) {
                    Vector3f v = heliGeom.getLocalTranslation();
                    heliGeom.setLocalTranslation(v.x, v.y + step*speed, v.z);
                }
                if (name.equals("Down") && !keyPressed) {
                    Vector3f v = heliGeom.getLocalTranslation();
                    heliGeom.setLocalTranslation(v.x, v.y - step*speed, v.z);
                }
                if (name.equals("Left") && !keyPressed) {
                    Vector3f v = heliGeom.getLocalTranslation();
                    heliGeom.setLocalTranslation(v.x + step*speed, v.y, v.z);
                }
                if (name.equals("Right") && !keyPressed) {
                    Vector3f v = heliGeom.getLocalTranslation();
                    heliGeom.setLocalTranslation(v.x - step*speed, v.y, v.z);
                }
            }
        };
        
        inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_DOWN));
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_LEFT));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_RIGHT));
        inputManager.addListener(actionListener, new String[]{"Up","Down","Left","Right"});
        
        gummyMat.setColor("Color", ColorRGBA.Blue);
        heliMat.setColor("Color", ColorRGBA.Red);
        heliGeom.setMaterial(gummyMat);
        gummyGeom.setMaterial(heliMat);
        rootNode.attachChild(gummyGeom);
        rootNode.attachChild(heliGeom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
