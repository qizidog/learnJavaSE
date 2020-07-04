package oo.oo1;
/**
 * 计算两点之间的距离
 * @author qizidog
 *
 */

class Point{
	double x;
	double y;
	
	double get_distance(Point p) {
		return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
	}
	
	Point(double _x, double _y){
		x = _x;
		y = _y;
	}
}

public class Map {
	public static void main(String[] args) {
		Point p1 = new Point(10, 15);
		Point p2 = new Point(7, 19);
		System.out.println(p1.get_distance(p2));
	}
}
