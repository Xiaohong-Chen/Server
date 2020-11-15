package com.example.wbdvfa2020xiaohongchenserverjava.models;

import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Unique identifier for this widget
    // Topic this lesson belongs to
    private String topicId;
    // Optional name of the widget
    private String name;
    // Type of the widget, e.g., Heading, List, Paragraph, Image, YouTube, HTML, Link
    private String type;
    // Order with respect to widgets in the same list
    private Integer widgetOrder;
    // Plain text useful for heading text, paragraph text, link text, etc
    private String text;
    // Absolute or relative URL referring to online resource
    private String src;
    // Useful to represent size of widget, e.g., heading size
    private Integer size;
    // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
    private Integer width, height;
    // CSS class implementing some CSS rule and transformations configured in some CSS rule
    private String cssClass;
    // CSS transformations applied to the widget
    private String style;
    // Some arbitrary initial value interpreted by the widget
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public int compareTo(Object o) {
        Widget w = (Widget) o;
        return this.widgetOrder - w.getWidgetOrder();
    }
}
