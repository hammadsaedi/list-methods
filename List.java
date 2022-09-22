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
     * Insert at last index
     * Appends given element at the end of the array 
     * @param array Generic Type Array, in which element has to be appended
     * @param element Generic Type element, which has to be to be appended
     * @return Generic type Array, with appended element
     * @apiNote Both param must be of same Type
    */
    public static <T> T[] append(T[] array, T element) {
        // new array creation with size of n + 1 for last element to be appended
        @SuppressWarnings("unchecked")
        T[] buffer = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length + 1);
        
        // Copying previous array's elements into new array
        for (int i = 0; i < array.length; i++) {
            buffer[i] = array[i];
        }

        // Appending last element in new array
        buffer[array.length] = element;

        // returning appended array
        return buffer;
    }

    /**
     * Clears Array Elements
     * Returns new Array with zero elements
     * @param array Generic Type Array to be clear
     * @return Empty array with zero elements
    */
    @SuppressWarnings("unchecked")
    public static <T> T[] clear(T[] array) {
        // array creation with zero elements
        return (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), 0); 
        // returning cleared array with 0 valued elements
    }

    /**
     * Copies Array
     * Returns Deep Copy of Array
     * @param array Generic Type Array to be copied
     * @return Copied array
    */
    public static <T> T[] copy(T[] array) {
        // array creation with same size as of array to be copied
        @SuppressWarnings("unchecked")
        T[] buffer = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length);
        
        // Iterating through element of array
        for (int index = 0; index < array.length; index++){
            buffer[index] = array[index]; // copying elements
        }

        // returning cleared array with 0 valued elements
        return buffer;
    }

    /**
     * Counts number of elements with specific in an array
     * Returns number of elements with specific value in an array
     * @param array Generic Type Array whose elements are to be counted
     * @param value Generic Type value of element which has to be counted
     * @return Number of Elements
    */
    public static <T> int count(T[] array, T value) {
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
     * @param array1 Generic Type Array, in which another array has to be appended 
     * @param array2 Generic Type Array which has to be appended
     * @return Extended Generic Type Array, with appended array 
    */
    public static <T> T[] extend(T[] array1, T[] array2){
        // Variable declarations
        int index;
        T[] buffer;

        // Copying elements of first array into newly created Extended Array
        buffer = copy(array1);

        // for all elements of second array appending into Extended Array
        for (index = 0; index < array2.length; index++){
            buffer = append(buffer, array2[index]);
        }

        // returning extended array
        return buffer;
    }

    /**
     * Finds index of the first element with the specified value
     * @param array Generic Type array, in which value has to be searched
     * @param value Generic Type element's value which has to be searched
     * @return Index of first element in array with the passed value; return -1, in case of no element match
    */
    public static <T> int index(T[] array, T value){
        // Variable declarations
        int index;

        // Iterating through element of array
        for (index = 0; index < array.length; index++){
            if (array[index] == value){ // If any array element contains desired value
                return index; // return's elements index
            }
        }

        // Return -1, in case no element has such value 
        return  -1;
    }

    /**
     * Inserts element at specific index
     * @param array Generic type array, in which element has to be inserted 
     * @param number Generic type element, which has to be inserted
     * @param index Generic type index, where element has to be inserted
     * @return Generic Type array with element inserted at specific positions
    */
    public static <T> T[] insert(T[] array, T value, int index) {
        // size of new array
        final int size; 

        if (index >= array.length){ // in case, element which has to be inserted in index is higher than last-element-index
            size = index + 1; 
            // array.length + (index - (array.length - 1)); --->  Previous-Array's-Length + (New-Array-Index - Highest-Index-of-Previous-Array) ---> // 5 + 5 - 5 + 1 ---> 6
        } else { // + 1 for new element to be inserted
            size = array.length + 1;
        }
        
        // creating new array with appropriate size
        @SuppressWarnings("unchecked")
        T[] buffer = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        
        
        // Iterating through element of updated array
        for (int i = 0, j = 0; i < buffer.length; i++) {
            if (i == index){ // when index where elements is to be inserted reach 
                buffer[i] = value; // assigning desired value
            } else if (j < array.length){ // Copying other elements
                buffer[i] = array[j];
                j++; // for previous array's index; increment only if element is copied
            }      
        }

        // returning updated array
        return buffer;
    }

    /**
     * Removes element at the specified index
     * @param array Generic Type Array, in which element has to be removed
     * @param index Generic Type position where element has to be removed from array
     * @return Generic Type Array with removed element
    */
    // Method to Remove the element at the specified position
    public static <T> T[] pop(T[] array, int index) {        
        // creating new array with appropriate size
        @SuppressWarnings("unchecked")
        T[] buffer = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length - 1);
        
        
        // Iterating through element of parent array
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i == index){ // when index where elements to be remove reach 
                continue; // skip iterations
            } else { // Copying other elements
                buffer[j] = array[i];
                j++; // for new array's index; increment only if element is copied
            }      
        }

        // returning updated array
        return buffer;
    }

    /**
     * Removes element with specific value
     * @param array Generic Type Array, in which element has to be removed
     * @param value Generic Type element value which has to be removed
     * @return Generic Type Array with removed element
    */
    public static <T> T[] remove(T[] array, T value) {  
        // Variable declaration
        int count;

        // Calculating number of element with desired value
        count = count(array, value);

        // creating new array with appropriate size
        @SuppressWarnings("unchecked")
        T[] buffer = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length - count);

        // Iterating through element of parent array
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] == value){ // when valued element to be remove reach 
                continue; // skip iterations
            } else { // Copying other elements
                buffer[j] = array[i];
                j++; // for new array's index; increment only if element is copied
            }      
        }

        // returning updated array
        return buffer;
    }

    /**
     * Reverses the order of array
     * @param array Generic Type array which has to be reversed
     * @return Generic Type array in reversed order
    */
    // Method to reverse the order of array
    public static <T> T[] reverse(T[] array) {  
        // creating new array with appropriate size
        @SuppressWarnings("unchecked")
        T[] buffer = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length);
                
        // Iterating through element of parent array
        for (int i = 0; i < array.length; i++) {
            buffer[i] = array[(array.length - 1) - i]; // reverse indexing
        }

        // returning updated array
        return buffer;
    }   
}