package fr.istic.taa.Server.Controller;

import fr.istic.taa.Server.Repository.LocalisationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/localisation")
public class LocalisationController {

    @Autowired
    private LocalisationDAO LocalisationDAO;

}