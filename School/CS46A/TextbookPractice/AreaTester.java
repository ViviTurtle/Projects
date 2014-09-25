import java.awt.Rectangle;
public class AreaTester
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(0,0,50,50);
        double area = box.getWidth()*box.getHeight();
        System.out.println(area);
    }
}