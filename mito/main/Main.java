package mito.main;

import mito.hero.Hero;
import mito.hero.Superhero;
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
        Superhero sh = new Superhero("hirosisannda-");
        
        System.out.println(h.hp);
        System.out.println(teki.Level);
        
        h.attack(teki);
        System.out.println(sh.name);
        sh.sleep();
        sh.flying();
        sh.land();
        //System.out.println(teki.Level);

    }
}

