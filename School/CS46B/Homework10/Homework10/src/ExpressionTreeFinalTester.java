public class ExpressionTreeFinalTester {
   public static void main(String[] args)
   {
      ExpressionTree a = new ExpressionTree(7);
      ExpressionTree b = new ExpressionTree(5);
      ExpressionTree c = new ExpressionTree('*', a, b);

      ExpressionTree d = new ExpressionTree(4);
      ExpressionTree e = new ExpressionTree(18);
      ExpressionTree f = new ExpressionTree('+', d, e);


      System.out.println(a);
      System.out.println("Expected:  7");
      System.out.println(c);
      System.out.println("Expected:  (7 * 5)");
      System.out.println(f);
      System.out.println("Expected:  (4 + 18)");
      
      ExpressionTree i = new ExpressionTree('-', c, f);
      System.out.println(i);
      System.out.println("Expected:  ((7 * 5) - (4 + 18))");
   
      System.out.println(a.eval());
      System.out.println("Expected:  7");
      System.out.println(c.eval());
      System.out.println("Expected:  35");
      System.out.println(f.eval());
      System.out.println("Expected:  22");
      System.out.println(i.eval());
      System.out.println("Expected:  13");
   }

}