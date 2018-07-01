package de.rwth.swc.oosc.swcarchitect.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import de.rwth.swc.bibliography.BibliographySpringApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BibliographySpringApplication.class)
@WebAppConfiguration
public class BibliographySpringApplicationTests {

	@Test
	public void contextLoads() {
	}

}
