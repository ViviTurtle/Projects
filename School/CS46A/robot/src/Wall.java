import org.lgna.story.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cay
 */
public class Wall extends Window 
{
    /**
     * Construct a wall that is north or west of a robot at a given location
     * @param x the x location of a robot adjacent to this wall
     * @param y the y location of a robot adjacent to this wall
     * @param direction X_DIRECTION or Y_DIRECTION
     */
    public Wall(int x, int y, int orientation) 
    {
        super(x, y, orientation);
        setSize(new Size(0.9, 0.8, 0));
        setOpacity(0.6);                
    }    
}
