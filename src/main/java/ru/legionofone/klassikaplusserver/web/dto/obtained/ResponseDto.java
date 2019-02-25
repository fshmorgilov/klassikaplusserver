package ru.legionofone.klassikaplusserver.web.dto.obtained;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
@Deprecated
// TODO: 2/21/2019 выпилить
public class ResponseDto implements Serializable {

    @JsonProperty("data")
    private DataDto data = null;
    @JsonIgnore
    private Map<String, DataDto> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 4138989425664953972L;

    @JsonProperty("data")
    public DataDto getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(DataDto data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, DataDto> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, (DataDto) value);
    }

}