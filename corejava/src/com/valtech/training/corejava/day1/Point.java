package com.valtech.training.corejava.day1;

import java.io.Serializable;

public class Point implements Comparable<Point>,Serializable {

	

	
	public static final Point ORIGIN = new Point(0,0);
	protected int x;
	protected int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if(distance()< o.distance()) {
            return -1;
        }
        if (distance()== o.distance()) {
            if(x<o.x) {
                return -1;
            }
            if(x>o.x) {
                return +1;
            }
            return 0;
        }
        
        return +1;
		
		
	}
	

	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p=(Point) obj;
			return p.x==x && p.y ==y;
			
		}
		return false;
		
	}
	public int hashCode() {
		return toString().hashCode();
	}
	public String toString() {
		return new StringBuffer("X = ").append(x).append("Y = ").append(y).toString();
		
	}
	
	public Point() {
		
	}
	
	public double distance() {
		return Math.sqrt(x*x+y*y);
	}
	public double distance(int x,int y) {
        int dx = this.x-y;
        int dy = this.y-x;
        return Math.sqrt(dx*dx+dy*dy);
	}
	
	public double distance(Point p) {
		return this.distance(p.x,p.y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
 public static void main(String[] args) {
	Point p =new Point(2,3);
	System.out.println("x = "+p.getX()+" y= "+p.getY());
	System.out.println(p.distance());
	System.out.println(p.distance(10,20));
	System.out.println(p.distance(new Point(12,13)));
}
}




