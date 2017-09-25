package fr.istic.taa.Server.repository;

import fr.istic.taa.Server.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CityDAO extends JpaRepository<City, Long> {

}
