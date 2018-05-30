package com.jetblue.api.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import springfox.documentation.spring.web.plugins.Docket;

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
