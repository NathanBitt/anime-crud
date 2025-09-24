package nb.dev.anime.anime_crud.dtos;


import nb.dev.anime.anime_crud.entities.Studio;

public class StudioMinDTO {
    private String name;


    public StudioMinDTO() {
    }

    public StudioMinDTO(Studio studio) {
        this.name = studio.getName();
    }

    public StudioMinDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

