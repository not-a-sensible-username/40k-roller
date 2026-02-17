import java.util.ArrayList;

public class Uppies 
{
    int diceNumber;
    int check;
    int[] success;
    int damPerDice;
    ArrayList<Integer> diceResults;


    public Uppies(int diceNumber, int check, int[] success, int damPerDice) 
    {
        this.diceNumber = diceNumber;
        this.check = check;
        this.success = success;
        this.damPerDice = damPerDice;

        
        Rolling rolling = new Rolling(diceNumber, new ArrayList<>());
        diceResults = rolling.getDice();

    }

    public int[] Checking()
    {
     for (int i = 0; i < diceResults.size();  i++) 
      {
        if (diceResults.get(i) == 6)
        {
            success[1] = success[1] + 1;
        }

        if (diceResults.get(i) >= check) 
        {
            success[0] = success[0] + 1;
        }
      }
      return success;
    }

    public int[] saveChecking()
    {
        int total = diceResults.size();
     for (int i = 0; i < diceResults.size();  i++) 
      {
        if (diceResults.get(i) == 6)
        {
            success[1] = success[1] + 1;
        }

        if (diceResults.get(i) >= check) 
        {
            success[0] = success[0] + 1;
        }
      }
      success[0] = total - success[0]; 
      return success;
    }


    //make an array that takes each dice and puts it into one slot of the array one at a time
    //roll save against that damage
    //print an array of dice with the remaining damage left
    public ArrayList<Integer> feelNoPain()
    {
        ArrayList<Integer> finalDamPerDice = new ArrayList<>();
        ArrayList<Integer> damPerDice = new ArrayList<>();
    for (int j = 0; j < diceResults.size();  j++) 
    {
        for(int k = 0; k < success[0]; k++)
        finalDamPerDice.add(diceResults.get(j));
            for (int i = 0; i < finalDamPerDice.size();  i++) 
            {
                Rolling rollin = new Rolling(1, new ArrayList<>());
                rollin.getDice();
                if (diceResults.get(i) == 6)
                {
                   success[1] = success[1] + 1;
                }

                if (diceResults.get(i) >= check) 
                {
                damPerDice.add(diceResults.get(i));
                }
            }
    }
      return damPerDice;
    }


    public int[] getSuccess()
    {
        return success;
    }
}
