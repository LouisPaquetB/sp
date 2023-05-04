package src.main.java;

public class Tower {

    enum Power {
        poison,
        stun,
        burn,
        freeze
    }

    private float cost;
    private int range;
    private int damage_bullet;
    private float fire_rate;
    private int unlock_level;
    private float decay_timeout;
    private Power power;

    public Tower(float cost, int range, int damage_bullet, float fire_rate, int unlock_level, float decay_timout){
        this.cost = cost;
        this.range = range;
        this.damage_bullet = damage_bullet;
        this.fire_rate = fire_rate;
        this.unlock_level = unlock_level;
        this.decay_timeout = decay_timout;


    }
}
