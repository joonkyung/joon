package a.b.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.MemberVO;

@Controller 
public class Test2Controller {
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public void test4(Model model) {
		List<MemberVO> list = new  ArrayList<MemberVO>();
		list.add(new MemberVO("m001","홍",11));
		list.add(new MemberVO("m002","길",12));
		list.add(new MemberVO("m003","동",13));
		list.add(new MemberVO("m004","오",14));
		list.add(new MemberVO("m005","빠",15));
		
		model.addAttribute("list", list);
	}

	@ResponseBody
	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public List<Map<String, Object>> test4(@RequestParam Map<String, Object> map) throws JsonParseException, JsonMappingException, IOException {	//우리가 받아온거는 List지만 받아올때는 Map으로 받아와야한다.
		String jsonStr = map.get("list").toString();
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> list = mapper.readValue(jsonStr, new TypeReference<ArrayList<Map<String, Object>>>(){});
		for(Map<String, Object> x : list) {
			System.out.println("::::::::::::");
			System.out.println(x.get("id"));
			System.out.println("::::::::::::");
			System.out.println(x.get("name"));
			System.out.println("::::::::::::");
			System.out.println(x.get("age"));
			System.out.println("::::::::::::");
		}
		return list;
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public void test3() {

	}

	@ResponseBody
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public MemberVO test3(MemberVO vo) {
		
		System.out.println(vo);
		return vo;
	}

	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void test2() {

	}

	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	@ResponseBody
	public String[] test2(String[] arr) {
		for (String x : arr) {
			System.out.println(x);
		}
		return arr;
	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {

	}

	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	@ResponseBody
	public String test1(String str) {
		System.out.println(str);
		
		return str;
	}

	@RequestMapping("/json1")
	@ResponseBody
	public MemberVO json1() {
		MemberVO vo = new MemberVO("m001", "lee", 11);

		return vo;
	}
}
