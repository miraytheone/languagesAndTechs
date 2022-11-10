package kodlama.io.languagesAndTechs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="languages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private int id;
	
	@Column(name="language_name")
	private String name;

	@OneToMany(mappedBy ="language")
	private List<Technology> technologies;
}
