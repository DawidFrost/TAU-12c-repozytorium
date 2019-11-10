package pl.edu.pjatk.tau.jbehave.searchEngine;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;


public class searchTest extends JUnitStory {

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        ParameterConverters parameterConverters = new ParameterConverters();

        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
                new LoadFromClasspath(embeddableClass), parameterConverters);
        parameterConverters.addConverters(
                new ParameterConverters.ExamplesTableConverter(examplesTableFactory));



        return new MostUsefulConfiguration()

                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useParameterConverters(parameterConverters)
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.CONSOLE)
                );
    }


    @Override
    public InjectableStepsFactory stepsFactory() {

        return new InstanceStepsFactory(configuration(), new searchingStepByStep());
    }

}
