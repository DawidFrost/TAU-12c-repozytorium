package pl.edu.pjatk.tau.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.pjatk.tau.domain.Movie;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImpl implements MovieService {

    private static Integer counterID = 0;
    private static List<Movie> db = new ArrayList<>();



    private final static LocalDate LOCAL_DATE = LocalDate.of(2012, 12, 21);



    @InjectMocks
    private Movie movie;

    @Mock
    private Clock clock;

    private Clock fixedClock;



    @Before
    public void initMocks() {
        fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    public List<Movie> readAll() {
        List<Movie> allMovies = db;
        allMovies.forEach(Movie::setReadObjDateTime);
        return db;
    }



    public Movie read(Integer id) {
        Optional<Movie> movie = findByID(id);

        movie
                .ifPresent(Movie::setReadObjDateTime);

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
            updated.setUpdateObjDateTime();
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
        movie.setCreateObjDateTime();
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