package test.com.hello;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}. 얍얍얍", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)		// localhost:서버포트/test 로 호출
	public String test(Model model) {
		logger.info("Welcome test!");
		
		model.addAttribute("result", "야쓰");		// test.jsp에 result model 객체를 담아 전달
				
		return "aaa/test";
	}
	
	
	// responsebody annotation을 추가해서 비동기 통신 요청을 할 수 있음(jsp 없이 처리)
	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		logger.info("Welcome test2!");
		
		String msg = "hello test2";	
				
		return msg;
	}
	
	@ResponseBody			// 마찬가지로 ajax 통신
	@RequestMapping(value = "/test3.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")		// produces 옵션을 통해 한글 깨짐 현상 해결
	public String test3() {
		logger.info("Welcome test3!");
		
		String[] jsonTextAry = new String[2];
		String jsonText = "{\"name\":\"김정민\", \"주소\" : \"우리집\"}";		// json으로 데이터 리턴 {"key" : "value"}		
		String jsonText2 = "{\"name\" : \"구구구\", \"주소\" : \"가가가\"}";
		
		jsonTextAry[0] = jsonText;
		jsonTextAry[1] = jsonText2;
				
		// 위의 배열은 그냥 해본거임
		
		return jsonText;
	}
	
	// jackson 라이브러리 추가(maven - jackson, pom.xml에 dependecy 추가)
	@ResponseBody			
	@RequestMapping(value = "/test4.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")		
	public TestVO test4() {
		logger.info("Welcome test4!");
		
		TestVO vo = new TestVO();
		vo.setName("kim");
		vo.setTel("02");
		return vo;
	}
	
	@ResponseBody			
	@RequestMapping(value = "/test5.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")		// produces 옵션을 통해 한글 깨짐 현상 해결
	public ArrayList<TestVO> test5() {		// arraylist로 리턴	
		logger.info("Welcome test5!");
		
		ArrayList<TestVO> list = new ArrayList<TestVO>();
		TestVO vo = null;
		
		for(int i=0; i<4; i++) {
			vo = new TestVO();
			vo.setName("kim" + i);
			vo.setTel("02" + i);
			list.add(vo);
		}
				
		return list;
	}
	
}
