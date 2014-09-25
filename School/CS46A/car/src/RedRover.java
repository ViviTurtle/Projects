
import org.lgna.story.resources.prop.RedRoverResource;
import org.lgna.story.*;

public class RedRover extends Prop {

    public RedRover() {
        super(RedRoverResource.RED_ROVER);
    }

    public SJoint getHead() {
        return this.getJoint(RedRoverResource.HEAD);
    }

    public SJoint getFrontLeftWheel() {
        return this.getJoint(RedRoverResource.FRONT_LEFT_WHEEL);
    }

    public SJoint getBackLeftWheel() {
        return this.getJoint(RedRoverResource.BACK_LEFT_WHEEL);
    }

    public SJoint getFrontRightWheel() {
        return this.getJoint(RedRoverResource.FRONT_RIGHT_WHEEL);
    }

    public SJoint getBackRightWheel() {
        return this.getJoint(RedRoverResource.BACK_RIGHT_WHEEL);
    }
}
