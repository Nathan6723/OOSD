package Interfaces;

import model.Cell;

public interface Mobility {
//public void move(int x1,int y1,int x2,int y2);

public boolean move(int x1,int y1,int x2,int y2,Cell i,Cell j);
}
