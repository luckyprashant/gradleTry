package com.jetblue.api.config;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springfox.documentation.spring.web.plugins.Docket;

import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * The Class SwaggerConfigTest.
 * Dummy class for code coverage. Actual test can be performed via rest assured client.
 */
@RunWith(MockitoJUnitRunner.class)
public class SwaggerConfigTest {
	
	/** The swagger config. */
	@InjectMocks 
	SwaggerConfig swaggerConfig;

	/**
	 * Should return api docs.
	 */
	@Test
	public void shouldReturnApiDocs() {
		Docket api = swaggerConfig.api();
		assertNotNull("DocketApi should not be null", api);
	}
}
