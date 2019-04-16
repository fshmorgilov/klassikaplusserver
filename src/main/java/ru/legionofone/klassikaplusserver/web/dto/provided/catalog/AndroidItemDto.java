package ru.legionofone.klassikaplusserver.web.dto.provided.catalog;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "ext_id",
        "name",
        "description",
        "vendorCode",
        "novelty",
        "pageAlias",
        "icon",
        "manufacturer",
        "base_price",
        "discount",
        "discountable",
        "price",
        "photos",
        "category",
        "categoryId"
})
@JsonRootName(value = "item")
public class AndroidItemDto implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("ext_id")
    private String extId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("vendorCode")
    private String vendorCode;
    @JsonProperty("novelty")
    private boolean novelty;
    @JsonProperty("pageAlias")
    private String pageAlias;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("base_price")
    private double basePrice;
    @JsonProperty("discount")
    private int discount;
    @JsonProperty("discountable")
    private boolean discountable;
    @JsonProperty("price")
    private double price;
    @JsonProperty("category")
    private String category;
    @JsonProperty("categoryId")
    private Integer categoryId;
    @JsonProperty("photos")
    private List<PhotoDto> photos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2253449424643818819L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("ext_id")
    public String getExtId() {
        return extId;
    }

    @JsonProperty("ext_id")
    public void setExtId(String extId) {
        this.extId = extId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("vendorCode")
    public String getVendorCode() {
        return vendorCode;
    }

    @JsonProperty("vendorCode")
    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    @JsonProperty("novelty")
    public boolean isNovelty() {
        return novelty;
    }

    @JsonProperty("novelty")
    public void setNovelty(boolean novelty) {
        this.novelty = novelty;
    }

    @JsonProperty("pageAlias")
    public String getPageAlias() {
        return pageAlias;
    }

    @JsonProperty("pageAlias")
    public void setPageAlias(String pageAlias) {
        this.pageAlias = pageAlias;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty("base_price")
    public double getBasePrice() {
        return basePrice;
    }

    @JsonProperty("base_price")
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @JsonProperty("discount")
    public int getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @JsonProperty("discountable")
    public boolean isDiscountable() {
        return discountable;
    }

    @JsonProperty("discountable")
    public void setDiscountable(boolean discountable) {
        this.discountable = discountable;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("photos")
    public List<PhotoDto> getPhotos() {
        return photos;
    }

    @JsonProperty("photos")
    public void setPhotos(List<PhotoDto> photos) {
        this.photos = photos;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("categoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}