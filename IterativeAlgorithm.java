package 소프1단계;
import java.util.Vector;
import java.util.Stack;

class Queen {
  int getx(){
	  
	  return x;
  }
  int gety(){
	  
	  return y;
  }
   void set(int x, int y) {
      this.x = x;
      this.y = y;
   }
  private int x, y;
}

class answer {
    answer(int n) {
    	anw=new Queen[n]; 
    	for(int i=0; i<n; i++)
      anw[i]=new Queen();
   }
    Queen getanswer(int index){
    	
    	return anw[index];
    }
  private Queen anw[];
}

public class IterativeAlgorithm {
   Stack<Queen> st = new Stack<Queen>();
   Vector<answer> vc = new Vector<answer>();
 
   public static boolean isPromising(Stack<Queen> st, Queen test) {
      for (int i = 0; i < st.size(); i++) {
         if (st.get(i).gety() == test.gety() || st.get(i).getx() == test.getx())
            return false; // 같은 행이나,열인지
         if (Math.abs(st.get(i).getx() - test.getx()) == Math.abs(st.get(i).gety() - test.gety()))
            return false; // '\' 방향
         
      }
      return true;
   }

   void start(int num) {

      int i = 1, j = 1;
      int sum = 0;
      Queen Q = new Queen();
      
         for (; i <= num; i++) {
            for (; j <= num; j++) {
               Queen Qt = new Queen();
               Qt.set(i, j);
               if (isPromising(st, Qt)) {
                  st.push(Qt);
                  break;
               }

            }
            if (i != st.size() && st.size() != 0) {//행에서 스택에 저장이 안됫을때
               Q = st.pop();
               i = Q.getx() - 1;
               j = Q.gety() + 1;
            
            } else
               j = 1;
            if (st.size() == num) {
                answer an = new answer(num);

               for (int r = 0; r < st.size(); r++) {
            	  
                  an.getanswer(r).set( st.get(r).getx(),st.get(r).gety()); 
               }
               vc.add(an);

               sum = sum + 1;
               System.out.println();
               Q = st.pop();
               i = Q.getx() - 1;
               j = Q.gety() + 1;
            

            }

         }

      
   }
}