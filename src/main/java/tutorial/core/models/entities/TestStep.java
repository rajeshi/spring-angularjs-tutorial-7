package tutorial.core.models.entities;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Rajesh on 10/25/17.
 */
@Document(collection="testStep")
public class TestStep implements Serializable{

    @Id
    private Long id;

    private String title;

    private List<TestStepProperties> testScriptProperties;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TestStepProperties> getTestScriptProperties() {
        return testScriptProperties;
    }

    public void setTestScriptProperties(List<TestStepProperties> testScriptProperties) {
        this.testScriptProperties = testScriptProperties;
    }
}
