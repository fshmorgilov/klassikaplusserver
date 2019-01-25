package ru.legionofone.klassikaplusserver.web.dto.obtained;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "menutitle",
        "pagetitle",
        "parent",
        "longtitle",
        "uri",
        "alias",
        "menuindex",
        "introtext",
        "description",
        "published",
        "template",
        "price",
        "discount",
        "old_price",
        "country",
        "sostav",
        "size",
        "brand",
        "number",
        "style",
        "articul",
        "view_main",
        "new",
        "with_goods",
        "img_mini",
        "image",
        "photogallery",
        "child_pages"
})
public class CategoryDto implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("menutitle")
    private String menutitle;
    @JsonProperty("pagetitle")
    private String pagetitle;
    @JsonProperty("parent")
    private String parent;
    @JsonProperty("longtitle")
    private String longtitle;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("menuindex")
    private String menuindex;
    @JsonProperty("introtext")
    private String introtext;
    @JsonProperty("description")
    private String description;
    @JsonProperty("published")
    private String published;
    @JsonProperty("template")
    private String template;
    @JsonProperty("price")
    private Object price;
    @JsonProperty("discount")
    private Object discount;
    @JsonProperty("old_price")
    private Object oldPrice;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sostav")
    private Object sostav;
    @JsonProperty("size")
    private Object size;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("number")
    private Object number;
    @JsonProperty("style")
    private Object style;
    @JsonProperty("articul")
    private Object articul;
    @JsonProperty("view_main")
    private Object viewMain;
    @JsonProperty("new")
    private Object _new;
    @JsonProperty("with_goods")
    private Object withGoods;
    @JsonProperty("img_mini")
    private String imgMini;
    @JsonProperty("image")
    private String image;
    @JsonProperty("photogallery")
    private Object photogallery;
    @JsonProperty("child_pages")
    private List<ItemDto> childPages = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3062157434456738262L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenutitle() {
        return menutitle;
    }

    public void setMenutitle(String menutitle) {
        this.menutitle = menutitle;
    }

    public String getPagetitle() {
        return pagetitle;
    }

    public void setPagetitle(String pagetitle) {
        this.pagetitle = pagetitle;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getLongtitle() {
        return longtitle;
    }

    public void setLongtitle(String longtitle) {
        this.longtitle = longtitle;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMenuindex() {
        return menuindex;
    }

    public void setMenuindex(String menuindex) {
        this.menuindex = menuindex;
    }

    public String getIntrotext() {
        return introtext;
    }

    public void setIntrotext(String introtext) {
        this.introtext = introtext;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getDiscount() {
        return discount;
    }

    public void setDiscount(Object discount) {
        this.discount = discount;
    }

    public Object getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Object oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getSostav() {
        return sostav;
    }

    public void setSostav(Object sostav) {
        this.sostav = sostav;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public Object getStyle() {
        return style;
    }

    public void setStyle(Object style) {
        this.style = style;
    }

    public Object getArticul() {
        return articul;
    }

    public void setArticul(Object articul) {
        this.articul = articul;
    }

    public Object getViewMain() {
        return viewMain;
    }

    public void setViewMain(Object viewMain) {
        this.viewMain = viewMain;
    }

    public Object getNew() {
        return _new;
    }


    public void setNew(Object _new) {
        this._new = _new;
    }

    public Object getWithGoods() {
        return withGoods;
    }

    public void setWithGoods(Object withGoods) {
        this.withGoods = withGoods;
    }

    public String getImgMini() {
        return imgMini;
    }

    public void setImgMini(String imgMini) {
        this.imgMini = imgMini;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getPhotogallery() {
        return photogallery;
    }

    public void setPhotogallery(Object photogallery) {
        this.photogallery = photogallery;
    }

    public List<ItemDto> getChildPages() {
        return childPages;
    }



    public void setChildPages(List<ItemDto> childPages) {
        this.childPages = childPages;
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

