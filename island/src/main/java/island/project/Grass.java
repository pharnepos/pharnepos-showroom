/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package island.project;

// Клетка с травой
public class Grass extends EmptyCell {

    public Grass(int x, int y) {
        super(x, y);
        this.type = GRASS;
        this.next = GRASS;
    }
    
    @Override
    public EmptyCell getNextDayCell(Island island){
        calculateNeighbours(island);
        if (neighbours[RABBIT] > neighbours[GRASS] ){
            return new EmptyCell(x, y);
        }
        return this;
    }
}
