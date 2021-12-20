package com.example.examproject.Candidate.Service;

import com.example.examproject.Candidate.Entity.Candidate;
import com.example.examproject.Candidate.Repo.CandidateRepo;
import com.example.examproject.Party.Entity.Party;
import com.example.examproject.Party.Repo.PartyRepo;
import com.example.examproject.Candidate.Dto.CandidateDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateServiceInterface {
    private PartyRepo partyRepo;
    private CandidateRepo candidateRepo;

    ModelMapper modelMapper = new ModelMapper();


    public CandidateServiceImpl(PartyRepo partyRepo, CandidateRepo candidateRepo) {
        this.partyRepo = partyRepo;
        this.candidateRepo = candidateRepo;
    }

    @Override
    public Candidate createCandidate (CandidateDto dto){
      Candidate candidate = modelMapper.map(dto, Candidate.class);
        Party party = partyRepo.findById(dto.getParty_id()).orElseThrow();
        candidate.setParty(party);
     return candidateRepo.save(candidate);
    }
    @Override
    public Candidate editCandidate (CandidateDto dto){
        Candidate candidate = candidateRepo.findById(dto.getId()).orElseThrow();
        Party party = partyRepo.findById(dto.getParty_id()).orElseThrow();
        candidate.setParty(party);
        return candidateRepo.save(candidate);
    }
    @Override
    public void deleteCandidate(CandidateDto dto){
        Candidate candidate = candidateRepo.findById(dto.getId()).orElseThrow();
        candidateRepo.delete(candidate);
    }
    @Override
    public List<Candidate> getAllCandidates(){
         List<Candidate> candidates = candidateRepo.findAll();
        return candidates;
    }
    @Override
    public List<Candidate> getCandidatesForParty(int id){
        return candidateRepo.findAllByParty_Id(id);
    }
}
