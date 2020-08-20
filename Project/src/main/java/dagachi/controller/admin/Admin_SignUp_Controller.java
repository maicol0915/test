package dagachi.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dagachi.dto.admin.Admin_Login_Dto;
import dagachi.dto.admin.Admin_SignUp_Dto;
import dagachi.service.admin.Admin_SignUp_Service;

@Controller
public class Admin_SignUp_Controller {

	@Autowired
	private Admin_SignUp_Service service;

	// 회원가입폼 작성 get
	@GetMapping(value = "admin/admin_Join")
	public String getRegister(Admin_SignUp_Dto dto) throws Exception {
		return "admin_Join";
	}

	// 회원가입폼 작성 post
	@PostMapping(value = "admin/admin_Join")
	public String postRegister(Admin_SignUp_Dto dto) throws Exception {
		service.register(dto);
		return "afterSignUp"; // 회원가입 완료시 afterSignUp로 리턴함
	}

	// 로그인get
	@RequestMapping(value = "admin/admin_login", method = RequestMethod.GET)
	public String getLogin(Admin_SignUp_Dto dto) throws Exception {
		return "admin_login";
	}

	// 로그인post
	@RequestMapping(value = "admin/admin_login", method = RequestMethod.POST)
	public String postLogin(Admin_Login_Dto dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		HttpSession session = req.getSession();

		Admin_Login_Dto login = service.login(dto);

		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
		}
		return "redirect:admin_login";
	}

	// 로그아웃
	@GetMapping(value = "/admin/admin_logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "redirect:admin_login";
	}

}