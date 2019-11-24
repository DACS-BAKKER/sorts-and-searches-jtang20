import edu.princeton.cs.algs4.*;

import java.util.*;

public class InsertionSort{ // randomly generates then sorts an array
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
        insertionSort(a);
        System.out.println("Time taken(seconds): " + timer.elapsedTime());
        System.out.println("Sorted Array: " + Arrays.toString(a));
    }
    public static void insertionSort(int[] a){
        for (int i=1; i<a.length; i++){
            int key = a[i];
            int j = i-1;
            while (j>=0 &&a[j] > key){
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1]=key;
        }
    }
}