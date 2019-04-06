package ru.legionofone.klassikaplusserver.web.dto.provided.catalog.category;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.legionofone.klassikaplusserver.web.dto.provided.ErrorDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.DataDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "status",
        "errors"
})
public class CategoryResponseDto implements Serializable {

    @JsonProperty("data")
    private CategoryDataDto data;
    @JsonProperty("status")
    private String status;
    @JsonProperty("errors")
    private List<ErrorDto> errors = null;
    @JsonProperty("revision")
    private int revision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6906648723676220107L;

    @JsonProperty("data")
    public CategoryDataDto getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(CategoryDataDto data) {
        this.data = data;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("errors")
    public List<ErrorDto> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<ErrorDto> errors) {
        this.errors = errors;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }
}