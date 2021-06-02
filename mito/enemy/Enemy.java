package mito.enemy;

public class Enemy{
    public int hp;
    public final int Level = 10;

    public void nigeru(){
        System.out.println("にっげろー");
    }
    public Enemy(int hp){
        this.hp = hp;

        System.out.println("体力：" + this.hp);
    }
}