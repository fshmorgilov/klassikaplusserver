package ru.legionofone.klassikaplusserver.model.persistance.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "item")
public class DbItem implements Serializable {
//todo getter setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name; //h1
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
//    @Ignore
//    private String icon;
//    @Ignore
//    private String photo;
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
    public int getId() {
        return id;
    }
}
