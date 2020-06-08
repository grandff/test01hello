package test.com.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestVO {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private String name;
	private String tel;
	
	public TestVO() {
		logger.info("TestVO On");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
