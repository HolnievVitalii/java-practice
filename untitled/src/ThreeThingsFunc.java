import org.junit.Test;

import java.util.*;

import static java.lang.System.*;
import static org.junit.Assert.assertEquals;

/**
 * @author holnievvitalii@outlook.com
 */
public class ThreeThingsFunc {
    /**
     * simple method that output min,max and avg value from initial array of numbers
     *
     * @param arr
     */
    public static void threeThingsDo(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int avg = (int) Arrays.stream(arr).average().getAsDouble();
        out.println("the smallest number value - " + min);
        out.println("the largest number value- " + max);
        out.println("the average value of all numbers - " + avg);
    }

    public static void main(String[] args) {
//        int[] lol = new int[]{-134, 2, 75, 206, 3345};
//        ThreeThingsFunc.threeThingsDo(lol);
        ThreeThingsFunc.theThingMethod();
    }


    @Test
    public void testThingMethod() {
        int[] integers = new int[]{20, 98, 12, 7, 35};
        int min = Arrays.stream(integers)
                .min()
                .getAsInt();
        int max = Arrays.stream(integers)
                .max()
                .getAsInt();
        int avg = (int) Arrays.stream(integers)
                .average()
                .getAsDouble();

        assertEquals(7, min);
        assertEquals(98, max);
        assertEquals(34, avg);
    }

    /**
     * method "the thing" that can be offered numbers.
     * <p>
     * At any given time it can tell 3 things:
     * 1) the smallest number it has encountered so far
     * 2) the largest number it has encountered so far
     * 3) the average of all numbers it has encountered so far
     * <p>
     * Prove that it is working correctly. Make it so that a novice programmer cannot use it the wrong way, nor that an evil programmer can break it.
     */
    public static void theThingMethod() {

        List<Integer> arr = new ArrayList<>();//initializing a list that we will use in future for adding integers inside it

        while (true) {
            Scanner input = new Scanner(in);
            out.println("Enter the count of numbers that you will input: ");


            if (input.hasNextInt()) {
                int ARRAY_SIZE = input.nextInt();


                out.print("Insert elements: " + "(" + ARRAY_SIZE + ")");

                try {
                    int count = 0; // added counter for seeing position of current integer that was input
                    for (int i = 0; i < ARRAY_SIZE; i++) { /*if we had input an integer then we adding it to the our list*/
                        out.println("");
                        count++;
                        out.print("Input " + count + " element and press ENTER to add it to list: ");
                        arr.add(input.nextInt());
                    }
                } catch (InputMismatchException e) { //if we have a wrong symbol at list, then just got notification about it and returning to start of the method
                    err.print(errMsg());
                    theThingMethod();
                }

                out.print("Inserted array elements:");
                out.println(arr);
                int min = Collections.min(arr);
                int max = Collections.max(arr);
                OptionalDouble avg = arr.stream().mapToInt(e -> e).average();

                out.println("the smallest number - " + min);
                out.println("the largest number - " + max);
                out.println("the average of all numbers - " + avg);

            } else if (!input.hasNextInt()) {
                out.println("");
                err.print(errMsg());// if we had a wrong array size or wrong symbol that describe our array
                theThingMethod();                // size then we'll be see an error message and returning to start of the method
            }


        }
    }

    /**
     * an error message
     *
     * @return message that tells us we can't use any symbols except integers
     */
    private static String errMsg() {
        return "please input only numbers (characters, strings or symbols not allowed here!) => ";
    }
}


