package pl.edu.pjatk.tau;

import pl.edu.pjatk.tau.domain.Movie;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pjatk.tau.service.MovieService;
import pl.edu.pjatk.tau.service.MovieServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieServiceTest {
    private MovieService service;
    private Movie movie_1;
    private Movie movie_2;

    @Before
    public void init() {
        service = new MovieServiceImpl();
        movie_1 = new Movie("TestName_1", "Type1", "Director1");
        movie_2 = new Movie("TestName_2", "Type2", "Director1");
    }


    @Test
    void canAddovie(){
        service.add(movie_1);
        assertThat(movie_1.getId()).isNotNull();
    }


}

