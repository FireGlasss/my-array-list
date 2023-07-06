import java.util.Collections;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        MyList<String> my = new MyList<>();
        MyList<Integer> my = new MyList<>();
//        my.add(111);
//        my.add(112);
//        my.add(111);
//        my.add(111);
//        my.add(115);
//        my.add(116);
//        my.add(117);
//        my.add(118);
//        my.add(119);
//        my.add(121);
//        my.add(122);
//        my.add("abc");
//        my.add("bbb");
//        my.add("acc");
//        my.add("aaa");
//        my.add("abb");
//        my.add("ccc");
//        my.add("aac");
//        my.add("aab");
//        my.add("cca");
//        my.add("cba");
//        my.add("daa");

//        my.add(1111, 2);
//        my.set(555, 5);
//        my.add("ddc", 2);
//        my.set("cdd", 5);


        QuickSort.quickSort(my);
        System.out.println(my);
    }
}
