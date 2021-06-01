package mito.hero;

public class Hero{
    public int hp;
    public String name;

    public void sleep(){
        this.hp += 5;
        System.out.println(this.name + "は回復した。");
    }
    public Hero(String name){
        System.out.println("hi");
        this.hp = 100;
        this.name = name;
        //this.name = name;
        //System.out.println(this.hp/* + this.name*/ + "コンストラクタ");
    }
    /*    public static void main(String[] args){
        Hero anyone = new Hero();
        System.out.println(anyone.hp);
    
    }*/
}