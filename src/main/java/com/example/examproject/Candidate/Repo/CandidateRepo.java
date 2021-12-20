package com.example.examproject.Candidate.Repo;

import com.example.examproject.Candidate.Entity.Candidate;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Integer> {
      List<Candidate> findAllByParty_Id(int id);
}
