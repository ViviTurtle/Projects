import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
This class draws a house by allowing the user to specify houses of different sizes.
*/
public class House implements Drawable
{

/**
Constructor to initiate the bottom left corner
@param x the left corner coordinate
@param y the bottom corner coordinate
@param width the width
@param height the height
*/
public House(int x, int y, int width, int height)
{
xleft = x;
ybottom = y;
this.width = width;
this.height = height;
}

/**
Draws the house
@param g2 the graphics context
*/
public void draw(Graphics2D g2)
{
Rectangle front =
new Rectangle(xleft, ybottom - height, width, height);

Rectangle door =
new Rectangle(xleft + width / 5, ybottom - height / 2, width / 5, height / 2);

Rectangle window =
new Rectangle(xleft + width * 3 / 5, ybottom - height / 2, width / 5, height / 5);

Line2D.Double roofLeft =
new Line2D.Double(xleft, ybottom - height, xleft + width / 2, ybottom - height * 5 / 4);

Line2D.Double roofRight =
new Line2D.Double(xleft + width, ybottom - height, xleft + width / 2, ybottom - height * 5 / 4);

g2.draw(front);
g2.draw(door);
g2.draw(window);
g2.draw(roofLeft);
g2.draw(roofRight);
}

private int xleft;
private int ybottom;
private int width;
private int height;
}