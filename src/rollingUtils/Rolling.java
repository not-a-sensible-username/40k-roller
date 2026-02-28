package rollingUtils;

import java.util.Random;
import java.util.ArrayList;


/**
 *
 *
 */
public class Rolling 
{
    private Random random = new Random();

    private ArrayList<Integer> diceResults = new ArrayList<>(); // this is also kinda pointless, it should be made in the getDice function to make the function static
    

    private int diceRollAmount; //this variable is kinda pointless, it should be an argument to the getDice function
    
    /**
     * USELESS CONSTRUCTOR -- refigure class to get rid of it later
     */
    public Rolling(int diceRollAmount, ArrayList<Integer> diceType) 
    {
        this.diceRollAmount = diceRollAmount;
        this.diceResults = diceType;
    }
    

    /**
     *This method returns an array of results, from the rolling  of a given amount of dice (given in constructor, might try and change later)
     *@return an array of d6 dice roll results
     */
    public ArrayList<Integer> getDice() 
    {
        
        for (int i = 0; i < diceRollAmount; i++) 
        {
        int diceRoll = random.nextInt(6) + 1;
            diceResults.add(diceRoll);
        }
        return diceResults; 
    }
}
