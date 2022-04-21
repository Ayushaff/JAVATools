import com.oyos.list.util.*;
 class myiteratorTest {
    public static void main(String[] args) {
        myLinkedList list1=new myLinkedList();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        myArrayList list2=new myArrayList();
        list2.add(11);
        list2.add(22);
        list2.add(33);
        list2.add(44);

        System.out.println("iterating linked list ");
        myiterator i1=list1.iterator();
        for(int i=0;i1.hasNext();i++){
            int x;
            x=i1.next();
            System.out.println(x);
        }
        System.out.println("iterating array list ");
        myiterator i2=list2.iterator();
        for(int i=0;i2.hasNext();i++){
            int x;
            x=i2.next();
            System.out.println(x);
        }
        //accessing after iterator pointer at null or at end of iteration
        int x;
        x=i2.next();
        System.out.println(x);
    }
}
