package nb.dev.anime.anime_crud.repository;

import nb.dev.anime.anime_crud.entities.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

}
