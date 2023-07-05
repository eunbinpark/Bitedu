package bitedu.bipa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitedu.bipa.member.vo.TestVo;

public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");

//		resp.setContentType("text/html; charset=UTF-8");
//		req.setCharacterEncoding("UTF-8");
//		String paramUserId = req.getParameter("user_id");
//		String pass = req.getParameter("pass");
//		String pass_check = req.getParameter("pass_check");
//		String user_name = req.getParameter("user_name");
//		String post_code = req.getParameter("post_code");
//		String addr1 = req.getParameter("addr1");
//		String addr2 = req.getParameter("addr2");
//		String birth_year = req.getParameter("birth_year");
//		String birth_month = req.getParameter("birth_month");
//		String birth_date = req.getParameter("birth_date");
//		String gender = req.getParameter("gender");
//		String[] favr = req.getParameterValues("favr");
//		String intro = req.getParameter("intro");
//
//		TestVo user = new TestVo(paramUserId, pass, pass_check, user_name, post_code, addr1, addr2, birth_year,
//				birth_month, birth_date, gender, favr, intro);
//		req.setAttribute("user", user);
//		RequestDispatcher rd = req.getRequestDispatcher("./member/view_update.jsp");// 위와같은 이유로
//		// RequestDispatcher 써 그래서 기존 req를 연장시ㅕ켜 rd.forward(req, resp);

		test(req, resp);
		// resp.sendRedirect("./member/view_update.jsp");//원래 req객체 말고 sendRedirect는 새로운
		// request 날라가기 때문에 test null 뜬다.
		// resp.sendRedirect("./member/view_update.jsp?user_id="+paramUserId);//현재가
		// MemberSample이기때문에 찾아가야해 *연관1
	}

	public void test(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json; charset=UTF-8");
		// application/json은 JSON 데이터를 의미하며, charset=UTF-8은 문자 인코딩 방식을 UTF-8로 지정한다는 것을 나타냄
		//서버가 JSON 형식의 데이터를 클라이언트로 응답할 때, 클라이언트는 이 응답이 JSON 형식임을 인식하고 해당 데이터를 적절하게 처리할 수 있게 됩니다.
		//또한, UTF-8 인코딩을 사용하여 다국어 문자를 올바르게 표현할 수 있습니다.
		
		String defaultUserId = "admin";
		String paramUserId = req.getParameter("user_id");

		PrintWriter writer = resp.getWriter();
		//서버의 응답(response)을 클라이언트로 보내는 데 사용되는 PrintWriter 객체를 생성하는 부분
		//getWriter() 메서드는 resp 객체로부터 PrintWriter 객체를 얻기 위해 호출됩니다.
		//PrintWriter는 텍스트 데이터를 출력하는 데 사용되는 자바의 클래스
		if (defaultUserId.equals(paramUserId)) {
			writer.write("{\"result\":false}");
		} else {
			writer.write("{\"result\":true}");
		}
		writer.flush();
		//writer.flush()는 PrintWriter 객체에 대해 버퍼를 비우고 모든 출력 내용을 강제로 클라이언트로 보내는 역할
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		// this.doGet(req, resp);//이렇게 바로 get 호출할 수 있다.
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");// 날라올 때 UTF-8로 처리해라
		String paramUserId = req.getParameter("user_id");
		String pass = req.getParameter("pass");
		String pass_check = req.getParameter("pass_check");
		String user_name = req.getParameter("user_name");
		String post_code = req.getParameter("post_code");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String birth_year = req.getParameter("birth_year");
		String birth_month = req.getParameter("birth_month");
		String birth_date = req.getParameter("birth_date");
		String gender = req.getParameter("gender");
		String[] favr = req.getParameterValues("favr");
		String intro = req.getParameter("intro");

		TestVo user = new TestVo(paramUserId, pass, pass_check, user_name, post_code, addr1, addr2, birth_year,
				birth_month, birth_date, gender, favr, intro);
		req.setAttribute("user", user);
		// resp.sendRedirect("./member/view_update.jsp");//원래 req객체 말고 sendRedirect는 새로운
		// request 날라가기 때문에 test null 뜬다.
		RequestDispatcher rd = req.getRequestDispatcher("./member/result.html");// 위와같은 이유로 RequestDispatcher 써 그래서
																					// 기존 req를 연장시ㅕ켜
		rd.forward(req, resp);
	}
}
