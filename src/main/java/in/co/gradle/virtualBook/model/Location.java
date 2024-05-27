package in.co.gradle.virtualBook.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="location")
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	String doorNo;
	String city;
	

}
