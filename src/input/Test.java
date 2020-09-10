package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {
        System.out.print("enter you name: ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        try {
            String name = in.readLine();
            System.out.println("hello, " + name + ". Enter three ints...");
            int[] values = new int[3];
            double sum = 0.0;

            for (int i = 0; i < values.length; i++) {
                System.out.print("number " + (i + 1) + ": ");
                String tmp = in.readLine();
                values[i] = Integer.parseInt(tmp);
                sum += values[i];
            }

            System.out.println("the average equals " + sum / values.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
