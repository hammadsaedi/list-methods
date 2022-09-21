import java.util.Arrays;

/**
 * This program is just to test functionality of List Class, by @hammadsaedi
 * @author Hammad Saeedi (@hammadsaedi - everywhere) 
*/
public class test {
    public static void main(String[] args){
        // // Integer Type Array
        Integer[] array = {0, 1, 2, 3, 4, 5};
        
        // Displaying Array
        System.out.println("Array: " + Arrays.toString(array));

        // Appending number at the end of array
        array = List.append(array, 18);
        // Displaying Array
        System.out.println("Array after appending: " + Arrays.toString(array));

        // Coping Array
        array = List.copy(array);
        System.out.println("Copied Array: " + Arrays.toString(array));

        // Extending Array
        array = List.extend(array, new Integer[] {7, 8, 9});
        // Displaying Array
        System.out.println("Extended: " + Arrays.toString(array));

        // Inserting in Array
        array = List.insert(array, 19, 0);
        // Displaying Array
        System.out.println("Array after insertion of 19 at 0 index: " + Arrays.toString(array));

        // Removing element from Array at specific position
        array = List.pop(array, 0);
        // Displaying Array
        System.out.println("Array after removing element at 0 index: " + Arrays.toString(array));

        // Removing elements from Array with specific value
        array = List.remove(array, 1);
        // Displaying Array
        System.out.println("Array after removing element with 1 value: " + Arrays.toString(array));

        // Reversing order of array
        array = List.reverse(array);
        // Displaying Array
        System.out.println("Array after reversing: " + Arrays.toString(array));

        // Displaying Number of time a specific element exist
        System.out.println("Frequency of 0: " + List.count(array, 0));

        // Displaying index of the first element with the specified value
        System.out.println("Index of 5: " + List.index(array, 5));

        // Clearing Array's Elements
        array = List.clear(array);
        // Displaying Array
        System.out.println("Array after clearing: " + Arrays.toString(array));
    }
}
