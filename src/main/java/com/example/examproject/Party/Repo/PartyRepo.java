package com.example.examproject.Party.Repo;

import com.example.examproject.Party.Entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepo extends JpaRepository<Party,Integer> {


}
