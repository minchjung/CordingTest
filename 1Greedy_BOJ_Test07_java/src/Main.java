import java.util.*;
//BOJ Greedy ȸ�ǽ� 
// ���� �켱���� 
// 1.���� �ð� ���� ���� + 2. ����~���� �ð� ����  
class Conference {
	int[] time= {0,0};
	
	Conference(int a, int b){ //��ü ���� 
		this.time[0]=a; //����
		this.time[1]=b;// ��
	}
}
public class Main { 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// Conference ��ü ����Ʈ
		ArrayList<Conference> conf = new ArrayList<Conference>();
		for (int i = 0 ; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			conf.add(new Conference(a,b));
		}
		// Collections.sort ���� ���̵�  
		Collections.sort(conf, new Comparator<Conference>() {
			public int compare(Conference c1, Conference c2) {
				if(c1.time[1] > c2.time[1]) {
					return 1;  // end ���� ���� 
				}else if(c1.time[1] < c2.time[1]) {
					return -1;
				}else { // end ������ start �� end �� ���� �������� ����
					return c1.time[0] -c1.time[1];
				}
			}
		});

		int end = -1 ; //���� end �񱳰� 
		int cnt=0 ; 
		for (int i=0; i < n ; i++) {
			int start = conf.get(i).time[0];
			if (start >= end) { // ���ĵ� ��ü�� ���� end �� �ش� ��ü�� start�� �� 
				end = conf.get(i).time[1]; // start�� �� end �ð� ���� ũ�� 
				cnt++;// ī��Ʈ 
			}
		}
		System.out.print(cnt);
		
	}// main 
}
    