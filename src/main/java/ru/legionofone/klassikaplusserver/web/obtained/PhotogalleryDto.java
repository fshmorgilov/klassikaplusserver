package ru.legionofone.klassikaplusserver.web.obtained;

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
"MIGX_id",
"image",
"minimage",
"title"
})
public class PhotogalleryDto implements Serializable
{

@JsonProperty("MIGX_id")
private String mIGXId;
@JsonProperty("image")
private String image;
@JsonProperty("minimage")
private String minimage;
@JsonProperty("title")
private String title;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = 4726470783581110687L;

@JsonProperty("MIGX_id")
public String getMIGXId() {
return mIGXId;
}

@JsonProperty("MIGX_id")
public void setMIGXId(String mIGXId) {
this.mIGXId = mIGXId;
}

@JsonProperty("image")
public String getImage() {
return image;
}

@JsonProperty("image")
public void setImage(String image) {
this.image = image;
}

@JsonProperty("minimage")
public String getMinimage() {
return minimage;
}

@JsonProperty("minimage")
public void setMinimage(String minimage) {
this.minimage = minimage;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
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