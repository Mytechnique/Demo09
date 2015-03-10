package fi.jamk;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author h8599
 */
public class Ball {
   private int x,y;
   private int dx,dy;
   private int size;
   private Color color;
   private int maxX, maxY;
   
   public Ball(int maxX, int maxY) {
       this.maxX = maxX;
       this.maxY = maxY;
       this.size = 25;
       Random rand = new Random();
       // position
       this.x = rand.nextInt(maxX-this.size);
       this.y = rand.nextInt(maxY-this.size);
       // speed
       this.dx = rand.nextInt(6)-3; // -3 <-> 3
       if ( this.dx == 0) this.dx = 3;
       
       this.dy = rand.nextInt(6)-3; // -3 <-> 3
       if ( this.dy == 0) this.dy = 3;
       // color
       this.color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
       
       
   } // Konstr.
   
   public void move() {
       this.x += dx; // this.x = this.x + dx;
       this.y += dy; // this.y = this.y = dy;
       
       //x
       if(this.x < 0 || this.x+this.size > this.maxX) dx *= -1;
       if(this.y < 0 || this.y+this.size > this.maxY) dy *= -1;
       
   }
   public int getX() { return this.x; }
   public int getY() { return this.y; }
   public int getSize() { return this.size; }
   public Color getColor() { return this.color; }
} // CLASS
