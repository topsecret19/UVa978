import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
public class Main {
public static void main(String[] args) {
	int tests, B, SG, SB;
	Scanner sc = new Scanner(System.in);
	tests = sc.nextInt();
	while(tests-->0) {
		B=sc.nextInt();
		SG=sc.nextInt();
		SB=sc.nextInt();
		PriorityQueue<Integer> green = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			public int compare(Integer i,Integer j) {
				return j - i;
			}
		});
		for(int i=0; i<SG; i++) {
			green.add(sc.nextInt());
		}
		
		PriorityQueue<Integer> blue = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {
				return j - i;
			}
		});
		for(int j=0; j<SB; j++) {
			blue.add(sc.nextInt());
		}
		while(true) {
			if(green.isEmpty()&&blue.isEmpty()) {
				System.out.println("green and blue died");
				break;
			}else if(blue.isEmpty()) {
				System.out.println("green wins");
				while(!green.isEmpty()) {
					System.out.println(green.poll());
				}
				break;
			}else if(green.isEmpty()) {
				System.out.println("blue wins");
				while(!blue.isEmpty()) {
					System.out.println(blue.poll());
				}
				break;
			}else {
				int count=0;
				int a,b;
				while(!green.isEmpty()&&!blue.isEmpty()&&count<B) {
					a=green.poll();
					b=blue.poll();
					if(a>b) {
						green.add(a-b);
					}else if(a<b) {
						blue.add(b-a);
					}
					count++;
				}
			}
		}
		if(tests>0) {
			System.out.println();
		}
	}
}
}
