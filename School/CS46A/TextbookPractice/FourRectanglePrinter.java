import java.awt.Rectangle;
public class FourRectanglePrinter
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(0,0,50,50);
        System.out.println(box);
        Rectangle box2 = box.translate(50,50);
        System.out.println(box2);
        Rectangle box3 = box.translate(0,50);
        System.out.println(box3);
        Rectangle box4 = box.translate(50,50);
        System.out.println(box4);
    }
}