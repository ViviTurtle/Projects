

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameOfLifeViewer extends JFrame
{
   public static Grid init(int rows, int columns)
   {
      Grid grid = new MysteryGrid(rows, columns);
      int r = rows / 2;
      int c = columns / 2;
      /*
           1
           .1  
          111
       */
      grid.set(new Location(r, c + 1), 1);
      grid.set(new Location(r-1, c), 1);
      grid.set(new Location(r+1, c-1), 1);
      grid.set(new Location(r+1, c), 1);
      grid.set(new Location(r+1, c+1), 1);
      return grid;
   }

   public static void nextGeneration(Grid cells)
   {
      ArrayList<Location> makeDead = new ArrayList<>();
      ArrayList<Location> makeAlive = new ArrayList<>();
      for (int i = 0; i <= 8; i++)
         for (Location loc : Grids.locationsWithNeighbors(cells, i))
            if (i < 2 || i > 3)
               makeDead.add(loc);
            else if (i == 3)
               makeAlive.add(loc);
      Grids.setLocations(cells, makeDead, 0);
      Grids.setLocations(cells, makeAlive, 1);
   }

   public static void main(String[] args)
   {
      final int ROWS = 10;
      final int COLUMNS = 10;
      final int CELL_SIZE = 8;      
      final Dimension preferredSize = new Dimension(
         ROWS * CELL_SIZE,
         COLUMNS * CELL_SIZE);

      final Grid cells = init(ROWS, COLUMNS);

      final JFrame frame = new JFrame();
      frame.add(new JComponent() 
         {
            public void paintComponent(Graphics g)
            {
               for (int i = 0; i < ROWS; i++)
               {
                  for (int j = 0; j < COLUMNS; j++)
                  {
                     if (cells.get(new Location(i, j)) != 0)
                     {
                        g.fillRect(j * CELL_SIZE, i * CELL_SIZE,
                           CELL_SIZE - 1, CELL_SIZE - 1);
                     }
                  }                  
               }
            }
            
            public Dimension getPreferredSize()
            {
               return preferredSize;
            }
         }); 
      frame.pack();

      // Add timer
      final int DELAY = 100; // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, new ActionListener() 
         {
            public void actionPerformed(ActionEvent event)
            {
               nextGeneration(cells);
               frame.repaint();
            }
         });
      t.start();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

}
