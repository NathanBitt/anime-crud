package nb.dev.anime.anime_crud.entities;

import jakarta.persistence.*;

@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String synopsis;
    private String genre;
    private int volumes;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    //@Column(nullable = false) isso não funciona
    private Studio studio;

    private Anime(){

    }

    public Anime(String name, String synopsis, String genre, int volumes, Double price, Studio studio) {
        this.name = name;
        this.synopsis = synopsis;
        this.genre = genre;
        this.volumes = volumes;
        this.price = price;
        this.studio = studio;
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

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
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
}
