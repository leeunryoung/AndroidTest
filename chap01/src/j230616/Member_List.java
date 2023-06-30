package j230616;
import java.awt.BorderLayout;

import java.awt.event.*;
import java.util.*;
//import java.util.List;
import javax.swing.*;
import javax.swing.JFrame;
//import javax.swing.JFrame(JTable,JPanel,JButton,JScrollPane,JOptionPane)
import javax.swing.table.DefaultTableModel;

import kkk2.MemberProc;



//@SuppressWarnings("serial")
public class Member_List extends JFrame implements MouseListener,ActionListener{

	  Vector v;   //data 내용 list 
      Vector cols; //list의 제목줄
      DefaultTableModel model;
      JTable jTable;
      JScrollPane pane;
      JPanel pbtn;
      JButton btnInsert;

      public <CMemberDAO> Member_List(){

             super(" 테니스 회원 리스트 " );

          //   v=getMemberList();

           //  CMemberDAO

             MemberDAO dao = new MemberDAO();
             v = dao.getMemberList();
//테이블 내용
             System.out.println("v="+v);

             cols = getColumn();

             //public DefaultTableModel()

//             public DefaultTableModel(int rowCount, int columnCount)
//
//             public DefaultTableModel(Vector columnNames, int rowCount)
//
//             public DefaultTableModel(Object[] columnNames, int rowCount)
//
//             public DefaultTableModel(Vector data,Vector columnNames)
//
//             public DefaultTableModel(Object[][] data,Object[] columnNames)

             model = new DefaultTableModel(v, cols);
//-----------이게 있어야 창에 출력됨 (v-행, cols-열)
             //JTable()

             //JTable(int numRows, int numColumns)

             //JTable(Object[][] rowData, Object[] columnNames)

             //JTable(TableModel dm)

             //JTable(TableModel dm, TableColumnModel cm)

             //JTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm)

             //JTable(Vector rowData, Vector columnNames)   

             //jTable = new JTable(v,cols);
//----------내용을 담을 테이블
             jTable = new JTable(model);
             pane = new JScrollPane(jTable);
             add(pane);

             pbtn = new JPanel();
             btnInsert = new JButton("회원가입");
             pbtn.add(btnInsert);
             add(pbtn,BorderLayout.NORTH);

             jTable.addMouseListener(this); //리스너 등록
             btnInsert.addActionListener(this); //회원가입버튼 리스너 등록

             setSize(600,200);
             setVisible(true);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }//end 생성자
  
      //JTable의 컬럼
	public Vector getColumn(){
             Vector col = new Vector();
             col.add("Id");
             col.add("Pwd");
             col.add("Name");
             col.add("Age");
             col.add("Gender");          
             col.add("Addr");
             col.add("Guruk");
             col.add("Specialty");

             return col;
      }//getColumn

      //Jtable 내용 갱신 메서드
      public void jTableRefresh(){
           
    	  MemberDAO dao = new MemberDAO();
          DefaultTableModel model= new DefaultTableModel(dao.getMemberList(), getColumn());
          jTable.setModel(model);          
      }
      
     public static void main(String[] args) {
             new Member_List();
      }//main

      @Override
      public void mouseClicked(MouseEvent e) {
             // mouseClicked 만 사용
             int r = jTable.getSelectedRow();
             String id = (String) jTable.getValueAt(r, 0);
             //System.out.println("id="+id);
             MemberProc mem = new MemberProc(id, this); 
             //아이디를 인자로 수정창 생성
      }
      @Override
      public void mouseEntered(MouseEvent e) {
             // TODO Auto-generated method stub
      }
      @Override
      public void mouseExited(MouseEvent e) {
             // TODO Auto-generated method stub
      }
      @Override
      public void mousePressed(MouseEvent e) {
             // TODO Auto-generated method stub
      }
      @Override
      public void mouseReleased(MouseEvent e) {
             // TODO Auto-generated method stub
      }
      @Override
      public void actionPerformed(ActionEvent e) {
             //버튼을 클릭하면
             if(e.getSource() == btnInsert ){
                    new MemberProc(this);
                    
             /*테스트*/
                    //dao = new CustomerDAO();              
                    //dao.userSelectAll(model);
                    //model.fireTableDataChanged();
                    //jTable.updateUI();             
                    //jTable.requestFocusInWindow();
           }
      }}
       

