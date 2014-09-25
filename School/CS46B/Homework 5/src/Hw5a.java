//

import java.util.Arrays;

public class Hw5a {

    private int[] a;

    public Hw5a(int[] in1) {
        a = in1;
    }

    public String toString() {
        return Arrays.toString(a);
    }

    public void sort(int k) {
        int length = a.length - 1;
        int max;
        int count = 0;
        int position;
        for (int j = 0; j <= length && count < k; j++) {
            position = length - j;
            max = 0;
            for (int i = 0; i <= length - j; i++) {
                if (a[i] > max) {
                    max = a[i];
                    position = i;
                }
            }
            a[position] = a[length - j];
            a[length - j] = max;
            count++;


        }
    }
}
