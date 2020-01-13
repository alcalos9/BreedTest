package com.aeco.breeds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.aeco.breeds.controller.BreedController;
import com.aeco.breeds.model.UrlService;
import com.aeco.breeds.services.BreedServices;

@SpringBootTest
public class BreedControllerTests {

	@Autowired
	private BreedController controller;
	
	BreedServices servicesBreed;
	
	@Autowired
	private Environment env;
	
	@Test
	public void testUrl() {
		UrlService listUrl = new UrlService();
		Assert.assertEquals(listUrl, controller.getUrls());
	}
	
	@Before
    public void setUp() {
		servicesBreed = Mockito.mock(BreedServices.class);
        controller = new BreedController();
    }

    @Test
    public void itShouldReturnTheServiceValueWith200StatusCode() {
    	
        Mockito.when(servicesBreed.getUrls(env)).thenReturn(null);
        UrlService httpResponse = controller.getUrls();

        Assert.assertEquals(httpResponse.getImage(), "imagen");
        Assert.assertEquals(httpResponse.getAll(), "url");
    }
	
	
}
