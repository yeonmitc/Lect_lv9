package 배열심화;

import java.util.Random;

public class 가운데숫자찾기 {

	public static void main(String[] args) {
		 Random rd = new Random();

		 while(true) {
		 int num = rd.nextInt(1000000)+1;
		 int cnt =0; 
		 int gameNum = 1;
		 
		 for(int i =1; i <10000000 ;){
			 if(num/i!=0) {
				 cnt++;
				 gameNum*=10; 
			 }
			 i*=10;
			 
		 }
		 gameNum/=10; 
		 if(cnt%2==0) {
			System.out.println("this is even number of digits game restarted! ");
			continue;
		 }else {

			 int[] game = new int[cnt]; 
			 int answer = 0; 
			  System.out.println(num);
			 for(int i =0; i < cnt; i++) {
				 game[i] = num/gameNum;
				 num%=gameNum;
				 gameNum/=10;
				 System.out.print(game[i] + " ");
			 }
			 
			 answer = game[(cnt/2)];
			 
			 System.out.println();
			 
			 System.out.println("Answer is  : " + answer);
		 }
		 
		 break;
		 
		 }


	}

}
