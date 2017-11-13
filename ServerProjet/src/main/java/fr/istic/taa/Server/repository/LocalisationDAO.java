package fr.istic.taa.Server.repository;

import fr.istic.taa.Server.model.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LocalisationDAO extends JpaRepository<Localisation,Integer>{
}
