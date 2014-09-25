
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.*;
import org.lgna.story.resources.prop.CakeResource;

public class Scene extends SScene {

    private SRoom room = new SRoom();
    private SCamera camera = new SCamera();
    private Trashcan trashcan = new Trashcan();

    public Scene() {
        super();
    }

    private void performCustomSetup() {
    }

    private void performGeneratedSetUp() {
        this.setAtmosphereColor(new Color(0.5, 0.5, 1.0));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        this.room.setFloorPaint(SRoom.FloorAppearance.REDWOOD);
        this.room.setWallPaint(SRoom.WallAppearance.BUNNIES_PINK);
        this.room.setCeilingPaint(Color.WHITE);
        this.room.setOpacity(1.0);
        this.room.setName("room");
        this.room.setVehicle(this);
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        this.camera.setOrientationRelativeToVehicle(new Orientation(0.0, 0.995185, 0.0980144, 6.12323E-17));
        this.camera.setPositionRelativeToVehicle(new Position(9.61E-16, 1.56, -5.85));
        this.trashcan.setPaint(Color.WHITE);
        this.trashcan.setOpacity(1.0);
        this.trashcan.setName("trashcan");
        this.trashcan.setVehicle(this);
        this.trashcan.setOrientationRelativeToVehicle(new Orientation(0.0, 1.0, 0.0, 1.0));
        this.trashcan.setPositionRelativeToVehicle(new Position(0.0, 0.0, 0.0));
        this.trashcan.setSize(new Size(0.317, 0.867, 0.307));
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

    public void myFirstMethod() {
        trashcan.getLid().roll(RollDirection.LEFT, 0.125);
        trashcan.say("Hello, Richard!", Say.duration(1.0));
        trashcan.move (MoveDirection.LEFT, 1);
        trashcan.getLid().roll(RollDirection.RIGHT, 0.125);
        
     Prop cake = new Prop(CakeResource.BIRTHDAY_CAKE_MATERIALS);
     cake.setVehicle(this);
     cake.setPositionRelativeToVehicle(new Position(2, 0, 2));
     cake.move(MoveDirection.FORWARD, 1);
     cake.resize(10);
    }
}
