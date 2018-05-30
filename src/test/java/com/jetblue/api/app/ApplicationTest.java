package com.jetblue.api.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author JetBlue
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	/**
	 * Context loads.
	 * @throws Exception the exception
	 */
	@Test
    public void contextLoads() throws Exception {
	}
	
	@Test
	public void applicationContextTest() {
		Application.main(new String[] {});
	}
	
	
}
