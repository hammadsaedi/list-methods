/**
 * <p><b>Enhanced Arrays</b></p>
 * By default, Java Arrays have fixed size which is set during arrays creation.
 * In python, List have extendable size. Means, we can add or remove any element from any index at run time.
 * This class contains method which can be used to do such stuff.
 * <p><b>Java Version:</b></p>
 * <p>java 17.0.2 2022-01-18 LTS</p>
 * <p>Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)</p>
 * <p>Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)
 * <p><b>Date and Time:</b></p> <p>12 April 2022 9:20 pm<p/>
 * @author Hammad Saeedi (@hammadsaedi - everywhere)
 * @version 1.0
 *
*/

public class List {

    /**
     * Appends an element at the end of the array
     * @param array Integer Type Array, in which element has to be appended (add at last index)
     * @param number Integer Type number element, which has to be to be appended
     * @return Integer type Array, with appended element
    */
    public static int[] append(int[] array, int number) {
        // new array creation with size of n + 1 for last element to be appended
        int[] appendArray = new int[array.length + 1];
    
        // Copying previous array's elements into new array
        for (int i = 0; i < array.length; i++) {
            appendArray[i] = array[i];
        }

        // Appending last element in new array
        appendArray[array.length] = number;

        // returning appended array
        return appendArray;
    }

    /**
     * clears elements of array
     * @param array Integer Type Array to be clear
     * @return empty array with zero elements
    */
    public static int[] clear(int[] array) {
        // array creation with zero elements
        int[] clearedArray = new int[0];

        // returning cleared array with 0 valued elements
        return clearedArray;
    }

    /**
     * copies array
     * @param array Integer Type Array to be copied
     * @return Copied array
    */
    // Method to return copy of array
    public static int[] copy(int[] array) {
        // array creation with same size as of array to be copied
        int[] copiedArray = new int[array.length];

        // Copying array
        copiedArray = array; 

        // returning cleared array with 0 valued elements
        return copiedArray;
    }

    /**
     * Counts number of elements with specific in an array
     * @param array Integer Type Array whose elements are to be counted
     * @param value Integer Type value of element which has to be counted
     * @return Number of Elements
    */
    // Method to return number of elements with specific value in an array
    public static int count(int[] array, int value) {
        // Variable declarations
        int numberOfElement = 0, index;
        
        // Iterating through element of array
        for (index = 0; index < array.length; index++){
            if (array[index] == value) { // if ith element of array is equal to desired value
                numberOfElement++; // incrementing number of Element
            }
        }

        // return number of element with specific value
        return numberOfElement;
    }

    /**
     * Appends array at the end of another array
     * @param array1 Integer Type Array, in which another array has to be appended 
     * @param array2 Integer Type Array which has to be appended
     * @return Extended Integer Type Array, with appended array 
    */
    // Method to append array with all elements af other array (List Extend Method - Python)
    public static int[] extend(int[] array1, int[] array2){
        // Variable declarations
        int index;
        int[] extendArray;

        // Copying elements of first array into newly created Extended Array
        extendArray = copy(array1);

        // for all elements of second array appending into Extended Array
        for (index = 0; index < array2.length; index++){
            extendArray = append(extendArray, array2[index]);
        }

        // returning extended array
        return extendArray;
    }

    /**
     * Finds index of the first element with the specified value
     * @param array Integer Type array, in which value has to be searched
     * @param value Integer Type element's value which has to be searched
     * @return Index of first element in array with the passed value; return -1, in case of no element match
    */
    public static int index(int[] array, int value){
        // Variable declarations
        int index;

        // Iterating through element of array
        for (index = 0; index < array.length; index++){
            if (array[index] == value){ // If any array element contains desired value
                return index; // return's elements index
            }
        }

        // Return -1, in case no element have such value 
        return  -1;
    }

    /**
     * Inserts element at specific index
     * @param array Integer type array, in which element has to be inserted 
     * @param number Integer type element, which has to be inserted
     * @param index Integer type index, where element has to be inserted
     * @return Integer Type array with element inserted at specific positions
    */
    // Method to add an element at the specified position
    public static int[] insert(int[] array, int number, int index) {
        
        final int size; // size of new array

        if (index >= array.length){ // in case, element is to be inserted in index higher than last-element-index
            size = index + 1; 
            // array.length + (index - (array.length - 1)); --->  Previous-Array's-Length + (New-Array-Index - Highest-Index-of-Previous-Array) ---> // 5 + 5 - 5 + 1 ---> 6
        } else { // + 1 for new element to be inserted
            size = array.length + 1;
        }
        
        // creating new array with appropriate size
        int[] updatedArray = new int[size];
        
        // Iterating through element of updated array
        for (int i = 0, j = 0; i < updatedArray.length; i++) {
            if (i == index){ // when index where elements is to be inserted reach 
                updatedArray[i] = number; // assigning desired value
            } else if (j < array.length){ // Copying other elements
                updatedArray[i] = array[j];
                j++; // for previous array's index; increment only if element is copied
            }      
        }

        // returning updated array
        return updatedArray;
    }

    /**
     * Removes element at the specified index
     * @param array integer Type Array, in which element has to be removed
     * @param index Integer Type position where element has to be removed from array
     * @return Integer Type Array with removed element
    */
    // Method to Remove the element at the specified position
    public static int[] pop(int[] array, int index) {        
        // creating new array with appropriate size
        int[] updatedArray = new int[array.length - 1];
        
        // Iterating through element of parent array
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i == index){ // when index where elements to be remove reach 
                continue; // skip iterations
            } else { // Copying other elements
                updatedArray[j] = array[i];
                j++; // for new array's index; increment only if element is copied
            }      
        }

        // returning updated array
        return updatedArray;
    }

    /**
     * Removes element with specific value
     * @param array integer Type Array, in which element has to be removed
     * @param value Integer Type element value which has to be removed
     * @return Integer Type Array with removed element
    */
    // Method to Remove the item with the specified value
    public static int[] remove(int[] array, int value) {  
        // Variable declaration
        int count;

        // Calculating number of element with desired value
        count = count(array, value);

        // creating new array with appropriate size
        int[] updatedArray = new int[array.length - count];
        
        // Iterating through element of parent array
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] == value){ // when valued element to be remove reach 
                continue; // skip iterations
            } else { // Copying other elements
                updatedArray[j] = array[i];
                j++; // for new array's index; increment only if element is copied
            }      
        }

        // returning updated array
        return updatedArray;
    }

    /**
     * Reverses the order of array
     * @param array Integer Type array which has to be reversed
     * @return Integer Type array in reversed order
    */
    // Method to reverse the order of array
    public static int[] reverse(int[] array) {  
        // creating new array with appropriate size
        int[] updatedArray = new int[array.length];
        
        // Iterating through element of parent array
        for (int i = 0; i < array.length; i++) {
            updatedArray[i] = array[(array.length - 1) - i]; // reverse indexing
        }

        // returning updated array
        return updatedArray;
    }   
}