package kodlama.io.languagesAndTechs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.languagesAndTechs.business.abstracts.ILanguageService;
import kodlama.io.languagesAndTechs.business.requests.CreateLanguageRequest;
import kodlama.io.languagesAndTechs.business.requests.UpdateLanguageRequest;
import kodlama.io.languagesAndTechs.business.responses.GetAllLanguageResponse;
import kodlama.io.languagesAndTechs.dataAccess.abstracts.ILanguageRepository;
import kodlama.io.languagesAndTechs.entities.concretes.Language;

@Service
public class LanguageManager implements ILanguageService{

	
	private ILanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(ILanguageRepository languageRepository) {
		this.languageRepository =languageRepository;
	}
	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();
		
		
		for(Language language : languages) {
		
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}
		
		return languageResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		if(createLanguageRequest.getName().isEmpty() || createLanguageRequest.getName().isBlank()) {
			throw new Exception("Programming language name cannot be null");
		}
		else {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());;
		this.languageRepository.save(language);
		}
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		for(Language language:languageRepository.findAll()) {
			if(language.getId() == updateLanguageRequest.getId()) {
				language.setName(updateLanguageRequest.getName());
				languageRepository.save(language);
			}
		}
	}

	@Override
	public GetAllLanguageResponse getById(int id) throws Exception {
		Language language = languageRepository.findById(id).orElseThrow( () -> new Exception("Id does not exist"));
		GetAllLanguageResponse getAllLanguageResponse = new GetAllLanguageResponse();
		getAllLanguageResponse.setId(id);
		getAllLanguageResponse.setName(language.getName());
		return getAllLanguageResponse;
	}

}
