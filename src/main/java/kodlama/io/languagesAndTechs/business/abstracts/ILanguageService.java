package kodlama.io.languagesAndTechs.business.abstracts;

import java.util.List;

import kodlama.io.languagesAndTechs.business.requests.CreateLanguageRequest;
import kodlama.io.languagesAndTechs.business.requests.UpdateLanguageRequest;
import kodlama.io.languagesAndTechs.business.responses.GetAllLanguageResponse;

public interface ILanguageService {
	List<GetAllLanguageResponse> getAll();
	GetAllLanguageResponse getById(int id) throws Exception;
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void delete( int id);
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
}
