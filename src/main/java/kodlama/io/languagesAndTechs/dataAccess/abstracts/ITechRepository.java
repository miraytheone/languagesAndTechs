package kodlama.io.languagesAndTechs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.languagesAndTechs.entities.concretes.Technology;

public interface ITechRepository extends JpaRepository<Technology, Integer>{

}
