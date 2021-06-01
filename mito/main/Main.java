package mito.main;

import mito.hero.Hero;
import mito.enemy.Enemy;

public class Main{
    public static void main(String[] args){
        /*Hero h = new Hero("hiroshi");
        Enemy mobu = new Enemy(100);
        h.sleep();
        System.out.println("h.name");
        System.out.println(h.getClass());
        System.out.println(h.hp);
        System.out.println("h.hp");
    */
        Hero h = new Hero("hiroshi");
        Enemy teki = new Enemy(100);
        System.out.println(h.hp);
        System.out.println(h.hp);
        //System.out.println(teki.Level);

    }
}

