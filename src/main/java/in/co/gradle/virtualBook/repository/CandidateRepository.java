package in.co.gradle.virtualBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.gradle.virtualBook.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {

}
