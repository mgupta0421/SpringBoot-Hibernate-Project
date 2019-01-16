package io.javabrains.springbootstarter.vehicle;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;





@Component
public interface VehicleJpaRepo extends JpaRepository<Vehicle, String> {

}