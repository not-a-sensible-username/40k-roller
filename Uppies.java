import java.util.ArrayList;

public class Uppies 
{
    int diceNumber;
    int check;
    int[] success;

    ArrayList<Integer> diceResults;


    public Uppies(int diceNumber, int check, int[] success) 
    {
        this.diceNumber = diceNumber;
        this.check = check;
        this.success = success;

        
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
        for (int i = 0; i < diceResults.size();  i++) 
            {
                if (diceResults.get(i) < check) 
                {
                success[0] = success[0] + 1;
                }
            }
            return success;
    }


    
    public int[] feelNoPain()
    {
        int noPainCheck = success[0];
        success[0] = 0;
        for (int i = 0; i < diceResults.size();  i++) 
        {
            if (diceResults.get(i) < check) 
            {
            success[0] = success[0] + 1;
            System.out.println(success[0]);
            }
            
        }
        int diceSaver = success[0]; //4
        success[0] = success[0] * success[1]; //8
        System.out.println("div");
        Rolling rollin = new Rolling(success[0], new ArrayList<>());
        diceResults = rollin.getDice();
        int diceAmount = 0;
        for (int i = 0; i < success[0]; i++) //8
        {
            if (diceResults.get(i) >= noPainCheck) //# < 4+
                {
                success[0] = success[0] - 1; //14 
                diceAmount = diceAmount + 1;
                System.out.println(diceResults.get(i));
                }
        }
        diceSaver = diceSaver - (diceAmount / success[1]);
        success[1] = success[0]; //2 = 7
        success[0] = diceSaver; //7 = 4
        return success;
    }


    public int[] getSuccess()
    {
        return success;
    }
}
