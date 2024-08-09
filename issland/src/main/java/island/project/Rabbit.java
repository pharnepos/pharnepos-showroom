/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package island.project;

// Клетка с кроликом
public class Rabbit extends EmptyCell {
    
    int age = 0;

    public Rabbit(int x, int y) {
        super(x, y);
        this.type = RABBIT;
        this.next = RABBIT;
    }

    @Override
    public EmptyCell getNextDayCell(Island island){
        calculateNeighbours(island);
        if (neighbours[SNAKE] > 0 && neighbours[RABBIT] <= neighbours[SNAKE] ){
            return new EmptyCell(x, y);
        }
        if (this.age > 3){
            return new EmptyCell(x, y);
        }
        increaseAge();
        return this;
    }

    protected void increaseAge() {
        this.age += 1;
    }
}
