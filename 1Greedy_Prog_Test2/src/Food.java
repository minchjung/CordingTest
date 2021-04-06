import java.util.LinkedList;
import java.util.*;

class Food{
	private int time;
	private int idx; 
	
	public Food(int time, int idx) {
		this.time = time ;
		this.idx = idx; 
	}

	public int getTime() {
		return time;
	}

	public void SetTime(int time) {
		this.time=time;
	}

	public int getIdx() {
		return idx;
	}

}
class Solution{
	static int solution(int[]arr, long k) {
		Queue<Food> q = new LinkedList<Food>();
		int num=1;
		int sum=0;
		for(int a : arr) {
			q.offer(new Food(a,num));
			sum+=a;
			num++;
		}
		if(sum<=k) {return -1;}
		else if (q.size()==1) {return 1;}
		
		int sec=0;
		while(true) {
			sec++;
			Food food = q.poll();
			int now = food.getTime();
			int idxNow = food.getIdx();
			if(sec < k ) { 
				int nxt = now-1; 
				if(nxt !=0) {
					food.SetTime(nxt);
					q.offer(food);
				}
			}else {
				if(q.isEmpty()) { return idxNow;}  
				return q.poll().getIdx();
			}
		}
	}//solution func
}//Solution class

