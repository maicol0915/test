package dagachi.controller.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dagachi.dto.customer.Customer_Login_Dto;
import dagachi.dto.customer.Customer_SignUp_Dto;
import dagachi.service.customer.Customer_Login_Service;

@Controller
public class Customer_Login_Controller {

	@Inject
	private Customer_Login_Service service;

	// 회원가입폼 작성 get
	@GetMapping(value = "customer/customer_Join")
	public String getRegister(Customer_SignUp_Dto dto) throws Exception {
		return "customer_Join";
	}

	// 회원가입폼 작성 post
	@RequestMapping(value = "customer/customer_Join", method = RequestMethod.POST)
	public String postRegister(Customer_SignUp_Dto dto) throws Exception {
		service.register(dto);
		return "afterSignUp"; // 회원가입 완료시 afterSignUp로 리턴함
	}

	// 로그인get
	@GetMapping(value = "customer/customer_login")
	public String getLogin(Customer_SignUp_Dto dto) throws Exception {
		return "customer_login";
	}

	// 로그인post
	@PostMapping(value = "customer/customer_login")
	public String login(Customer_Login_Dto vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		HttpSession session = req.getSession();

		Customer_Login_Dto login = service.login(vo);

		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
		}
		return "redirect:customer_login";
	}

	// 로그아웃
	@GetMapping(value = "/customer/customer_logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "redirect:customer_login";
	}

	// mailSending 코드 컨트롤러(비밀번호)
	@RequestMapping(value = "/customer/findPass", method = { RequestMethod.GET, RequestMethod.POST })
	public String mailSending(HttpServletRequest request, String customer_Email) throws IOException {
		int num = 0;
		try {
			num = service.ID(customer_Email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (num != 0) {

			EmailDTO email = new EmailDTO();

			Random r = new Random();
			int rdn = r.nextInt(4589362) + 49311; // 이메일로 받는 인증코드 부분 (난수)
			System.out.println(rdn);
			String receiver = customer_Email; // 받는 사람 이메일
			String subject = "비밀번호 찾기 이메일 입니다."; // 제목
			String content =

					System.getProperty("line.separator") + // 한줄씩 줄간격을 두기위해 작성

							System.getProperty("line.separator") +

							"고객님 비밀번호 찾기"

							+ System.getProperty("line.separator") +

							System.getProperty("line.separator") +

							" 인증번호는 " + rdn + " 입니다. "

							+ System.getProperty("line.separator") +

							System.getProperty("line.separator") +

							"받으신 인증번호를 홈페이지에 입력하시면 새로운 비밀번호 설정이 가능합니다."; // 내용

			email.setReceiver(receiver);

			email.setSubject(subject);

			email.setContent(content);
			System.out.println("받는 이메일 ::" + receiver);
			boolean result = service.mailSend(email);
			System.out.println("결과 ::" + result);

			HttpSession session = request.getSession();
			session.setAttribute("num" + customer_Email, rdn);
			return "findPass";
		} else {

			return "findPass";
		}
	}

	// 이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
	// 내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
	// 틀리면 다시 원래 페이지로 돌아오는 메소드
	@ResponseBody
	@RequestMapping(value = "/insertCode", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean join_certification(HttpServletRequest request, String inputCode, String customer_Email)
			throws IOException {

		System.out.println("입력한 인증번호 : " + inputCode);

		HttpSession session = request.getSession();
		boolean result = service.emailCertification(session, customer_Email, Integer.parseInt(inputCode));
		System.out.println(result);
		return result;

	}

	@RequestMapping(value = "/changePw", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinInfo(@RequestParam(value = "customer_Email") String customer_Email, Model m) throws Exception {
		m.addAttribute("customer_Email", customer_Email);

		return "customer/changePassword";
	}

	// 비밀번호 찾기 / 변경
	@PostMapping("/newPw")
	public String updateMyinfo(Model model, String customer_Password, String customer_Email) throws Exception {

		HashMap<String, Object> map = new HashMap<>();

		map.put("customer_Password", customer_Password);
		map.put("customer_Email", customer_Email);
		service.update(map);
		return "customer/login";
	}

	//mailSending 코드 회원가입시 인증
	@ResponseBody
	@RequestMapping(value = "/emailSend", method = { RequestMethod.GET, RequestMethod.POST })
	public void mailSending1(HttpServletRequest request, String customer_Email) throws IOException {
		EmailDTO email = new EmailDTO();

		Random r = new Random();
		int certiNum = r.nextInt(4589362) + 49311; // 이메일로 받는 인증코드 부분 (난수)
		System.out.println(certiNum);
		String receiver = customer_Email; // 받는 사람 이메일
		String subject = "회원가입 인증 이메일 입니다."; // 제목
		String content =

				System.getProperty("line.separator") + // 한줄씩 줄간격을 두기위해 작성

						System.getProperty("line.separator") +

						"저희 홈페이지를 이용해 주셔서 감사합니다."

						+ System.getProperty("line.separator") +

						System.getProperty("line.separator") +

						" 인증번호는 " + certiNum + " 입니다. "

						+ System.getProperty("line.separator") +

						System.getProperty("line.separator") +

						"받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
		email.setReceiver(receiver);

		email.setSubject(subject);

		email.setContent(content);
		System.out.println("받는 이메일 ::" + receiver);
		boolean result = service.mailSend(email);
		System.out.println("결과 ::" + result);

		HttpSession session = request.getSession();
		session.setAttribute("num" + customer_Email, certiNum);

	}

	// 이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
	// 내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
	// 틀리면 다시 원래 페이지로 돌아오는 메소드
	@ResponseBody
	@RequestMapping(value = "/certification", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean join_certification1(HttpServletRequest request, String inputCode, String customer_Email)
			throws IOException {

		System.out.println("입력한 인증번호 : " + inputCode);

		HttpSession session = request.getSession();
		boolean result = service.emailCertification(session, customer_Email, Integer.parseInt(inputCode));
		System.out.println(result);
		return result;

	}

	@RequestMapping(value = "/joinInfoForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinInfo(@RequestParam(value = "customer_name") String customer_name,
			@RequestParam(value = "customer_Email") String customer_Email,
			@RequestParam(value = "customer_password") String customer_password, Model m) throws Exception {
		m.addAttribute("customer_name", customer_name);
		m.addAttribute("customer_Email", customer_Email);
		m.addAttribute("customer_password", customer_password);

		return "customer/joinInfo";
	}

	@PostMapping(value = "/joinPost")
	public ModelAndView joinPost(Customer_SignUp_Dto dto, HttpSession session) throws Exception {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("customer/joinPost");
		service.insert(dto);

		return mav;
	}

}

/*
 * @ResponseBody
 * 
 * @PostMapping(value = "") public boolean mailSending(HttpServletRequest
 * request, String customer_Email) throws IOException { int num = 0; try { num =
 * service.one(customer_Email);
 * 
 * } catch (Exception e) { e.printStackTrace(); } if (num != 0) {
 * 
 * EmailDTO dto = new EmailDTO();
 * 
 * Random rd = new Random(); int rdn = rd.nextInt(4589362) + 49311;
 * 
 * String receiver = customer_Email; String subject = "비밀번호 찾기 이메일입니다."; String
 * content = System.getProperty("line.separator")+
 * System.getProperty("line.separator")+ "안녕하세요 저희 홈페이지를 찾아주셔서 감사합니다."+
 * System.getProperty("line.separator")+ "인증번호는" + rdn +"입니다."+
 * System.getProperty("line.separator")+ System.getProperty("line.separator")+
 * "받으신 인증번호를 홈페이지에 입력해 주시면 새 비밀번호 설정이 가능합니다.";
 * 
 * dto.setReceiver(receiver); dto.setSubject(subject); dto.setContent(content);
 * 
 * System.out.println("받는 이메일" + receiver); boolean result = service.mail
 * 
 * 
 * } }
 */