package kodlama.io.languagesAndTechs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechResponse {
	private int id;
	private String name;
	private int languageId;
}
