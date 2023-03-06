package com.mygdx.game.oop.Unit;

import java.util.ArrayList;

public interface GameInterface {
     void step(ArrayList<Person> team1, ArrayList<Person> team2);
     String getInfo();

}
