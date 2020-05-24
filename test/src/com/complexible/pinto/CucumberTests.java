import com.complexible.common.openrdf.model.ModelIO;
import com.complexible.pinto.RDFMapper;
import com.complexible.pinto.annotations.RdfProperty;
import com.complexible.pinto.annotations.RdfsClass;
import com.complexible.pinto.java.helper.ModelTestHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.*;

public class CucumberTests {
    Object object;

    @Given("I have a {string} object")
    public void iHaveAClassObject(String className) {
        object = Class(className);
    }

    @And("The object name is {string}")
    public void theObjectNameIs(String name) {
        object.name  =  name;
    }
}

    @When("I want to serialize the {string} object to {string}")
    public iWantToSerializeObject(String objectName, String filePath) {
        RDFMapper.writeValue(Class(objectName), filePath);
    }

    @When("I want to deserialize the {string} object from {string}")
    public iWantToDeSerializeObject(String objectName, String filePath) {
        return RDFMapper.readValue(Class(objectName), filePath);
    }
}