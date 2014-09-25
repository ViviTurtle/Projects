public class Bug2Tester
{
    public static void main(String[] args)
    {
Bug2 bugsy = new Bug2();
bugsy.turn(300);
bugsy.turn(50);
int turns = bugsy.getTurns(); // sets turns to 350
System.out.println(turns);
bugsy.turn(40);
turns = bugsy.getTurns(); // sets turns to 30
System.out.println(turns);
}
}