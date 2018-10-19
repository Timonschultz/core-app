package nl.timonschultz.hots.persistence.map;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {

    boolean existsByName(String name);

}
