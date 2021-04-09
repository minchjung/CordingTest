import java.util.*;
public class Main {
	// 제일 작은 시간이 앞으로 가면 끝 
	// 오름 차순 정렬 해주고 
	// ArrayList를 두개 생성 <- add 시간조회 O(N) 이중 for문 과 결국 시간상수는 동일
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arrSum = new ArrayList<>();
		
		int n = sc.nextInt(); 
		for(int i = 0 ; i < n ; i++) {
			arr.add(sc.nextInt());
		}
		arr.sort(null);
		
		int sum = 0 ;
		arrSum.add(sum);
		for (int i = 0 ; i < arr.size() ; i ++) {
			sum+=arr.get(i);
			arrSum.add(sum); 
		}
		int total = 0;
		for (int i = 0 ; i < arrSum.size() ; i ++) {
			total += arrSum.get(i);
		}
		System.out.print(total);
	}//main
}//Main
