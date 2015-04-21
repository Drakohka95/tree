import java.io.*;

import javax.swing.tree.DefaultMutableTreeNode;
   
public class Search {
    public int memRead(DefaultMutableTreeNode node, int i) 
            throws IOException {
    	int find = 0;
    	
          // ������� ����� ������ � ������ 
          StringWriter writer = 
            new StringWriter(128);
          // �������� ������ � ����� ������
          save(writer, node, i);
          // ������� �����
          writer.close();
          // ������� ����� ��� ����
          Reader reader = 
            new StringReader(writer.toString());
          BufferedReader bufferedReader = 
            new BufferedReader(reader);
          // ��������� ����
          String line;
          while ((line = bufferedReader.readLine()) 
              != null) {
     //       System.out.println(line);
          find = Integer.parseInt(line);
          }
          bufferedReader.close();
          
          return find;
        }
        private static void save(Writer generic,  DefaultMutableTreeNode node, int i) 
            throws IOException {
          PrintWriter out = new PrintWriter(generic);
          
          DefaultMutableTreeNode super_root;
          
          super_root = node;
          out.println(super_root.getChildAt(i));
        }
      } 