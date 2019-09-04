package fr.weight.serieservice.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.weight.serieservice.dto.SerieModel;
import lombok.Data;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Data
public class Serie extends ResourceSupport {

    private SerieModel model;

    @JsonCreator
    public Serie(@JsonProperty("content") SerieModel model) {
        this.model = model;
    }


    public Serie(@JsonProperty("content") SerieModel model, Link l) {
        this.model = model;
        this.add(l);
    }

}
