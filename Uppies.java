import java.util.ArrayList;
import java.util.Scanner;

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

    public int abilities()
    {
        return check;
    }

    public int[] Checking()
    {
        int ability = success[0];
        success[0] = 0;

        //method for sustained hits
        ArrayList<Integer> newDice = new ArrayList<>(); 
        int susAmountMod = 0;
        if (ability == 6)
        {
            Scanner howManySus = new Scanner(System.in); //
            System.out.println("Sustained hits modifier?");  // asking sustained modifier
            susAmountMod = howManySus.nextInt();    //
        }
    for (int i = 0; i < diceResults.size();  i++) //going through dice amount
    {
        if (ability == 6) //if ability is sustained
        {
            int susAmount = 0; //making the sustained amount variable
                if (diceResults.get(i) == 6) //if a dice in the amount of dice rolled a six
                    {
                        susAmount = susAmount + 1; //add one to the amout of sustained dice
                    }
                    susAmount = susAmount * susAmountMod; //sustained amount times the sustained modifieer
                    Rolling rolling = new Rolling(susAmount, new ArrayList<>()); // rolling the sustained dice
                    newDice.addAll(rolling.getDice()); //putting the rolled sustained dice in a previously defined list
        }
    }

    // the threshhold for regular checks
    diceResults.addAll(newDice); //adding sustained dice to the amount of regular dice
    ability = 1;
    for (int i = 0; i < diceResults.size();  i++) 
    {
        System.out.print(" " + diceResults.get(i) + " "); //printing dice amount
        
            if (ability == 1)
            {
                if (diceResults.get(i) == 6)
                {
                    System.out.print("SUSTAINED!"); //show sustained
                    success[1] = success[1] + 1;
                }
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
