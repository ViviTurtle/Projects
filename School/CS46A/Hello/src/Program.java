
import org.lgna.story.*;

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
