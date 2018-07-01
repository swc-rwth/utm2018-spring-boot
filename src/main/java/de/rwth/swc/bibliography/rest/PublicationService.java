package de.rwth.swc.bibliography.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import core.Bibliography;
import io.swagger.annotations.ApiOperation;
import publications.Book;
import publications.Publication;
import tools.AdminTool;

/**
 * Created by andy on 14.01.16.
 */

@RestController
@RequestMapping("/publications")
public class PublicationResource {

	@Autowired
	private Bibliography bibliography;
	
	@Autowired
	private AdminTool adminTool;

	@PostConstruct
	private void init() {
		  Book b1 = new Book("01"),b2 = new Book("02");
		
	      b1.setTitle("Software Engineering");
	      b1.addAuthor("Ian Sommerville");
	      b1.setYear("2013");
	      b1.setPublishingHouse("Addison");
	      b1.setIsbn("12345");
	      
	      b2.setTitle("Design Patterns");
	      b2.addAuthor("Erich Gamma");
	      b2.setYear("2010");
	      b2.setPublishingHouse("Addison");
	      b2.setIsbn("6789");
	      
	      adminTool.add(b1);
	      adminTool.add(b2);

	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "Everything fine";
	}

	@ApiOperation(value = "Gets all existing publications", notes = "Provides all publications as String", response = Publication.class)
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllPublications() {
		bibliography.search("*");
		return bibliography.export();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> showImage(@PathVariable("id") String id) {
		bibliography.search(id);
		return ResponseEntity.ok().body(bibliography.export());
	}

}
