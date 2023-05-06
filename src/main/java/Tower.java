package src.main.java;

public class Tower {

    enum Power {
        poison,
        stun,
        burn,
        freeze,
        none
    }

    private float cost;
    private int range;
    private int damage_bullet;
    private float fire_rate;
    private int unlock_level;
    private float decay_timeout;
    private Power power;

    private String sprite;

    public Tower(float cost, int range, int damage_bullet, float fire_rate, int unlock_level, float decay_timout, String sprite, Power power){
        this.cost = cost;
        this.range = range;
        this.damage_bullet = damage_bullet;
        this.fire_rate = fire_rate;
        this.unlock_level = unlock_level;
        this.decay_timeout = decay_timout;
        this.sprite = sprite;
        this.power = power;
    }

    public float get_cost(){
        return cost;
    }

    public int get_range(){
        return range;
    }

    public int get_damage(){
        return damage_bullet;
    }

    public float get_fire_rate(){
        return fire_rate;
    }

    public int get_unlock_level(){
        return unlock_level;
    }

    public float get_decay_timeout(){
        return decay_timeout;
    }

    public String getSprite() {return this.sprite;}

    public Power get_power(){
        return power;
    }
}
