import edu.princeton.cs.algs4.*;
import java.util.*;

public class MergeSortTD { //mergesort top down, recursive
    public static void main(String args[]) {
        int size = 100; //size of array, please increase number if time returns 0.0 :)
        Random rgen = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            int x = rgen.nextInt(size) + 1;
            a[i] = x;
        }
        System.out.println(Arrays.toString(a));
        Stopwatch timer = new Stopwatch();
        mergesortTD(a, 0, a.length - 1);
        System.out.println("Time taken(seconds): " + timer.elapsedTime());
        System.out.println(Arrays.toString(a));
    }

    public static void mergesortTD(int A[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergesortTD(A, start, mid);
            mergesortTD(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    public static void merge(int A[], int l, int m, int r) {
        int n1 = m - l + 1; // Find sizes of two subarrays to be merged
        int n2 = r - m;

        int L[] = new int[n1]; // Create temp array
        int R[] = new int[n2]; // Create temp array

        for (int i = 0; i < n1; ++i) { // Copy data to temp arrays
            L[i] = A[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = A[m + 1 + j];
        }

        int i = 0; // Initial indexes of first and second subarrays
        int j = 0;
        int k = l; // Initial index of merged subarry array
        while (i < n1 && j < n2) {  // Merge the temp arrays
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) { // Copy remaining elements of L[] if any
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) { // Copy remaining elements of R[] if any
            A[k] = R[j];
            j++;
            k++;
        }
    }

}
