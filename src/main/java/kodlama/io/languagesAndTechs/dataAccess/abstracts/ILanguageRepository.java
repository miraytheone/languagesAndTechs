package kodlama.io.languagesAndTechs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.languagesAndTechs.entities.concretes.Language;

public interface ILanguageRepository extends JpaRepository<Language, Integer> {

}
