package j230616;

//package CustomerAccount;
//이름 규칙 : 테이블명DAO , 테이블명DTO
//CRUD : Create;insert , Read;Select, Update, delete

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
//DB 처리
public class MemberDAO {
	
private static final String DRIVER
       = "oracle.jdbc.driver.OracleDriver";
private static final String URL
       = "jdbc:oracle:thin:@localhost:1521:xe";
private static final String USER = "C##himedia"; //DB ID
private static final String PASS = "himedia"; //DB 패스워드
Member_List mList;
	 
public MemberDAO() {

}

public MemberDAO(Member_List mList){
	
    this.mList = mList;
    System.out.println("DAO=>"+mList);
}
/**DB연결 메소드*/

public Connection getConn(){

    Connection con = null;
    
    try {
           Class.forName(DRIVER); //1. 드라이버 로딩
           con = DriverManager.getConnection(URL,USER,PASS); //2. 드라이버 연결

    } catch (Exception e) {
           e.printStackTrace();
    }
    return con;

}
/**한사람의 회원 정보를 얻는 메소드*/

public MemberDTO getMemberDTO(String id){
      
	MemberDTO dto = new MemberDTO();

       Connection con = null;             //연결
       PreparedStatement ps = null; //명령
       ResultSet rs = null;       //결과

       try {
              con = getConn();
              String sql = "select * from tb_Member2 where id= audus";
              ps = con.prepareStatement(sql);
              ps.setString(1, id);
              rs = ps.executeQuery(); 
              
              if(rs.next()){
                    dto.setId(rs.getString("id"));
                    dto.setPwd(rs.getString("pwd"));
                    dto.setName(rs.getString("Name"));
                    dto.setAge(rs.getString("age"));
                    dto.setAddr(rs.getString("gender"));
                    dto.setGuruk(rs.getString("addr"));
                    dto.setGender(rs.getString("guruk"));
                    dto.setSpecialty(rs.getString("specialty"));
              }
       } catch (Exception e) {
              e.printStackTrace();
       }            
      return dto;         
}

/**멤버리스트 출력*/
public Vector getMemberList(){
	
       Vector data = new Vector();  //Jtable에 값을쉽게넣는방법 1.2차원배열 2.Vector에 vector추가
       Connection con = null;             //연결
       PreparedStatement ps = null; //명령
       ResultSet rs = null;       //결과

       try{
              con = getConn();
              String sql = "select * from Member2 order by name asc";
              ps = con.prepareStatement(sql);
              rs = ps.executeQuery();

              while(rs.next()){
                    String id = rs.getString("id");
                    String pwd = rs.getString("pwd");
                    String name = rs.getString("name");
                    String age = rs.getString("age");
                    String gender = rs.getString("gender");             
                    String addr = rs.getString("addr");
                    String guruk = rs.getString("guruk");
                    String specialty = rs.getString("specialty");
                    
                    Vector row = new Vector();                 
                    row.add(id);
                    row.add(pwd);
                    row.add(name);
                    row.add(age);
                    row.add(gender);
                    row.add(addr);
                    row.add(guruk);
                    row.add(specialty);
                    
                    data.add(row);                          
              }//while
       }catch(Exception e){
              e.printStackTrace();
       }
       return data;
  }      //getMemberList()
}
/**회원 등록*/
public boolean insertMember(MemberDTO dto){
       boolean ok = false;
       Connection con = null;             //연결
       PreparedStatement ps = null; //명령
       try{
          con = getConn();
     String sql = "insert into Member2(" +
                  "id,pwd,name,age,gender," +
                  "addr,guruk, specialty) "+
                  "values(?,?,?,?,?,?,?,?,?,?)";
 
              ps = con.prepareStatement(sql);
              ps.setString(1, dto.getId());
              ps.setString(2, dto.getPwd());
              ps.setString(3, dto.getName());
              ps.setString(4, dto.getAge());
              ps.setString(5, dto.getGender());
              ps.setString(6, dto.getAddr());
              ps.setString(7, dto.getGuruk());
              ps.setString(8, dto.getSpecialty());
              int r = ps.executeUpdate(); //실행 -> 저장
              
              if(r>0){
                    System.out.println("가입 성공"); 
                    ok=true;
              }else{
                    System.out.println("가입 실패");
              }
              
       }catch(Exception e){
              e.printStackTrace();
       }
       return ok;
}//insertMmeber



/**회원정보 수정*/
public boolean updateMember(MemberDTO vCus){
       System.out.println("dto="+vCus.toString());
       boolean ok = false;
       Connection con = null;
       PreparedStatement ps = null;

       try{ 
              con = getConn();                 
              String sql = "update tb_Member set name=?, addr=?, birth=?, job=?, gender=?" +
                           ", intro=? "+ "where id=? and pwd=?";
  
              ps = con.prepareStatement(sql);
             
              ps.setString(1, vCus.getId());
              ps.setString(2, vCus.getPwd());
              ps.setString(3, vCus.getName());
              ps.setString(4, vCus.getAge());
              ps.setString(5, vCus.getGender());
              ps.setString(6, vCus.getAddr());
              ps.setString(7, vCus.getGuruk());
              ps.setString(8, vCus.getSpecialty());

              int r = ps.executeUpdate(); //실행 -> 수정
              // 1~n: 성공 , 0 : 실패
              if(r>0) ok = true; //수정이 성공되면 ok값을 true로 변경

       }catch(Exception e){
              e.printStackTrace();
       }
       return ok;
}

/**회원정보 삭제 :
 *tip: 실무에서는 회원정보를 Delete 하지 않고 탈퇴여부만 체크한다.*/
public boolean deleteMember(String id, String pwd) {
       boolean ok =false ;
       Connection con =null;
       PreparedStatement ps =null;

       try {
              con = getConn();
              String sql = "delete from tb_Member where id=? and pwd=?";
              
              ps = con.prepareStatement(sql);
              ps.setString(1, id);
              ps.setString(2, pwd);
              int r = ps.executeUpdate(); // 실행 -> 삭제

             if (r>0) ok=true; //삭제됨;

       } catch (Exception e) {
              System.out.println(e + "-> 오류발생");
       }            
       return ok;
}
/**DB데이터 다시 불러오기*/  
public void userSelectAll(DefaultTableModel model) {

Connection con =  null;
PreparedStatement ps = null;
ResultSet rs = null;

try {
   con = getConn();
   String sql = "select * from tb_Member order by name asc";
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   
   // DefaultTableModel에 있는 데이터 지우기
   for (int i = 0; i < model.getRowCount();) {
       model.removeRow(0);
   }
   
   while (rs.next()) {
       Object data[] = {rs.getString(1), rs.getString(2),
               rs.getString(3), 
               rs.getString(4),
               rs.getString(5),
               rs.getString(6),
               rs.getString(7),
               rs.getString(8)};
               
       model.addRow(data);               
   }
} catch (SQLException e) {
   System.out.println(e + "=> userSelectAll fail");
} finally{

          if(rs!=null)
                    try {
                           rs.close();
                     } catch (SQLException e2) {
                           // TODO Auto-generated catch block
                           e2.printStackTrace();
                    }
              if(ps!=null)
                    try {
                           ps.close();
                    } catch (SQLException e1) {
                           // TODO Auto-generated catch block
                           e1.printStackTrace();
                     }
              if(con!=null)
                    try {
                           con.close();
                    } catch (SQLException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                    }
           }
   }
}









