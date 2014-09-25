
import org.lgna.story.resources.prop.TrashcanResource;
import org.lgna.story.*;

public class Trashcan extends Prop {

    public Trashcan() {
        super(TrashcanResource.TRASHCAN_INDOOR_VALUE_CLEAN);
    }

    public SJoint getStep() {
        return this.getJoint(TrashcanResource.STEP);
    }

    public SJoint getLid() {
        return this.getJoint(TrashcanResource.LID);
    }
}
