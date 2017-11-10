package fr.istic.taa.Server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.taa.Server.model.User;

// Imports ...

@Transactional
public interface UserDao extends JpaRepository<User, Integer> {


    User findByLoginAndPassword(String login, String password);
}