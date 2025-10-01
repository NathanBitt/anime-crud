package nb.dev.anime.anime_crud.dtos;

import nb.dev.anime.anime_crud.entities.Anime;
import nb.dev.anime.anime_crud.entities.Studio;

import java.util.List;

public class StudioSaveDTO {
    private String name;
    private List<Anime> animeList;

    public StudioSaveDTO(){}

    public StudioSaveDTO(String name, List<Anime> animeList) {
        this.name = name;
        this.animeList = animeList;
    }

    public StudioSaveDTO(Studio studio){
        this.name = studio.getName();
        this.animeList = studio.getAnimeList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Anime> getAnimeList() {
        return animeList;
    }

    public void setAnimeList(List<Anime> animeList) {
        this.animeList = animeList;
    }
}
