
import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;


public class Function implements Runnable {
		int start,step,key;
		DefaultMutableTreeNode node;
	public Function(int start,int step, DefaultMutableTreeNode node, int key){
		this.start = start;
		this.step = step;
		this.node = node;
		this.key = key;
	}
	public void run() {
		Search sss = new Search();
        int find = -1;
        int i = 0; 
        for (i = start; i < (start+step) ; i++ ){
        
        try {
			find = sss.memRead(node, i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // �����!!! �����������!!!!
        
        if (find == key){
      	  System.out.println("������� ���� ��������� � ���� " + (i+1) + "-��� ������� �������� �����"); 
      //	  return;
        }
                 
        }
		
		
	}
}
