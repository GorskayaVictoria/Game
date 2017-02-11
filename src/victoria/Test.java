package victoria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by Prog_1 on 11.12.2016.
 */
public class Test {
    public static void main(String[] args) {
        Stack<Cell> inter=new Stack<>();
        inter.push(new Cell(3));
        inter.push(new Cell(1));
        inter.push(new Cell(2));
        System.out.println(inter.elementAt(2).getValue());

//        for (Cell i:inter){
//            System.out.println(i.getValue());
//        }
        int size=inter.size();
        for (int i = 0; i <size ; i++) {
            System.out.println(inter.pop().getValue());
        }
    }
}
