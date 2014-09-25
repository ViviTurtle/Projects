// This machine counts the number of votes for the Democratic and Republican Party
public class VotingMachine
{
private double democraticVote;
private double republicanVote;
    public void voteForDemocrat() 
    //this votes for the Democrats
    {
        democraticVote = democraticVote + 1;
    }
    
    public void voteForRepublican()
    //this adds a vote for the Republicans
    {
        republicanVote = republicanVote + 1;
    }
   
    public double getDemocratVotes() 
    //this adds up the votes for the Democrats
    {
        return democraticVote;
    }
    
    public void clear()
    //this resets the votes to 0
    {
        republicanVote = republicanVote*0;
        democraticVote = democraticVote*0;
    }
    
    public double getRepublicanVotes() 
    //this adds up the votes for the Republicans
    {
        return republicanVote;
    }
    

}