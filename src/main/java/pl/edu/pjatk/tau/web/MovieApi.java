package pl.edu.pjatk.tau.web;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.tau.domain.Movie;
import pl.edu.pjatk.tau.service.MovieServiceDB;

@RestController
public class MovieApi {


    private MovieServiceDB movieServiceDB;

    @Autowired
    public MovieApi(MovieServiceDB movieServiceDB) {
        this.movieServiceDB = movieServiceDB;
    }

    @RequestMapping("/")
    public String index() {
        return "This is non rest, just checking if everything works.";
    }

    @GetMapping(value = "/movie/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Movie readMovie(@PathVariable("id") Integer id) throws SQLException {
        return movieServiceDB.readMovieById(id);
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Movie> readMovies(@RequestParam(value = "filter", required = false) String f)
            throws SQLException {
        return movieServiceDB.readAll();
    }

    @PostMapping(value = "/movie",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Movie createMovie(@RequestBody Movie m) throws SQLException {
        if (movieServiceDB.createMovie(m) < 1) {
            return null;
        }
        return m;
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteMovie(@PathVariable("id") Integer id) throws SQLException {
        return movieServiceDB.deleteMovie(id);

    }

    @RequestMapping(value = "/movies", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteAllMovies() throws SQLException {
        return movieServiceDB.deleteAllMovies();
    }

    @PutMapping (value = "/movie/{id}",
              consumes = MediaType.APPLICATION_JSON_VALUE,
              produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateFramework(@PathVariable("id") Integer id,@RequestBody Movie m ) throws SQLException {
        return movieServiceDB.updateMovie(id,m);
    }

}