package ru.legionofone.klassikaplusserver.web.dto.provided.catalog.category;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "categories"
})
@JsonRootName(value = "data")
public class CategoryDataDto implements Serializable {

    @JsonProperty("categories")
    private Map<Integer, String> categories = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9010141155132269969L;

    @JsonProperty("categories")
    public Map<Integer, String> getItems() {
        return categories;
    }

    @JsonProperty("categories")
    public void setItems(Map<Integer, String> items) {
        this.categories = items;
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
