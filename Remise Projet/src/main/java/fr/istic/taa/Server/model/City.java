package fr.istic.taa.Server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.istic.taa.Server.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class City{
    private double id;

    private String name;

    private String country;

    @Id
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}


