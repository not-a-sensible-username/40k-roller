package rollingUtils;

import java.util.Random;
import java.util.ArrayList;


/**
 * The Rolling class is used for generating and manipulating a large amount of randomly generated numbers from 1-6 or 1-3
 */
public class Rolling 
{
    private Random random; // generates random numbers

    private ArrayList<Integer> diceResults = new ArrayList<>(); //TO BE PHASED OUT    
    private int diceRollAmount; // To be phased out
    
    /**
     * TO BE PHASED OUT 
     */
    public Rolling(int diceRollAmount, ArrayList<Integer> diceType) 
    {
        this.random = new Random();
        this.diceRollAmount = diceRollAmount;
        this.diceResults = diceType;
    }



    /**
     *The Main Constructor for the Rolling Class, initializes random
     */
    public Rolling()
    {   
        this.random = new Random();
        this.diceRollAmount = 0;
    }
    



    /**
     *TO BE PHASED OUT
     * */
    public ArrayList<Integer> getDice() 
    {
        
        for (int i = 0; i < diceRollAmount; i++) 
        {
            int diceRoll = random.nextInt(6) + 1;
            diceResults.add(diceRoll);
        }
        return diceResults; 
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
