package nb.dev.anime.anime_crud.services;

import nb.dev.anime.anime_crud.dtos.AnimeDTO;
import nb.dev.anime.anime_crud.dtos.AnimeSaveDTO;
import nb.dev.anime.anime_crud.dtos.StudioMinDTO;
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

    public AnimeSaveDTO saveAnime(AnimeSaveDTO dto) {
        Anime anime = new Anime();
        anime.setName(dto.getName());
        anime.setSynopsis(dto.getSynopsis());
        anime.setGenre(dto.getGenre());
        anime.setEpisodes(dto.getEpisodes());
        anime.setPrice(dto.getPrice());
        anime.setStatus(dto.getStatus());
        anime.setStudio(dto.getStudio());
        animeRepository.save(anime);
        return new AnimeSaveDTO(anime);

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
