import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Test {

	public static void main(String[] args) throws IOException {                                         
		                                                               
		 int m = 0;
			System.out.println("������� ���-�� �����");
			
			Scanner sc = new Scanner(System.in); // ������ ������ ������ Scanner
	        if(sc.hasNextInt()) { // ���������� ������� ���� � ������ ����� ����� ������� ����� �����
	          m = sc.nextInt(); // ��������� ����� ����� � ������ ����� � ��������� � ����������
	        } else {
	          System.out.println("�� ����� �� ����� �����");
	        }                                                              
	                                                                             
	 
	    JFrame jf = new JFrame("Tree with " + m + " nodes");                                       
	
	    DefaultMutableTreeNode super_root = new DefaultMutableTreeNode(0);
        // ������� ���� ���������� ������ ������
	    for (int i = 0; i < m; i++) {
	    	int k = 1 + (int) (Math.random() * 1000); // ������� ������������ �������
            // ��� ������� ����� �������� ������� ��������� ����������� ���� ������ JTree
            DefaultMutableTreeNode mroot = new DefaultMutableTreeNode(k);
            // ����� �� ���������� ������ ��������� ����
            super_root.add(mroot);
        }
	    
	    final JTree jt = new JTree(super_root);
	    
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           
	    jf.getContentPane().add(new JScrollPane(jt));                                
	    jf.pack();                                                                   
	    jf.setVisible(true); 
	    
	    
	    int n = 0;
		System.out.println("������� ������� ����");
		
		Scanner sc2 = new Scanner(System.in); // ������ ������ ������ Scanner
        if(sc2.hasNextInt()) { // ���������� ������� ���� � ������ ����� ����� ������� ����� �����
          n = sc2.nextInt(); // ��������� ����� ����� � ������ ����� � ��������� � ����������
        } else {
          System.out.println("�� ����� �� ����� �����");
        }
        
           
        
   

        /*
        super_root.getChildAt(n); //������� �������� n-��� �������
        super_root.getChildCount(); //������� ���-�� �������� �����
        
        super_root.children();
        */
       
  /*      Search sss = new Search();
        int find = -1;
        int i = 0; 
        for (i = 0; i < m; i++ ){
        
        find = sss.memRead(super_root, i); // �����!!! �����������!!!!
        
        if (find == n){
      	  System.out.println("������� ���� ��������� � ���� " + (i+1) + "-��� ������� �������� �����"); 
      //	  return;
        }
                 
        }
        */
        
	    int st = 0;
		System.out.println("������� ���-�� �����");
		
		Scanner sc3 = new Scanner(System.in); // ������ ������ ������ Scanner
        if(sc3.hasNextInt()) { // ���������� ������� ���� � ������ ����� ����� ������� ����� �����
          st = sc3.nextInt(); // ��������� ����� ����� � ������ ����� � ��������� � ����������
        } else {
          System.out.println("�� ����� �� ����� �����");
        }
        
        int step = m/st;
        
        Thread [] thread = new Thread[st];
        Function [] function = new Function[st];
        for(int i=0;i<(st-1);i++){
        	function[i] = new Function((step*i), step, super_root, n);
        	thread[i] = new Thread(function[i]);
        	thread[i].start();
        	
        }
        
        function[st-1] = new Function((step*(st-1)), (m-((st-1)*step)), super_root, n);
    	thread[st-1] = new Thread(function[st-1]);
    	thread[st-1].start();
        
		for (int i = 0; i < st; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				System.out.println("Intrrupted!");
			}
		}
        
        
        System.out.println("��� ����� �����");
	}
}
