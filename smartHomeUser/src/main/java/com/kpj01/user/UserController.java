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
@WebServlet({"/index.do", "/u_join.do", "/u_joinOK.do", "/u_login.do", "/u_loginOK.do", "/c_cs.do", "/u_update.do", "/u_updateOK.do"})
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
		} else if (sPath.equals("/u_join.do")) {
			System.out.println("==== 현재 u_join.jsp 입니다.====");

			RequestDispatcher rd = request.getRequestDispatcher("user/join.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/u_joinOK.do")) {
			System.out.println("----- u_joinOK.do ----");

			UserVO vo = new UserVO();
			UserDAO dao = new UserDAOimpl();
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

//			int result = 0;
			int result = dao.insert(vo);
			System.out.println("insert result:" + result);
			
			if (result == 1) { //회원 가입 성공시 '로그인이 됐다'고 써진 페이지로 이동.
				response.sendRedirect("u_login.do");
			} else { //회원 가입 성공 X => 다시 가입 페이지로 이동.
				response.sendRedirect("u_join.do");
			}
		} else if (sPath.equals("/u_update.do")) {
			// 여기선 삭제할 행 번호 1개를 선택하는 로직만.
			System.out.println("----- u_update.do ----");

			UserVO vo = new UserVO();
			UserDAO dao = new UserDAOimpl();
			String num = String.valueOf(request.getSession().getAttribute("userNum"));
			System.out.println(num);
			vo.setUserNum(Integer.parseInt(num));

			UserVO vo2 = dao.selectOne(vo);

			request.setAttribute("vo2", vo2);
			System.out.println(vo2.toString());
			RequestDispatcher rd = request.getRequestDispatcher("user/update.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/u_updateOK.do")) {
			// else if (sPath.equals("/m_updateOK.do")) {
			System.out.println("----- m_update.do ----");
			// 객체 1개 선택 dao.update해주기 .update가 수정하는 함수니까.
			UserVO vo = new UserVO();
			UserDAO dao = new UserDAOimpl();

			vo.setUserNum(Integer.parseInt(request.getParameter("userNum")));
			vo.setUserId(request.getParameter("userId"));
			vo.setUserPw(request.getParameter("userPw"));
			vo.setUserName(request.getParameter("userName"));
			vo.setUserPhone(request.getParameter("userPhone"));
			vo.setUserAddSi(request.getParameter("userAddSi"));
			vo.setUserAddGu(request.getParameter("userAddGu"));
			vo.setUserAddDong(request.getParameter("userAddDong"));
			vo.setUserAddDetail(request.getParameter("userAddDetail"));
			vo.setUserBirth(request.getParameter("userBirth"));
			vo.setUserAge(Integer.parseInt(request.getParameter("userAge")));
			vo.setUserNick(request.getParameter("userNick"));

			int result = dao.update(vo);
			System.out.println("update result : " + result);

			if (result == 1) { // 수정 성공 => 메인페이지로 이동
				request.setAttribute("uresult", 1); 
				response.sendRedirect("u_update.do");
			} else { // 실패
				request.getSession().setAttribute("uresult", 0); 
				response.sendRedirect("u_update.do");
			}
			
		} else if (sPath.equals("/u_login.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("user/login.jsp");
			rd.forward(request, response);
			
		} else if (sPath.equals("/u_loginOK.do")) {
			System.out.println(request.getParameter("userId"));
			System.out.println(request.getParameter("userPw"));

			UserVO vo = new UserVO();
			UserDAO dao = new UserDAOimpl();
			vo.setUserId(request.getParameter("userId"));
			vo.setUserPw(request.getParameter("userPw"));
			
			// result = successed / failed로 나올 것
			String result = dao.loginOK(vo); 
			
			System.out.println(result);
			if (result.equals("successed")) {
				vo = dao.selectById(vo);
				// login = successed / failed
				request.getSession().setAttribute("login", result); 
				request.getSession().setAttribute("userID", vo.getUserId());
				request.getSession().setAttribute("userNum", vo.getUserNum());
				
				request.getSession().setMaxInactiveInterval(5000);
				System.out.println(request.getSession().getMaxInactiveInterval());
			}
			// failed를 화면에 출력
			request.getSession().setAttribute("login", result); 
			response.sendRedirect("index.do");
		} else if (sPath.equals("/u_logout.do")) {
			
			// 모든 세션 제거 => 모든세션 제거해 로그아웃
			request.getSession().invalidate(); 
			response.sendRedirect("index.do");
		}
		
		
		
	}//end

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
