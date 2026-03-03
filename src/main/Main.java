package main;

//Java Library Imports
import java.util.ArrayList;

//Project Imports
import rollingUtils.Uppies;
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
                int ability = 80085;

                ArrayList<Integer> abilityArray = new ArrayList<>();
                //While Loop Purpose: to say what abilities for the dice are chosen
                while (ability != 1) 
                {
                    System.out.println("Active Ability:");
                    //checks for nutin
                        System.out.println("1)'Nutin?'");
                    
                    //checks for lethatl hits
                    if (ability == 2)
                    { 
                        abilityArray.add(2);  
                    } else {
                        System.out.println("2)Lethal Hits:");
                    }
                    

                    
                    //checks for rapid fire
                    if (ability == 3)
                        { 
                            abilityArray.add(3);  
                        } else {
                            System.out.println("3)rapid fire:");
                        }
            
                    //checks for blast
                    if (ability == 4)
                        { 
                            abilityArray.add(4);  
                        } else {
                            System.out.println("4)Blast:");
                        }

                    //checks for Hazardus ~ TEXT SELECT
                    if (ability == 5)
                        { 
                            abilityArray.add(5);  
                        } else {
                            System.out.println("5)Hazardus");
                        }



                    //checks for sustained hits ~ TEXT SELECT
                    if (ability == 6)
                        { 
                            abilityArray.add(6);  
                        } else {
                            System.out.println("6)Sustained hits:");
                        }
                        ability = scc.nextInt();
                }

        
        
                //hit
                ArrayList<Integer> diceArray = new ArrayList<>();
                System.out.println("How many dice?");
                int diceNumber = scc.nextInt();

                System.out.println("How many of this weapon?");
                int weaponCount = scc.nextInt();

                System.out.println("Hit roll?");
                int hitroll = scc.nextInt();
        
                Uppies uppieHit = new Uppies(diceNumber, hitroll, new int[]{ability, weaponCount});
        
                for(int i=0; i < abilityArray.size(); i++)
                    {
                        if (abilityArray.get(i) == 2)
                            {
                                
                            }
                        if (abilityArray.get(i) == 3)
                            {
    
                            }
                        if (abilityArray.get(i) == 4)
                            {
        
                            }
                        if (abilityArray.get(i) == 5)
                            {
        
                            }
                        if (abilityArray.get(i) == 6)
                            {
        
                            }
                    }
                    if (abilityArray.size() == 0)
                        {
                           diceArray = uppieHit.getNutin();
                        }

                    
                int[] success = uppieHit.getSuccess();
                System.out.println();
                System.out.println(diceArray);
                System.out.println();
                System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
            
                if (ability == 2) //if lethal hits
                {
                    System.out.println("Wound roll?");
                    int upOnWound = scc.nextInt();
                    Uppies uppieWound = new Uppies(success[0] - success[1], upOnWound, new int[]{0, success[1]});
                    uppieWound.getNutin();
                    success = uppieWound.getSuccess();
                    System.out.println("");
                    System.out.println("Go Through:" + success[0] + "     six:" + success[1]);
            
                }       //end of if thetal hits
                else 
                {
              
        
        
                    System.out.println("Wound roll?");
                
        
                    int upOnWound = scc.nextInt();
              
        
                    Uppies uppieWound = new Uppies(success[0], upOnWound, new int[]{0, 0});
            
        
                    uppieWound.getNutin();
        
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

            
                Uppies uppieSave = new Uppies(diceNumber, upOnSave, new int[]{0, 0});
            
                uppieSave.saveChecking();
            
                int[] success = uppieSave.getSuccess();
            
                if (feelNoPain == 1)
            
                {
                
                
                    System.out.println("");
                
                    System.out.println("FeelNoPain Save?");
                
                    int FoPain = scc.nextInt();

                
                    Uppies uppieNoPain = new Uppies(diceNumber, upOnSave, new int[]{FoPain, damPerDice});
                
                    
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
