/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.models;

/**
 *
 * @author hvdil
 */
public class tag {
    
    private int id;
    private String tag;
    private String tagCode;
    private String relatedTag;

//    public tag(int aInt, String string, String string0, String string1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getRelatedTag() {
        return relatedTag;
    }

    public void setRelatedTag(String relatedTag) {
        this.relatedTag = relatedTag;
    }
    
    public tag() {
    }
    
    
    public tag(int ID, String tag, String tagCode, String relatedTag){
        this.id = ID;
        this.tag = tag;
        this.tagCode = tagCode;
        this.relatedTag = relatedTag;
    } 
    
    public int getId()
    {
        return id;
    }
    
    public String getTag()
    {
        return tag;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
