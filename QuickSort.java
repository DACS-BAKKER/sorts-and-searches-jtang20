import edu.princeton.cs.algs4.*;

import java.util.*;
/* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */

public class QuickSort {
    int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            if (arr[j] < pivot) { // If current element is smaller than the pivot
                i++;

                int temp = arr[i]; // swap arr[i] and arr[j]
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1]; // swap arr[i+1] and arr[high] (or pivot)
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void sort(int arr[], int low, int high) {
        if (low < high) { // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);  // Recursively sort elements before partition and after partition
            sort(arr, pi+1, high);
        }
    }


    public static void main(String args[]) { // Test client
        int size = 100; //size of array, please increase number if time returns 0.0 :)
        Random rgen = new Random();
        int[] a = new int[size];
        for(int i=0; i<size; i++){
            int x = rgen.nextInt(size)+1;
            a[i]=x;
        }
        System.out.println("Unsorted Array: " + Arrays.toString(a));
        Stopwatch timer = new Stopwatch();
        QuickSort ob = new QuickSort();
        ob.sort(a, 0, a.length-1);
        System.out.println("Time taken(seconds): " + timer.elapsedTime());
        System.out.println("Sorted Array: " + Arrays.toString(a));
    }
}
