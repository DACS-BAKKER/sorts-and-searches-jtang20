import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class BinarySearch {
    private static int binarySearch(int arr[], int l, int r, int x) {  // Returns index of x if it is present in arr[l..r], else return -1
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x){ // If the element is present at the middle itself
                return mid;
            }
            if (arr[mid] > x) { // If element is smaller than mid, then it can only be present in left subarray
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);  // Else the element can only be present in right subarray
        }
        return -1; // We reach here when element is not present in array
    }


    public static void main(String args[]) { // Driver method to show analytically what the best case, worst case, and average case cost of a binary search is on N sorted values
        StdOut.println("Binary search Test");
        StdOut.print("Enter a sorted array size that is greater than 0 for a binary search simulation (try a large number such as 10,000,000): ");
        int size = StdIn.readInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        StdOut.println("\nBest case: search for element in the middle of array\nSearch for middle integer inside array: " + array[array.length / 2]);
        Stopwatch bestCase = new Stopwatch();
        for (int i = 0; i < size - 1; i++) {
            binarySearch(array, 0, array.length - 1,array[array.length / 2]);
        }
        StdOut.println("Index: " + binarySearch(array, array[array.length / 2], 0, array.length - 1) + "\nTime: " + bestCase.elapsedTime() / size + " s");


        StdOut.println("\nAverage case: calculated by averaging time of search for every element in array\nTotal elements searched: " + size);
        Stopwatch averageCase = new Stopwatch();
        for (int i = 0; i < array.length; i++) {
            binarySearch(array, 0, array.length - 1, i);
        }
        StdOut.println("Average time: " + averageCase.elapsedTime() / size + " s");

        StdOut.println("\nWorst case: search for element not inside array\nSearch for integer which does not exist inside array: " + size);
        Stopwatch worstCase = new Stopwatch();
        for (int i = 0; i < size - 1; i++) {
            binarySearch(array, 0, array.length - 1, size);
        }
        StdOut.println("Index: " + binarySearch(array, 0, array.length - 1,size) + "\nTime: " + worstCase.elapsedTime() / size + " s");

    }

}
