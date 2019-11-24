import edu.princeton.cs.algs4.*;
import java.util.*;

public class SelectionSort{ // randomly generates then sorts an array
    public static void main(String args[]){
        int size = 100; //size of array, please increase number if time returns 0.0 :)
        Random rgen = new Random();
        int[] a = new int[size];
        for(int i=0; i<size; i++){
            int x = rgen.nextInt(size)+1;
            a[i]=x;
        }
        System.out.println("Unsorted Array: " + Arrays.toString(a));
        Stopwatch timer = new Stopwatch();
        selectionSort(a);
        System.out.println("Time taken(seconds): " + timer.elapsedTime());
        System.out.println("Sorted Array: " + Arrays.toString(a));
    }
    public static void selectionSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int swap = a[i];
                a[i] = a[min];
                a[min] = swap;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}