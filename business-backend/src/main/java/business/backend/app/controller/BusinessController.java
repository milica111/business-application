package business.backend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.backend.app.services.BusinessServiceInterface;

@RestController
@RequestMapping("/business-mgmt")
public class BusinessController {
	
	@Autowired
	private BusinessServiceInterface businessService;

	@CrossOrigin
	@RequestMapping("/business-entry/{id}")
	public Object getBusinessEntry(@PathVariable String id) {
		 return businessService.getBusinessEntry(id);	 
	}
}
