package pl.edu.pjatk.tau.jbehave.deleteFromList;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pl.edu.pjatk.tau.domain.Movie;
import pl.edu.pjatk.tau.service.MovieServiceImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertTrue;


public class deletingStepByStep {
    private MovieServiceImpl movieServiceImpl = new MovieServiceImpl();

    @Given("movies in table: $movieTable")
    public void getFrameworksTable(ExamplesTable movieTable)
    {
        ArrayList<Movie> moviesToAdd = readMoviesFromTable(movieTable);
        for(Movie movie: moviesToAdd)
            movieServiceImpl.create(movie);
    }

    public ArrayList<Movie> readMoviesFromTable(ExamplesTable movieTable)
    {
        ArrayList<Movie> result= new ArrayList<Movie>();
        for (Map<String, String> tableRow : movieTable.getRows()) {
            Integer id = Integer.parseInt(tableRow.get("id"));
            String name = tableRow.get("name");
            String type = tableRow.get("type");
            String director = tableRow.get("director");
            result.add(new Movie(id, name, type, director));
        }
        return result;

    }



    @When("I delete movies from table: $movieTable")
    public void deleteFromList(ExamplesTable movieTable)
    {
        movieServiceImpl.deleteFromList(readMoviesFromTable(movieTable));
    }



    @Then("I should have in database: $movieTable")
    public void checkThatMovieExistingInList(ExamplesTable movieTable)
    {
        for(Movie movie : readMoviesFromTable(movieTable))
            assertTrue(movieServiceImpl.itHas(movie));
    }

    @Then("I should't contain: $movieTable")
    public void checkThatMovieDontExistingInList(ExamplesTable movieTable)
    {
        for(Movie movie : readMoviesFromTable(movieTable))
            assertTrue(!movieServiceImpl.itHas(movie));
    }

}
