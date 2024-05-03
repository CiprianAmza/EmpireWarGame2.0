package com.example.demo.repository;

import com.example.demo.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String userName);

    Optional<User> findById(int ID);

}
