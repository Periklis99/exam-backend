package com.example.examproject.Candidate.Service;

import com.example.examproject.Candidate.Dto.CandidateDto;
import com.example.examproject.Candidate.Entity.Candidate;

import java.util.List;

public interface CandidateServiceInterface {

    Candidate createCandidate (CandidateDto dto);
    Candidate editCandidate (CandidateDto dto);
    void deleteCandidate(CandidateDto dto);
     List<Candidate> getAllCandidates();
    List<Candidate> getCandidatesForParty(int id);
}
