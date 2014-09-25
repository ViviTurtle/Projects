public class TreeDraftTester {
   public static void main(String[] args)
   {
        Tree t1 = new Tree("Tom");
        Tree s11 = new Tree("Jerry");
        Tree s12 = new Tree("Kevin");
        System.out.println(t1.nodesWithOddNumberChildren());
        System.out.println("Expected: 0");
        t1.addSubtree(s11);
        System.out.println(t1.nodesWithOddNumberChildren());
        System.out.println("Expected: 1");
        t1.addSubtree(s12);
        System.out.println(t1.nodesWithOddNumberChildren());
        System.out.println("Expected: 0");
        
        System.out.println(new Tree().nodesWithOddNumberChildren());
        System.out.println("Expected: 0");
   }
}