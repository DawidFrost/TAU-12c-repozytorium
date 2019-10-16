package pl.edu.pjatk.tau;

import pl.edu.pjatk.tau.domain.Movie;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pjatk.tau.service.MovieService;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieServiceTest {
    private MovieService service;
    private Movie movie_1;
    private Movie movie_2;

    @Before
    public void init() {
        service = new BookServiceImpl();
        movie_1 = new Movie("Jan Kowalski", "Book1", "978-1-4028-9462-6");
        movie_2 = new Movie("Jan Lisowski", "Book2", "978-1-4028-9462-4");
    }


    @Test
    void canAddovie(){
        service.add(movie_1);
        assertThat(movie_1.getId()).isNotNull();
    }


}

