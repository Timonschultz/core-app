package nl.timonschultz.hots.persistence.icon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepository extends JpaRepository<Icon, Long> {

    boolean existsByIconIsNullAndId(long id);

}