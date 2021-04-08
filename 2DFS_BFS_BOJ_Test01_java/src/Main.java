import java.util.*;
public class Main {
	public static void main(String[] args) {
		// 특정 노드를 index로 접근시 상수의 시간 복잡도를 가지는 ArrayList 
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); 
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); // 총노드 수
		int m = sc.nextInt(); // 총 간선 수 
		int v = sc.nextInt(); // 시작 노드 
		
		for(int i=0 ; i <= 1000;i++ ) {// 간선 수+1만큼 초기화 하면 런타임 오류! 그냥 max값으로 초기화;
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0 ; i < m;i++ ) {// 간선 입력값 세팅
			int a = sc.nextInt();
			int b = sc.nextInt();
			 
			adj.get(a).add(b); // 노드의 간선 정보를 양쪽으로 셋팅
			adj.get(b).add(a);
		}
 
		// DFS by Stack  
		Stack<Integer> stack = new Stack<Integer>();
		boolean [] visit = new boolean[n+1]; // 노드 갯수 +1 만큼 배열 (0)번 인덱스 값없음 
		ArrayList<Integer> dfs = new ArrayList<>(); // visit 순서를 담을 ans
		// python 처럼 노드를 방문 리스트에 append 식으로 처리하면 자바에서 조회하기 위해 for문을 돌아야함
		// boolean 리스트로 인덱스로 조회해 오1 시간 복잡도로 set
		stack.push(v);
		visit[v]=true;
		dfs.add(v);
		while(! stack.isEmpty()) {
			int now = stack.pop(); //최근에 들어간 node - 작은 node 부터 뽑음
			Collections.sort(adj.get(now)); 
			// 현재 노드에 연결된 노드 정보를 오름차순 정렬 후 뒤집는다.
			Collections.reverse(adj.get(now)); //내림차순
			for(int i : adj.get(now)) { 
				//i는 큰 node부터 뽑아져 나옴
				//양쪽으로 정보를 담았기 때문에 비어 있는 index는 없음
				// 조회 시간 O(1), stack 추가 삽입 시간 O(1) 모두 상수 시간, 양쪽 담아 처리 무리 없음.
				if(! visit[i]) {
					stack.push(i);
					} 
			}
			if(! visit[now]) { // 도로가 사이클로 연결되면 마지막이 중복처리 되기 때문에 조건처리
				visit[now]=true;
				dfs.add(now);
			}
		}
		//BFS by Queue 
		Queue<Integer> q = new LinkedList<>(); 
		boolean[] visit2 =new boolean[n+1]; 
		ArrayList<Integer> bfs = new ArrayList<>(); // visit 순서를 담을 ans
		q.offer(v); 
		visit2[v]=true;
		bfs.add(v);
		  
		while(! q.isEmpty() ){
			int now = q.poll(); 
			Collections.sort(adj.get(now)); //오름차순 
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
		//DFS 출력
		for(int i = 0 ; i<dfs.size(); i++ ) {
			System.out.print(dfs.get(i)); //숫자로 print !!
			System.out.print(" "); 
		}
		System.out.println(); 
		//BFS 출력 
		for(int i = 0 ; i<bfs.size(); i++ ) {
			System.out.print(bfs.get(i));
			System.out.print(" "); 
		}
	}//main
}
