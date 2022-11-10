package kodlama.io.languagesAndTechs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.languagesAndTechs.business.abstracts.ITechsService;
import kodlama.io.languagesAndTechs.business.requests.CreateTechRequest;
import kodlama.io.languagesAndTechs.business.requests.UpdateTechRequest;
import kodlama.io.languagesAndTechs.business.responses.GetAllTechResponse;
import kodlama.io.languagesAndTechs.dataAccess.abstracts.ILanguageRepository;
import kodlama.io.languagesAndTechs.dataAccess.abstracts.ITechRepository;
import kodlama.io.languagesAndTechs.entities.concretes.Language;
import kodlama.io.languagesAndTechs.entities.concretes.Technology;

@Service
public class TechManager implements ITechsService {

	
	private ITechRepository techRepository;
	private ILanguageRepository languageRepository;
	
	@Autowired
	public TechManager(ITechRepository techRepository, ILanguageRepository languageRepository) {
		this.techRepository=techRepository;
		this.languageRepository=languageRepository;
	}
	
	@Override
	public List<GetAllTechResponse> getAll() {
		List<Technology> technologies = techRepository.findAll();
		List<GetAllTechResponse> techResponse = new ArrayList<GetAllTechResponse>();
		
		for(Technology technology : technologies) {
			GetAllTechResponse responseItem = new GetAllTechResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			responseItem.setLanguageId(technology.getLanguage().getId());
			techResponse.add(responseItem);
		}
		
		return techResponse;
	}

	@Override
	public void add(CreateTechRequest createTechRequest) throws Exception {
		Language programmingLanguage = languageRepository.findById(createTechRequest.getLanguageId()).orElseThrow(() -> new Exception("Programming language id does not exist."));
		Technology technology = new Technology();
		technology.setName(createTechRequest.getName());
		technology.setLanguage(programmingLanguage);

		this.techRepository.save(technology);
		
	}

	@Override
	public void delete(int id) {
		techRepository.deleteById(id);
	}

	@Override
	public void update(UpdateTechRequest updateTechRequest) {
		for(Technology technology: techRepository.findAll()) {
			if(technology.getId() == updateTechRequest.getId()) {
				technology.setName(updateTechRequest.getName());
			}
		}
		
	}

	

}
