package src.main.java;

import java.lang.*;
import java.io.*;
import java.util.*;

import graphics.*;
import src.main.java.TowerDefenseHandler;

public class TowerDefense {
    public static void main(String args[]) {
        TowerDefenseHandler handler = new TowerDefenseHandler();
        try {
            TowerDefenseView view = new TowerDefenseView(handler);
        } catch (IOException e) {
            System.out.println("Failed to init GUI (" + e.getMessage() + ")");
        }
    }
}