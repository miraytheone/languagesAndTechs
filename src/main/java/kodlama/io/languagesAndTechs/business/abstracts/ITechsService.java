package kodlama.io.languagesAndTechs.business.abstracts;

import java.util.List;

import kodlama.io.languagesAndTechs.business.requests.CreateTechRequest;
import kodlama.io.languagesAndTechs.business.requests.UpdateTechRequest;
import kodlama.io.languagesAndTechs.business.responses.GetAllTechResponse;

public interface ITechsService {
	List<GetAllTechResponse> getAll();

	void add(CreateTechRequest createTechRequest) throws Exception;
	void delete( int id);
	void update(UpdateTechRequest updateTechRequest) throws Exception;
}
