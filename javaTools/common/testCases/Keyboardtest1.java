import com.oyos.Keyboard.util.*;
class Keyboardtest1 {
    public static void main(String[] args) {
        String a;
        Keyboard k=new Keyboard();
        System.out.println("enter a");
        a=k.getString();
        String b;
        System.out.println("Enter b");
        b=k.getString();
        System.out.println("string a= "+a);
        System.out.println("string b= "+b);
        System.out.println("end");
    }
}
