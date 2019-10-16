package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


public class MovieServiceImpl implements MovieService {

    private static Integer counterID = 0;
    private static List<Movie> db = new ArrayList<>();

    public List<Movie> readAll() {
        return db;
    }


    public Movie read(Integer id) {
        Optional<Movie> movie = findByID(id);

        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new NoSuchElementException();
        }
    }


    public Integer update(Movie updatedMovie) {
        Optional<Movie> movie = findByID(updatedMovie.getId());

        if (movie.isPresent()) {
            Movie updated = movie.get();
            updated.setName(updatedMovie.getName());
            updated.setDirector(updatedMovie.getDirector());
            updated.setType(updatedMovie.getType());
            return updated.getId();
        } else {
            throw new NoSuchElementException();
        }
    }

    private Integer addID() {
        return counterID++;
    }

    public void delete(Integer id) {
        Movie movie = read(id);
        db.remove(movie);
    }


    public void removeAll() {
        db = new ArrayList<>();
    }

    public Integer create(Movie movie) {
        if(movieExists(movie)) {
            throw new IllegalArgumentException("Movie exists in database");
        }
        movie.setId(addID());
        db.add(movie);
        return movie.getId();
    }

    private Optional<Movie> findByID(Integer id){
        return db.stream()
                    .filter(m -> m.getId().equals(id))
                    .findFirst();
    }

    private boolean movieExists(Movie movie) {

        return findByID(movie.getId()).isPresent();
    }
}