package com.hiconsolution.streetsop17.models;

/**
 * Created by attaullahkhizar on 8/28/17.
 */

public class ParentModelIndexModel {

    private String Id;
    private String Name;
    private String DisplayOrder;
    private String ImageLink;


    public ParentModelIndexModel(String id, String name, String displayOrder, String imageLink) {
        Id = id;
        Name = name;
        DisplayOrder = displayOrder;
        ImageLink = imageLink;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        DisplayOrder = displayOrder;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }
}
