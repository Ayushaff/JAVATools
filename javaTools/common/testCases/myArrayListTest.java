import com.oyos.list.util.*;

class myArrayListTest {
    public static void main(String[] args) {
        myArrayList list1 = new myArrayList();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        for (int x = 0; x < list1.getSize(); x++) {
            System.out.println(list1.get(x));
        }
        System.out.println("**************");
        myArrayList list2 = new myArrayList();
        list2.copyFrom(list1);
        for (int i = 0; i < list2.getSize(); i++) {
            System.out.println(list2.get(i));
        }
        System.out.println(list2.removeAt(2));
        for (int i = 0; i < list2.getSize(); i++) {
            System.out.println(list2.get(i));
        }
                
    }
}
