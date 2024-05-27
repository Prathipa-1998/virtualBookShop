package in.co.gradle.virtualBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.gradle.virtualBook.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
