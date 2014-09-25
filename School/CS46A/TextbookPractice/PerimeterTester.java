import java.awt.Rectangle;
public class PerimeterTester
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(0,0,50,50);
        double perimeter = box.getWidth()+ box.getHeight();
        System.out.println(perimeter*2);
    }
}