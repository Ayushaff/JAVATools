import com.oyos.list.util.*;

class myLinkedListTest {
    public static void main(String[] args) {
        myLinkedList list1 = new myLinkedList();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        for (int x = 0; x < list1.getSize(); x++) {
            System.out.println(list1.get(x));
        }

        System.out.println("**************");
        myLinkedList list2 = new myLinkedList();
        for(int i=1;i<8;i++){
            list2.add(i);
        }
        for (int i = 0; i < list2.getSize(); i++) {
            System.out.println(list2.get(i));
        }

        System.err.println(list2.removeAt(3));
        System.err.println(list2.removeAt(2));
        System.out.println("list : ");
        for (int i = 0; i < list2.getSize(); i++) {
            System.out.println(list2.get(i));
        }
        System.out.println("**************");

        list2.update(1,111);
        System.out.println("list : ");
        for (int i = 0; i < list2.getSize(); i++) {
            System.out.println(list2.get(i));
        }
        System.out.println("**************");
        myLinkedList list3=new myLinkedList();
        list2.appendTo(list3);
        list3.appendFrom(list2);
        for (int i = 0; i < list3.getSize(); i++) {
            System.out.println(list3.get(i));
        }
        System.out.println("**************");
        System.out.println("end");

    }
}
