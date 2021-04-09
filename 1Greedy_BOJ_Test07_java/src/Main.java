import java.util.*;
//BOJ Greedy 회의실 
// 정렬 우선순위 
// 1.종료 시간 기준 정렬 + 2. 시작~종료 시간 간격  
class Conference {
	int[] time= {0,0};
	
	Conference(int a, int b){ //객체 생성 
		this.time[0]=a; //시작
		this.time[1]=b;// 끝
	}
}
public class Main { 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// Conference 객체 리스트
		ArrayList<Conference> conf = new ArrayList<Conference>();
		for (int i = 0 ; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			conf.add(new Conference(a,b));
		}
		// Collections.sort 오버 라이드  
		Collections.sort(conf, new Comparator<Conference>() {
			public int compare(Conference c1, Conference c2) {
				if(c1.time[1] > c2.time[1]) {
					return 1;  // end 기준 정렬 
				}else if(c1.time[1] < c2.time[1]) {
					return -1;
				}else { // end 같으면 start 와 end 의 간격 기준으로 정렬
					return c1.time[0] -c1.time[1];
				}
			}
		});

		int end = -1 ; //최초 end 비교값 
		int cnt=0 ; 
		for (int i=0; i < n ; i++) {
			int start = conf.get(i).time[0];
			if (start >= end) { // 정렬된 객체의 이전 end 와 해당 객체의 start와 비교 
				end = conf.get(i).time[1]; // start가 전 end 시간 보다 크면 
				cnt++;// 카운트 
			}
		}
		System.out.print(cnt);
		
	}// main 
}
    