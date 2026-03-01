package scannerUtils;

//Java Library Imports
import java.util.Scanner;

/**
 *This class holds a scanner, and allows for easy management of a System.in scanner
 */
public class SuperScanner implements Closeable{

    private Scanner sc;
    
    /**
     *Constructor for the super Scanner class
     */
    public SuperScanner(){
        sc = new Scanner(System.in);
    }

    


    //METHODS START

    /**
     *
     */
    public int nextInt(){
        int returnable = sc.nextInt();
        return returnable;
    }



    
    @Override
    public void close(){
        sc.close();
    }



}
