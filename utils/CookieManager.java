package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class CookieManager {
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName, cValue);
		cookie.setPath("/");
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}
	//명시한 이름의 쿠키를 찾아 그값을 반환합니다.
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue ="";  //반환 값
		
		Cookie[] cookies=request.getCookies();
		if(cookies != null) {
			for (Cookie c : cookies) {
				String cookieName =c.getName();
				if(cookieName.equals(cName)) {
					cookieValue= c.getValue();
				}
			}
		}
		return cookieValue;
	}
	//명시 한 이름의 쿠키를 삭제합니다.
	public static void delete(HttpServletResponse response, String cName) {
		makeCookie(response, cName, "", 0);
		}
}
