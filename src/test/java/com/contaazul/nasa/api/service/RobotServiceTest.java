package com.contaazul.nasa.api.service;

import static com.contaazul.nasa.api.model.Moviment.L;
import static com.contaazul.nasa.api.model.Moviment.M;
import static com.contaazul.nasa.api.model.Moviment.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.contaazul.nasa.api.NasaApiApplication;
import com.contaazul.nasa.api.model.Moviment;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NasaApiApplication.class)
@WebAppConfiguration
public class RobotServiceTest {

	@Autowired
	private RobotService robotService;

	private List<Moviment> moviments = new ArrayList<>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		moviments.addAll(Arrays.asList(M, M, R, M, M, R, M, M, R, M, L));
	}

	@Test
	public void shouldExecuteMoviment() {
		String positionString = robotService.executeMoviment(moviments);

		Assert.assertThat(positionString, CoreMatchers.is("(1, 0, S)"));
	}

}
