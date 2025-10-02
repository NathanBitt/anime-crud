package nb.dev.anime.anime_crud.controllers;

import jakarta.validation.Valid;
import nb.dev.anime.anime_crud.dtos.AnimeDTO;
import nb.dev.anime.anime_crud.dtos.AnimeSaveDTO;
import nb.dev.anime.anime_crud.entities.Anime;
import nb.dev.anime.anime_crud.services.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {
    AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping("/new")
    public ResponseEntity<AnimeSaveDTO> saveAnime(@Valid @RequestBody AnimeSaveDTO anime) {
        animeService.saveAnime(anime);
        return ResponseEntity.status(HttpStatus.CREATED).body(anime);
    }

    @GetMapping
    public List<AnimeDTO> animeList() {
        return animeService.animeList();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable Long id) {
        animeService.deleteAnime(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("find/{id}")
    public AnimeDTO findAnime(@PathVariable Long id) {
        return animeService.findAnime(id);
    }

    @PutMapping("/edit/{id}")
    public AnimeDTO editAnime(@Valid @PathVariable Long id, @RequestBody Anime animeUpdated) {
        return animeService.editAnime(id, animeUpdated);
    }
}
