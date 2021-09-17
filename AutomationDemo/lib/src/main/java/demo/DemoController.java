package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test")
public class DemoController {

	@GetMapping(value = "/1")
	@ResponseBody
	public String test() {
		return "Hello world";
	}
}
