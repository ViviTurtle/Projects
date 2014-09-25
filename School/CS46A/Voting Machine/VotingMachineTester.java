import java.lang.Math;
/**
   This program tests the voting machine class.
*/
public class VotingMachineTester
{  
   public static void main(String[] args)
   {  
      VotingMachine vm = new VotingMachine();
      
      vm.voteForDemocrat();
      vm.voteForRepublican();
      vm.voteForDemocrat();
      vm.voteForRepublican();
      vm.voteForRepublican();

      System.out.print("Democrats: ");
      System.out.println(vm.getDemocratVotes());
      System.out.println("Expected: 2");
      System.out.print("Republicans: ");
      System.out.println(vm.getRepublicanVotes());
      System.out.println("Expected: 3");

      vm.clear();
      System.out.print("Democrats: ");
      System.out.println(vm.getDemocratVotes());
      System.out.println("Expected: 0");
      System.out.print("Republicans: ");
      System.out.println(vm.getRepublicanVotes());
      System.out.println("Expected: 0");

      vm.voteForDemocrat();
      vm.voteForRepublican();
      vm.voteForDemocrat();
      vm.voteForDemocrat();
      vm.voteForRepublican();

      System.out.print("Democrats: ");
      System.out.println(vm.getDemocratVotes());
      System.out.println("Expected: 3");
      System.out.print("Republicans: ");
      System.out.println(vm.getRepublicanVotes());
      System.out.println("Expected: 2");

   }
}
