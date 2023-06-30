package s20230609;

import java.util.ArrayList;
import java.util.Scanner;

import j230530.MemberDAO;

public class MemberTest2 {

	    public static void main(String[] args) {
	        System.out.print("Input ename...? ");
	        Scanner sc = new Scanner(System.in);
	        String inp = sc.next();
	        
	        System.out.println(inp);
	        sc.close();
	 
	        MemberDAO dao = new MemberDAO();
	        ArrayList<MemberVo> list = dao.list(inp);
	 
	        for (int i = 0; i < list.size(); i++) {
	            MemberVo data = (MemberVo) list.get(i);
	            String empno = data.getEmpno();
	            String ename = data.getEname();
	      
	            System.out.println(empno + " : " + ename + " : ");
	        }
	    }
	    public class MemberVo {
	        private String empno;
	        private String ename;
	  
	     
	        public MemberVo() {
	     
	        }
	     
	        public MemberVo(String empno, String ename) {
	            this.empno = empno;
	            this.ename = ename;
	          
	        }
	     
	        public String getEmpno() {
	            return empno;
	        }
	     
	        public String getEname() {
	            return ename;
	        }
	     
	       
	    }}
