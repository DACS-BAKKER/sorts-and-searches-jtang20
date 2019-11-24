import edu.princeton.cs.algs4.*;

public class BirthdayProblem {
    public static void main(String[] args) {
        StdOut.println("This program runs experiments to show that number of integers generated before first repeated value is sqrt(pi*N/2)");

        StdOut.println("\nEnter int N to generate integers between 0 and N-1 to find number of integers needed to generate before first repeated value.");
        StdOut.print("Enter N: ");
        int N = StdIn.readInt();

        StdOut.print("\nEnter number of cycles to simulate: ");
        int cycles = StdIn.readInt();

        int counter = 0;  // counts number of integers generated

        for (int i = 0; i < cycles; i++) { // iterates number of cycles
            boolean[] exts = new boolean[N];
            boolean rep = false;
            while (!rep) {  // keep cycling until there is a repeat birthday
                counter++;
                int birthday = (int) (Math.random() * N); // randomly generated birthday
                if (exts[birthday]) { // if already exists, it is a repeat
                    rep = true;
                } else { // if birthday does not currently exist, track
                    exts[birthday] = true;
                }
            }
        }
        // comparisons
        StdOut.println("\nThe average case for " + cycles + " cycles took " + (double) counter / cycles + " integers generated before the first repeated value.");
        StdOut.println("The hypothesized value is sqrt(pi*N/2): " + Math.sqrt(N * Math.PI / 2));
        StdOut.println("Error (%): " + Math.abs((Math.sqrt(N * Math.PI / 2) - (double) counter / cycles) / Math.sqrt(N * Math.PI / 2)) * 100 + "%.");
    }
}
