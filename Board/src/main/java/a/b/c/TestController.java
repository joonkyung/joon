package a.b.c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.MemberVO;

@Controller // 컨트롤러는 servlet-context에 패키지를 추가해줘야함
public class TestController {

	@RequestMapping("/e3")
	public String e3(RedirectAttributes rttr, Model model) {
		rttr.addAttribute("test1", "test1입니다.");
		rttr.addFlashAttribute("test2", "test2입니다.");
		model.addAttribute("test3", "test3입니다.");

		return "redirect:/f";
	}

	@RequestMapping("/e2")
	public String e2(RedirectAttributes rttr) {
		System.out.println("e2::::::::::::::::::::");
		
		rttr.addFlashAttribute("test", "test입니다.");
		rttr.addFlashAttribute("test2", "test2입니다.");

		return "redirect:/f";
	}

	@RequestMapping("/f") // 모델어트리부트를 하지않으면 e에서 바인딩한 데이터가 넘어가지않음
	public void f(@ModelAttribute("test") String test, @ModelAttribute("test2") String test2,
			@ModelAttribute("test3") String test3) {
		System.out.println("f::::::::::::::::::::");
		System.out.println(test);
	}

	@RequestMapping("/e")
	public String e(Model model) { // model객체에 데이터바인딩
		System.out.println("e::::::::::::::::::::");
		model.addAttribute("test", "test입니다.");

		return "redirect:/f"; // 주소창에 e를 입력하면 f로 넘어감.
	}

	@RequestMapping("/d")
	public void d(Model model) {
		MemberVO vo = new MemberVO("m001", "john", 11);
		model.addAttribute("vo", vo);
	}

	@RequestMapping("/c") // 모델로 데이터를 바인딩한것처럼 뷰까지 데이터가 넘어감
	public void c(@ModelAttribute("msg") String msg) {
		System.out.println("c:::::::::::::::::::::");
	}

	@RequestMapping("/b")
	public void b(String msg, String age, Model model) {
		System.out.println("b:::::::::::::::::::::");
		System.out.println("msg는: " + msg);
		System.out.println("age는:" + age);
		model.addAttribute("msg", msg);
		model.addAttribute(age); // 이렇게 키값을 정해주지않고 바인딩할때에는 넘겨주는 자료의 자료형의 첫글자를 소문자로하고 받는다 ${string}
	}

	@RequestMapping("/a")
	public String a() {
		System.out.println("a:::::::::::::::::::::");

		return "a";
	}

	@RequestMapping("/t1")
	public String t1() {
		System.out.println("t1() 메서드 입니다.");

		return "test1";
	}

}
