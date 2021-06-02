package mito.hero;

import mito.enemy.Enemy;

public class Superhero extends Hero{
    public boolean flying;
    public void flying(){
        this.flying = true;
        System.out.println("飛んだ");
    }

    public void land(){
        this.flying = false;
        System.out.println("飛べない豚はただの豚だ");
    }

    public Superhero(String name){
        this.name = name;
        
    }
}