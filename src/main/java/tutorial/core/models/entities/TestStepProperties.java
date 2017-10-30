package tutorial.core.models.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

/**
 * Created by Chris on 6/28/14.
 */
public class TestStepProperties implements Serializable {
    @Id
    private Long id;

    private String key;
    
    private String value;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
