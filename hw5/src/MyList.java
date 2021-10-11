
public class MyList<E> implements List<E> {
    private E[] elements;
    private int size;

    public MyList() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E e) {
        if (e == null)
            throw new IllegalArgumentException();

        if (elements.length == size) {
            E[] replacement = (E[]) new Object[elements.length * 2];

            for (int i = 0; i < size; i++) {
                replacement[i] = elements[i];
            }
            elements = replacement;
        }

        elements[size] = e;
        size++;

    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return elements[index];
    }

    public void replace(E e, E replaceWith) {
        if (e == null)
            throw new IllegalArgumentException();
        if (replaceWith == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(e)) {
                elements[i] = replaceWith;
            }
        }

    }

    public int remove(E e) {
        if (e == null)
            throw new IllegalArgumentException();

        int index = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                elements[i] = null;
                count++;
            } else {
                elements[index] = elements[i];
                if (index != i)
                    elements[i] = null;
                index++;
            }
        }

        if (size < elements.length / 4) {
            E[] replacement = (E[]) new Object[elements.length / 2];
            for (int i = 0; i < size; i++) {
                replacement[i] = elements[i];
            }
            elements = replacement;
        }

        size = index;
        return count;

    }

    public int contains(E e) {
        if (e == null)
            throw new IllegalArgumentException();

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        elements = (E[]) new Object[1];
        size = 0;
    }

    public int size() {
        return size;
    }

    public E[] toArray(E[] e) {
        E[] arr = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = elements[i];
        }
        return arr;
    }
}
