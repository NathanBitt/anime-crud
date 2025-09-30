package nb.dev.anime.anime_crud.services;

import nb.dev.anime.anime_crud.dtos.AnimeDTO;
import nb.dev.anime.anime_crud.entities.Anime;
import nb.dev.anime.anime_crud.exceptions.ResourceNotFoundException;
import nb.dev.anime.anime_crud.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public AnimeDTO saveAnime(Anime anime) {
       Anime saved = animeRepository.save(anime);
       return new AnimeDTO(saved);
    }

    public void deleteAnime(Long id) {
        if(!animeRepository.existsById(id)){
           throw new ResourceNotFoundException("Anime com id " + id + " não encontrado");
        } animeRepository.deleteById(id);
    }

    public List<AnimeDTO> animeList() {
        return animeRepository
                .findAll()
                .stream()
                .map(AnimeDTO::new)
                .toList();
    }

    public AnimeDTO findAnime(Long id) {
       Anime anime = animeRepository
               .findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Produto com id " +id+ " não encontrado"));
       return new AnimeDTO(anime);

    }

    public AnimeDTO editAnime(Long id, Anime animeUpdated) {
        Anime animeSaved = animeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Anime not found"));

        animeSaved.setName(animeUpdated.getName());
        animeSaved.setGenre(animeUpdated.getGenre());
        animeSaved.setPrice(animeUpdated.getPrice());
        animeSaved.setSynopsis(animeUpdated.getSynopsis());
        animeRepository.save(animeSaved);
        return new AnimeDTO(animeSaved);

    }
}
