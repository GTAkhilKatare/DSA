/*
Array is a indexable data structure in which the data is stored in a continuous manner.
They are stored like:

POSITION (INDEX)            DATA
0                           data 1
1                           data 2
2                           data 3
|                             |
|                             |
|                             |
n                           data n

In array, we can see any data or get any data using the position of it.
The position is also known as index and therefore they are known as indexable DS.
*/

package DataStructures.LinearDS;

public class Array 
{
    public static void main(String... args)
    {
        String[] array = new String[5]; // defining the array
        array[0] = "Data 1";
        array[1] = "Data 2";
        array[2] = "Data 3";
        array[3] = "Data 4";
        array[4] = "Data 5";

        System.out.println("Array created successfully.");
        printArray(array);
    }

    private static void printArray(String[] array)
    {
        int index = 0;
        int lengthOfArray = array.length - 1;

        System.out.print("Array: [");

        for (; index < lengthOfArray; index++)
            System.out.print(array[index] + " | ");

        System.out.println(array[index] + "]");
    }
}
