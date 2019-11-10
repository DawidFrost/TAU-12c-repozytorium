package pl.edu.pjatk.tau.jbehave.searchEngine;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import pl.edu.pjatk.tau.domain.Movie;
import pl.edu.pjatk.tau.service.MovieServiceImpl;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class searchingStepByStep {
    private ExamplesTable movieTable;
    private MovieServiceImpl movieServiceImpl;

    @Given("a search engine")
    public void searchEngineSetup(){
        movieServiceImpl = new MovieServiceImpl();
    }

    @Given("the movies in table: $movieTable")
    public void readMoviesTable(ExamplesTable movieTable)
    {

        this.movieTable = movieTable ;
        readMovieFromTable(movieTable);

    }


    @When("search movie that start with $string")
    public void setSearchString(String string){
        movieServiceImpl.setSearchString(string);
    }

    @Then("searching should return $result movies")
    public void shouldReturn(int result){
        assertEquals(result,movieServiceImpl.searchWithRegex().size());
    }


    public void readMovieFromTable(ExamplesTable movieTable)
    {

        for (Map<String, String> tableRow : movieTable.getRows()) {
            int id = Integer.parseInt(tableRow.get("id"));
            String name = tableRow.get("name");
            String type = tableRow.get("type");
            String director = tableRow.get("director");
            movieServiceImpl.create(new Movie(id, name, type, director));
        }

    }


}
