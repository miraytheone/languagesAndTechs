package kodlama.io.languagesAndTechs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechRequest {
	private int id;
	private String name;
	private int languageId;
}
