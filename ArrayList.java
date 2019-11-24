import java.util.Iterator;

public class ArrayList { // resizable array
    private int[] array; // variables */
    private int size;

    public ArrayList() { // // constructor to initialize array and size
        array = new int[2];
        size = 0;
    }

    public void clear() {
        array = new int[2];
        size = 0;
    }


    public int size() {
        return size;
    } //returns size


    public int peek() {
        return array[size - 1];
    } //peeks item


    public void push(int n) { // pushes item
        if (size == array.length) {  // if at threshold, increase array by 2 times
            resize(2 * array.length);
        }
        array[size++] = n;
    }

    public int pop() { //   // pops item
        if (size > 0) { //if array has items, store popped value and decrease size */
            int popped = array[size - 1];
            size--;
            if (size > 0 && size == array.length / 4){
                resize(array.length / 2);
            }
            return popped;  // return popped value
        } else { // if nothing in array
            return Integer.parseInt(null);
        }
    }

    private void resize(int capacity) { // resize array to given capacity
        array = java.util.Arrays.copyOf(array, capacity);
    }

    public Iterator<Integer> iterator() { //iterator
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Integer> {
        private int i;

        public ReverseArrayIterator() {
            i = size - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
        }

        public Integer next() {
            return array[i--];
        }
    }
}