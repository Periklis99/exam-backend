package com.example.examproject.Candidate.Service;

import com.example.examproject.Candidate.Dto.CandidateDto;
import com.example.examproject.Candidate.Entity.Candidate;
import com.example.examproject.Candidate.Repo.CandidateRepo;
import com.example.examproject.Party.Repo.PartyRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CandidateServiceImplTest {
    CandidateServiceImpl candidateService;

    @Autowired
    PartyRepo partyRepo;
    @Autowired
    CandidateRepo candidateRepo;


    @BeforeEach
    void setUp() {
        candidateService = new CandidateServiceImpl(partyRepo,candidateRepo);
    }

    @Test
    @Sql("/testData.sql")
    void createCandidate() {
        CandidateDto dto = new CandidateDto("Bob",2,null);
        Candidate candidate = candidateService.createCandidate(dto);
        assertEquals("Bob",candidate.getName());
        assertEquals(2,candidate.getParty().getId());
        assertEquals(104,candidate.getId());
    }

    @Test
    @Sql("/testData.sql")
    void editCandidate() {
        CandidateDto dto = new CandidateDto(1,100);
        Candidate candidate = candidateService.editCandidate(dto);
        assertEquals(1,candidate.getParty().getId());
        assertEquals(100,candidate.getId());
    }


    @Test
    @Sql("/testData.sql")
    void deleteCandidate() {
        CandidateDto dto = new CandidateDto(100);
        candidateService.deleteCandidate(dto);
        assertEquals(1,candidateService.getCandidatesForParty(1).size());
    }

    @Test
    @Sql("/testData.sql")
    void getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        assertEquals(4,candidates.size());
    }

    @Test
    @Sql("/testData.sql")
    void getCandidatesForParty() {
        List<Candidate> candidates = candidateService.getCandidatesForParty(2);
        assertEquals(2,candidates.size());
    }
}