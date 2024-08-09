/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package island.project;

/**
 *
 * @author pharnepos
 */
import java.util.Random;
public class Island {
    
    EmptyCell[][] island = new EmptyCell[20][20]; // Основной массив

    EmptyCell[][] islandNextDay = new EmptyCell[20][20];
    
    // Метод вывода
    public void print(){
        for(int i = 0; i<this.island.length; i++){
            for(int j = 0; j<this.island[0].length; j++){
                this.island[i][j].print();
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
    }
    
    // Конструктор. Заполняет клетки случайным типом клетки
    public Island() {
        Random random = new Random();
        for(int i = 0; i<this.island.length; i++){
            for(int j = 0; j<this.island[0].length; j++){
                this.islandNextDay[i][j] =  new EmptyCell(i, j);
                if (i == 0 || j == 0 || i == this.island.length -1 || j == this.island[0].length - 1) {
                    this.island[i][j] =  new EmptyCell(i, j);
                } else {
                    switch (random.nextInt(4)) {
                        case 0:
                            this.island[i][j] = new Snake(i, j);
                            break;
                        case 1:
                            this.island[i][j] = new Rabbit(i, j);
                            break;
                        case 2:
                            this.island[i][j] = new Grass(i, j);
                            break;
                        case 3:
                            this.island[i][j] = new EmptyCell(i, j);
                            break;
                    }
                }
            }
        }
    }
    
    // Метод вычисления следующего дня.
    // Метод вызывает метод обновления у каждой клетки основного массива и заносит 
    // возвращенные значения во вспомогательный. После этого значения из 
    // вспомогательного массива переносятся в основной.
    private void passOneDay() {
        for(int i = 1; i<this.island.length - 1; i++){
            for(int j = 1; j<this.island[0].length - 1; j++){
                this.islandNextDay[i][j] = this.island[i][j].getNextDayCell(this);
            }
        }
        this.island = this.islandNextDay;
    }
    
    // Метод вычисления следующих n дней. Выводит обновленный остров каждый день.
    public void passNDays(int n){
        for(int day = 0; day<n; day++){
            this.passOneDay();
            this.print();
        }
    }
    
}
