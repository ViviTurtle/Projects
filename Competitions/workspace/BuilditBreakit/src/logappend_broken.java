import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class logappend_broken {
	private static long timestamp; // number
	private static String token; // any
	private static String employeeName; // letters
	private static String guestName; // letters
	private static boolean leaving;
	private static long roomid; // number
	private static String logFileName; // any
	private static boolean isBatch;
	private static String batchFileName; // any
	private static boolean arriving;
	private static boolean isBroken;
	private static final long defaultRoom = -9856762;
	private static Long startTime;
	private static Long LatestTime;

	public static void main(String args[]) throws FileNotFoundException,
			UnsupportedEncodingException {

		// String decryptedLogFile = parseLogFile();
		parseCommands(args);
		checkCommands();
		print();
		if (isBatch) {
			String[] args2;
			Scanner scan = new Scanner(new File(batchFileName));
			while (scan.hasNextLine()) {
				System.out.println("----New Line from Batch----");
				args2 = getArguments(scan.nextLine());
				parseCommands(args2);
				checkCommands();
				print();
				encrypt(append());

			}
			scan.close();
		} else {
			encrypt(append());
		}
	}

	private static String[] getArguments(String line) {
		int count = 0;
		String[] args2;
		Scanner scan2 = new Scanner(line);
		while (scan2.hasNext()) {
			count++;
			scan2.next();
		}
		scan2.close();
		args2 = new String[count];
		count = 0;
		Scanner scan3 = new Scanner(line);
		while (scan3.hasNext()) {
			args2[count] = scan3.next();
			count++;
		}
		scan3.close();
		return args2;
	}

	private static void encrypt(String log) throws FileNotFoundException,
			UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(logFileName, "UTF-8");

		String s = null;
		String test = "";
		try {

			// Run decypt ruby
			// using the Runtime exec method:
			Process p = Runtime.getRuntime().exec(
					"ruby Encrypt.rb " + token + " " + logFileName + " '" + log
							+ "'");

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			// BufferedReader stdError = new BufferedReader(new
			// InputStreamReader(
			// p.getErrorStream()));

			// read the output from the command
			while ((s = stdInput.readLine()) != null) {
				test += s;
			}

			// read any errors from the attempted command
			// System.out.println("Here is the standard error of the command (if any):\n");
			// while ((s = stdError.readLine()) != null) {
			// System.out.println(s);

			// }
			//
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
		if (test.equals("Fail:Authentication")) {
			System.out.println("Error: Invalid Token");
			System.exit(1);
		} else
			// test case
			writer.println(log);
		writer.close();
		// test
		System.out.println("Success!");
	}

	private static ArrayList<String> delimite(String log) {
		ArrayList<String> log_array = new ArrayList<String>();
		Scanner scan = new Scanner(log);
		while (scan.hasNextLine()) {
			log_array.add(scan.nextLine());
		}
		scan.close();
		return log_array;

	}

	private static ArrayList<String> String2Array(String line) {
		ArrayList<String> answer = new ArrayList<String>();
		Scanner read = new Scanner(line);
		while (read.hasNext()) {
			answer.add(read.next());
		}
		read.close();
		return answer;

	}

	private static String arrive(ArrayList<String> log_array) {
		boolean inserted = false;
		boolean inGallery = false;
		int indexGallery = -1;
		String answer = "";
		ArrayList<String> gallery = new ArrayList<String>();
		if (log_array.size() == 0) {
			log_array.add(Long.toString(defaultRoom));
			startTime = timestamp;
			LatestTime = timestamp;
		}
		if (log_array.get(0).contains(guestName)) {
			inGallery = true;
			gallery = String2Array(log_array.get(0));
			indexGallery = gallery.indexOf(guestName);
		}

		if (roomid != defaultRoom && inGallery) {
			for (int i = 1; i < log_array.size(); i++) {
				Scanner read2 = new Scanner(log_array.get(i));
				Long room = Long.parseLong(read2.next());
				read2.close();
				// Adds a new line with new room
				if (roomid == room && inserted == false) {
					if (!log_array.get(i).contains(guestName)) {
						answer += System.lineSeparator() + log_array.get(i)
								+ " " + guestName;
						inserted = true;
					} else {
						System.out
								.println("That person is already in that room");
						System.exit(1);
					}
				}
				if (roomid < room && inserted == false) {
					answer += System.lineSeparator() + roomid + " " + guestName;
					inserted = true;
				}
				if (roomid != room) {
					answer += System.lineSeparator() + log_array.get(i);
				}

			}
			// Need to add to the end
			if (inserted == false) {
				inserted = true;
				answer += System.lineSeparator() + roomid + " " + guestName;
			}
			String newGallery = gallery.get(0);
			for (int i = 1; i < gallery.size(); i++) {
				if (i != indexGallery) {
					newGallery += " " + gallery.get(i);
				}
			}
			answer = newGallery + answer;
		}
		if (roomid == defaultRoom && inGallery) {
			System.out.println("That person is already in that room");
			System.exit(1);
		} else if (roomid != defaultRoom && !inGallery) {
			System.out
					.println("That person needs to be in the gallery before entering a room");
			System.exit(1);
		} else if (roomid == defaultRoom && !inGallery) {
			answer = log_array.get(0) + " " + guestName;
			for (int i = 1; i < log_array.size(); i++) {
				answer += System.lineSeparator() + log_array.get(i);
			}
		}
		return answer;

	}

	private static String leave(ArrayList<String> log_array) {
		String answer = "";
		if (log_array.size() == 0) {
			System.out.println("No people are in the gallery to leave");
			System.exit(1);
		}
		String search = binarySearch(log_array);
		if (!search.isEmpty()) {
			if (log_array.get(0).contains(guestName)
					&& log_array.get(0).contains(Long.toString(defaultRoom))) {
				answer += System.lineSeparator() + search;
			} else {
				answer += log_array.get(0) + " " + guestName;
			}
			for (int i = 1; i < log_array.size(); i++) {
				if (log_array.get(i).contains(Long.toString(roomid))) {
					answer += System.lineSeparator() + search;
				} else {
					answer += System.lineSeparator() + log_array.get(i);
				}
			}
			return answer;
		}
		System.out.println("No person with that name and person type");
		System.exit(1);
		return "";

	}

	private static String binarySearch(List<String> list) {
		if (list.size() == 0) {
			System.out.println("No person with that name in this room");
			System.exit(1);
		}
		int middle = list.size() / 2;
		String temp = "";
		long nextlong;
		String temp2 = "";
		Scanner scan = new Scanner(list.get(middle));
		nextlong = scan.nextLong();
		if (nextlong < roomid) {
			scan.close();
			return binarySearch(list.subList(middle, list.size()));
		} else if (nextlong > roomid) {
			scan.close();
			return binarySearch(list.subList(0, middle));
		} else {
			temp += Long.toString(nextlong);
			while (scan.hasNext()) {
				temp2 = scan.next();
				if (!temp2.equals(guestName)) {
					temp += " " + temp2;
				}
			}
		}
		scan.close();
		return temp;
	}

	private static String append() throws FileNotFoundException {
		String answer = "";
		Long low = (long) -1;
		Long high = (long) -1;
		ArrayList<String> log_array = new ArrayList<String>();
		String logfile_plain = "";
		logfile_plain = parseLogFile();
		// test code
		Scanner test = new Scanner(new File(logFileName));
		while (test.hasNextLine()) {
			logfile_plain += test.nextLine() + System.lineSeparator();
		}
		String[] temp = logfile_plain.split("[?]");
		test.close();

		//
		log_array = delimite(temp[0]);
		if (arriving) {
			answer = arrive(log_array);
		} else {
			answer = leave(log_array);
		}
		if (temp.length > 1) {
			Scanner scan2 = new Scanner(temp[1]);
			low = scan2.nextLong();
			high = scan2.nextLong();
			scan2.close();
		}
		if (timestamp < high) {
			System.out.println("Timestamp has too low of a time");
			System.exit(-1);
		}
		answer += "? " + startTime + " " + timestamp;

		return answer;

	}

	private static void print() {
		if (isBatch) {
			System.out.println("Batch? : True");
			System.out.println("Batch File Name: " + batchFileName);
		} else {
			System.out.println("Timestamp: " + timestamp); // number
			System.out.println("Token: " + token);
			System.out.println("Employee Name: " + employeeName);// letters
			System.out.println("Guest Name: " + guestName);
			if (leaving) {
				System.out.println("Leaving: True");
			}
			if (arriving) {
				System.out.println("Arriving: True");
			}
			if (roomid != -9856762) {
				System.out.println("Room ID: " + roomid); // number
			}
			System.out.println("Log File Name: " + logFileName); // any

		}
		if (isBroken) {

			System.out.println("isBroken: " + isBroken);
		}

	}

	private static void makeDefaults() {
		timestamp = -1;
		token = "";
		employeeName = "";
		guestName = "";
		leaving = false;
		roomid = defaultRoom;
		logFileName = "";
		isBatch = false;
		batchFileName = "";
		arriving = false;
		isBroken = false;
	}

	private static String parseLogFile() {
		String decyptedLogFile = "";

		String s = null;

		try {

			// Run decrypt ruby
			// using the Runtime exec method:
			Process p = Runtime.getRuntime().exec(
					"ruby Decrypt.rb " + token + " " + logFileName);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			// BufferedReader stdError = new BufferedReader(new
			// InputStreamReader(
			// p.getErrorStream()));

			// read the output from the command
			while ((s = stdInput.readLine()) != null) {
				decyptedLogFile += s;
			}

			// read any errors from the attempted command
			// System.out.println("Here is the standard error of the command (if any):\n");
			// while ((s = stdError.readLine()) != null) {
			// System.out.println(s);
			// }
			//
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
		if (decyptedLogFile.equals("Fail:Authentication")) {
			System.out.println("Error: Invalid Token");
			System.exit(1);
		} else if (decyptedLogFile.isEmpty()) {
			return "";
		}
		return decyptedLogFile;
	}

	private static void checkCommands() {

		if (isBatch == false) {
			if (timestamp < 0) {

				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out.println("Invalid Timestamp");
				System.exit(1);
			}
			if (token.equals("")) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out.println("Please Enter a token");
				System.exit(1);
			}
			if (guestName.equals("") && (employeeName.equals("")))

			{
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out
						.println("Please Enter a Guest name or Employee name");
				System.exit(1);
			}
			if ((!guestName.equals("")) && (!(employeeName.equals("")))) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out
						.println("Please enter only one Guest name or Employee name");
				System.exit(1);
			}
			if (leaving == true && arriving == true) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out
						.println("Please only enter -L (Leaving) or a -A (Arriving)");
				System.exit(1);
			}
			if (leaving == false && arriving == false) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out
						.println("Please enter -L (Leaving) or a -A (Arriving)");
				System.exit(1);
			}
			if (roomid < 0 && (roomid != -9856762)) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out.println("Please enter a positive Room ID");
				System.exit(1);

			}
			if (logFileName.isEmpty()) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out.println("Please Specify a Log File");
				System.exit(1);
			}
			if ((!testWhitelist(employeeName)) || (!testWhitelist(guestName))) {
				System.out.println("Please Enter a real Name");
				System.exit(1);
			}
			if (guestName.isEmpty()) {
				guestName = "E:" + employeeName;
			} else {
				guestName = "G:" + guestName;
			}
		}

	}

	private static void parseCommands(String[] args) {
		makeDefaults();
		for (int i = 0; i < args.length; i = i + 2) {
			switch (args[i].toUpperCase()) {
			case "-B":
				if (args.length > 2 || isBatch == true) {
					isBroken = true;
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out
							.println("Please do not add additional commands to a Batch command");
					System.exit(1);
				} else {
					isBatch = true;
					batchFileName = args[i + 1];
				}
				break;
			case "-T":
				if (timestamp != -1) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out.println("Please enter only one Timestamp");
					System.exit(1);
				}

				else {
					if (i + 1 > args.length - 1) {
						System.out.println("Incorrect input");
						System.out
								.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
						System.out.println("logappend -B <Batch File>");
						System.out.println("No buffer overflows please");
						System.exit(-1);
					}
					timestamp = Long.parseLong(args[i + 1]);
				}

				break;
			case "-K":
				if (!token.isEmpty()) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out.println("Please enter only one Token");
					System.exit(1);
				}

				else {
					if (i + 1 > args.length - 1) {
						System.out.println("Incorrect input");
						System.out
								.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
						System.out.println("logappend -B <Batch File>");
						System.out.println("No buffer overflows please");
						System.exit(-1);
					}
					token = args[i + 1];
				}
				break;
			case "-E":
				if (!employeeName.isEmpty()) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out.println("Please enter only one Employee");
					System.exit(1);
				}

				else {
					if (i + 1 > args.length - 1) {
						System.out.println("Incorrect input");
						System.out
								.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
						System.out.println("logappend -B <Batch File>");
						System.out.println("No buffer overflows please");
						System.exit(-1);
					}
					employeeName = args[i + 1];
				}
				break;
			case "-G":
				if (!guestName.isEmpty()) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out.println("Please enter only one Guest");
					System.exit(1);
				}

				else {
					if (i + 1 > args.length - 1) {
						System.out.println("Incorrect input");
						System.out
								.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
						System.out.println("logappend -B <Batch File>");
						System.out.println("No buffer overflows please");
						System.exit(-1);
					}
					guestName = args[i + 1];
				}
				break;
			case "-L":
				if (leaving == true) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out
							.println("Please enter only Leave or Arrival Once");
					System.exit(1);
				}

				else {
					leaving = true;
					i--;
				}
				break;
			case "-A":
				if (arriving == true) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out
							.println("Please enter only Leave or Arrival Once");

					System.exit(1);
				}

				else {
					arriving = true;
					i--;
				}
				break;
			case "-R":
				if (roomid != -9856762) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out.println("Please enter only one roomid");
					System.exit(1);
				}

				else {
					if (i + 1 > args.length - 1) {
						System.out.println("Incorrect input");
						System.out
								.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
						System.out.println("logappend -B <Batch File>");
						System.out.println("No buffer overflows please");
						System.exit(-1);
					}
					roomid = Long.parseLong(args[i + 1]);
				}
				break;
			default:
				if (logFileName.isEmpty()) {
					logFileName = args[i];
					i--;
				} else {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out.println("Please enter only 1 log file");
					System.exit(1);
				}
				break;
			}
		}

	}

	private static boolean testWhitelist(String test) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		// String numbers = "1234567890";
		int i = 0;
		while (i < test.length() - 1) {
			String letter = test.substring(i, i + 1).toLowerCase();
			if (!alphabet.contains(letter)) {
				return false;
			}
			i++;
		}
		return true;
	}
}
