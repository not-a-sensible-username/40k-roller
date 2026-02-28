package utils;

import java.util.Random;
import java.util.ArrayList;

public class Rolling 
{
    Random random = new Random();

    ArrayList<Integer> diceResults = new ArrayList<>();
    int diceRollAmount;

    public Rolling(int diceRollAmount, ArrayList<Integer> diceType) 
    {
        this.diceRollAmount = diceRollAmount;
        this.diceResults = diceType;
    }
    
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
