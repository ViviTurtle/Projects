/**
 * The assignment class keeps one score for one student, as well as the
 * perfect score.  Student scores should default to 0 if they are requested
 * before being set.
 * @author you
 */
public class Assignment
{
     int maxScore;
     int theScore = 0;
     //any fantastic code you want here.

     /**
     * Creates the assignment, setting the perfect mark.
     * @param perfectScore This student's mark
     */
    public Assignment(int perfectScore)
    {
      maxScore = perfectScore;
    }
   
    /**
     * Sets the score for this student.
     * @param score This student's mark
     */
    public void setScore(int score)
    {
       if (score < 0 || score > maxScore) {
          throw new  IllegalArgumentException ("Impossible score.");
       }
       theScore = score;
       
     //any fantastic code you want here.
    } 
    
     /**
     * Gets the score for this student.
     */
    public int getScore()
    {
     return theScore;
    }

     /**
     * Gets the grade for this student, normalized to 0.0-100.0 range.
     */
    public double getGradeAsPercentage()
    {
       return (double)theScore/(double)maxScore;
     //any fantastic code you want here.
    } 
}