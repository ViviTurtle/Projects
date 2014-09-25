/*
 * This class provides a constructs rectangles and tests whether they are contained, intersected, or disjointed from each other
 */
public class Rectangle
{
    private int x;
    private int y;
    private int maxX;
    private int maxY;

    /*
    Constructs a rectangle.
    @param x = the leftmost x-value
    @param y = the topmost y-value
    @param width the width
    @param height the height
     */
    public Rectangle(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.maxX = x + width;
        this.maxY = y + height;
    }

    /*
     * This method tests whether the second rectangle is contained in the first rectangle
     * @param other the other Rectangle
     * @return true or false
     */
    public boolean contains (Rectangle other)
    {
        return ((this.x <= other.x) && (this.x <= other.maxX) && (this.y <= other.y) && (this.y <= other.maxY) && (other.x <= this.maxX) && (other.maxX <= this.maxX) && (other.y <= this.maxY) && (other.maxY <= this.maxY));
    }

    /*
     * This method tests whether the second rectangle is intersecting the first rectangle
     * @param other the other Rectangle
     * @return true or false
     */

    public boolean intersects(Rectangle other)
    {

        return ((!this.contains(other)) && ((((this.x <= other.x) && (other.x <= this.maxX) && (this.y <= other.y) && (other.y <= this.maxY)) || ((this.x <= other.maxX) && (other.maxX <= this.maxX) && (this.y <= other.maxY) && (other.maxY <= this.maxY)) || ((this.x <= other.x) && (other.x <= this.maxX) && (this.y <= other.maxY) && (other.maxY <= this.maxY)) || ((this.x <= other.maxX) && (other.maxX <= this.maxX) && (this.y <= other.y) && (other.y <= this.maxY)))));

    }

    /*
     * This method tests whether the second rectangle is disjointed from the first rectangle
     * @param other the other Rectangle
     * @return true or false
     */    
    public boolean isDisjointFrom(Rectangle other)
    {
        return ((!this.contains(other)) && (!this.intersects(other)) && (!other.contains(this)));
    } 
}