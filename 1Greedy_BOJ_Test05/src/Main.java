import java.util.*;
public class Main {
	// ���� ���� �ð��� ������ ���� �� 
	// ���� ���� ���� ���ְ� 
	// ArrayList�� �ΰ� ���� <- add �ð���ȸ O(N) ���� for�� �� �ᱹ �ð������ ����
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
