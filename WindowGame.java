package com.sist.dongeun;

import javax.swing.JFrame;


public class WindowGame {
	
	public static final int WIDTH = 445, HEIGHT = 629;
	
	private Board board;
	private JFrame window;  //import한 java swing의 JFrame 사용. private 이므로 해당 클래스 내에서만 사용가능. WindowGame 생성자 통해 밖에서 사용.
	
	public WindowGame () {
		window = new JFrame("Tetris"); // put a name for imported JFrame
		window.setSize(WIDTH, HEIGHT); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame과 따라다니는 메소드. x표 누르면 창이 닫혀도 JVM에는 남아있다. /작업자 프로세스에 아직 가동중인 것 같이 닫히도록 해줌.
		window.setResizable(false); // 창크기 조절
		window.setLocationRelativeTo(null); // set the initial position to the center of the screen 
		
		board = new Board(); //board class 만들고 여기 인스턴스 생성.
		window.add(board); // window.add ??
		window.setVisible(true); 

		
		
		
	}
	
	public static void main(String[] args) {
		new WindowGame ();

	}  

}
