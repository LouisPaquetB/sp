package src.main.java;

import java.lang.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

import graphics.*;
import graphics.exceptions.*;

public class TowerDefense implements TowerDefenseEventsHandlerInterface {
    // MACRO
    private final float DEFAULT_MONEY = 10;

    private final int DEFAULT_BASE_HEALTH = 1000;
    private final int DEFAULT_BASE_HEALING = 1000;
    private final int DEFAULT_BASE_X = 10;
    private final int DEFAULT_BASE_Y = 1;

    private final int UNLOCKED_TOWERS = 2;

    // GUI
    private TowerDefenseView view;

    // global
    private float global_money;
    private int wave;
    private int number_of_unlocked_towers;

    // elements
    private Base base;
    private final Tower tower[] = {
        new Tower((float)1, 1, 1, (float)1, 1, (float)100, TowerDefenseConstants.TOWER1_SPRITE_PATH, null),
        new Tower((float)1, 1, 1, (float)1, 2, (float)100, TowerDefenseConstants.TOWER2_SPRITE_PATH, null),
        new Tower((float)1, 1, 1, (float)1, 3, (float)100, TowerDefenseConstants.TOWER3_SPRITE_PATH, null),
        new Tower((float)1, 1, 1, (float)1, 4, (float)100, TowerDefenseConstants.TOWER4_SPRITE_PATH, null),
        new Tower((float)1, 1, 1, (float)1, 5, (float)100, TowerDefenseConstants.TOWER5_SPRITE_PATH, null),
        new Tower((float)1, 1, 1, (float)1, 6, (float)100, TowerDefenseConstants.TOWER6_SPRITE_PATH, null),
        new Tower((float)1, 1, 1, (float)1, 7, (float)100, TowerDefenseConstants.TOWER7_SPRITE_PATH, null),
        new Tower((float)1, 1, 1, (float)1, 8, (float)100, TowerDefenseConstants.TOWER8_SPRITE_PATH, null)
    };

    private TowerDefense(float money) {
        try {
            init();
        } catch (IOException e) {
            System.out.println("Failed to init GUI (" + e.getMessage() + ")");
        }
        view.promptNewGame();
    }
    private void init() throws IOException {
        view = new TowerDefenseView(this);
        base = new Base(DEFAULT_BASE_HEALTH, DEFAULT_BASE_X, DEFAULT_BASE_Y, DEFAULT_BASE_HEALING);
    }
    private void setMoney(float money) {
        global_money = money;
        if(global_money < 0) global_money = 0;
        view.updateMoney(global_money);
    }
    private void addMoney(float money) {
        if(money > 0) {
            global_money += money;
            view.updateMoney(global_money);
        }
    }
    private void removeMoney(float money) {
        if(money < 0) global_money -= money;
        if(global_money < 0) global_money = 0;
        view.updateMoney(global_money);
    }
    private void setWave(int wave) {
        if(wave <= 0) {this.wave = 1;}
        else {this.wave = wave;}
    }
    private void addWave() {
        this.wave++;
    }
    private void setNumberOfUnlockedTowers(int number) { 
        if(number < 0) this.number_of_unlocked_towers = 0;
        else if (number > UNLOCKED_TOWERS) this.number_of_unlocked_towers = UNLOCKED_TOWERS;
        else this.number_of_unlocked_towers = number;
    }
    private void addNumberOfUnlockedTowers() {
        if(this.number_of_unlocked_towers + 1 <= UNLOCKED_TOWERS) this.number_of_unlocked_towers++;
    }
    private void tryUnlockNewTower() throws UnknownTowerException {
        int i = 0;
        for(Tower value : this.tower) {
            if(value.get_unlock_level() == wave) {
                view.unlockTower(i);
                addNumberOfUnlockedTowers();
            }
            i++;
        }
    }

    @Override
    public void launchWave() {
        // start of wave
        System.out.println("Current wave : " + this.wave);

        // during the wave TO DO



        // end of wave
        addWave();
        try {
            tryUnlockNewTower();
        } catch (UnknownTowerException e) {
            System.out.println("Failed to end wave (" + e.getMessage() + ")");
        }
    }

    @Override
    public void moveTowerToField(int x, int y, int towerIndex) {
        if(towerIndex > 0 && towerIndex <= number_of_unlocked_towers) {
            try {
                view.updateTowerField(x, y, new ImageIcon(tower[towerIndex-1].getSprite()), 0);
            } catch (WrongTowerPositionException e) {
                System.out.println("Failed to set Tower wrongTowerPositionException (" + e.getMessage() + ")");
            } catch (EmptySpriteException e) {
                System.out.println("Failed to set Tower emptySpriteException (" + e.getMessage() + ")");
            }
        }
    }

    @Override
    public void startNewGame() {
        setMoney(DEFAULT_MONEY);
        setWave(1);
        setNumberOfUnlockedTowers(0);
        try {
            tryUnlockNewTower();
            view.updateBase(10, 1, DEFAULT_BASE_HEALTH, new ImageIcon(TowerDefenseConstants.BASE_SPRITE_PATH));
        } catch (WrongBasePositionException | EmptySpriteException | UnknownTowerException e) {
            System.out.println("Failed to start (" + e.getMessage() + ")");
        }
    }

    public static void main(String args[]) {
        // start the process
        new TowerDefense(10);
    }
}