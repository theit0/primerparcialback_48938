package primerparcialback_48938.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import primerparcialback_48938.controllers.BaseController;
import primerparcialback_48938.services.BaseService;


import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "primerparcialback_48938",importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchUnitTest {

    @ArchTest
    public static final ArchRule layerRule =
    layeredArchitecture().consideringAllDependencies()
            .layer("Controller").definedBy("primerparcialback_48938.controllers")
            .layer("Service").definedBy("primerparcialback_48938.services")
            .layer("Persistence").definedBy("primerparcialback_48938.repositories")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

    @ArchTest
    public static final ArchRule controllerNameRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().resideInAPackage("primerparcialback_48938.controllers");

    @ArchTest
    public static final ArchRule controllerBaseRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().implement(BaseController.class)
                    .orShould().haveSimpleName("BaseController");

    @ArchTest
    public static final ArchRule serviceNameRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().resideInAPackage("primerparcialback_48938.services");

    @ArchTest
    public static final ArchRule serviceBaseRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().implement(BaseService.class)
                    .orShould().haveSimpleName("BaseServiceImpl");

    @ArchTest
    public static final ArchRule repositoryNameRule =
            classes().that().haveSimpleNameEndingWith("Repository").should().resideInAPackage("primerparcialback_48938.repositories");

    @ArchTest
    public static final ArchRule entitiesAnnotation =
            classes().that().resideInAPackage("primerparcialback_48938.entities").should().beAnnotatedWith(Entity.class)
                    .orShould().haveSimpleName("Base");

}
