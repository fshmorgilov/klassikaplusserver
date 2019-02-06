package ru.legionofone.klassikaplusserver.model.domain;

import java.util.Map;

public class CatalogItem {
    private String id;
    private String extId;
    private String icon;
    private String picture;
    private double price;
    private Map<Integer, String> gallery;
    private Boolean novelty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<Integer, String> getGallery() {
        return gallery;
    }

    public void setGallery(Map<Integer, String> gallery) {
        this.gallery = gallery;
    }

    public Boolean getNovelty() {
        return novelty;
    }

    public void setNovelty(Boolean novelty) {
        this.novelty = novelty;
    }
}
