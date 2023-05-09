package kr.or.dw.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionDeleteServlet.do")
public class SessionDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Session 삭제하기
		
		// 1. Session 객체 가져오기
		HttpSession session = req.getSession();
		
		// 2. 세션값만 삭제하기 ==> removeAttribute()메서드 이용
		// 형식) session객체.removeAttribute("삭제할 세션 key값");
		session.removeAttribute("testSession"); // 세션에 저장된 데이터만 삭제. 세션을 삭제하는것은 아니다.
		
		// 3. 세션 자체를 삭제하기 ==> invalidate() 메서드 사용
		// 형식) session객체.invalidate();
		session.invalidate();
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out= res.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터가 삭제되었습니다.</h2><br><br>");
		out.println("<a href='"+req.getContextPath()+"/basic/03/sessionTest.jsp'>시작문서로 이동</a>");
		out.println("</bodt></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
