public class BugTester
{
    public static void main(String[] args)
    {
        Bug bug = new Bug(new RectangularGrid(4, 5)); 
        System.out.println(bug.getPosition());
        System.out.println("Expected: (2, 2)");
        bug.move();
        bug.move();
        System.out.println(bug.getPosition());
        System.out.println("Expected: (4, 2)");// Print the actual and expected position
        bug.move(); // Move the bug 
        System.out.println(bug.getPosition());
        System.out.println("Expected: (3, 2)");// Print the actual and expected position
        bug.turn();// Turn the bug clockwise
        bug.move();// Move the bug 
        System.out.println(bug.getPosition());
        System.out.println("Expected: (3, 1)");// Print the actual and expected position
    }
}
