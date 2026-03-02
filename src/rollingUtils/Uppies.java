package rollingUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Uppies 
{
    int diceNumber; // TO BE PHASED OUT
    int check;
    int[] success;
    ArrayList<Boolean> choices;
    ArrayList<Integer> diceResults;

    Rolling roller;

    /**
     *To Be Phased Out
     */
    public Uppies(int diceNumber, int check, int[] success, ArrayList<Boolean> choices) 
    {
        this.diceNumber = diceNumber;
        this.check = check;
        this.success = success;
        this.choices = choices;
        

        Rolling rolling = new Rolling();
        diceResults = rolling.getDice(diceNumber);
    }


    public Uppies()
    {
        this.roller = new Rolling();
    }
    





    //METHODS


    public int abilities()
    {
        return this.check;
    }



    //This is a whole ass thing - rework completely
    public int[] Checking()
    {
        boolean lethal = choices.get(1);
        boolean rapid = choices.get(2);
        boolean blast = choices.get(3);
        boolean hazard = choices.get(4);
        boolean sustain = choices.get(5);


        success[0] = 0;
        
        ArrayList<Integer> newDiceSus = new ArrayList<>();

        //lethal hits - START
        int lethals = success[1];
        if (success[1] > lethals) //If Statement does Nothing?? 
            {//makes it so that lethals is enabled
            } 
        //lethal hits - END

        //method for hazardus
        if (hazard == true) 
        {
                ArrayList<Integer> hazDie = new ArrayList<>();
                Rolling rolling = new Rolling();
                diceResults = rolling.getDice(diceNumber);
                if (hazDie.get(0) == 1) 
                {
                    hazard = true;
                }
            
        }



            //method for blast ~ THEN MAKE IT A METHOD!!
            int blastNumber = 0;
        ArrayList<Integer> newDiceBlast = new ArrayList<>();

        if (blast == true) {
        Scanner howMany = new Scanner(System.in);
        System.out.println("How many models in enemy unit?");
        blastNumber = howMany.nextInt() / 5; //number of enemy models in enemy unit
        Rolling rolling = new Rolling();
        diceResults = rolling.getDice(blastNumber);
        diceResults.addAll(newDiceBlast); //adding the blast list into the total rolls
        }
        //method for blast

        //method for sustained hits
        int AmountMod = 0;
            if (sustain == true)
                {
            Scanner howManySus = new Scanner(System.in);      //
            System.out.println("Sustained hits modifier?");  //asking sustained modifier
            AmountMod = howManySus.nextInt();               //
                }
    int AmountSus = 0; //making the "six" amount variable
   for (int i = 0; i < diceResults.size();  i++) //going through dice amount
    {
                if (diceResults.get(i) == 6) //if a dice in the amount of dice rolled a six
                    {
                        AmountSus = AmountSus + 1; //add one to the amout of "six" dice
                    }
    }
            if (sustain == true) //if ability is sustained
        {
                    AmountSus = AmountSus * AmountMod; //sustained amount times the sustained modifieer
                    Rolling rolling = new Rolling();
                    diceResults = rolling.getDice(AmountSus);
        }

//end method for sustained hits

//start method for rapid fire
if (rapid == true)
    {
        Scanner rapidd = new Scanner(System.in);
        System.out.println("Rapid Fire modifier?"); //rapid fire modifier 
        int rapidF = rapidd.nextInt();

        Scanner wepCount = new Scanner(System.in);
        System.out.println("Weapon count?"); //number of weapons being shot
        int weponCount = wepCount.nextInt();

        int rapidFiredDice = rapidF * weponCount; //number of rapidFireDice 

        Rolling rolling = new Rolling(); // list of all the rapidFireDice

        diceResults = rolling.getDice(diceNumber);//adding the reapid fire dice to the base dicelist
    }
//end method for rapid fire

    // the threshhold for regular checks
    int firstDiceList = diceResults.size(); // count of the first dice list
    diceResults.addAll(newDiceSus); //adding sustained dice to the amount of regular dice
    success[1] = 0; // resets the six counter so it doesn't count lethal hits as sixes
    for (int i = 0; i < diceResults.size();  i++) 
    {
        System.out.print(" " + diceResults.get(i) + " "); //printing dice amount
            if (firstDiceList < diceResults.size())
            {
                if (diceResults.get(i) == 6)
                {
             // sustained hits keyworkd adder
                    if (sustain == true) 
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
            }
        

        if (diceResults.get(i) >= check) 
        {
            success[0] = success[0] + 1;
        }
    }
    //prints lethal hits
    if (lethal == true) 
        {
            System.out.println("");
        }
    //end print lethal hits

    //print hazardus 
    if (hazard == true) 
    {
        System.out.println("");
        System.out.println("");
        System.out.println("Pass Hazard save? " + hazard);
    }
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
        Rolling rolling = new Rolling();
        diceResults = rolling.getDice(success[0]);
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


    //returns success
    public int[] getSuccess()
    {
        return success;
    }
}
