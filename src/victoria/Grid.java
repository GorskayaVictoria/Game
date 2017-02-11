package victoria;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Prog_1 on 11.12.2016.
 */
public class Grid implements IGrid{
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    private Cell[][] cells=new Cell[4][4];

    public Grid() {
        for (int i = 0; i <cells.length ; i++) {
            for (int j = 0; j <cells.length; j++) {
                cells[i][j]=new Cell(0);
            }
        }
     initRandomValues();
        //cells=initRandomValues().getCells();
    }

    private void initRandomValues() {
        Random random=new Random();
        int x=random.nextInt(4);
        int y=random.nextInt(4);
        cells[x][y].setValue(RandomHelper.getValue());
        int x1=random.nextInt(4);
        int y1=random.nextInt(4);
        while (x==x1&&y==y1) {
            x1=random.nextInt(4);
            y1=random.nextInt(4);
        }
        cells[x1][y1].setValue(RandomHelper.getValue());
    }
    @Override
    public void initRandomValues2(){

        Random random=new Random();
        int x=random.nextInt(4);
        int y=random.nextInt(4);
        while (cells[x][y].getValue()!=0) {
            x=random.nextInt(4);
            y=random.nextInt(4);
        }
        cells[x][y].setValue(RandomHelper.getValue());
    }

    public Cell[][] getCells() {
        return cells;
    }

    @Override
    public void mergeHorizontal(){//(int x, int y, int x1, int y1) {
        Stack<Cell> stackSell=new Stack<>();
        Cell cellBuf=null;

        for (int i = 0; i <cells.length; i++) {
            if (cells[i][0].getValue() != 0) {

            for (int j = 1; j <cells.length ; j++) {
                if (cells[i][j-1].getValue()==cells[i][j].getValue()){
                    cellBuf=new Cell(cells[i][j].getValue()+cells[i][j-1].getValue());
                    stackSell.push(cellBuf);
                    cells[i][j].setValue(0);
                    cells[i][j-1]=cellBuf;
                }
                stackSell.clear();
            }

        } else {
                for (int j = cells.length-2; j >0 ; j--) {
                    if (cells[i][j].getValue()==cells[i][j+1].getValue()){
                        cellBuf=new Cell(cells[i][j].getValue()+cells[i][j+1].getValue());
                        stackSell.push(cellBuf);
                        cells[i][j].setValue(0);
                        cells[i][j+1]=cellBuf;
                    }
                    stackSell.clear();
                }}



    }}


    @Override
    public void merge(){//(int x, int y, int x1, int y1) {
        Stack<Cell> stackSell=new Stack<>();
        Cell cellBuf=null;

        for (int j = 0; j <cells.length; j++) {
            if (cells[0][j].getValue() != 0) {

                for (int i = 1; i <cells.length ; i++) {
                    if (cells[i-1][j].getValue()==cells[i][j].getValue()){
                        cellBuf=new Cell(cells[i][j].getValue()+cells[i-1][j].getValue());
                        stackSell.push(cellBuf);
                        cells[i][j].setValue(0);
                        cells[i-1][j]=cellBuf;
                    }
                    stackSell.clear();
                }

            } else {
                for (int i = cells.length-2; i >0 ; i--) {
                    if (cells[i][j].getValue()==cells[i+1][j].getValue()){
                        cellBuf=new Cell(cells[i][j].getValue()+cells[i+1][j].getValue());
                        stackSell.push(cellBuf);
                        cells[i][j].setValue(0);
                        cells[i+1][j]=cellBuf;
                    }
                    stackSell.clear();
                }}



        }}






    @Override
    public void moveRight() {
        Stack<Cell> stackSell=new Stack<>();
        Cell cellBuf=null;
        for (int i = 0; i <cells.length ; i++) {
            for (int j = 0; j <cells.length ; j++) {
                if (cells[i][j].getValue()!=0) {
                    cellBuf=new Cell(cells[i][j].getValue());
                    stackSell.push(cellBuf);
                    cells[i][j].setValue(0);
                }
            }
            int j=cells[i].length-1;
            int size=stackSell.size();
            for (int k = 0; k <size ; k++) {
                cells[i][j].setValue(stackSell.pop().getValue());
                j--;
            }
            stackSell.clear();
        }
    }

    @Override
    public void moveLeft() {
        Stack<Cell> stackSell=new Stack<>();
        Cell cellBuf=null;
        for (int i = 0; i <cells.length ; i++) {
            for (int j = 0; j <cells.length ; j++) {
                if (cells[i][j].getValue()!=0) {
                    cellBuf=new Cell(cells[i][j].getValue());
                    stackSell.push(cellBuf);
                    cells[i][j].setValue(0);
                }
            }
            int j=0;

            for (Cell cell:stackSell){
                cells[i][j].setValue(cell.getValue());
                j++;
            }
            stackSell.clear();
        }
    }

    @Override
    public void moveUp() {
        Stack<Cell> stackSell=new Stack<>();
        Cell cellBuf=null;
        for (int j = 0; j <cells.length ; j++) {
            for (int i = 0; i <cells.length ; i++) {
                if (cells[i][j].getValue()!=0) {
                    cellBuf=new Cell(cells[i][j].getValue());
                    stackSell.push(cellBuf);
                    cells[i][j].setValue(0);
                }
            }
            int i=0;

            for (Cell cell:stackSell){
                cells[i][j].setValue(cell.getValue());
                i++;
            }
            stackSell.clear();
        }

    }

    @Override
    public void moveDown() {
        Stack<Cell> stackSell=new Stack<>();
        Cell cellBuf=null;
        for (int j = 0; j <cells.length ; j++) {
            for (int i = 0; i <cells.length ; i++) {
                if (cells[i][j].getValue()!=0) {
                    cellBuf=new Cell(cells[i][j].getValue());
                    stackSell.push(cellBuf);
                    cells[i][j].setValue(0);
                }
            }
            int i=cells[j].length-1;
            int size=stackSell.size();
            for (int k = 0; k <size ; k++) {
                cells[i][j].setValue(stackSell.pop().getValue());
                i--;
            }
            stackSell.clear();
        }

    }
}
