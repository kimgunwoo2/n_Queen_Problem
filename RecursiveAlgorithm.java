package ����1�ܰ�;
import java.util.Stack;
import java.util.Vector;


public class RecursiveAlgorithm {
	
	Stack<Queen> st = new Stack<Queen>();
	 Vector<answer> vc = new Vector<answer>();
	  boolean isPromising(int[] q, int n) {
	        for (int i = 0; i < n; i++) {
	            if (q[i] == q[n]) return false;   // ���� ������
	            if (Math.abs(q[i] - q[n]) == Math.abs(n - i)) return false;   // �밢�� ����
	        
	        }
	        return true;
	    }
	   void enumerate(int N) {
	        int[] a = new int[N];
	        enumerate(a, 0);
	    }
	   void enumerate(int[] q, int n) {
	        int N = q.length;

	       
	        if (n == N) { 
	        	answer an=new answer(N);
	        	for(int i=0; i<N; i++){
	        		an.getanswer(i).set(i+1,q[i]+1 );	 
	        	}
	        	vc.add(an);
	        } else {
	            for (int i = 0; i < N; i++) {
	                q[n] = i;
	                if (isPromising(q, n)) enumerate(q, n + 1);   // �����ϴٸ� ��� Ž��(���ȣ��)
	            }
	        }
	    }
	  void start(int num){
	      
	            enumerate(num);
	       
	     
	  }

}
