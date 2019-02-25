package ru.legionofone.klassikaplusserver.web.dto.provided.revision;

import com.fasterxml.jackson.annotation.*;
import ru.legionofone.klassikaplusserver.web.dto.provided.ErrorDto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data",
"status",
"errors"
})
public class ResponseDto implements Serializable {

    @JsonProperty("data")
    private Integer data;
    @JsonProperty("status")
    private String status;
    @JsonProperty("errors")
    private List<ErrorDto> errors = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6906549723676220107L;

    @JsonProperty("data")
    public Integer getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Integer data) {
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
}
