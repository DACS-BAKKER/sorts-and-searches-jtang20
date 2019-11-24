import edu.princeton.cs.algs4.*;
import java.util.*;

public class RadixSort {
    private static int getMax(int arr[], int n) { //returns maximum value in arr[]
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    private static void countSort( int arr[], int n, int exp){  // A function to do counting sort of arr[] according to the digit represented by exp
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
            for (i = 0; i < n; i++) {// Store count of occurrences in count[]
                count[(arr[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++) { // Change count[i] so that count[i] now contains actual position of this digit in output[]
                count[i] += count[i - 1];
            }
            for (i = n - 1; i >= 0; i--) { // Build the output array
                output[count[(arr[i] / exp) % 10] - 1] = arr[i];
                count[(arr[i] / exp) % 10]--;
            }
            for (i = 0; i < n; i++){ // Copy the output array to arr[], so that arr[] now contains sorted numbers according to curent digit
                arr[i] = output[i];
            }
    }

    public static void radixsort ( int arr[], int n){ // The main function of radix sort that sorts arr[] of size n using radix sort
        int m = getMax(arr, n); // Find the maximum number to know number of digits
        for (int exp = 1; m / exp > 0; exp *= 10) { // Do counting sort for every digit by passing exp. exp is 10^i where i is current digit number
            countSort(arr, n, exp);
        }
    }

    public static void main(String args[]){
        int size = 100; //size of array, please increase number if time returns 0.0 :)
        Random rgen = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            int x = rgen.nextInt(size) + 1;
            a[i] = x;
        }
        System.out.println(Arrays.toString(a));
        Stopwatch timer = new Stopwatch();
        radixsort(a, size);
        System.out.println("Time taken(seconds): " + timer.elapsedTime());
        System.out.println(Arrays.toString(a));
    }

}
