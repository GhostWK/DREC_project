package engine.map;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by USER on 20.02.2017.
 */
public class Din {
    public static final int FLAT = 2;
    public static final int PLAIN = 3;
    public static final int MUTABLE = 4;
    public static final int MOUNTAIN = 5;

    public static int[] getSmoothRandom(int num, int first, int max, int downD, int upD){
        int[] arr = new int[num];
        Random r = new Random();
        arr[0] = first;
        for(int i = 1; i <num; i++){
            while (true){
                int temp = r.nextInt(max);
                if(temp < arr[i-1] + r.nextInt(upD) && temp > arr[i-1] - r.nextInt(downD)){
                    arr[i] = temp;
                    break;
                }
            }

        }
        return arr;
    }


}
