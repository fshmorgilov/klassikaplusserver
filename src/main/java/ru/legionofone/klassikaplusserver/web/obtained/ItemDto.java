package ru.legionofone.klassikaplusserver.web.obtained;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class ItemDto {

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
    private String price;
    @JsonProperty("discount")
    private Object discount;
    @JsonProperty("old_price")
    private Object oldPrice;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sostav")
    private CompositionDto composition;
    @JsonProperty("size")
    private SizeDto size;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("number")
    private String number;
    @JsonProperty("style")
    private StyleDto style;
    @JsonProperty("articul")
    private String articul;
    @JsonProperty("view_main")
    private String viewMain;
    @JsonProperty("new")
    private String _new;
    @JsonProperty("with_goods")
    private Object withGoods;
    @JsonProperty("img_mini")
    private String imgMini;
    @JsonProperty("image")
    private String image;
    @JsonProperty("photogallery")
    private PhotogalleryDto photogallery;
    @JsonProperty("child_pages")
    private String childPages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5756738634783614208L;

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
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
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
    public CompositionDto getComposition() {
        return composition;
    }

    @JsonProperty("sostav")
    public void setComposition(CompositionDto composition) {
        this.composition = composition;
    }

    @JsonProperty("size")
    public SizeDto getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(SizeDto size) {
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
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("style")
    public StyleDto getStyle() {
        return style;
    }

    @JsonProperty("style")
    public void setStyle(StyleDto style) {
        this.style = style;
    }

    @JsonProperty("articul")
    public String getArticul() {
        return articul;
    }

    @JsonProperty("articul")
    public void setArticul(String articul) {
        this.articul = articul;
    }

    @JsonProperty("view_main")
    public String getViewMain() {
        return viewMain;
    }

    @JsonProperty("view_main")
    public void setViewMain(String viewMain) {
        this.viewMain = viewMain;
    }

    @JsonProperty("new")
    public String getNew() {
        return _new;
    }

    @JsonProperty("new")
    public void setNew(String _new) {
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
    public PhotogalleryDto getPhotogallery() {
        return photogallery;
    }

    @JsonProperty("photogallery")
    public void setPhotogallery(PhotogalleryDto photogallery) {
        this.photogallery = photogallery;
    }

    @JsonProperty("child_pages")
    public String getChildPages() {
        return childPages;
    }

    @JsonProperty("child_pages")
    public void setChildPages(String childPages) {
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
