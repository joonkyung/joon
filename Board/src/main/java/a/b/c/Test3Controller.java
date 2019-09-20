package a.b.c;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class Test3Controller {
	@RequestMapping("/resttest4")
	private void resttest4() {

	}
	@RequestMapping("/resttest3")
	private void resttest3() {

	}

	@RequestMapping("/resttest2")
	private void resttest2() {

	}

	@RequestMapping("/hello")
	private void hello() {

	}
}
