package _03_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private int cellsPerRow;
	private int cellSize;
	
	private Timer timer;
	
	//1. Create a 2D array of Cells. Do not initialize it.
Cell[][] array2DCells;
	
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
		//2. Calculate the cell size.
		cellSize=w/cpr;
		//3. Initialize the cell array to the appropriate size.
		array2DCells=new Cell[cpr][cpr];
		//3. Iterate through the array and initialize each cell.
		//   Don't forget to consider the cell's dimensions when 
		//   passing in the location.
		for(int i=0; i<cellsPerRow; i++) {
			for(int j=0; j<cellsPerRow; j++) {
			array2DCells[i][j]=new Cell(j*cellSize, i*cellSize, cellSize);;
		}
		}
	}
	
	public void randomizeCells() {
		//4. Iterate through each cell and randomly set each
		//   cell's isAlive member to true of false
		Random rand=new Random();
		for(int i=0; i<cellsPerRow; i++) {
			for(int j=0; j<cellsPerRow; j++) {
				boolean ran=rand.nextBoolean();
			array2DCells[i][j].isAlive=ran;
		}
		}
		repaint();
	}
	
	public void clearCells() {
		//5. Iterate through the cells and set them all to dead.
		for(int i=0; i<cellsPerRow; i++) {
			for(int j=0; j<cellsPerRow; j++) {
			array2DCells[i][j].isAlive=false;
		}
		}
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//6. Iterate through the cells and draw them all
		for(int i=0; i<cellsPerRow; i++) {
			for(int j=0; j<cellsPerRow; j++) {
			array2DCells[i][j].draw(g);
		}
		}
		
		
		// draws grid
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
	
	//advances world one step
	public void step() {
		//7. iterate through cells and fill in the livingNeighbors array
		// . using the getLivingNeighbors method.
		int[][] livingNeighbors = new int[cellsPerRow][cellsPerRow];
		for(int i=0; i<cellsPerRow; i++) {
			for(int j=0; j<cellsPerRow; j++) {
			livingNeighbors[i][j]=getLivingNeighbors(i, j);
		
		
		//8. check if each cell should live or die
	array2DCells[i][j].liveOrDie(livingNeighbors[i][j]);
		
			}
			}
		repaint();
	}
	//9. Complete the method.
	//   It returns an int of 8 or less based on how many
	//   living neighbors there are of the 
	//   cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		int aliveNeighbors=0;
					if(x>0) {	
						if(y>0) {
		if(array2DCells[x-1][y-1].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
					}
					if(x>0) {
		if(array2DCells[x-1][y].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
					if(x>0) {
						if(y<cellsPerRow-1) {
		if(array2DCells[x-1][y+1].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
					}
					if(y>0) {
		if(array2DCells[x][y-1].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
		//Cell being checked
		//if(array2DCells[x][y].isAlive==true) {
			//aliveNeighbors+=1;
		//}
					if(y<cellsPerRow-1) {	
		if(array2DCells[x][y+1].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
					if(x<cellsPerRow-1) {
						if(y>0) {
		if(array2DCells[x+1][y-1].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
					}
					if(x<cellsPerRow-1) {
		if(array2DCells[x+1][y].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
					if(x<cellsPerRow-1) {
						if(y<cellsPerRow-1) {
		if(array2DCells[x+1][y+1].isAlive==true) {
			aliveNeighbors+=1;
		}
					}
					}
		return aliveNeighbors;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//10. Use e.getX() and e.getY() to determine
		//    which cell is clicked. Then toggle
		//    the isAlive variable for that cell.
		for(int i=0; i<cellSize; i++) {
			for(int j=0; j<cellSize; j++) {
				if(e.getX()>=i*cellSize && e.getX()<=i+1*cellSize && e.getY()>=j*cellSize && e.getY()<=j+1*cellSize) {
					array2DCells[i*cellSize][j*cellSize].isAlive=true;
		}
		}
		}
		
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
