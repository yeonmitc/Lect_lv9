package 배열심화;



import java.util.Random;

class Horse{
	
	String name; 
	int pos; 
	int rank; 
	boolean finish;
	
}

class Race{
	
	Random rd = new Random(); 
	
	int size = 4;
	int line = 20;
	
	Horse horses[] = new Horse[size];
	int track[][] = new int[size][line];
	
	Race() {
		
		for(int i=0; i<horses.length;i++) {
			horses[i] = new Horse();
		}
		horses[0].name="aaa"; 
		horses[1].name="bbb";
		horses[2].name="ccc";
		horses[3].name="ddd";
		
		play();
		printHourse();
		ranking();
	}
	
	
	void printHourse() {
		System.out.println();
		for(int i=0; i<size; i++) {
			for(int k=0; k<line; k++) {
				if(horses[i].pos == k) {
					System.out.print("[" +horses[i].name+"]");
				}else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
		
	}
	
	void play() {
		
		boolean run = true;
		int count =1;
		
		
		while(run) {
			printHourse();
			for(int i = 0; i < size; i++) {
				if(horses[i].finish == true) continue;
				int r = rd.nextInt(4) + 1;
				horses[i].pos += r;
				if(horses[i].pos >= 19) {
					horses[i].pos = 19;
					horses[i].rank = count;
					horses[i].finish = true;
					count++;
					if(count > size) {
						run = false;
						break;
					}
				}
			}		
			
		}
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		
		
	}
	
	void ranking() {
		System.out.println();
		System.out.println("=====rank====");
		int count =1;
		while(count<5) {
			
			for(int i=0; i<horses.length;i++) {
				if(horses[i].rank == count) {
					System.out.println( count + " ) " +horses[i].name);
					count++;
					break;
				}
			}
		}
	}
	
}
public class 경마1{

	public static void main(String[] args) {

				
				new Race();
				

	}

}
