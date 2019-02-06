package ru.legionofone.klassikaplusserver.web.dto.provided;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "items"
})
@JsonRootName(value = "data")
public class DataDto implements Serializable {

    @JsonProperty("items")
    private List<AndroidItemDto> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9010141154147269969L;

    @JsonProperty("items")
    public List<AndroidItemDto> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<AndroidItemDto> items) {
        this.items = items;
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