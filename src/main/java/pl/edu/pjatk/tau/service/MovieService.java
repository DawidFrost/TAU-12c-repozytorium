package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.Movie;

import java.util.List;

public interface MovieService {

    Integer create(Movie movie);

    List<Movie> readAll();

    Movie read(Integer id);

    Integer update(Movie movie);

    void delete(Integer id);

    void removeAll();


}
