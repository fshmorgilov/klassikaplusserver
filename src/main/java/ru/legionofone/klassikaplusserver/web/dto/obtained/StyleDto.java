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
        "468",
        "469",
        "470"
})
@Deprecated
public class StyleDto implements Serializable {

    @JsonProperty("468")
    private String _468;
    @JsonProperty("469")
    private String _469;
    @JsonProperty("470")
    private String _470;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 38040843838610821L;

    @JsonProperty("468")
    public String get468() {
        return _468;
    }

    @JsonProperty("468")
    public void set468(String _468) {
        this._468 = _468;
    }

    @JsonProperty("469")
    public String get469() {
        return _469;
    }

    @JsonProperty("469")
    public void set469(String _469) {
        this._469 = _469;
    }

    @JsonProperty("470")
    public String get470() {
        return _470;
    }

    @JsonProperty("470")
    public void set470(String _470) {
        this._470 = _470;
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