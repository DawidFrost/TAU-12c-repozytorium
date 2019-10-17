package pl.edu.pjatk.tau;

import org.junit.After;
import pl.edu.pjatk.tau.domain.Movie;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pjatk.tau.service.MovieService;
import pl.edu.pjatk.tau.service.MovieServiceImpl;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MovieServiceTest {
    private MovieService service;
    private Movie movie_1;
    private Movie movie_2;
    private Movie movie_3;

    @Before
    public void init() {
        service = new MovieServiceImpl();
        movie_1 = new Movie("Name_1", "Type1", "Director1");
        movie_2 = new Movie("Name_2", "Type2", "Director1");
        movie_3 = new Movie("Name_3", "Type3", "Director3");
    }


    @Test
    public void readAllTest() {
        service.create(movie_1);
        service.create(movie_2);
        service.create(movie_3);

        assertThat(service.readAll())
                .isNotNull()
                .isNotEmpty()
                .hasSize(3);
    }

    @Test
    public void updateWhenNotPresent() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy( () -> service.update(movie_1) );
    }

    @Test
    public void getAllWhenEmpty() {
        assertThat(service.readAll())
                .isNotNull()
                .isEmpty();
    }

    @Test
    public void updateTest() {
        Integer id = service.create(movie_1);
        Movie updatedMovie = new Movie("Name", movie_1.getDirector(), movie_1.getType());
        updatedMovie.setId(0);
        service.update(updatedMovie);

        assertThat(service.read(0))
                .isNotNull()
                .hasNoNullFieldsOrProperties();

        assertThat(service.read(0).getName()).isNotEqualTo("NotName");
    }

    @Test
     public void createTest(){
        service.create(movie_1);

        assertThat(movie_1.getId()).isNotNull();
        assertThat(movie_2.getId()).isNull();
    }

    @After
    public void removeMovies() {
        service.removeAll();
    }

}
