import edu.princeton.cs.algs4.*;
import java.util.*;

public class StableSelectionSort {
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
        stableSelectionSort(a);
        System.out.println("Time taken(seconds): " + timer.elapsedTime());
        System.out.println(Arrays.toString(a));
    }
    public static void stableSelectionSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;  // Find minimum element from arr[i] to arr[n - 1].
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int key = a[min]; // Move minimum element at current i.
            while (min > i) {
                a[min] = a[min - 1];
                min--;
            }
            a[i] = key;
        }
        System.out.println(Arrays.toString(a));
    }
}
