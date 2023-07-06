import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyListTests {
    private MyList<Integer> integerMyList;
    private MyList<String> stringMyList;

    @BeforeEach
    public void setup() {
        integerMyList = new MyList<>();
        stringMyList = new MyList<>();
    }

    @Test
    @DisplayName("Тест получения значение")
    public void testGet() {
        integerMyList.add(1);
        stringMyList.add("abc");

        assertEquals(1, integerMyList.get(0));
        assertEquals("abc",  stringMyList.get(0));
    }

    @Test
    @DisplayName("Тест ошибки без индекса при получении значения")
    public void testGet_IndexOutOfBounds() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        assertThrows(IndexOutOfBoundsException.class, () -> {integerMyList.get(4);});
        assertThrows(IndexOutOfBoundsException.class, () -> {stringMyList.get(4);});
    }

    @Test
    @DisplayName("Тест добавления")
    public void testAdd() {
        integerMyList.add(1);
        stringMyList.add("abc");

        assertEquals(1, integerMyList.get(0));
        assertEquals("abc",  stringMyList.get(0));
    }

    @Test
    @DisplayName("Тест добавления по индексу")
    public void testAddAtIndex() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(4);
        integerMyList.add(5);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        integerMyList.add(3, 2);
        stringMyList.add("ddd", 2);


        assertEquals(3, integerMyList.get(2));
        assertEquals("ddd",  stringMyList.get(2));
    }
    @Test
    @DisplayName("Тест ошибки без индекса при добавлении")
    public void testAdd_IndexOutOfBounds() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        assertThrows(IndexOutOfBoundsException.class, () -> {integerMyList.add(5, 4);});
        assertThrows(IndexOutOfBoundsException.class, () -> {stringMyList.add("ddd", 3);});
    }
    @Test
    @DisplayName("Тест удаление по индексу")
    public void testDeleteByIndex() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        integerMyList.delete(2);
        stringMyList.delete(1);

        assertEquals(4, integerMyList.get(2));
        assertEquals("cab",  stringMyList.get(1));
    }
    @Test
    @DisplayName("Тест ошибки без индекса при удалении")
    public void testDelete_IndexOutOfBounds() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        assertThrows(IndexOutOfBoundsException.class, () -> {integerMyList.delete(4);});
        assertThrows(IndexOutOfBoundsException.class, () -> {stringMyList.delete(3);});
    }

    @Test
    @DisplayName("Тест удаление по значению")
    public void testDeleteByValue() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        integerMyList.delete(integerMyList.get(2));
        stringMyList.delete("abc");

        assertEquals(4, integerMyList.get(2));
        assertEquals("bca",  stringMyList.get(0));
    }

    @Test
    @DisplayName("Тест ошибки не найденного значения")
    public void testDeleteByValue_NotFound() {
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        assertThrows(NoSuchElementException.class, () -> {stringMyList.delete("ddd");});
    }

    @Test
    @DisplayName("Тест дисплея")
    public void testDisplay() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        integerMyList.display();
        stringMyList.display();
    }

    @Test
    @DisplayName("Тест сета")
    public void testSet() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        integerMyList.set(5, 2);
        stringMyList.set("ddd", 0);

        assertEquals(5, integerMyList.get(2));
        assertEquals("ddd", stringMyList.get(0));
    }

    @Test
    @DisplayName("Тест ошибки не найденного индекса при сете")
    public void testSet_IndexOutOfBounds() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        assertThrows(IndexOutOfBoundsException.class, () -> {integerMyList.set(5, 5);});
        assertThrows(IndexOutOfBoundsException.class, () -> {integerMyList.set(5, -1);});
        assertThrows(IndexOutOfBoundsException.class, () -> {stringMyList.set("ddd", 3);});
    }

    @Test
    @DisplayName("Тест сета")
    public void testGetIndex() {
        integerMyList.add(1);
        stringMyList.add("abc");

        assertEquals(0, integerMyList.getIndex(1));
        assertEquals(0, stringMyList.getIndex("abc"));
    }

    @Test
    @DisplayName("Тест ошибки не найденного индекса при нахождении по индексу")
    public void testGetIndex_NotFound() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        assertEquals(-1, integerMyList.getIndex(5));
        assertEquals(-1, stringMyList.getIndex("ddd"));
    }

    @Test
    @DisplayName("Тест получения размера листа")
    public void testGetSize() {
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        stringMyList.add("abc");
        stringMyList.add("bca");
        stringMyList.add("cab");

        assertEquals(4, integerMyList.getSize());
        assertEquals(3, stringMyList.getSize());
    }

    @Test
    @DisplayName("Тест пустой ли список")
    public void testIsEmpty() {
        stringMyList.add("abc");

        assertEquals(true, integerMyList.isEmpty());
        assertEquals(false, stringMyList.isEmpty());
    }

}


