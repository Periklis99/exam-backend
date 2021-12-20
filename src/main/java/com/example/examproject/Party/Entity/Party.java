package com.example.examproject.Party.Entity;

import com.example.examproject.Candidate.Entity.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="party")
public class Party {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String name;

    @OneToMany(mappedBy = "party")
    @JsonIgnore
    private Set<Candidate> candidates;

}
