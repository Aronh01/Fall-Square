package fallframe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class SquareComponent extends JPanel {
	List<Square> squares;
	Random random;
	
	public SquareComponent() {
		squares=new ArrayList<>();
		random =new Random();
		setBackground(new Color(255, 200, 0));
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		drawSquares(g);
		repaint();
	}
	
	public void addSquare()
	{		

		Square square=new Square(random.nextInt(getHeight()-10));
		squares.add(square);
		(new Thread(square)).start();
	}
	
	void drawSquares(Graphics g)
	{
		for(Square square:squares)
		{
			if(square.getPoint('a').getY()>getHeight())
			{
				square.reset(random.nextInt(getHeight()-10));
			}
			square.draw(g);
		}
	}
}
