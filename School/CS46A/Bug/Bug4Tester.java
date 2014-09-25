public class Bug4Tester
{
    public static void main(String[] args)
    {
        Bug4 superBug = new Bug4(7, 8); // Position (3, 4)
        superBug.move(); // Position (4, 5)

        System.out.println(superBug.getX());
        System.out.println("Expected: 4");      
        System.out.println(superBug.getY());
        System.out.println("Expected: 5");  
        superBug.move(); // Position (5, 6)

        System.out.println(superBug.getX());
        System.out.println("Expected: 5");      
        System.out.println(superBug.getY());
        System.out.println("Expected: 6");  
        superBug.move(); // Position (6, 7)

        System.out.println(superBug.getX());
        System.out.println("Expected: 6");      
        System.out.println(superBug.getY());
        System.out.println("Expected: 7");  
        superBug.turn(); 
        superBug.move(); // Position (7, 6)
        System.out.println(superBug.getX());
        System.out.println("Expected: 7");      
        System.out.println(superBug.getY());
        System.out.println("Expected: 6");                    
        superBug.move(); // Position (6, 5)
        System.out.println(superBug.getX());
        System.out.println("Expected: 6");      
        System.out.println(superBug.getY());
        System.out.println("Expected: 5");                    
    }
}
