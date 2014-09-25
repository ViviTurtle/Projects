
import org.lgna.story.*;
import org.lgna.common.ForEachRunnable;
import org.lgna.common.DoTogether;
import org.lgna.common.ForEachTogether;

public class Program extends SProgram {

    private Scene myScene = new Scene();

    public Program() {
        super();
    }

    public Scene getMyScene() {
        return this.myScene;
    }

    public static void main(final String[] args) {
        final Program story = new Program();
        story.initializeInFrame(args);
        story.setActiveScene(story.getMyScene());
    }
}
