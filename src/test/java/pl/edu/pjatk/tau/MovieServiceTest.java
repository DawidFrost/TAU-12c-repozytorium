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
import static org.junit.Assert.*;

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

    @Test(expected = NoSuchElementException.class)
    public void deleteTest() {

        service.create(movie_1);
        Integer mId = service.create(movie_2);

        service.delete(mId);
        service.read(mId);
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
    public void readMovie() {
        Integer mId = service.create(movie_1);
        Movie testMovie = service.read(mId);

        assertEquals(movie_1.getId(), testMovie.getId());
        assertEquals(movie_1.getName(), testMovie.getName());
        assertEquals(movie_1.getType(), testMovie.getType());
        assertEquals(movie_1.getDirector(), testMovie.getDirector());
    }

    @Test
    public void updateWhenNotPresent() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy( () -> service.update(movie_1) );
    }

    @Test   
    public void readAllWhenEmpty() {
        assertThat(service.readAll())
                .isNotNull()
                .isEmpty();
    }


    @Test
    public void updateTest() {
        Integer id = service.create(movie_1);
        Movie toupdate = new Movie("Name", movie_1.getType(), movie_1.getDirector());
        toupdate.setId(id);
        service.update(toupdate);

        Movie updatedMovie = service.read(id);

        assertEquals("Name",updatedMovie.getName() );
        assertEquals("Type1",updatedMovie.getType() );
        assertEquals("Director1",updatedMovie.getDirector() );

    }

    @Test
    public void createTest(){
        service.create(movie_1);
        service.create(movie_2);

        assertNotEquals(movie_1,movie_2);
        assertThat(movie_1.getId()).isNotNull();
        assertThat(movie_3.getId()).isNull();
    }

    @Test
    public void removeAllTest() {
        service.create(movie_1);
        service.create(movie_2);
        service.removeAll();

        assertEquals(0, service.readAll().size());

    }

    @After
    public void removeMovies() {
        service.removeAll();
    }

}