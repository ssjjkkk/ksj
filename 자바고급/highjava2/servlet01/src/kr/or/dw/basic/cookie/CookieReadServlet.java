package kr.or.dw.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet ("/CookieReadServlet.do")
public class CookieReadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 저장된 쿠키 읽어오기
		// 1) 전체 쿠키 정보를 request 객체를 통해서 가져온다.
		// 		==> 이때 가져온 쿠키 정보들은 배열에 저장된다.
		// 형식) Cookie[] 쿠키배열변수 = request.getCookies();
		Cookie[] cookieArr = req.getCookies();
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html><head><meta charset='UTF-8'><title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Cookie 데이터 확인하기</h2>");
		
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h2>저장된 쿠키 정보가 없습니다.</h2>");
		}else {
			for (Cookie c : cookieArr) {
				out.println("쿠키 변수 : " + c.getName() + "<br>"); 
	 			out.println("쿠키 값 : " + URLDecoder.decode(c.getValue(), "utf-8") + "<hr>");
			}
			out.println("<br><br>");
		}
		out.println("<a href='" + req.getContextPath() + "/basic/02/cookieTest.jsp'>시작문서로 이동</a>");
		out.println("</body></html>");
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
