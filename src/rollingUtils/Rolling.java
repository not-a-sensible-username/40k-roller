package rollingUtils;

import java.util.Random;
import java.util.ArrayList;


/**
 * The Rolling class is used for generating and manipulating a large amount of randomly generated numbers from 1-6 or 1-3
 */
public class Rolling 
{
    private Random random; // generates random numbers



    /**
     *The Main Constructor for the Rolling Class, initializes random
     */
    public Rolling()
    {   
        this.random = new Random();
    }
    


    /**
     *@Param diceAmount
     *
     */
    public ArrayList<Integer> getDice(final int diceAmount){
        ArrayList<Integer> returnable = new ArrayList<Integer>();
        int temp;
        for(int i = 0; i < diceAmount; i++)
        {
            temp = (this.random).nextInt(6) + 1;
            returnable.add(temp);
        }

        return returnable;

    }
}
