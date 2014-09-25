/**
 * The assignment class keeps one score for one student, as well as the
 * perfect score.  Student scores should default to 0 if they are requested
 * before being set.
 * @author you
 */
public class Assignment
{
   private int perfect;
   private int score;
     //any fantastic code you want here.

     /**
     * Creates the assignment, setting the perfect mark.
     * @param perfectScore This student's mark
     */
    public Assignment(int perfectScore)
    {
       perfect = perfectScore;
     //any fantastic code you want here.
    }
   
    /**
     * Sets the score for this student.
     * @param score This student's mark
     */
    public void setScore(int score)
    {
       if (score > perfect || score < 0) {
          throw new IllegalArgumentException (" Impossible Score ");
       }
       this.score = score;
     //any fantastic code you want here.
    } 
    
     /**
     * Gets the score for this student.
     */
    public int getScore()
    {
       return score;
     //any fantastic code you want here.
    }

     /**
     * Gets the grade for this student, normalized to 0.0-100.0 range.
     */
    public double getGradeAsPercentage()
    {
       return 100 * (double) score/(double)perfect;
     //any fantastic code you want here.
    } 
}