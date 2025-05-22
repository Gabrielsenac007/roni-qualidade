package com.roni.roniAtividade.repository;

import com.roni.roniAtividade.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, String> {
}
