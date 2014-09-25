
public class Hw7b {

    public static boolean checkTags(String[] values) {
        int position = -1;
        int position1 = -1;
        boolean tags = true;
        String test = "";
        for (int i = 0; i < values.length && tags; i++) { //goes through each variable, if one is not empty then tags is false.
            if (!values[i].isEmpty()) {
                tags = false;
            }
        }
        if (tags) { //if tag is true, then that means the whole array is empty meaning its true.
            return tags;
        }
        for (int i = 0; i < values.length && test.isEmpty(); i++) {
            if (!values[i].isEmpty()) {
                test = values[i];
                position1 = i;
            }
        }
        test = test.substring(0, 1) + "/" + test.substring(1, test.length());
        for (int i = 0; i < values.length && position == -1; i++) {
            if (values[i].equals(test)) {
                position = i;
            }
        }
        if (position == -1) {
            return false;
        }
        values[position1] = "";
        values[position] = "";
        return checkTags(values);
    }
}