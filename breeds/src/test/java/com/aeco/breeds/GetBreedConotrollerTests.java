package com.aeco.breeds;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aeco.breeds.controller.GetBreedController;
import com.aeco.breeds.model.Image;
import com.aeco.breeds.model.ResultBreed;
import com.aeco.breeds.services.GetBreedServices;

@SpringBootTest
public class GetBreedConotrollerTests {

	@Autowired
	private GetBreedController controller;
	
	GetBreedServices serviceGetBreed;
	
	@Test
	 public void testBreeds() {
		ResultBreed result = new ResultBreed();
		Assert.assertEquals(result, controller.getBreed("dog"));
	 }
	
	@Before
    public void setUp() {
		serviceGetBreed = Mockito.mock(GetBreedServices.class);
        controller = new GetBreedController();
    }

    @Test
    public void itShouldReturnTheServiceValueWith200StatusCode() {
    	
    	List<String> subBreeds = new ArrayList<String>();
    	List<Image> images = new ArrayList<Image>();
    	
        Mockito.when(serviceGetBreed.getAllBreeds("url")).thenReturn(null);
        Mockito.when(serviceGetBreed.getImagesBreed("url")).thenReturn(null);
        ResultBreed httpResponse = controller.getBreed("dog");

        Assert.assertEquals(httpResponse.getBreed(), "dogs");
        Assert.assertEquals(httpResponse.getImages(), images);
        Assert.assertEquals(httpResponse.getSubBreeds(), subBreeds);
    }
}
