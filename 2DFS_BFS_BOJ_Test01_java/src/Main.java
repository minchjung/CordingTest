import java.util.*;
public class Main {
	public static void main(String[] args) {
		// Ư�� ��带 index�� ���ٽ� ����� �ð� ���⵵�� ������ ArrayList 
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); 
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); // �ѳ�� ��
		int m = sc.nextInt(); // �� ���� �� 
		int v = sc.nextInt(); // ���� ��� 
		
		for(int i=0 ; i <= 1000;i++ ) {// ���� ��+1��ŭ �ʱ�ȭ �ϸ� ��Ÿ�� ����! �׳� max������ �ʱ�ȭ;
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0 ; i < m;i++ ) {// ���� �Է°� ����
			int a = sc.nextInt();
			int b = sc.nextInt();
			 
			adj.get(a).add(b); // ����� ���� ������ �������� ����
			adj.get(b).add(a);
		}
 
		// DFS by Stack  
		Stack<Integer> stack = new Stack<Integer>();
		boolean [] visit = new boolean[n+1]; // ��� ���� +1 ��ŭ �迭 (0)�� �ε��� ������ 
		ArrayList<Integer> dfs = new ArrayList<>(); // visit ������ ���� ans
		// python ó�� ��带 �湮 ����Ʈ�� append ������ ó���ϸ� �ڹٿ��� ��ȸ�ϱ� ���� for���� ���ƾ���
		// boolean ����Ʈ�� �ε����� ��ȸ�� ��1 �ð� ���⵵�� set
		stack.push(v);
		visit[v]=true;
		dfs.add(v);
		while(! stack.isEmpty()) {
			int now = stack.pop(); //�ֱٿ� �� node - ���� node ���� ����
			Collections.sort(adj.get(now)); 
			// ���� ��忡 ����� ��� ������ �������� ���� �� �����´�.
			Collections.reverse(adj.get(now)); //��������
			for(int i : adj.get(now)) { 
				//i�� ū node���� �̾��� ����
				//�������� ������ ��ұ� ������ ��� �ִ� index�� ����
				// ��ȸ �ð� O(1), stack �߰� ���� �ð� O(1) ��� ��� �ð�, ���� ��� ó�� ���� ����.
				if(! visit[i]) {
					stack.push(i);
					} 
			}
			if(! visit[now]) { // ���ΰ� ����Ŭ�� ����Ǹ� �������� �ߺ�ó�� �Ǳ� ������ ����ó��
				visit[now]=true;
				dfs.add(now);
			}
		}
		//BFS by Queue 
		Queue<Integer> q = new LinkedList<>(); 
		boolean[] visit2 =new boolean[n+1]; 
		ArrayList<Integer> bfs = new ArrayList<>(); // visit ������ ���� ans
		q.offer(v); 
		visit2[v]=true;
		bfs.add(v);
		  
		while(! q.isEmpty() ){
			int now = q.poll(); 
			Collections.sort(adj.get(now)); //�������� 
			for(int i : adj.get(now)) {
				if(! visit2[i]) {
					q.offer(i);
				}
			}
			if(! visit2[now]) {
				visit2[now]=true;
				bfs.add(now);
			}
		}
		//DFS ���
		for(int i = 0 ; i<dfs.size(); i++ ) {
			System.out.print(dfs.get(i)); //���ڷ� print !!
			System.out.print(" "); 
		}
		System.out.println(); 
		//BFS ��� 
		for(int i = 0 ; i<bfs.size(); i++ ) {
			System.out.print(bfs.get(i));
			System.out.print(" "); 
		}
	}//main
}
