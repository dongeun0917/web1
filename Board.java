package com.sist.dongeun;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel{
	
	
	public static final int BOARD_WIDTH= 10;
	public static final int BOARD_HEIGHT = 20;
	public static final int BLOCK_SIZE = 30; // 테트리스 보드의 각 칸 크기 
	private Timer looper;
	private Color [][] board = new Color [BOARD_WIDTH][BOARD_HEIGHT];		// 보드 색
	
	private Color [][] shape = {					//도형 색
			{Color.RED, Color.RED, Color.RED},		//이중배열 문법 확인 필
			{null, Color.RED, null}
	};
	
	public Board() {
		
		//이 부분 좀 더 이해 필요함. 
		//
		// Timer 는 첫번째 인자millisecond 시간간격으로 두번째 인자를 프린트하거나 뭔가 실행하는 것으로 추측. 
		looper = new Timer(500, new ActionListener(){  		// Time for delay. put about 500 millisecond (means a half of second), 두번째 파라미터가 생성자인 상황.
			
			int n = 0;
			@Override			// add unimplemented method <-> 영상 Implement all abstract methods
			public void actionPerformed(ActionEvent e) { // 이 메서드를 오버라이딩한거고, 이건 이대로 new ActionListe  ner 만들고 초기화에 actionPerformed-...쓰고 실행할 코드를 밑에 쓰는 것이라고 일단 외우기.
				System.out.println(n++);
			}  
		 }
		);
				
		looper.start();
	
	}
	
	
	@Override
	// 배경선 그리기.
	// paintComponent는 원래 있던 함수인데 overriding 하는 중. Graphics 도 JPanel 의 일부이므로 g의 데이터타입으로 쓰임.
	protected void paintComponent(Graphics g) {    			
		
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
//		g.setColor(Color.black);
//		g.drawRect(10, 10, 200, 200);
		
		
		// draw the shape
		for(int row = 0; row < shape.length; row++) {
			for(int col = 0; col <shape[0].length; col++) {
				if(shape[row][col] != null) {
					g.setColor(shape[row][col]); // 없으면 그냥 안해주는게 아니라, 있는 경우에 색을 칠해주라고 설정.
					g.fillRect(row * BLOCK_SIZE, col * BLOCK_SIZE , BLOCK_SIZE, BLOCK_SIZE);
				}
				 
				
			}
		}
		
		
		
		// draw the board
		g.setColor(Color.white);  //Graphics.drawLine 함수 : 좌표(x1, y1)에서 좌표(x2, y2)까지 직선을 그린다. 
		 ////// 오른쪽에 공백은 어떻게 남겼는지: BLOCK_SIZE 만큼 BOARD_WIDTH 번, or BOARD_HEIGHT 번. 이렇게 위치를 그어라.
		for(int row = 0; row <  BOARD_HEIGHT; row++) {
			g.drawLine(0, BLOCK_SIZE * row, BLOCK_SIZE * BOARD_WIDTH, BLOCK_SIZE * row); 
		}
		
		for(int col = 0; col <  BOARD_WIDTH+1; col++) {
			g.drawLine( col * BLOCK_SIZE, 0, col * BLOCK_SIZE, BLOCK_SIZE * BOARD_HEIGHT); 
		}
		
		
		
	}

	
	
	public static void main(String[] args) {
		
	
	}
	


}
