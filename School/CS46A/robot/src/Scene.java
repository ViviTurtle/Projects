
import java.util.ArrayList;
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.*;

public class Scene extends SScene {

    private SGround ground = new SGround();
    private SCamera camera = new SCamera();
    private Robot carol;
    private ArrayList<Window> wallsAndWindows = new ArrayList<Window>();

    private void performGeneratedSetUp() 
    {
        this.setAtmosphereColor(new Color(0.588, 0.886, 0.988));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        this.ground.setPaint(SGround.SurfaceAppearance.GRASS);
        this.ground.setOpacity(1.0);
        this.ground.setName("ground");
        this.ground.setVehicle(this);
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        double yCameraAngle = Math.toRadians(30.0);
        double xCameraAngle = Math.toRadians(-10.0);
        double sx = Math.sin(xCameraAngle / 2);
        double cx = Math.cos(xCameraAngle / 2);
        double sy = Math.sin(yCameraAngle / 2);
        double cy = Math.cos(yCameraAngle / 2);
        
        this.camera.setOrientationRelativeToVehicle(new Orientation(sx*cy, cx*sy, sx*sy, cx*cy));
        this.camera.setPositionRelativeToVehicle(new Position(10, 4, 15));
    }

    private void initializeEventListeners() {
        this.addSceneActivationListener(new SceneActivationListener() {
            public void sceneActivated(final SceneActivationEvent e) {
                Scene.this.myFirstMethod();
            }
        });
    }

    protected void handleActiveChanged(final Boolean isActive, final Integer activationCount) {
        if (isActive) {
            if (activationCount == 1) {
                this.performGeneratedSetUp();
                this.performCustomSetup();
                this.initializeEventListeners();
            } else {
                this.restoreStateAndEventListeners();
            }
        } else {
            this.preserveStateAndEventListeners();
        }
    }

    public SCamera getCamera() 
    {
        return camera;
    }    

    public ArrayList<Window> getWallsAndWindows() 
    {
        return wallsAndWindows;
    }
    
    /**
     * A helper method for adding a wall to the scene.
     * @param x the x-location of the wall
     * @param y the y-location of the wall
     * @param direction the direction of the wall
     */
    private void addWall(int x, int y, int direction)
    {
        Wall w = new Wall(x, y, direction);
        w.setVehicle(this);
        wallsAndWindows.add(w);
    }

        /**
     * A helper method for adding a window to the scene.
     * @param x the x-location of the window
     * @param y the y-location of the window
     * @param direction the direction of the window
     */
    private void addWindow(int x, int y, int direction)
    {
        Window w = new Window(x, y, direction);
        w.setVehicle(this);
        wallsAndWindows.add(w);
    }

    /**
     * A helper method for adding a wall to the room. The method adds a wall
     * except at the window location.
     * @param x the x-location of the wall
     * @param y the y-location of the wall
     * @param windowX the x-location of the window
     * @param windowY the y-location of the window
     * @param direction the direction of the wall
     */
    private void addWallExceptAt(int x, int y, int windowX, int windowY, int direction)
    {
       if (x != windowX || y != windowY) addWall(x, y, direction);
    }
    

    // This method sets up a maze. Don't look inside.
    private void makeMaze()
    {
        for (int i = 0; i < 10; i++)
        {
            addWall(i, 0, Wall.X_DIRECTION);
            if (i != 5)
                addWall(i, 10, Wall.X_DIRECTION);
            if (i < 7)
                addWall(i, 5, Wall.X_DIRECTION);
        }
        for (int i = 0; i < 10; i++)
        {
            addWall(0, i, Wall.Y_DIRECTION);
            addWall(10, i, Wall.Y_DIRECTION);
            if (i > 2 && i < 9)
                addWall(7, i, Wall.Y_DIRECTION);
        }
        addWindow(5, 10, Wall.X_DIRECTION);
    }

    /**
     * This method sets up the room. Don't look inside.
     * @param width the width of the room
     * @param depth the depth of the room
     * @param windowX the x-location of the window
     * @param windowY the y-location of the window
     */
    private void makeRoom(int width, int depth, int windowX, int windowY)
    {
        for (int i = 0; i < width; i++)
        {
            addWallExceptAt(i, 0, windowX, windowY, Wall.X_DIRECTION);
            addWallExceptAt(i, depth, windowX, windowY, Wall.X_DIRECTION);
        }
        for (int i = 0; i < depth; i++)
        {
            addWallExceptAt(0, i, windowX, windowY, Wall.Y_DIRECTION);
            addWallExceptAt(width, i, windowX, windowY, Wall.Y_DIRECTION);
        }
        int dir;
        if (windowX == 0 || windowX == depth) dir = Wall.Y_DIRECTION;
        else dir = Wall.X_DIRECTION;
        addWindow(windowX, windowY, dir);
    }

    private void performCustomSetup() 
    {
        makeRoom(8, 6, 3, 6);        
        // makeMaze();
        carol = new Robot(2, 2);
        carol.setVehicle(this);        
        carol.turnLeft();
    }

    public void goToWall()
    {
      while (!carol.frontHasWallorWindow())
         carol.moveForward();
    }

    public void findWindow()
    {
      while (carol.rightHasWall())
      {
         if (carol.frontHasWallorWindow())
         {
            carol.turnLeft();
         }
         carol.moveForward();
      }
    }
    
    public void myFirstMethod() 
    {
       goToWall();
       carol.turnLeft();
       findWindow();        
    }   
}
