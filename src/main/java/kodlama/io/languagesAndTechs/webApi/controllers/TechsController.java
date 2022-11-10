package kodlama.io.languagesAndTechs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.languagesAndTechs.business.abstracts.ITechsService;
import kodlama.io.languagesAndTechs.business.requests.CreateTechRequest;
import kodlama.io.languagesAndTechs.business.requests.UpdateTechRequest;
import kodlama.io.languagesAndTechs.business.responses.GetAllTechResponse;

@RestController
@RequestMapping("/api/techs")
public class TechsController {
	private ITechsService techService;

	@Autowired
	public TechsController(ITechsService techService) {
		this.techService = techService;
	}

	@GetMapping("/getAll")
	public List<GetAllTechResponse> getAll() {
		return techService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateTechRequest createTechRequest) throws Exception {
		techService.add(createTechRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		techService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateTechRequest updateTechRequest) throws Exception {
		techService.update(updateTechRequest);
	}
}
