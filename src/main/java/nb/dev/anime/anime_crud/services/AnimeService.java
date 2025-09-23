package nb.dev.anime.anime_crud.services;

import nb.dev.anime.anime_crud.dtos.AnimeDTO;
import nb.dev.anime.anime_crud.entities.Anime;
import nb.dev.anime.anime_crud.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    private AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public AnimeDTO saveAnime(Anime anime) {
        Anime animeSaved = animeRepository.save(anime);
        return new AnimeDTO(animeSaved);
    }

    public void deleteAnime(Long id) {
        animeRepository.deleteById(id);
    }

    public List<AnimeDTO> animeList() {
        List<AnimeDTO> animeList = animeRepository.findAll()
                .stream()
                .map(AnimeDTO::new)
                .toList();
        return animeList;
    }

    public AnimeDTO findAnime(Long id) {
       Anime anime = animeRepository.findById(id).orElseThrow();
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
