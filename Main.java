import java.util.Scanner;

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

        Scanner howMany = new Scanner(System.in);
        System.out.println("How many dice?");
        int diceNumber = howMany.nextInt();

        Scanner bility = new Scanner(System.in);
        System.out.println("Active Ability:"); System.out.println("1)'Nutin?'"); System.out.println("2)Lethal Hits:"); 
        System.out.println("3)Rapid Fire:"); System.out.println("4)Blast:"); System.out.println("5)Hazardus:");
        System.out.println("6)Sustained Hits:");
        int ability = bility.nextInt();
        Uppies hitType = new Uppies(0, ability, new int[]{0, 0});
        ability = hitType.abilities();
        System.out.println(ability);

        Scanner hitRoll = new Scanner(System.in);
        System.out.println("Hit roll?");
        int upOnHit = hitRoll.nextInt();
        Uppies uppieHit = new Uppies(diceNumber, upOnHit, new int[]{ability, 0});
        uppieHit.Checking();
        int[] success = uppieHit.getSuccess();
        System.out.println("");
        System.out.println("Go Through:" + success[0] + "     six:" + success[1]);

        Scanner woundRoll = new Scanner(System.in);
        System.out.println("Wound roll?");
        int upOnWound = woundRoll.nextInt();
        Uppies uppieWound = new Uppies(success[0], upOnWound, new int[]{0, 0});
        uppieWound.Checking();
        success = uppieWound.getSuccess();
        System.out.println("");
        System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
        
        } else {
            Scanner howMany = new Scanner(System.in);
            System.out.println("How many dice?");
            int diceNumber = howMany.nextInt();

            Scanner saveRoll = new Scanner(System.in);
            System.out.println("save Roll?");
            int upOnSave = saveRoll.nextInt();
            Uppies uppieSave = new Uppies(diceNumber, upOnSave, new int[]{0, 0});
            uppieSave.saveChecking();
            int[] success = uppieSave.getSuccess();


            Scanner perDice = new Scanner(System.in);
            System.out.println("Damage Per Dice?");
            int damPerDice = perDice.nextInt();

            Scanner noPain = new Scanner(System.in);
            System.out.println("Feel No Pain?"); System.out.println("1) yes"); System.out.println("2) no");
            int feelNoPain = noPain.nextInt();
            
            if (feelNoPain == 1)
            {
                Scanner fNoPain = new Scanner(System.in);
                System.out.println("FeelNoPain Save?");
                int FoPain = noPain.nextInt();

                Uppies uppieNoPain = new Uppies(diceNumber, upOnSave, new int[]{FoPain, damPerDice});
                uppieNoPain.feelNoPain();
                success = uppieNoPain.getSuccess();
                System.out.println("Failed:" + success[0] + "      Total Damage:" + success[1]);
            } else {
                System.out.println("Failed:" + success[0] + "      Total Damage:" + success[0] * damPerDice);
            }
        }
     }
    }
}