package pl.edu.pjatk.tau.jbehave.deleteFromList;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.After;
import pl.edu.pjatk.tau.service.MovieService;
import pl.edu.pjatk.tau.service.MovieServiceImpl;

public class deleteFromListTest extends JUnitStory {

    private MovieService service = new MovieServiceImpl();

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.CONSOLE)
                );
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new deletingStepByStep());
    }

    @After
    public void removeMovies() {
        service.removeAll();
    }
}
