import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class logappend_temp {
	private static long timestamp; // number
	private static String token; // any
	private static String Name; // letters
	private static boolean isLeaving;
	private static boolean isArriving;
	private static boolean isGuest;
	private static long roomid; // number
	private static String logFileName; // any
	private static boolean isBatch;
	private static String batchFileName; // an
	private static Long LatestTime;
	private static ArrayList<Data> DataList = new ArrayList<Data>();

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
				setDataList();
				execute();
				encrypt(Data2String());
				DataList.clear();

			}
			scan.close();
		} else {
			setDataList();
			execute();
			encrypt(Data2String());
			DataList.clear();
		}
	}

	private static String Data2String() {
		String answer = DataList.get(0).toString();
		for (int i = 1; i < DataList.size(); i++) {
			answer += System.lineSeparator() + DataList.get(i).toString();
		}
		return answer;
	}

	private static void setDataList() throws FileNotFoundException {

		String tname;
		long troom;
		boolean tguest;
		long tarrival;
		long tleave;
		// Scanner scan = new Scanner(parseLogFile());
		Scanner scan = new Scanner(new File(logFileName))
				.useDelimiter("[\n\r_]");
		while (scan.hasNext()) {
			tname = scan.next();
			if (!tname.equals("")) {
				troom = scan.nextLong();
				tguest = scan.nextBoolean();
				tarrival = scan.nextLong();
				tleave = scan.nextLong();
				Data insert = new Data(tname, troom, tguest, tarrival, tleave);
				DataList.add(insert);
			}
		}
		scan.close();
		if (DataList.size() != 0) {
			tarrival = DataList.get(DataList.size() - 1).getArrivalTime();
			tleave = DataList.get(DataList.size() - 1).getLeaveTime();
			if (tarrival > tleave) {
				LatestTime = tarrival;
			} else {
				LatestTime = tleave;
			}

		} else {
			LatestTime = (long) -1;
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
		// try {
		//
		// // Run decypt ruby
		// // using the Runtime exec method:
		// Process p = Runtime.getRuntime().exec(
		// "ruby Encrypt.rb " + token + " " + logFileName + " '" + log
		// + "'");
		//
		// BufferedReader stdInput = new BufferedReader(new InputStreamReader(
		// p.getInputStream()));
		//
		// // BufferedReader stdError = new BufferedReader(new
		// // InputStreamReader(
		// // p.getErrorStream()));
		//
		// // read the output from the command
		// while ((s = stdInput.readLine()) != null) {
		// test += s;
		// }
		//
		// // read any errors from the attempted command
		// //
		// System.out.println("Here is the standard error of the command (if any):\n");
		// // while ((s = stdError.readLine()) != null) {
		// // System.out.println(s);
		//
		// // }
		// //
		// } catch (IOException e) {
		// System.out.println("exception happened - here's what I know: ");
		// e.printStackTrace();
		// System.exit(-1);
		// }
		// if (test.equals("Fail:Authentication")) {
		// System.out.println("Error: Invalid Token");
		// System.exit(1);
		// } else
		// test case
		writer.println(log);
		writer.close();
		// test
		System.out.println("Success!");
	}

	private static void execute() {
		boolean successful = false;
		int index = -1;
		boolean inGallery = false;
		if (timestamp < LatestTime) {
			System.out.println("You can't enter or leave a room in the past");
			System.exit(1);
		}
		if (isLeaving) {
			for (int i = 0; i < DataList.size(); i++) {
				if (DataList.get(i).isGuest() == isGuest
						&& DataList.get(i).getName().equals(Name)
						&& DataList.get(i).getRoom() == roomid
						&& DataList.get(i).getLeaveTime() == -1) {
					DataList.get(i).setLeaveTime(timestamp);
					successful = true;
					if (roomid != -1) {
						DataList.add(new Data(Name, isGuest, timestamp));
					}
				}
			}
			if (successful == false) {
				System.out
						.println("There exist no person in that room at the current moment");
				System.exit(1);
			}
		} else if (isLeaving == false) {
			for (int i = 0; i < DataList.size(); i++) {
				if (DataList.get(i).isGuest() == isGuest
						&& DataList.get(i).getName().equals(Name)
						&& DataList.get(i).getRoom() == -1
						&& DataList.get(i).getLeaveTime() == -1) {
					inGallery = true;
					index = i;
				}
			}
			if (roomid == -1 && inGallery) {
				System.out.println("That person is already in the gallery");
				System.exit(-1);
			}
			if (roomid != -1 && !inGallery) {
				System.out
						.println("That person needs to be in the gallery before intering a room");
				System.exit(-1);
			}
			if (roomid == -1 && !inGallery) {
				DataList.add(new Data(Name, isGuest, timestamp));
			} else if (roomid != -1 && inGallery) {
				int count = 0;
				for (int i = 0; i < DataList.size() - count && inGallery; i++) {
					if (DataList.get(i).isGuest() == isGuest
							&& DataList.get(i).getName().equals(Name)
							&& DataList.get(i).getRoom() == roomid
							&& DataList.get(i).getLeaveTime() == -1) {
						System.out
								.println("That person is already in that room");
						System.exit(-1);
					} else {
						DataList.add(new Data(Name, roomid, isGuest, timestamp));
						DataList.get(index).setLeaveTime(timestamp);
						inGallery = false;
						count++;
					}
				}
			}
		}

	}

	private static void print() {
		if (isBatch) {
			System.out.println("Batch? : True");
			System.out.println("Batch File Name: " + batchFileName);
		} else {
			System.out.println("Timestamp: " + timestamp); // number
			System.out.println("Token: " + token);
			System.out.println("Name: " + Name);// letters

			if (isLeaving) {
				System.out.println("isLeaving: True");
			} else {
				System.out.println("isLeaving: False");
			}
			System.out.println("Room ID: " + roomid); // number
			System.out.println("Log File Name: " + logFileName); // any

		}
	}

	private static void makeDefaults() {
		timestamp = -1;
		token = "";
		Name = "";
		isLeaving = false;
		isArriving = false;
		isGuest = false;
		roomid = -1;
		logFileName = "";
		isBatch = false;
		batchFileName = "";
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
			if (Name.equals(""))

			{
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out
						.println("Please Enter a Guest name or Employee name");
				System.exit(1);
			}

			if (isLeaving == true && isArriving == true) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out
						.println("Please only enter -L (isLeaving) or a -A (Arriving)");
				System.exit(1);
			}
			if (isLeaving == false && isArriving == false) {
				System.out.println("Incorrect input");
				System.out
						.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
				System.out.println("logappend -B <Batch File>");
				System.out
						.println("Please enter -L (isLeaving) or a -A (Arriving)");
				System.exit(1);
			}
			if (roomid < 0 && (roomid != -1)) {
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
			if (!testWhitelist(Name)) {
				System.out.println("Please Enter a real Name");
				System.exit(1);
			}

		}

	}

	private static void parseCommands(String[] args) {
		makeDefaults();
		for (int i = 0; i < args.length; i = i + 2) {
			switch (args[i].toUpperCase()) {
			case "-B":
				if (args.length > 2 || isBatch == true) {
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
				if (!Name.isEmpty()) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out
							.println("Please enter only one Guest or Employee");
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
					isGuest = false;
					Name = args[i + 1];
				}
				break;
			case "-G":
				if (!Name.isEmpty()) {
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
					isGuest = true;
					Name = args[i + 1];
				}
				break;
			case "-L":
				if (isLeaving == true) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out
							.println("Please enter only Leave or Arrival Once");
					System.exit(1);
				}

				else {
					isLeaving = true;
					i--;
				}
				break;
			case "-A":
				if (isArriving == true) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out
							.println("Please enter only Leave or Arrival Once");

					System.exit(1);
				}

				else {
					isArriving = true;
					i--;
				}
				break;
			case "-R":
				if (roomid != -1) {
					System.out.println("Incorrect input");
					System.out
							.println("logappend -T <long> -K <Token> -E/-G <Name> -A/-L -R <Long> <logfilename>");
					System.out.println("logappend -B <Batch File>");
					System.out.println("Please enter only one room id");
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
