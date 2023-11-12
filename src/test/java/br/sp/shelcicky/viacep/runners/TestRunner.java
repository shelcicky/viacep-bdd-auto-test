package br.sp.shelcicky.viacep.runners;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.SpringFactory;
import org.junit.BeforeClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        objectFactory = SpringFactory.class,
        features = "classpath:features",
        glue = "br.sp.shelcicky.viacep.steps",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@ALL and not @NOT_RUN",
        dryRun = false
)
public class TestRunner {
/**
 * Cleaning report directory before test execution.
 */

        private static final String REPORT_DIRECTORY = String.format("%s%starget", System.getProperty("user.dir"), File.separator);

        @BeforeClass
        public static void deleteTargetDirectory() throws IOException {
                FileUtils.deleteDirectory(new File(REPORT_DIRECTORY));
        }
}
