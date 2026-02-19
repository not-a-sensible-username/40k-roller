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

        ArrayList<Integer> newDice = new ArrayList<>();
        int abilitySub = 0;
//method for sustained hits
        int susAmountMod = 0;
        if (ability == 6)
        {
            abilitySub = 6;
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
                    Rolling rollingSus = new Rolling(susAmount, new ArrayList<>()); // rolling the sustained dice
                    newDice.addAll(rollingSus.getDice()); //putting the rolled sustained dice in a previously defined list
        }
    }

//end method for sustained hits

//start method for rapid fire
if (ability == 3)
    {
        Scanner rapid = new Scanner(System.in);
        System.out.println("Rapid Fire modifier?"); //rapid fire modifier 
        int rapidF = rapid.nextInt();

        Scanner wepCount = new Scanner(System.in);
        System.out.println("Weapon count?"); //number of weapons being shot
        int weponCount = wepCount.nextInt();

        int rapidFiredDice = rapidF * weponCount; //number of rapidFireDice 

        Rolling rollingRapid = new Rolling(rapidFiredDice, new ArrayList<>()); // list of all the rapidFireDice

        diceResults.addAll(rollingRapid.getDice()); //adding the reapid fire dice to the base dicelist
    }
//end method for rapid fire

    // the threshhold for regular checks
    int firstDiceList = diceResults.size(); // count of the first dice list
    diceResults.addAll(newDice); //adding sustained dice to the amount of regular dice
    ability = 1;
    for (int i = 0; i < diceResults.size();  i++) 
    {
        System.out.print(" " + diceResults.get(i) + " "); //printing dice amount
        if (ability == 1)
        {
            if (firstDiceList < diceResults.size())
            {
                if (diceResults.get(i) == 6)
                {
             // sustained hits keyworkd adder
                    if (abilitySub == 6) 
                        {
                            System.out.print("SUSTAINED!"); //show sustained
                            success[1] = success[1] + 1;
                            firstDiceList = firstDiceList + susAmountMod;
                        }
             // end sustained hits keyworkd adder 
                }
            } else {
            if (diceResults.get(i) == 6)
                {
                            success[1] = success[1] + 1;
                }
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
                System.out.print(" " + diceResults.get(i) + " ");
                System.out.print("");
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
            }
            System.out.println(diceResults.get(i));
            
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
