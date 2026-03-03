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
    public Uppies(int diceNumber, int check, int[] success) 
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



    public ArrayList<Integer> getNutin()
    {
        success[0] = 0;
        success[1] = 0;
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

                
      return diceResults;
    }

    public ArrayList<Integer> getHazard() 
    {

            Rolling rolling = new Rolling();
            diceResults = rolling.getDice(diceNumber);

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
                
            
                success[0] = success[0];
            
                  return diceResults;
    }


    public ArrayList<Integer> getLethal()
    {

        return diceResults;
    }
    public ArrayList<Integer> getSustained() 
{
        success[0] = 0;
        
        ArrayList<Integer> newDiceSus = new ArrayList<>();

        //lethal hits - START
        int lethals = success[1];
        //lethal hits - END


        //method for sustained hits
        int AmountMod = 0;
    
            Scanner howManySus = new Scanner(System.in);      //
            System.out.println("Sustained hits modifier?");  //asking sustained modifier
            AmountMod = howManySus.nextInt();               //

        int AmountSus = 0; //making the "six" amount variable
        
        for (int i = 0; i < diceResults.size();  i++) //going through dice amount
        {
                if (diceResults.get(i) == 6) //if a dice in the amount of dice rolled a six
                {

                        AmountSus = AmountSus + 1; //add one to the amout of "six" dice
            
                    AmountSus = AmountSus * AmountMod; //sustained amount times the sustained modifieer
                    Rolling rolling = new Rolling();
                    diceResults = rolling.getDice(AmountSus);
                }
        }
        return diceResults;
 }

public ArrayList<Integer> getBlast()
{
    int blastNumber = 0;
    ArrayList<Integer> newDiceBlast = new ArrayList<>();

    Scanner howMany = new Scanner(System.in);
    System.out.println("How many models in enemy unit?");
    blastNumber = howMany.nextInt() / 5; //number of enemy models in enemy unit
    Rolling rolling = new Rolling();
    diceResults = rolling.getDice(blastNumber);
    diceResults.addAll(newDiceBlast); //adding the blast list into the total rolls

    return diceResults;
}

//start method for rapid fire
public ArrayList<Integer> getRapid() 
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

        return diceResults;
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
