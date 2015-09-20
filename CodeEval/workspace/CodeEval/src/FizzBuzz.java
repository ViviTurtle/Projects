public class Main {

	public static void main(String[] args) {
		int div1=0;
		int div2=0;
		int max=0;
		try
		{
		div1 = Integer.parseInt(args[0]);
		div2 = Integer.parseInt(args[1]);
		max = Integer.parseInt(args[2]);
		}
		catch (NumberFormatException e) 
		{
			System.err.println("Argument" + " must be an integer");
	        System.exit(1);
		}
		String answer = "";
		for (int i = 1; i <= max; i++) {
			if (i % div1 == 0) {
				if (i % div2 == 0) {
					answer = answer + " FB";
				} else
					answer = answer + " F";
			} else if (i % div2 == 0) {
				answer = answer + " B";
			} else
				answer = answer + " " + Integer.toString(i);
		}
		System.out.print(answer.substring(1, answer.length()));
	}
}
