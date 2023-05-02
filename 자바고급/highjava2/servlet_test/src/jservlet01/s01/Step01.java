package jservlet01.s01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Step01
 */

public class Step01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;

    /**
     * Default constructor. 
     */
    public Step01() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		System.out.println("Step01");
		System.out.println("1. init");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2. doGet, count : " + this.count++);
	}

	@Override
	public void destroy() {
		System.out.println("3. destroy");
	}
	
}
