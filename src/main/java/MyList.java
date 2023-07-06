import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * The MyList class is a generic class that represents a dynamic array implementation.
 * It allows adding, deleting, and retrieving elements from the list.
 * The list automatically adjusts its capacity based on the number of elements it contains.
 * The class provides methods for adding elements at specific positions, deleting elements by index or value,
 * getting the index of an element, and getting the current size of the list.
 *
 * @author Maydanov Trofim, trofim419@gmail.com
 */
public class MyList<T> {
    private T[] list;
    private int size;
    private final int  INITIAL_CAPACITY = 10;

    /**
     * Constructs a new MyList object with the specified capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the capacity is less than or equal to 0
     */
    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        } else {
            list = (T[]) new Object[capacity];
        }
    }
    /**
     * Constructs a new MyList object with the default initial capacity.
     */
    public MyList() {
        list = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds an element to the end of the list.
     * If the list is full, its capacity is increased.
     *
     * @param value the value to be added
     */
    public void add(T value) {
        if (size >= list.length) {
            increaseCapacity();
        }
      list [size++] = value;
    }

    /**
     * Adds an element at the specified position in the list.
     * If the list is full, its capacity is increased.
     *
     * @param value the value to be added
     * @param index the position at which the value should be added
     */
    public void add (T value, int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Индекс не найден");
        }
        if (size >= list.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i-1];
        }
        list[index] = value;
        size++;
    }

    /**
     * Deletes the element at the specified index from the list.
     * If the size of the list becomes less than or equal to 1.5 times its capacity,
     * its capacity is decreased.
     *
     * @param index the index of the element to be deleted
     */
    public void delete(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Индекс не найден");
        }
        for(int i = index; i < size; i++){
            list[i] = list[i+1];
        }
        size--;
        if (size <= (list.length / 1.5)) {
            decreaseCapacity();
        }
    }

    /**
     * Deletes the first occurrence of the specified value from the list.
     * If the value is not found in the list, a NoSuchElementException is thrown.
     *
     * @param value the value to be deleted
     * @throws NoSuchElementException if the value is not found in the list
     */
    public void delete(T value) {
        int position = getIndex(value);
        if (position < 0) {
            throw new NoSuchElementException("Элемент не найден");
        }
        delete(position);
        }
    /**
     * Displays all the elements in the list.
     */
    public void display() {
        for(T elem: list) {
                System.out.print(elem + " ");

        }
    }

    /**
     * Retrieves the element at the specified index from the list.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || index > size -1) {
            throw new IndexOutOfBoundsException("Индекс не найден");
        }
        return list[index];
    }

    /**
     * Sets the value of the element at the specified index in the list.
     * If the index is greater than the current capacity of the list,
     * its capacity is increased to accommodate the new index.
     *
     * @param value the new value to be set
     * @param index the index of the element to be set
     */
    public void set(T value, int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Индекс не найден");
        }
        list[index] = value;
    }

    /**
     * Gets the index of the first occurrence of the specified value in the list.
     *
     * @param value the value to search for
     * @return the index of the value, or -1 if the value is not found
     */
    public int getIndex(T value) {
        if (value == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (value.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets the current size of the list.
     *
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Overridden method that escapes the list.
     *
     * @return escapes the list to the console
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    /**
     * The method checks the list for emptiness.
     *
     * @return true - if empty, false - if there is at least one value in the list.
     */
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * Increases the capacity of the list by 1.5 times.
     */
    private void increaseCapacity() {
        T[] copyList = list;
        list = (T[])new Object[(int) (copyList.length * 1.5)];
        System.arraycopy(copyList, 0, list, 0, copyList.length);
    }

    /**
     * Decreases the capacity of the list to 1.5 times its current size.
     */
    private void decreaseCapacity() {
        T[] copyList = list;
        list = (T[])new Object[(int) (copyList.length / 1.5)];
        System.arraycopy(copyList, 0, list,0 , (int) (copyList.length / 1.5));
    }

}
