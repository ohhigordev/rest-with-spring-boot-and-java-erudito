package br.com.ohhigordev.Repository;

import br.com.ohhigordev.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
