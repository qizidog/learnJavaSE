package basicGrammar;

import java.awt.*;
import javax.swing.*;


public class BallGame extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("image/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("image/net.png");
	
	double x=100;
	double y=100;
	boolean right=true;
	
	//画窗口的方法
	public void paint(Graphics g) {
		System.out.println("刷新窗口");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		if(right) {
			x = x+10;
		}else {
			x = x-10;
		}
		
		if(x>856-10) {
			right=false;
		}
		
		if(x<0) {
			right=true;
		}
	}
	
	//窗口加载
	void launchFrame() {
		setSize(856, 856);
		setLocation(50, 50);
		setVisible(true);
		
		//重画窗口
		while(true) {
			repaint();
		try {
			Thread.sleep(40);  // 40ms
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
	
	
	
	//main方法是程序执行的入口
	public static void main(String[] args) {
		System.out.println("我是qizidog");
		BallGame game = new BallGame();
		game.launchFrame();
	}
}
