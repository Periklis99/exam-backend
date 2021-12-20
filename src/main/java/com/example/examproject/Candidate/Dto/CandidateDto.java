package com.example.examproject.Candidate.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude()
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

    private String name;
    int party_id;
    private Integer id;

    public CandidateDto(Integer id) {
        this.id = id;
    }

    public CandidateDto(String name, int party_id) {
        this.name = name;
        this.party_id = party_id;
    }

    public CandidateDto(int party_id, Integer id) {
        this.party_id = party_id;
        this.id = id;
    }
}
