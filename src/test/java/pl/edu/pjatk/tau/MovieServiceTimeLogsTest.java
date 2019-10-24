package pl.edu.pjatk.tau;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.pjatk.tau.domain.Movie;
import pl.edu.pjatk.tau.service.MovieService;
import pl.edu.pjatk.tau.service.MovieServiceImpl;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTimeLogsTest {

    @InjectMocks
    private Movie firstTestMovie;

    @InjectMocks
    private Movie secondTestMovie;

    private MovieService service = new MovieServiceImpl();

    @Mock
    private Clock clock;

    private final static LocalDateTime STATIC_TIME_CREATE = LocalDateTime.of(2012,12,21, 21, 21, 21, 0);
    private final static LocalDateTime STATIC_TIME_READ = LocalDateTime.of(2019,01,12, 21, 0, 0, 0);
    private final static LocalDateTime STATIC_TIME_UPDATE = LocalDateTime.of(2012,12,21, 21, 21, 21, 0);

    private void mockTime(LocalDateTime staticTime) {
        Clock fixedClock = Clock.fixed(staticTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        Movie firstTestMovie = new Movie("Avatar", "Si-fi", "James Cameron");
        Movie secondTestMovie = new Movie("Joker", "Dramat", "Todd Phillips");
    }

    @Test
    public void checkCreationTime() {
        //Given
        mockTime(STATIC_TIME_CREATE);
        Integer id = service.create(firstTestMovie);
        //When
        Movie readMovie = service.read(id);

        //Then
        assertEquals(STATIC_TIME_CREATE,readMovie.getCreateObjDateTime());
    }

    @Test
    public void doNotSetCreationTimeWhenFlagIsFalse() {
        //Given
        mockTime(STATIC_TIME_CREATE);
        firstTestMovie.actCreateDateTime(false);

        //When
        Integer id = service.create(firstTestMovie);
        Movie readMovie = service.read(id);

        //Then
        assertEquals(null,readMovie.getCreateObjDateTime());
    }

    @Test
    public void setReadeObjDateTime() {
        //Given
        mockTime(STATIC_TIME_READ);


        //When
        Integer id = service.create(firstTestMovie);
        Movie readMovie = service.read(id);

        //Then
        assertEquals(STATIC_TIME_READ,readMovie.getReadObjDateTime());
    }

    @Test
    public void setReadeObjDateTimeWhenFlagIsFalse() {
        //Given
        mockTime(STATIC_TIME_READ);

        //When
        firstTestMovie.setactReadDateTime(false);
        Integer id = service.create(firstTestMovie);


        //Then
        Movie readMovie = service.read(id);
        assertEquals(null,readMovie.getReadObjDateTime());
    }

    @Test
    public void setUpdateObjDateTime() {
        //Given
        mockTime(STATIC_TIME_UPDATE);
        Integer id = service.create(firstTestMovie);
        Movie toupdate = new Movie("Avatar2", firstTestMovie.getType(), firstTestMovie.getDirector());
        //When
        toupdate.setId(id);
        service.update(toupdate);
        Movie updatedMovie = service.read(id);

        //Then
        assertEquals(STATIC_TIME_UPDATE,updatedMovie.getUpdateObjDateTime());
    }

    @Test
    public void setUpdateObjDateTimeWhenFlagIsFalse() {
        //Given
        mockTime(STATIC_TIME_UPDATE);
        firstTestMovie.setactUpdateDateTime(false);
        Integer id = service.create(firstTestMovie);
        Movie toupdate = new Movie("Avatar2", firstTestMovie.getType(), firstTestMovie.getDirector());
        //When
        toupdate.setId(id);
        service.update(toupdate);
        Movie updatedMovie = service.read(id);

        //Then
        assertEquals(null,updatedMovie.getUpdateObjDateTime());
    }

    @Test
    public void setReadObjDateTimeWhenReadAllAndFlagIsFalse() {
        //Given
        mockTime(STATIC_TIME_READ);
        service.create(firstTestMovie);
        service.create(secondTestMovie);

        //When
        List<Movie> allMovies = service.readAll();

        //Then
        assertEquals(STATIC_TIME_READ,allMovies.get(0).getReadObjDateTime());
        assertEquals(STATIC_TIME_READ,allMovies.get(1).getReadObjDateTime());
    }

    @After
    public void cleanup() {
        service.removeAll();
    }

}
