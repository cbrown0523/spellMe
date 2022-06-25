package com.spellme.demo.repositories;

import com.spellme.demo.Model.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepo extends JpaRepository<Term, Long> {
}
