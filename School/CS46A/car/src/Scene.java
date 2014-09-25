
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.*;

public class Scene extends SScene {

    private SGround ground = new SGround();
    private SCamera camera = new SCamera();
    private RedRover redRover = new RedRover();

    public Scene() {
        super();
    }

    private void performCustomSetup() {
    }

    private void performGeneratedSetUp() {
        this.setAtmosphereColor(new Color(0.588, 0.886, 0.988));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        this.ground.setPaint(SGround.SurfaceAppearance.MOON);
        this.ground.setOpacity(1.0);
        this.ground.setName("ground");
        this.ground.setVehicle(this);
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        this.camera.setOrientationRelativeToVehicle(new Orientation(0.0, 0.995418, 0.0956146, 6.12323E-17));
        this.camera.setPositionRelativeToVehicle(new Position(9.61E-16, 1.9, -7.55));
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

    public void myFirstMethod()
    {
    Car myRover = new Car(50);
    myRover.setVehicle(this); // Needed to make the car appear in the scene
    }
}
