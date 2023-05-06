package src.main.java;

public class Base {
    private int health;
    private int x;
    private int y;
    private int healing;

    public Base(int health, int x, int y, int healing) {
        this.health = health;
        this.x = x;
        this.y = y;
        this.healing = healing;
    }

    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public int get_health(){
        return health;
    }
    public int get_healing(){
        return healing;
    }

    public void set_x(int x){
        this.x = x;
    }

    public void set_y(int y){
        this.y = y;
    }

    public void set_health(int health){
        this.health = health;
    }

    public void set_healing(int healing){
        this.healing = healing;
    }


    
}
