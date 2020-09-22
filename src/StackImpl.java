/**
 * using an array
 */
public class StackImpl implements Stack {

    private Object list[];
    private int size;

    /**
     * Constructs an empty stack
     */
    public StackImpl() {
        list = new Object[5];
        size = 0;
    }

    /**
     * @see Stack#isEmpty()
     */
    public boolean isEmpty() {
        return size < 0;
    }

    /**
     * @see Stack#makeEmpty()
     */
    public void makeEmpty() {
        for (int i = 0; i < list.length; i++)
            list[i] = null;
        size = 0;
    }

    /**
     * @see Stack#push(Object)
     */
    public void push(Object item) {
        if (size >= list.length) {
            Object b[] = new Object[size + 5];
            System.arraycopy(b, 0, list, 0, size);
            list = b;
        }
        list[size++] = item;
    }

    /**
     * @see Stack#pop()
     */
    public Object pop() {
        return (size <= 0) ? null : list[size--];
    }

    /**
     * @see Stack#top()
     */
    public Object top() {
        return (size <= 0) ? null : list[size - 1];
    }

    /**
     * @see Stack#size()
     */
    public int size() {
        return size;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String s = new String("[");
        for (int i = 0; i < size; i++)
            s += (i < size - 1) ? list[i] + "," : list[i];
        return s + "]";
    }
}