import java.awt.Rectangle;


public class Homework1C
{
    public static void main(String[] args)
    {
        Rectangle rect1 = new Rectangle(0, 0, 60, 40);
        double area = rect1.getWidth()*rect1.getHeight();
        Rectangle rect2 = new Rectangle(20, 20, 80, 50);
        Rectangle rect3 = rect1.intersection(rect2);
        System.out.println(rect3.getWidth()*rect3.getHeight());
        
    }
}