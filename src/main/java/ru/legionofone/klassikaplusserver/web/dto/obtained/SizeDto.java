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
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14"
})
@Deprecated
// TODO: 2/21/2019 выпилить
public class SizeDto implements Serializable {

    @JsonProperty("4")
    private String _4;
    @JsonProperty("5")
    private String _5;
    @JsonProperty("6")
    private String _6;
    @JsonProperty("7")
    private String _7;
    @JsonProperty("8")
    private String _8;
    @JsonProperty("9")
    private String _9;
    @JsonProperty("10")
    private String _10;
    @JsonProperty("11")
    private String _11;
    @JsonProperty("12")
    private String _12;
    @JsonProperty("13")
    private String _13;
    @JsonProperty("14")
    private String _14;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -549258516369185385L;

    @JsonProperty("4")
    public String get4() {
        return _4;
    }

    @JsonProperty("4")
    public void set4(String _4) {
        this._4 = _4;
    }

    @JsonProperty("5")
    public String get5() {
        return _5;
    }

    @JsonProperty("5")
    public void set5(String _5) {
        this._5 = _5;
    }

    @JsonProperty("6")
    public String get6() {
        return _6;
    }

    @JsonProperty("6")
    public void set6(String _6) {
        this._6 = _6;
    }

    @JsonProperty("7")
    public String get7() {
        return _7;
    }

    @JsonProperty("7")
    public void set7(String _7) {
        this._7 = _7;
    }

    @JsonProperty("8")
    public String get8() {
        return _8;
    }

    @JsonProperty("8")
    public void set8(String _8) {
        this._8 = _8;
    }

    @JsonProperty("9")
    public String get9() {
        return _9;
    }

    @JsonProperty("9")
    public void set9(String _9) {
        this._9 = _9;
    }

    @JsonProperty("10")
    public String get10() {
        return _10;
    }

    @JsonProperty("10")
    public void set10(String _10) {
        this._10 = _10;
    }

    @JsonProperty("11")
    public String get11() {
        return _11;
    }

    @JsonProperty("11")
    public void set11(String _11) {
        this._11 = _11;
    }

    @JsonProperty("12")
    public String get12() {
        return _12;
    }

    @JsonProperty("12")
    public void set12(String _12) {
        this._12 = _12;
    }

    @JsonProperty("13")
    public String get13() {
        return _13;
    }

    @JsonProperty("13")
    public void set13(String _13) {
        this._13 = _13;
    }

    @JsonProperty("14")
    public String get14() {
        return _14;
    }

    @JsonProperty("14")
    public void set14(String _14) {
        this._14 = _14;
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