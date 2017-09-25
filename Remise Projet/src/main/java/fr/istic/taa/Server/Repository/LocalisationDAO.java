package fr.istic.taa.Server.Repository;

import fr.istic.taa.Server.Model.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LocalisationDAO extends JpaRepository<Localisation,Integer>{
}
