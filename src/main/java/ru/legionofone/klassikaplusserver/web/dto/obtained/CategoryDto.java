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

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("menutitle")
    public String getMenutitle() {
        return menutitle;
    }

    @JsonProperty("menutitle")
    public void setMenutitle(String menutitle) {
        this.menutitle = menutitle;
    }

    @JsonProperty("pagetitle")
    public String getPagetitle() {
        return pagetitle;
    }

    @JsonProperty("pagetitle")
    public void setPagetitle(String pagetitle) {
        this.pagetitle = pagetitle;
    }

    @JsonProperty("parent")
    public String getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(String parent) {
        this.parent = parent;
    }

    @JsonProperty("longtitle")
    public String getLongtitle() {
        return longtitle;
    }

    @JsonProperty("longtitle")
    public void setLongtitle(String longtitle) {
        this.longtitle = longtitle;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @JsonProperty("menuindex")
    public String getMenuindex() {
        return menuindex;
    }

    @JsonProperty("menuindex")
    public void setMenuindex(String menuindex) {
        this.menuindex = menuindex;
    }

    @JsonProperty("introtext")
    public String getIntrotext() {
        return introtext;
    }

    @JsonProperty("introtext")
    public void setIntrotext(String introtext) {
        this.introtext = introtext;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("published")
    public String getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(String published) {
        this.published = published;
    }

    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty("price")
    public Object getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Object price) {
        this.price = price;
    }

    @JsonProperty("discount")
    public Object getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(Object discount) {
        this.discount = discount;
    }

    @JsonProperty("old_price")
    public Object getOldPrice() {
        return oldPrice;
    }

    @JsonProperty("old_price")
    public void setOldPrice(Object oldPrice) {
        this.oldPrice = oldPrice;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("sostav")
    public Object getSostav() {
        return sostav;
    }

    @JsonProperty("sostav")
    public void setSostav(Object sostav) {
        this.sostav = sostav;
    }

    @JsonProperty("size")
    public Object getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Object size) {
        this.size = size;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("number")
    public Object getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Object number) {
        this.number = number;
    }

    @JsonProperty("style")
    public Object getStyle() {
        return style;
    }

    @JsonProperty("style")
    public void setStyle(Object style) {
        this.style = style;
    }

    @JsonProperty("articul")
    public Object getArticul() {
        return articul;
    }

    @JsonProperty("articul")
    public void setArticul(Object articul) {
        this.articul = articul;
    }

    @JsonProperty("view_main")
    public Object getViewMain() {
        return viewMain;
    }

    @JsonProperty("view_main")
    public void setViewMain(Object viewMain) {
        this.viewMain = viewMain;
    }

    @JsonProperty("new")
    public Object getNew() {
        return _new;
    }

    @JsonProperty("new")
    public void setNew(Object _new) {
        this._new = _new;
    }

    @JsonProperty("with_goods")
    public Object getWithGoods() {
        return withGoods;
    }

    @JsonProperty("with_goods")
    public void setWithGoods(Object withGoods) {
        this.withGoods = withGoods;
    }

    @JsonProperty("img_mini")
    public String getImgMini() {
        return imgMini;
    }

    @JsonProperty("img_mini")
    public void setImgMini(String imgMini) {
        this.imgMini = imgMini;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("photogallery")
    public Object getPhotogallery() {
        return photogallery;
    }

    @JsonProperty("photogallery")
    public void setPhotogallery(Object photogallery) {
        this.photogallery = photogallery;
    }

    @JsonProperty("child_pages")
    public List<ItemDto> getChildPages() {
        return childPages;
    }

    @JsonProperty("child_pages")
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

