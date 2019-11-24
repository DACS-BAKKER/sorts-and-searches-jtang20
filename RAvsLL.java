import edu.princeton.cs.algs4.StdIn;

public class RAvsLL {  //arraylist vs linkedlist
    public static void main(String[]args) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        ArrayList arrStack = new ArrayList();

        System.out.print("Enter the number of elements added to each stack: ");
        int N = StdIn.readInt();

        long bTime, aTime; //before and after times

        System.out.println("Pushing " + N + " values:");
        bTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        aTime = System.nanoTime();
        System.out.println("Linked List Stack Time: " + (aTime - bTime) / 1000);

        bTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            arrStack.push(i);
        }
        aTime = System.nanoTime();
        System.out.println("Resizeable Array Stack Time: " + (aTime - bTime) / 1000);


        System.out.println("\nPopping " + N + " values:");
        bTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.pop();
        }
        aTime = System.nanoTime();
        System.out.println("Linked List Stack Time: " + (aTime - bTime) / 1000);

        bTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            arrStack.pop();
        }
        aTime = System.nanoTime();
        System.out.println("Resizeable Array Stack Time: " + (aTime - bTime) / 1000);

        System.out.println("All times are shown in microseconds.");
    }
}
