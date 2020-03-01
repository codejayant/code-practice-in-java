package com.codejayant.tounderstand;

import java.util.Arrays;

/**
 * category: string
 */
public class StringCompression {

    public static void main(String[] args) {

        char[] stringArray1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] stringArray2 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};


        int index = compress(stringArray2);
        System.out.println(Arrays.toString(Arrays.copyOfRange(stringArray2, 0, index)));
    }

    private static int compress(char[] chars) {
        char ref = chars[0];
        int f = 1;
        int s = 1;
        int count = 1;

        while (f < chars.length) {
            if (ref == chars[f]) {
                count += 1;
                f++;
            } else {
                ref = chars[f];
                chars[s++] = Character.forDigit(count, 10);

                chars[s++] = ref;
                count = 1;
                f++;
            }
        }
        if (count > 1) {
            chars[s++] = Character.forDigit(count, 10);
        }

        return s;
    }

}
