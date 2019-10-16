package pl.edu.pjatk.tau.domain;



public class Movie {
    private Integer id;
    private String name;
    private String type;
    private String director;

    public Movie(String name,String type,String director) {
        this.name = name;
        this.type = type;
        this.director = director;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
