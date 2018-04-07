package fallframe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Square implements Runnable{

	private Point a,b,c,d;
	private int[] x;
	private int[] y;
	private Random random=new Random();
	private Color color;
	//private static boolean lock=true;
	private static Lock lock=new ReentrantLock();
	private int speed;
	
	Square(Point a,Point b,Point c,Point d)
	{
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		x = new int[]{(int) a.getX(),(int) b.getX(),(int) c.getX(),(int) d.getX()};
		y = new int[]{(int) a.getY(),(int) b.getY(),(int) c.getY(),(int) d.getY()};
		color=new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	Square(int point)
	{
		this(new Point(point, 0), new Point(point+10, 0), new Point(point+10,10), new Point(point, 10));
		speed=random.nextInt(50);
	}
	
	public double perimeter()
	{
		return a.distance(b)+b.distance(c)+c.distance(d)+d.distance(a);
	}
	
	public void reset(int point)
	{
		speed=random.nextInt(50);
		x = new int[]{point,point+10,point+10,point};
		y = new int[]{0,0,10,10};
	}
	
	public double[] diagonal()
	{
		return new double[]{a.distance(c),b.distance(d)};
	}
	
	public double diagonal(Point point)
	{
		if(point==a) return a.distance(c);
		else if(point==b) return b.distance(d);
		else if(point==c) return c.distance(a);
		else if (point==d) return d.distance(b);
		
		return 0;
	}
	
	public void changeCoordinate(char z,Point point)
	{
		if(z=='a'||z=='A')
			a.setLocation(point);
		if(z=='b'||z=='B')
			b.setLocation(point);
		if(z=='c'||z=='C')
			c.setLocation(point);
		if(z=='d'||z=='D')
			d.setLocation(point);
	}
	
	public Point getPoint(char z)
	{
		if(z=='a'||z=='A')
			return new Point(x[0],y[0]);
		if(z=='b'||z=='B')
			return new Point(x[1],y[1]);
		if(z=='c'||z=='C')
			return new Point(x[2],y[2]);
		if(z=='d'||z=='D')
			return new Point(x[3],y[3]);
		return null;
	}

	@Override
	public void run() {
		while(true)
		{
			lock.lock();
			lock.unlock();
				try 
				{
					Thread.sleep(speed);
					for(int i=0;i<4;++i)
						y[i]+=1;
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
		}
		
	}

	/*@Override
	public String toString() {
		return "Quadrangle A" + a.toString() + ", B" + b.toString() + ", C" + c.toString()+", D"+d.toString()+"\nPerimeter = "+perimeter()+" Area = "+area()+" Diagonal from coordinate A to C "+ diagonal(a);
	}*/
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.drawPolygon(x, y, 4);
		g.fillPolygon(x, y, 4);
	}
	
	public static void lock()
	{
		lock.lock();
	}
	
	public static void unLock()
	{
		lock.unlock();
	}
}
