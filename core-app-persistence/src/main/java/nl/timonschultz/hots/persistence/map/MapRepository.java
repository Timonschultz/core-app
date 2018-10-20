package nl.timonschultz.hots.persistence.map;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapRepository extends JpaRepository<Map, Long> {

    boolean existsByName(String name);

    Optional<Map> findByName(String name);

}
