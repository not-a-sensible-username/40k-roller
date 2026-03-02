package main;

//Java Library Imports
import java.util.Scanner;
import java.util.ArrayList;

//Project Imports
import rollingUtils.Uppies;
import rollingUtils.Rolling;
import scannerUtils.SuperScanner;



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
    
    //Methods - START
    
   


    //Methods - END







    public static void main(String[] args) 
    {
       
        SuperScanner scc = new SuperScanner();
        
       



        while (true) 
        {

            System.out.println("0) Exit");
            System.out.println("or");
            System.out.println("1) Hit"); 
            System.out.println("or"); 
            System.out.println("2) save");
        
            int hitOrSave = scc.nextInt();
        
            
            if (hitOrSave == 0)
            {
                scc.close();
             
                System.exit(0);
            }


            if (hitOrSave == 1) 
            {

                //ability
        
                int ability = -1;

                boolean subAbility1 = false;
                boolean subAbility2 = false;
                boolean subAbility3 = false;
                boolean subAbility4 = false;
                boolean subAbility5 = false;
                boolean subAbility6 = false;
        
                ArrayList<Boolean> abilities = new ArrayList<>(); //purpose:
        

                //While Loop Purpose: 
                while (ability != 1) 
                {
                    System.out.println("Active Ability:");
                    
                    //checks for nutin
                    if (subAbility1 == false)
                    {
                        System.out.println("1)'Nutin?'");
                    }
                    if (subAbility1 == true)
                    {
                        System.out.println("1)No other abilities");
                    }

                    //checks for lethatl hits
                    if (ability != 2)
                    { 
                        if (subAbility2 == false)
                        {
                            System.out.println("2)Lethal Hits:");
                        }
                    }
                    else 
                    {
                        subAbility2 = true;
                    }

                    
                    //checks for rapid fire
                    if (ability != 3)
                    {
                        if (subAbility3 == false)
                        {
                            System.out.println("3)Rapid Fire:");
                        } 
                    } 
                    else 
                    {
                        subAbility3 = true;
                    }
            


                    //checks for blast
                    if (ability != 4)
                    {
                    if (subAbility4 == false)
                        {
                            System.out.println("4)Blast:");
                        }
                    } 
                    else 
                    {
                        subAbility4 = true;
                    }


                    //checks for Hazardus ~ TEXT SELECT
                    if (ability != 5)
                    {
                        if (subAbility5 == false)
                        {
                            System.out.println("5)Hazardus:"); 
                        }
                    } 
                    else 
                    {
                        subAbility5 = true;
                    }



                    //checks for sustained hits ~ TEXT SELECT
                    if (ability != 6)
                    {
                        if (subAbility6 == false)
                        {
                            System.out.println("6)Sustained Hits:");
                        }
                    } 
                    else 
                    {
                        subAbility6 = true;
                    }

                    ability = scc.nextInt();

                
                    subAbility1 = true;
            
                }











            
                abilities.add(subAbility1); abilities.add(subAbility2); abilities.add(subAbility3); abilities.add(subAbility4); abilities.add(subAbility5); abilities.add(subAbility6);

        
        
                System.out.println("How many dice?");
        
                int diceNumber = scc.nextInt();

        
                Uppies hitType = new Uppies(0, ability, new int[]{0, 0}, abilities);
        
                ability = hitType.abilities();

        
                //hit
        
        
                System.out.println("Hit roll?");
        
                int upOnHit = scc.nextInt();
        
                Uppies uppieHit = new Uppies(diceNumber, upOnHit, new int[]{ability, 0}, abilities);
        
                uppieHit.Checking();
        
                int[] success = uppieHit.getSuccess();
        
                System.out.println("");

        
                System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
        
                if (subAbility2 == true) 
            
                {
                
                    ability = 2;
            
                }
                subAbility1 = false;
                subAbility2 = false;
                subAbility3 = false;
                subAbility4 = false;
                subAbility5 = false;
                subAbility6 = false;
                abilities.remove(subAbility1); abilities.remove(subAbility2); abilities.remove(subAbility3); abilities.remove(subAbility4); abilities.remove(subAbility5); abilities.remove(subAbility6);
                abilities.add(subAbility1); abilities.add(subAbility2); abilities.add(subAbility3); abilities.add(subAbility4); abilities.add(subAbility5); abilities.add(subAbility6);
                //wound
                if (ability == 2) //if lethal hits
                {
                    System.out.println("Wound roll?");
                    int upOnWound = scc.nextInt();
                    Uppies uppieWound = new Uppies(success[0] - success[1], upOnWound, new int[]{0, success[1]}, abilities);
                    uppieWound.Checking();
                    success = uppieWound.getSuccess();
                    System.out.println("");
                    System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
            
                }       //end of if thetal hits
                else 
                {
              
        
        
                    System.out.println("Wound roll?");
                
        
                    int upOnWound = scc.nextInt();
              
        
                    Uppies uppieWound = new Uppies(success[0], upOnWound, new int[]{0, 0}, abilities);
            
        
                    uppieWound.Checking();
        
                    success = uppieWound.getSuccess();
            
        
                    System.out.println("");
        
                    System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
            
                }
        
        
            } 
            else 
            {
            
            
                System.out.println("How many dice?");
            
                int diceNumber = scc.nextInt();

            
                System.out.println("save Roll?");
            
                int upOnSave = scc.nextInt();

            
            
                System.out.println("Damage Per Dice?");
            
                int damPerDice = scc.nextInt();
            
                System.out.println("Feel No Pain?"); System.out.println("1) yes"); System.out.println("2) no");
            
                int feelNoPain = scc.nextInt();

            
                Uppies uppieSave = new Uppies(diceNumber, upOnSave, new int[]{0, 0},  new ArrayList<>());
            
                uppieSave.saveChecking();
            
                int[] success = uppieSave.getSuccess();
            
                if (feelNoPain == 1)
            
                {
                
                
                    System.out.println("");
                
                    System.out.println("FeelNoPain Save?");
                
                    int FoPain = scc.nextInt();

                
                    Uppies uppieNoPain = new Uppies(diceNumber, upOnSave, new int[]{FoPain, damPerDice},  new ArrayList<>());
                
                    
                    uppieNoPain.feelNoPain();
                
                    success = uppieNoPain.getSuccess();
                
                    System.out.println("Failed:" + success[0] + "      Total Damage:" + success[1]);
            
                } 
                else 
                {
                
                    System.out.println("");
                
                    System.out.println("Failed:" + success[0] + "      Total Damage:" + success[0] * damPerDice);
            
                }

            }

        } 

    }

}
