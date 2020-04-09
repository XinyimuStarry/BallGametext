import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/deskbills.jpg");
	
	double x = 100;//小球的横坐标
	double y = 100;//小球的纵坐标
	double degree = 3.14/3;//方向
	
	//画窗口
	public void paint(Graphics g) {
		System.out.println("first paint");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball,(int)x, (int)y, null);
		
		x = x + 10*Math.cos(degree);
		y = y + 10*Math.sin(degree);
		
		//碰到上下边界
		if (y>500-40-30 || y<40+40) {//500是窗口高度，40是桌子边框，30是球直径，最后一个40是标题栏高度
			degree = -degree;
		}
		
		if (x<40 || x>856-40-30) {
			degree = 3.14 - degree;
		}
	}	
	
	//窗口加载
	void launchFrame() {
		setSize(300,300);
		setLocation(400,400);
		setVisible(true);
		
		//重画窗口，每秒画25次
		while(true) {
			repaint();
			try {
				Thread.sleep(40);//40ms,1秒=1000毫秒。大约一秒画25次窗口
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("I am Chen,this is my first Game.");
		BallGame game =new BallGame();
		game.launchFrame();
	}

}
