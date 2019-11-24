import edu.princeton.cs.algs4.*;
import java.util.*;

public class MergeSortBU {
    public static void main(String args[]) { // mergesort bottom up, (iterative)
        int size = 100; //size of array, please increase number if time returns 0.0 :)
        Random rgen = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            int x = rgen.nextInt(size) + 1;
            a[i] = x;
        }
        System.out.println(Arrays.toString(a));
        Stopwatch timer = new Stopwatch();
        mergesortBU(a);
        System.out.println("Time taken(seconds): " + timer.elapsedTime());
        System.out.println(Arrays.toString(a));
    }
    public static void mergesortBU(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = new int[mid]; // Split left part
            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }
            int[] right = new int[array.length - mid];  // Split right part
            for (int i = mid; i < array.length; i++) {
                right[i - mid] = array[i];
            }
            mergesortBU(left);
            mergesortBU(right);
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < left.length && j < right.length) { // Merge left and right arrays
                if (left[i] < right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < left.length) { // Collect remaining elements
                array[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) { // Collect remaining elements
                array[k] = right[j];
                j++;
                k++;
            }
        }
    }
}
