package nl.timonschultz.hots.persistence.hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

    boolean existsByName(String name);

    Optional<Hero> findByShortName(String name);

    @Query("select s.id as id, s.name as name, s.shortName as shortName from HEROES s")
    List<HeroNameAndIdAndShortName> getIdAndName();

}