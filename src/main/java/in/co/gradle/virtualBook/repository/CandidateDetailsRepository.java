package in.co.gradle.virtualBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.gradle.virtualBook.model.CandidateDetails;


public interface CandidateDetailsRepository extends JpaRepository<CandidateDetails,Integer> {

}
