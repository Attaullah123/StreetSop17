package com.hiconsolution.streetsop17.models;


import java.util.List;

public class StoreIndexCategoryList {

    private String Message;
    private String Status;
    private List<ParentModelIndexModel> Parentlist;

    public StoreIndexCategoryList(String message, String status, List<ParentModelIndexModel> parentlist) {
        Message = message;
        Status = status;
        Parentlist = parentlist;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<ParentModelIndexModel> getParentlist() {
        return Parentlist;
    }

    public void setParentlist(List<ParentModelIndexModel> parentlist) {
        Parentlist = parentlist;
    }
}
