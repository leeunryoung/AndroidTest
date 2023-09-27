package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.servlet.ServletContext;
import common.JDBConnect;

@SuppressWarnings("unused")
public class BoardDAO extends JDBConnect{


	//게시글 데이터를 받아  DB에 추가함.
	public int insertWrite(BoardDTO dto){
		int result=0;
		
		try {
			//INSERT 쿼리문 작성
			String query= "INSERT INTO board("
					+ "num,title, content, id, visitcount)"
					+"VALUES("
					+"seq_board_num.NEXTVAL, ?,?,?,0)";
			
			psmt=con.prepareStatement(query);//동적 쿼리
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			
			result=psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
//}
	
	
	public int selectCount(Map<String, Object> map) {
	   int totalCount=0;
    
	 String query= "SELECT COUNT(*) FROM board";
	 if(map.get("searchWord") != null) {
		 query += "WHERE" + map.get("searchField") + " "
				 +"LIKE '%" + map.get("searchWord") + "%'";
	 }
	 try {
		 stmt=con.createStatement();//쿼리문 생성		 
		 rs=stmt.executeQuery(query); //쿼리 실행
		 
		 rs.next();
		 totalCount=rs.getInt(1);
	 }
	 catch(Exception e) {
		 System.out.println("게시물 수를 구하는 중 예외 발생");
		 e.printStackTrace();
	 }
	 return totalCount;
	}	
	//검색 졸건에 맞는 게시물 목록을 반환합니다.
    //검색 조건에 맞는 게시물 목록을 반환합니다.(페이징 기능 지원).
	public List<BoardDTO> selectListPage(Map<String, Object> map){
		List<BoardDTO> bbs=new Vector<BoardDTO>();// 결과(게시물 목록)를 담을 변수 
		
    //쿼리문 템플릿
	String query = " SELECT * FROM ( "
			   	 + "  SELECT Tb.*, ROWNUM rNum FROM ( "
			     + "     SELECT * FROM board";
	//검색 조건 추가
	if(map.get("searchWord") != null) {
		query +=" WHERE " + map.get("searchField")
				+ " LIKE '%" + map.get("searchWord")+ "%' ";
	}
	
	query +="   ORDER BY num DESC "
			+"    )Tb "
			+" ) "
			+ "WHERE rNum BETWEEN ? AND ?";
	try {
		//쿼리문 완성
		psmt= con.prepareStatement(query);
		psmt.setString(1, map.get("start").toString());
		psmt.setString(2, map.get("end").toString());
		
		//쿼리문 실행
		rs = psmt.executeQuery();
		
		while (rs.next()) {
			//한 행(게시물 하나)의 데이터를 DTO에 저장
			BoardDTO dto= new BoardDTO();
			dto.setNum(rs.getString("num"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setPostdate(rs.getDate("postdate"));
			dto.setId(rs.getString("id"));
			dto.setVisitcount(rs.getString("Visitcount"));
			//반환할 결과 목록에 게시물 추가
			bbs.add(dto);
		}
	}
	catch(Exception e) {
		System.out.println("게시물 조회 중 예외 발생");
		e.printStackTrace();
	}
	//목록 반환
	return bbs;
	}

	public List<BoardDTO> selectList(Map<String, Object> map){
	   List<BoardDTO> bbs=new Vector<BoardDTO>();
	   										//결과(게시물 목록)을 담을 변수
	   //결과(게시물 목록)을 담을 변수
	   String query="SELECT * FROM board ";
	   if(map.get("searchWord") != null) {
		   query += "WHERE" + map.get("searchField") + " "
				   + "LIKE '%"+ map.get("searchMord") + "%' ";
	   }
	   query +=" ORDER BY num DESC ";
	   
	   try {
		   stmt= con.createStatement();  //쿼리문 생성
		   rs= stmt.executeQuery(query);  //쿼리 실행
		   
		   while (rs.next()) {  //결과를 순회하며 
			   // 한 행(게시물 하나)의 내용을 DTO에 저장
			   BoardDTO dto= new BoardDTO();  
			   dto.setNum(rs.getString("num"));  //일련번호
			   dto.setTitle(rs.getString("title"));  //제목
			   dto.setContent(rs.getString("content")); //내용
			   dto.setPostdate(rs.getDate("postdate"));  //작성일
			   dto.setId(rs.getString("id"));      //작성자 아이디
			   dto.setVisitcount(rs.getString("visitcount"));   //조회수
			   
			   bbs.add(dto);//결과 목록에 저장
		   }
	   }
	   catch(Exception e) {
		   System.out.println("게시물 조회 중 예외 발생");
		   e.printStackTrace();
	   }
	   return bbs;
   }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
