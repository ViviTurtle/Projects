public class Mail
{
    private String prob;
    private String greet;
    private String remin;
    /*
     * Constructs the Mail class when given three different strings
     * @param problem the reason why the person ie being notified
     * @param reminder why the letter is important
     * @param greeting the signature of the writer
     */
    public Mail(String problem, String reminder, String greeting)
    {
        prob = problem;
        remin = reminder;
        greet = greeting;
    }
    /*
     * Creates the actual message of the mail
     * @param name the name of the person being notified
     * @param assignment the name of the assignment of importance
     */
    public String createMessage(String name, String assignment)
    {
       String salutation = "Dear " + name + ":" + "\n" +"\n";
       String body = prob +  assignment;
       String text1 = salutation + body;
       String text2 = text1 + remin;
       String message = text2 + "\n" + "\n" + "Sincerely,"+"\n" + "\n" + greet;
       return message;
    }
}