package 배열심화;

import java.util.Random;
import java.util.Scanner;

public class 스네이크1 {

	public static void main(String[] args) {
		/*
		 * [스네이크게임]
		 * 1. 10x10 배열을 0으로 채운다.
		 * 2. 스네이크는 1234로 표시한다.
		 * 3. 머리 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
		 * 4. 자기몸하고 부딪히면, 사망한다.
		 * 5. 랜덤으로 아이템을 생성해
		 *    아이템을 먹으면 꼬리 1개가 자란다.
		 * 6. 꼬리는 최대 8개까지 증가할 수 있다.
		 */
		
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
		int[][] game = new int[10][10];
		int cnt = 0;
		int dir = rd.nextInt(4);
		int startx = rd.nextInt(7);
		int starty = rd.nextInt(game.length);
		for (int i = 0; i < 4; i++) {
			if (dir == 0) {				
				game[starty][startx + i] = i + 1;				
			} else if (dir == 1) {
				game[startx+i][starty] = i + 1;	
			} else if (dir == 2) {
				game[starty][startx - i +3] = i + 1;	
			} else {
				game[startx-i+3][starty] = i + 1;	
			}
			cnt++;
		}
		
		for (int i = 0; i < 8; i++) {
			int item1 = rd.nextInt(10);
			int item2 = rd.nextInt(10);
			if (game[item1][item2] == 0) {
				game[item1][item2] = 100;
			} else {
				i--;
			}
		}
		while (true) {
			int y = -1;
			int x = -1;
			System.out.println("[1.left][2.right][3.up][4.down]");
			for (int i = 0; i < game.length; i++) {
				for (int k = 0; k < game[i].length; k++) {
					if (game[i][k] == 100) {
						System.out.print("[♣]");
					} else if (game[i][k] == 0) {
						System.out.print("[ ]");
					} else if (game[i][k] == 1) {
						System.out.print("[S]");
						y = i;
						x = k;
					} else {
						System.out.print("[●]");
					}
				}
				System.out.println();
			}
			if(cnt==8) {
				System.out.println("승리!");
				break;
			}
			System.out.print("이동위치 입력");
			int input = scan.nextInt();
			if (input < 1 || input > 4) {
				System.err.println("입력 오류 : 1-4 입력");
				continue;
			}

			if (input == 1) {
				if (x != 0) {
					x--;
				}
			} else if (input == 2) {
				if (x != game[y].length - 1) {
					x++;
				}
			} else if (input == 3) {
				if (y != 0) {
					y--;
				}
			} else {
				if (y != game.length - 1) {
					y++;
				}
			}
			if (game[y][x] == 0) {
				for (int i = 0; i < game.length; i++) {
					for (int k = 0; k < game[i].length; k++) {
						if (game[i][k] == cnt) {
							game[i][k] = 0;
							break;
						}
					}
				}
			} else if (game[y][x] == 100) {
				if (cnt != 9) {
					cnt++;
				}
			} else {
				System.out.println("게임오버");
				break;
			}
			for (int i = 0; i < game.length; i++) {
				for (int k = 0; k < game[i].length; k++) {
					if (game[i][k] != 0 && game[i][k] != 100) {
						game[i][k]++;
					}
					if (game[i][k] == 9) {
						game[i][k] = 0;
					}
				}
			}
			game[y][x] = 1;
		}
		scan.close();
		
	}

}
