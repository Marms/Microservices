package fr.weight.execisestemplateservice.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.weight.execisestemplateservice.dto.ExerciceTemplateModel;
import lombok.Data;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Data
public class Template extends ResourceSupport {

    private ExerciceTemplateModel model;

    @JsonCreator
    public Template(@JsonProperty("content") ExerciceTemplateModel model) {
        this.model = model;
    }


    public Template(@JsonProperty("content") ExerciceTemplateModel model, Link l) {
        this.model = model;
        this.add(l);
    }

}
