import java.util.Random; 
import java.io.PrintWriter;
import java.io.FileNotFoundException; 
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.*;



  /**4  This program computes an estimate of πby simulating dart throws onto a square.5  */ 
  public class MonteCarlo7  {
   public static void main(String[] args)
   {  
       final int TRIES = 1000;
       Random generator = new Random();
      File file = new File ("C:/Users/Moham/Desktop/file.cvs");
   
    
       
       try{
           
           PrintWriter output = new PrintWriter(file);
       int hits = 0;
       for (int i = 1; i <= TRIES; i++)
       {  
           //Generate two random numbers between -1 and 1
           
           double r = generator.nextDouble();
           double x = -1 + 2 * r; 
           r = generator.nextDouble();
           double y = -1 + 2 * r;         
           double z = 4.0 * hits /i  ; 
           //Check whether the point lies in the unit circle
           
           if (x * x + y * y <= 1) {hits++; }
           System.out.println(4.0 * hits /i);
            output.println( 4.0 * hits / i);
        }
         double PiEstimate = 4.0 * hits / TRIES;
         System.out.println("Estimate for π: " + PiEstimate);
        
         output.close();
    }
    catch (IOException ex) {
        System.out.println(ex);
    }
        /*
         * The ratio hits / tries is approximately the same as the ratio 
         * circle area / square area = π/ 4
           */ 
 
}
  }
