import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        MyList<Integer> array = new MyList<>();
        array.add(5);
        array.add(2);
        array.add(7);
        array.add(1);
        array.add(8);

        QuickSort.quickSort(array);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(5, array.get(2));
        assertEquals(7, array.get(3));
        assertEquals(8, array.get(4));
    }

    @Test
    public void testQuickSortWithSingleElementArray() {
        MyList<Integer> array = new MyList<>();
        array.add(5);

        QuickSort.quickSort(array);

        assertEquals(5, array.get(0));
    }

    @Test
    public void testQuickSortWithSortedArray() {
        MyList<Integer> array = new MyList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        QuickSort.quickSort(array);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
        assertEquals(4, array.get(3));
        assertEquals(5, array.get(4));
    }

    @Test
    public void testQuickSortWithReverseSortedArray() {
        MyList<Integer> array = new MyList<>();
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(2);
        array.add(1);

        QuickSort.quickSort(array);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
        assertEquals(4, array.get(3));
        assertEquals(5, array.get(4));
    }


    @Test
    public void testQuickSortWithEmptyArray() {
        MyList<Integer> array = new MyList<>();

        QuickSort.quickSort(array);

        assertTrue(array.isEmpty());
    }
}
