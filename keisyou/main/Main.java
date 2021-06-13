package keisyou.main;
import keisyou.subclass.Subbclass;
import keisyou.superclass.Ssuperclass;

public class Main{
    public static void main(String[] args){
        System.out.println("main start");
        Subbclass sub = new Subbclass(32);
        System.out.println("子クラスのフィールド：" + sub.weight);
        System.out.println("スーパークラスのフィールド" + sub.hi);
    }
}