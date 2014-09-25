/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taylor
 */
public class TreeFinalTester 
{
   public static void main(String[] args)
   {
        Tree t1 = new Tree("Tom");
        Tree s11 = new Tree("Jerry");
        Tree s12 = new Tree("Kevin");
        Tree s121 = new Tree("Mary");
        Tree s111 = new Tree("Sally");
        Tree s112 = new Tree("Peggy");
        Tree s113 = new Tree("Sue");
        
        s11.addSubtree(s111);
        s11.addSubtree(s112);
        s11.addSubtree(s113);
        s12.addSubtree(s121);
        

        System.out.println(t1.nodesWithOddNumberChildren());
        System.out.println("Expected: 0");
        t1.addSubtree(s11);
        System.out.println(t1.nodesWithOddNumberChildren());
        System.out.println("Expected: 2");
        t1.addSubtree(s12);
        System.out.println(t1.nodesWithOddNumberChildren());
        System.out.println("Expected: 2");        
   }
 
}