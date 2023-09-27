package fileupload2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class FileUtil {
	//명시한 파일을 찾아 다운로드합니다
	public static void download(HttpServletRequest req, HttpServletResponse resp,
			String directory, String sfileName, String ofileName) {
		String sDirectory= req.getServletContext().getRealPath(directory);
		try {
			//파일을 잧아 입력 스트림 생성
			file file= new File(shirectory, sfileName);
			InputStream iStream= new FileInputStream(file);
			
			//한글 파일명 깨짐 방지
			String client= req.getHeader("User-Agent");
			if(client.indexOf("WOW64")== -1) {
				ofileName= new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			else {
				ofileName= new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
			}
			//파일 다운로드용 응답 헤더 설정
			resp.reset();
			resp.setContentType("Content-);
		}
		
	}
	
	
//파일 업로드(multipart/form-data 요청) 처리
	public static MultipartRequest uploadFile(HttpServletRequest req,
			String saveDirectory, int maxPostSize) {
		try {
			//파일 업로드
			return new MultipartRequest(req, saveDirectory, maxPostSize, "UTF-8");
		}
		catch(Exception e) {
			//업로드 실패
			e.printStackTrace();
			return null;
		}
		
	}

}
