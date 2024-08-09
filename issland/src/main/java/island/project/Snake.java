/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package island.project;

// Клетка со змеей
public class Snake extends Rabbit {

    public Snake(int x, int y) {
        super(x, y);
        this.type = SNAKE;
        this.next = SNAKE;
    }

    @Override
    public EmptyCell getNextDayCell(Island island){
        calculateNeighbours(island);
        if (neighbours[SNAKE] > 5){
            return new EmptyCell(x, y);
        }
        if (this.age > 6){
            return new EmptyCell(x, y);
        }
        increaseAge();
        return this;
    }
}
