/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package island.project;

// Пустая клетка
public class EmptyCell  {
    static final protected int EMPTY = 0, GRASS = 1, RABBIT = 2, SNAKE = 3;
    public int type;
    public int x;
    public int y;
    int next;
    protected int[] neighbours = new int[4];
    public EmptyCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.type = EMPTY;
        this.next = EMPTY;
    }

    protected void clearNeighbours() {
        for (int i = 0; i < 4; i++) {
            neighbours[i] = 0;
        }
    }
    public String returnType(){ // Тип клетки: пустая
        return "E";
    }

    protected void calculateNeighbours(Island island) {
        clearNeighbours();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                int neighbourType = island.island[i][j].type;
                neighbours[neighbourType] += 1;
            }
        }
        neighbours[type] -= 1;
    }

    public EmptyCell getNextDayCell(Island island){
        calculateNeighbours(island);
        if (neighbours[SNAKE] >= 2) {
            return new Snake(x, y);
        } else if (neighbours[RABBIT] >= 2) {
            return new Rabbit(x, y);
        } else if (neighbours[GRASS] >= 1) {
            return new Grass(x, y);
        }
        return this;
    }

    public void print(){
        switch(this.type) {
            case EMPTY:
                System.out.print("E  ");
                break;
            case GRASS:
                System.out.print("G  ");
                break;
            case RABBIT:
                System.out.print("R  ");
                break;
            case SNAKE:
                System.out.print("S  ");
                break;
            default:
                // code block
        }
    }
}
