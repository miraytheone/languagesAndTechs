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

import kodlama.io.languagesAndTechs.business.abstracts.ILanguageService;
import kodlama.io.languagesAndTechs.business.requests.CreateLanguageRequest;
import kodlama.io.languagesAndTechs.business.requests.UpdateLanguageRequest;
import kodlama.io.languagesAndTechs.business.responses.GetAllLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private ILanguageService languageService;
	
	@Autowired
	public LanguagesController(ILanguageService languageService) {
		this.languageService=languageService;
				
	}
	
	@GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		this.languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		languageService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest);
	}
	
	@GetMapping("{id}")
	public GetAllLanguageResponse getById(@PathVariable int id) throws Exception {
		return languageService.getById(id);
	}
}
