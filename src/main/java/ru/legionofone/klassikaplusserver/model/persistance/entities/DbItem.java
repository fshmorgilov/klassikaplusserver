package ru.legionofone.klassikaplusserver.model.persistance.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "item")
public class DbItem implements Serializable {
    //todo getter setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "name")
    private String name; //h1
    @Column(name = "ext_id")
    private String extId;
    @Column(name = "title")
    private String title;//title
    @Column(name = "description")
    private String description; //ключевое описание
    @Column(name = "annotation")
    private String annotation;
    @Column(name = "vendor_code") //артикул
    private String vendorCode;
    @Column(name = "shown_on_main") //показать на главной
    private Boolean shownOnMain;
    @Column(name = "novelty")
    private Boolean novelty;
    @Column(name = "description_long") //содержимое
    private String descriptionLong;
    @Column(name = "page_alias")
    private String pageAlias;
    @Column(name = "template") //todo шаблон отображения для сайта, возможно мне не нужен
    private String template;
    @Column(name = "menu_item_name")
    private String menuItemName; //Пункт Меню
    @Column(name = "related_link")
    private String relatedLink; // Сторонняя ссылка
    @Column(name = "dont_show")
    private Boolean dontShowInMenu; //Не показывать в меню
    @Column(name = "published")
    private Boolean published;
    @Column(name = "keywords")
    private String keywords;

    //    ////------additional_fields-----------////
//    //photo
    @Column(name = "icon")
    private String icon;
    @Column(name = "photo")
    private String photo;
//
//    //Characteristics
//    @Ignore
//    private String countryManufacturer; //Страна производитель
//    @Ignore
//    private String composition; //хз че с этим делать
//    @Ignore
//    private String manufacturer; //производитель
//    @Ignore
//    private List<String> styleCollection;

    //Pricing
    @Column(name = "base_price")
    private double basePrice;
    @Column(name = "discount")
    private double discount;
    @Column(name = "price")
    private double price;

    public String getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Boolean getShownOnMain() {
        return shownOnMain;
    }

    public void setShownOnMain(Boolean shownOnMain) {
        this.shownOnMain = shownOnMain;
    }

    public Boolean getNovelty() {
        return novelty;
    }

    public void setNovelty(Boolean novelty) {
        this.novelty = novelty;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public String getPageAlias() {
        return pageAlias;
    }

    public void setPageAlias(String pageAlias) {
        this.pageAlias = pageAlias;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getRelatedLink() {
        return relatedLink;
    }

    public void setRelatedLink(String relatedLink) {
        this.relatedLink = relatedLink;
    }

    public Boolean getDontShowInMenu() {
        return dontShowInMenu;
    }

    public void setDontShowInMenu(Boolean dontShowInMenu) {
        this.dontShowInMenu = dontShowInMenu;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
