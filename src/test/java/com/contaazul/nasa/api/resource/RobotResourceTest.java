package com.contaazul.nasa.api.resource;

import static com.contaazul.nasa.api.model.Moviment.L;
import static com.contaazul.nasa.api.model.Moviment.M;
import static com.contaazul.nasa.api.model.Moviment.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.contaazul.nasa.api.NasaApiApplication;
import com.contaazul.nasa.api.model.Moviment;
import com.contaazul.nasa.api.service.RobotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NasaApiApplication.class)
@WebAppConfiguration
public class RobotResourceTest extends ResourceTest {
	
	final String BASE_PATH = "http://localhost:8080/rest/mars";
	
	@InjectMocks
	private RobotResource robotResource;
	
	@MockBean
	private RobotService robotService;
	
	@MockBean
	private Moviment moviment;
	
	private MockMvc mvc;
	
	private List<Moviment> moviments = new ArrayList<>();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		moviments.addAll(Arrays.asList(M, M, R, M, M, R, M, M, R, M, L));
		
		mvc = MockMvcBuilders.standaloneSetup(robotResource).build();
	}

	@Test
	public void shouldMovimentRobot() throws Exception {
		Mockito.doReturn("(1, 0, S)").when(robotService).executeMoviment(moviments);
		
		mvc.perform(post(BASE_PATH + "/MMRMMRMM")
						.contentType(contentType))
			.andExpect(status().isOk());
	}

}
