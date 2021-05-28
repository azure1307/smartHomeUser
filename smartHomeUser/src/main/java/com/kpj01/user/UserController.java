package com.kpj01.user;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UserController
 */
@WebServlet({"/index.do", "/u_join.do", "/u_login.do", "/c_cs.do"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sPath = request.getServletPath();
		// sPath 제대로 연결되는지 확인차
		System.out.println("현재 sPath 경로는 " + sPath + " 입니다.");
		
		if (sPath.equals("/index.do")) {
			System.out.println(" ==== 현재 index.jsp 입니다.==== ");
			// 원하는 페이지(sPath)로 이동시켜주고 싶을 때
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}  
		// 회원가입창 - insert.do
		else if (sPath.equals("/u_join.do")) {
			System.out.println("==== 현재 u_join.jsp 입니다.====");

			RequestDispatcher rd = request.getRequestDispatcher("user/u_join.jsp");
			rd.forward(request, response);
		} 
		else if (sPath.equals("/u_joinOK.do")) {
			System.out.println("----- u_joinOK.do ----");

			UserVO vo = new UserVO();
			UserDAO dao = new UserDAOimpl();
			
			/* System.out.println(request.getParameter("contentTitle"));
			// System.out.println(request.getParameter("contentDirector"));
			System.out.println(request.getParameter("contentPoint"));
			System.out.println(request.getParameter("contentReview"));
			System.out.println(request.getParameter("contentPeopleName"));
			System.out.println(request.getParameter("contentRating"));
			System.out.println(request.getParameter("contentRecommend"));
			System.out.println(request.getParameter("contentSnack"));
			*/
			
			vo.setUserId(request.getParameter("userId"));
			vo.setUserPw(request.getParameter("userPw"));
			vo.setUserName(request.getParameter("userName"));
			vo.setUserPhone(request.getParameter("userPhone"));
			vo.setUserAddSi(request.getParameter(("userAddSi")));
			vo.setUserAddGu(request.getParameter("userAddGu"));
			vo.setUserAddDong(request.getParameter("userAddDong"));
			vo.setUserAddDetail(request.getParameter("userAddDetail"));
			vo.setUserBirth(request.getParameter("userBirth"));
			vo.setUserAge(Integer.parseInt(request.getParameter("userAge")));
			vo.setUserNick(request.getParameter("userNick"));

			int result = dao.insert(vo);
			System.out.println("insert result:" + result);

			if (result == 1) {
				// response.sendRedirect("u_login.do");
			} else {
				// response.sendRedirect("u_join.do");
			}
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
