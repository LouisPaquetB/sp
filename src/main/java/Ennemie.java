package src.main.java;

public class Ennemie {
    //final public private protected int var = 1; static = partage
    private float reward;
    private int health;
    private int range;
    private int speed;
    private int damage_bullet;
    private float fire_rate;


    public Ennemie(float reward, int health, int range, int speed, int damage_bullet, float fire_rate){
        this.reward = reward;
        this.health = health;
        this.range = range;
        this.speed = speed;
        this.damage_bullet = damage_bullet;
        this.fire_rate = fire_rate;

    }

    public float get_reward(){
        return reward;
    }

    public int get_health(){
        return health;
    }


}
