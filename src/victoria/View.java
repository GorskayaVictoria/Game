package victoria;

import java.util.Scanner;

/**
 * Created by Prog_1 on 11.12.2016.
 */
public class View {
    private Grid grid;

    public View() {
        grid=new Grid();
    }

    public void start (){
        while (true){
            Scanner scanner= new Scanner(System.in);
            String chose= scanner.nextLine();
            switch (chose){
                case "d": grid.moveRight();
                    grid.mergeHorizontal();
                    grid.moveRight();
                    grid.initRandomValues2();
                    print();
                    break;
                case "a": grid.moveLeft();
                    grid.mergeHorizontal();
                    grid.moveLeft();
                    grid.initRandomValues2();
                    print();
                    break;
                case "w": grid.moveUp();
                    grid.merge();
                    grid.moveUp();
                    grid.initRandomValues2();
                    print();
                    break;
                case "z": grid.moveDown();
                    grid.merge();
                    grid.moveDown();
                    grid.initRandomValues2();
                    print();
                    break;

                //case "m": grid.merge();
                  //  print();
                  //  break;


            }
        }

    }

    public void print(){
        for (int i = 0; i <grid.getCells().length ; i++) {
            for (int j = 0; j <grid.getCells().length ; j++) {
                System.out.print(grid.getCells()[i][j].getValue()+" ");
            }
            System.out.println();
        }
    }
}
