package victoria;

import java.util.Random;

/**
 * Created by Prog_1 on 11.12.2016.
 */
public class RandomHelper {
    public static int getValue() {
        Random random= new Random();
        int proc= random.nextInt(100);
        if (proc<20) {
            return 4;
        } else {
            return 2;
        }
    }
}
