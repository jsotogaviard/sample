package com.jsotogaviard;

import java.io.*;

public class App {

    public static void exec(InputStream in, PrintStream out) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final String numString = br.readLine();
        final int num = Integer.parseInt(numString);
        final String integers = br.readLine();
        final String[] integerArray = integers.split(" ");
        for (int i = 0; i < num; i++) {
            final String endString = integerArray[i];
            final int end = Integer.parseInt(endString);
            for (int j = 1; j <= end; j++) {
                final boolean multipleOfThree = j % 3 == 0;
                final boolean multipleOfFive = j % 5 == 0;
                if (multipleOfThree && multipleOfFive) {
                    out.println("FizzBuzz");
                } else if (multipleOfThree) {
                    out.println("Fizz");
                } else if (multipleOfFive) {
                    out.println("Buzz");
                } else {
                    out.println(j);
                }
            }
        }
    }
}
