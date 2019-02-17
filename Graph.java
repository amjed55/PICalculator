import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.awt.Color;
import java.util.ArrayList; 
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;


public class Graph  // responsible for viewing the component and its drawing call that Pigraphviewer
{

   static final int FRAME_WIDTH  = 1250 ; // select proper size for the frame 
   static final int FRAME_HEIGHT = 650  ; 
    
   public static void main(String[] args)
   {
      
      // Create the window
      JFrame frame = new JFrame();
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Assignment1 Graphical Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a component so that we can draw shapes 
      PiComponent component = new PiComponent();
      
      // Add component to frame
      frame.add(component);
      
      frame.setVisible(true);
   }
} // Pigraph


class PiComponent extends JComponent //responsible for drawing PI estimation graphically
{


public void paintComponent(Graphics g) {
 
 Graphics2D g2=(Graphics2D) g;
 Pigraph pi1 = new Pigraph();
 pi1.draw(g2);
 
 
 
} 



class Pigraph
{
private double pointsInCircle = 0;
private double pointsInSquare = 0;
private int R = 250;
private int repeat= 100000; // select proper number of repeat for PI estimation


public void draw(Graphics2D g2)
 {
 double x=0;
 double y=0;    
  for (int i=0; i<repeat; i++) {
  x = (double)Math.random()*2*R;
  y = (double)Math.random()*2*R;
  
  pointsInSquare = pointsInSquare + 1;
  if (Math.sqrt((x-R)*(x-R) + (y-R)*(y-R)) < R) {  // the random point is inside circle
   pointsInCircle = pointsInCircle + 1;
   g2.setColor(Color.RED);
   
      // fill here to show an small red component to show a point inside circle
   Rectangle redDot = new Rectangle((int)x,(int)y,1,1);
   g2.draw(redDot);
   
  }//if
  else
  {
  g2.setColor(Color.BLUE);
  
       // fill here to show an small blue component to show a point inside square
  Rectangle blueDot = new Rectangle((int)x,(int)y,1,1);
  g2.draw(blueDot);
  }//else
   double PI = pointsInCircle/pointsInSquare*4;
   
  //Draw the Graph
  
  //
   g2.setColor(Color.MAGENTA);
       // fill here to show an approximation of converge to PI by a graph in magenta color 
      g2.draw(new Ellipse2D.Double(i/(float)repeat*Graph.FRAME_WIDTH
      ,((float)(pointsInCircle/pointsInSquare*4)*50 + 400),1,1));
       
       
       
       
       
      // for (int j = 0; j<repeat;j++) {
           
      // Line2D.Double graph = new Line2D.Double(j*10, (Graph.FRAME_HEIGHT-50)-PI, j*10, 
      //(Graph.FRAME_HEIGHT-45)-PI);
      // int j2 = j;
      // g2.draw(graph);
   // }
   // System.out.println(PI);
 }
g2.setColor(Color.BLACK);
g2.drawString( Double.toString(pointsInCircle/pointsInSquare*4),Graph.FRAME_WIDTH-100,Graph.FRAME_HEIGHT-100);
System.out.println("PI estimated to: " + pointsInCircle/pointsInSquare*4);

} 
}

}