/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n_queens;

/**
 *
 * @author kulkarni
 */
public class Queen {

    private int r;
    private int c;


    public Queen(int r, int c){
        this.r = r;
        this.c = c;
    }

    public boolean checkAttack(Queen q) {
        return this.r == q.getRows() ||
                this.c == q.getColumns() ||
                Math.abs(this.c - q.getColumns()) == Math.abs(r - q.getRows());
    }

    public void goDown(int spaces) {

        r = (r + spaces) % Node.getSize();
    }


    public int getRows(){
        return r;
    }


    public int getColumns(){
        return c;
    }

    public String toString(){
        return "(" + r + ", " + c + ")";
    }
}