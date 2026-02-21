import java.util.Scanner;
import java.util.ArrayList;

/*

Main plan: make a rolling progam for warhammer 40k 10th,
main will run uppies and rolling, nothing else.

what rolling will do is it will wait for a user input of *number* dice
it will then roll said dice and give, and also take note of how many 6's, 5's, 4's, 3's, 2's, and 1's are rolled..

it will give these stats to uppies, what uppies will do is wait for another user input of
*number*, it will count how many of the dice are greater than or equal to the given number. 
It will also print how many of the dice are six

It will then give this to main where main will print how many dice are greater or equal and how many dice are six
Like so: "S:5, 6:2" S stands for successes and 6 stands for sixes. 
The program will then wait for the next round and do it again.
*/
public class Main 
{
    public static void main(String[] args) 
    {
     int continuous = 0;
     while (continuous == 0) 
     {
        Scanner sixOrSeven = new Scanner(System.in);
        System.out.println("1) Hit"); System.out.println("or"); System.out.println("2) save");
        int hitOrSave = sixOrSeven.nextInt();

        if (hitOrSave == 1) 
        {

        //ability
        Scanner bility = new Scanner(System.in);
        int ability = 0;
        boolean subAbility1 = false;
        boolean subAbility2 = false;
        boolean subAbility3 = false;
        boolean subAbility4 = false;
        boolean subAbility5 = false;
        boolean subAbility6 = false;
        ArrayList<Boolean> abilities = new ArrayList<>();
        while (ability != 1) 
            {
                bility = new Scanner(System.in);
                System.out.println("Active Ability:");
            
                        if (subAbility1 == false)
                            {
                            System.out.println("1)'Nutin?'");
                            }
                        if (subAbility1 == true)
                            {
                            System.out.println("1)No other abilities");
                            }
              if (ability != 2)
                { 
                    if (subAbility2 == false)
                        {
                        System.out.println("2)Lethal Hits:");
                        }
                } else 
                    {
                        subAbility2 = true;
                    }
            if (ability != 3)
                {
                    if (subAbility3 == false)
                        {
                            System.out.println("3)Rapid Fire:");
                        } 
                } else 
                    {
                        subAbility3 = true;
                    }
            if (ability != 4)
                {
                    if (subAbility4 == false)
                        {
                            System.out.println("4)Blast:");
                        }
                } else 
                    {
                        subAbility4 = true;
                    }
            if (ability != 5)
                {
                    if (subAbility5 == false)
                        {
                            System.out.println("5)Hazardus:"); 
                        }
                } else 
                    {
                        subAbility5 = true;
                    }
            if (ability != 6)
                {
                    if (subAbility6 == false)
                        {
                            System.out.println("6)Sustained Hits:");
                        }
                } else 
                    {
                        subAbility6 = true;
                    }
                ability = bility.nextInt();
                subAbility1 = true;
            }
            abilities.add(subAbility1); abilities.add(subAbility2); abilities.add(subAbility3); abilities.add(subAbility4); abilities.add(subAbility5); abilities.add(subAbility6);

        //dice amount
        Scanner howMany = new Scanner(System.in);
        System.out.println("How many dice?");
        int diceNumber = howMany.nextInt();

        Uppies hitType = new Uppies(0, ability, new int[]{0, 0}, abilities);
        ability = hitType.abilities();

        //hit
        Scanner hitRoll = new Scanner(System.in); 
        System.out.println("Hit roll?");
        int upOnHit = hitRoll.nextInt();
        Uppies uppieHit = new Uppies(diceNumber, upOnHit, new int[]{ability, 0}, abilities);
        uppieHit.Checking();
        int[] success = uppieHit.getSuccess();
        System.out.println("");
        System.out.println("Go Through:" + success[0] + "     six:" + success[1]);

        subAbility1 = false;
        subAbility2 = false;
        subAbility3 = false;
        subAbility4 = false;
        subAbility5 = false;
        subAbility6 = false;
        abilities.remove(subAbility1); abilities.add(subAbility2); abilities.add(subAbility3); abilities.add(subAbility4); abilities.add(subAbility5); abilities.add(subAbility6);
        abilities.add(subAbility1); abilities.add(subAbility2); abilities.add(subAbility3); abilities.add(subAbility4); abilities.add(subAbility5); abilities.add(subAbility6);

        //wound
        if (ability == 2) //if lethal hits
            {
                
                Scanner woundRoll = new Scanner(System.in);
                System.out.println("Wound roll?");
                int upOnWound = woundRoll.nextInt();
                Uppies uppieWound = new Uppies(success[0] - success[1], upOnWound, new int[]{0, success[1]}, abilities);
                uppieWound.Checking();
                success = uppieWound.getSuccess();
                System.out.println("");
                System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
            }       //end of if thetal hits
            else {
        Scanner woundRoll = new Scanner(System.in);
        System.out.println("Wound roll?");
        int upOnWound = woundRoll.nextInt();
        Uppies uppieWound = new Uppies(success[0], upOnWound, new int[]{0, 0}, abilities);
        uppieWound.Checking();
        success = uppieWound.getSuccess();
        System.out.println("");
        System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
            }
        
        } else {
            Scanner howMany = new Scanner(System.in);
            System.out.println("How many dice?");
            int diceNumber = howMany.nextInt();

            Scanner saveRoll = new Scanner(System.in);
            System.out.println("save Roll?");
            int upOnSave = saveRoll.nextInt();

            Scanner perDice = new Scanner(System.in);
            System.out.println("Damage Per Dice?");
            int damPerDice = perDice.nextInt();

            Scanner noPain = new Scanner(System.in);
            System.out.println("Feel No Pain?"); System.out.println("1) yes"); System.out.println("2) no");
            int feelNoPain = noPain.nextInt();

            Uppies uppieSave = new Uppies(diceNumber, upOnSave, new int[]{0, 0},  new ArrayList<>());
            uppieSave.saveChecking();
            int[] success = uppieSave.getSuccess();
            if (feelNoPain == 1)
            {
                Scanner fNoPain = new Scanner(System.in);
                System.out.println("");
                System.out.println("FeelNoPain Save?");
                int FoPain = noPain.nextInt();

                Uppies uppieNoPain = new Uppies(diceNumber, upOnSave, new int[]{FoPain, damPerDice},  new ArrayList<>());
                uppieNoPain.feelNoPain();
                success = uppieNoPain.getSuccess();
                System.out.println("Failed:" + success[0] + "      Total Damage:" + success[1]);
            } else {
                System.out.println("");
                System.out.println("Failed:" + success[0] + "      Total Damage:" + success[0] * damPerDice);
            }
        }
     }
    }
}