package com.example.examproject.Candidate.Controller;

import com.example.examproject.Candidate.Dto.CandidateDto;
import com.example.examproject.Candidate.Entity.Candidate;
import com.example.examproject.Candidate.Repo.CandidateRepo;
import com.example.examproject.Candidate.Service.CandidateServiceImpl;
import com.example.examproject.Candidate.Service.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class CandidateController {
    @Autowired
    private CandidateServiceInterface candidateService;


    @PostMapping
    private Candidate createCandidate(@RequestBody CandidateDto request){
        return candidateService.createCandidate(request);
    }
    @PutMapping
    private Candidate editCandidate (@RequestBody CandidateDto dto){
        return candidateService.editCandidate(dto);
    }

    @GetMapping
    List<Candidate> getAllCandidates(){
        List<Candidate> candidates = candidateService.getAllCandidates();
         return candidates;
    }

    @GetMapping(path = "/{id}")
    List<Candidate> getCandidatesForParty(@PathVariable int id){
        return candidateService.getCandidatesForParty(id);
    }

    @DeleteMapping
    void deleteCandidate(@RequestBody CandidateDto dto){
        candidateService.deleteCandidate(dto);
    }



}
