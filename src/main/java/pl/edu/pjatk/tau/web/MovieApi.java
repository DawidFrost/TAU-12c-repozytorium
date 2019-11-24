package pl.edu.pjatk.tau.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.tau.domain.Movie;
import pl.edu.pjatk.tau.service.MovieServiceDB;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MovieApi {

//    @Autowired
    MovieServiceDB movieServiceDB;

    @RequestMapping("/")
    public String index() {
        return "This is non rest, just checking if everything works.";
    }

    @RequestMapping(value = "/movie/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Movie readMovie(@PathVariable("id") int id) throws SQLException {
        return movieServiceDB.readMovieById(id);
    }

    @RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Movie> readMovies(@RequestParam(value = "filter", required = false) String f) throws SQLException {
        return movieServiceDB.readAll();
    }

    @RequestMapping(value = "/movie",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie createMovie(@RequestBody Movie m) throws SQLException {
        if (movieServiceDB.createMovie(m) < 1) return null;
        return m;
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteMovie(@PathVariable("id") int id) throws SQLException {
        return movieServiceDB.deleteMovie(movieServiceDB.readMovieById(id));

    }

    @RequestMapping(value = "/movies", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteAllMovies() throws SQLException {
        return movieServiceDB.deleteAllMovies();
    }

}





