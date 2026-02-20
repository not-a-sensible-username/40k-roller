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

        //lethal hits
        int lethals = success[1];
        boolean lethalTrue = false;
        if (success[1] > 0) 
            {
                lethalTrue = true; //makes it so that lethals is enabled
            } 
        //lethal hits

        //method for hazardus
        boolean hazardus = false;
        if (ability == 5) 
            {
                ArrayList<Integer> hazDie = new ArrayList<>();
                Rolling rolling = new Rolling(1, new ArrayList<>()); //rolls number of dice equal to blast
                hazDie.addAll(rolling.getDice()); //puts hazdie into list
                if (hazDie.get(0) == 1) 
                    {
                        hazardus = true;
                    }

            }

//method for sustained hits
        int AmountMod = 0;
        if (ability != 1)
        {

            //method for blast
        int blastNumber = 0;
        ArrayList<Integer> newDiceBlast = new ArrayList<>();

        if (ability == 4) {
        Scanner howMany = new Scanner(System.in);
        System.out.println("How many models in enemy unit?");
        blastNumber = howMany.nextInt() / 5; //number of enemy models in enemy unit
        Rolling rolling = new Rolling(blastNumber, new ArrayList<>()); //rolls number of dice equal to blast
        newDiceBlast.addAll(rolling.getDice()); //puts the blast number into a list
        }

        diceResults.addAll(newDiceBlast); //adding the blast list into the total rolls
        //method for blast

        // 
            if (ability == 6)
                {
            Scanner howManySus = new Scanner(System.in);      //
            System.out.println("Sustained hits modifier?");  //asking sustained modifier
            AmountMod = howManySus.nextInt();               //
                }
        }
    if (ability != 1)
{
    int Amount = 0; //making the "six" amount variable
   for (int i = 0; i < diceResults.size();  i++) //going through dice amount
    {
                if (diceResults.get(i) == 6) //if a dice in the amount of dice rolled a six
                    {
                        Amount = Amount + 1; //add one to the amout of "six" dice
                    }
            if (ability == 6) //if ability is sustained
        {
                    Amount = Amount * AmountMod; //sustained amount times the sustained modifieer
                    Rolling rollingSus = new Rolling(Amount, new ArrayList<>()); // rolling the sustained dice
                    newDice.addAll(rollingSus.getDice()); //putting the rolled sustained dice in a previously defined list
                    abilitySub = 6;
        }
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
    success[1] = 0; // resets the six counter so it doesn't count lethal hits as sixes
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
                            firstDiceList = firstDiceList + AmountMod;
                        }
             // end sustained hits keyworkd adder 
                }
            } else {
            if (diceResults.get(i) == 6)
                {
                            success[1] = success[1] + 1;
                }
                if (ability == 2) 
                    {
                        
                    }
            }
        
        }

        if (diceResults.get(i) >= check) 
        {
            success[0] = success[0] + 1;
        }
    }
    //prints lethal hits
    if (lethalTrue) 
        {
            System.out.println("");
            System.out.println("Lethal hits: " + lethals);
        }
    //end print lethal hits

    //print hazardus 
        System.out.println("");
        System.out.println("");
        System.out.println("Pass Hazard save? " + hazardus);
    //print hazardus
    success[0] = success[0] + lethals;

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
        System.out.print("");
        int noPainCheck = success[0];
        success[0] = 0;
        System.out.print("T: ");
        for (int i = 0; i < diceResults.size();  i++) 
        {
            if (diceResults.get(i) < check) 
            {
            success[0] = success[0] + 1;
            }
            System.out.print(" " + diceResults.get(i) + " ");
            
        }
        int diceSaver = success[0]; //4
        success[0] = success[0] * success[1]; //8
        System.out.println("");
        Rolling rollin = new Rolling(success[0], new ArrayList<>());
        diceResults = rollin.getDice();
        int diceAmount = 0;
        System.out.print("P: ");
        for (int i = 0; i < success[0]; i++) //8
        {
            if (diceResults.get(i) >= noPainCheck) //# < 4+
                {
                success[0] = success[0] - 1; //14 
                diceAmount = diceAmount + 1;
                System.out.print(" " + diceResults.get(i) + " ");
                }
        }
        System.out.println("");
        diceSaver = diceSaver - (diceAmount / success[1]);

        int total = diceAmount + success[0];

        success[1] = success[0]; //2 = 7
        success[0] = diceSaver; //7 = 4
        return success;
    }
    public int[] getSuccess()
    {
        return success;
    }
}