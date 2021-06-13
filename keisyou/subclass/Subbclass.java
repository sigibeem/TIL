package keisyou.subclass;
import keisyou.superclass.Ssuperclass;

public class Subbclass extends Ssuperclass{
    public int weight;
    public Subbclass(int weight){
        //super();
        super("hello", 21);
        this.weight = weight;
        System.out.println("hi subclass");
    }
}