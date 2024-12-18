import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GUI {
	GameData gameData;
	JFrame f;
	JLabel[][] b;
	JButton upButton = new JButton("UP");
	JButton downButton = new JButton("DOWN");
	JButton leftButton = new JButton("LEFT");
	JButton rightButton = new JButton("RIGHT");
	GUI(GameData gameData) {
		this.gameData = gameData;
		f = new JFrame("Magic Tower");
		b = new JLabel[gameData.H][gameData.W];
		for (int i = 0; i < gameData.H; i++) {
			for (int j = 0; j < gameData.W; j++) {
				b[i][j]=new JLabel();
				b[i][j].setBounds(j*100, i*100, 100, 100);
				f.add(b[i][j]);
			}
		}
		f.setSize(gameData.H*100+10+200, gameData.W*100+40+200);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		upButton = new JButton("Up");
		downButton = new JButton("Down");
		leftButton = new JButton("Left");
		rightButton = new JButton("Right");

		upButton.setBounds(gameData.H*100, gameData.W*100, 100, 100);
		downButton.setBounds(gameData.H*100, gameData.W*120, 100, 100);
		leftButton.setBounds(gameData.H*80, gameData.W*110, 100, 100);
		rightButton.setBounds(gameData.H*120, gameData.W*110, 100, 100);

		f.add(upButton);
		f.add(downButton);
		f.add(leftButton);
		f.add(rightButton);

		/**upButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("up button clicked");
			}
		});
		downButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("down button clicked");
			}
		});
		leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("left button clicked");
			}
		});
		rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("right button clicked");
			}
		});**/


		refreshGUI();
	}

	/**void handleButtonInput(char direction){
		if (gameControl != null) {
			gameControl.handleInput(direction);
		}else {
			System.out.println("null");
		}
		gameData.printMap();
		refreshGUI();
	}**/
	public void refreshGUI()
	{
		for (int i = 0; i < gameData.H; i++) {
			for (int j = 0; j < gameData.W; j++) {
				Image scaledImage = chooseImage(gameData.map[gameData.currentLevel][i][j]);
				b[i][j].setIcon(new ImageIcon(scaledImage));
			}
		}
	}
	private static Image chooseImage(int index){
		ImageIcon[] icons = new ImageIcon[10];
		Image scaledImage;
		icons[0]= new ImageIcon("Wall.jpg");
		icons[1]= new ImageIcon("Floor.jpg");
		icons[2]= new ImageIcon("Key.jpg");
		icons[3]= new ImageIcon("Door.jpg");
		icons[4]= new ImageIcon("Stair.jpg");
		icons[5]= new ImageIcon("Exit.jpg");
		icons[6]= new ImageIcon("Hero.jpg");
		icons[7]= new ImageIcon("Potion.jpg");
		icons[8]= new ImageIcon("Monster.jpg");
		if(index>10)
			scaledImage = icons[7].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		else if(index<0)
			scaledImage = icons[8].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		else
			scaledImage = icons[index].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return scaledImage;
	}
}
