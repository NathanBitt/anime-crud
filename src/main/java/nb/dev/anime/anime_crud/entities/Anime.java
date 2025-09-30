package nb.dev.anime.anime_crud.entities;

import jakarta.persistence.*;
import nb.dev.anime.anime_crud.enums.AnimeStatus;

@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String synopsis;
    private String genre;
    private int episodes;
    private Double price;
    @Enumerated(EnumType.STRING)
    private AnimeStatus status;
    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    //@Column(nullable = false) isso não funciona
    private Studio studio;

    public Anime(){

    }

    public Anime(String name, String synopsis, String genre, int episodes, Double price, Studio studio, AnimeStatus status) {
        this.name = name;
        this.synopsis = synopsis;
        this.genre = genre;
        this.episodes = episodes;
        this.price = price;
        this.studio = studio;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public AnimeStatus getStatus() {
        return status;
    }

    public void setStatus(AnimeStatus status) {
        this.status = status;
    }
}
