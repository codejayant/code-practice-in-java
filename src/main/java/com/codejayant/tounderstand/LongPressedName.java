package com.codejayant.tounderstand;

/**
 * category: arrays
 */
public class LongPressedName {

    public static void main(String[] args) {
//        String name = "pyplrz";
//        String typed = "ppyypllr";
        String name = "alex";
        String typed = "aaleex";
        System.out.println(LongPressedName.isLongPressedName(name, typed));
    }

    private static boolean isLongPressedName(String name, String typed) {
        int c = 0;

        for (int i = 0; i < name.length(); i++) {
            if (c < typed.length() && name.charAt(i) == typed.charAt(c)) {
                c++;

            } else {
                while (c < typed.length() - 1) {
                    if (typed.charAt(c) == typed.charAt(c - 1)) {
                        c = c + 1;
                    } else {
                        break;
                    }
                }
                if (name.charAt(i) != typed.charAt(c)) {
                    return false;
                }

                c++;
                if (i < name.length() - 1 && c >= typed.length()) {
                    return false;
                }

            }

        }
        return true;


    }


}
