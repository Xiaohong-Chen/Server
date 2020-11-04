package com.example.wbdvfa2020xiaohongchenserverjava.services;

import com.example.wbdvfa2020xiaohongchenserverjava.models.Widget;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class WidgetServices {

    List<Widget> widgets = new ArrayList<>();



    /**
     * Creates a new Widget instance and add it to the
     * existing collection of widgets for a topic whose ID is
     * tid. Returns new widget with a unique identifier
     *
     * @param tid topic id
     * @param widget widget
     * @return new widget
     */
    public Widget createWidget(String tid, Widget widget) {
        widget.setId(String.valueOf(new Date().getTime()+1));
        widget.setTid(tid);
        widgets.add(widget);
        return widget;
    }

    /**
     * Returns collection of all widgets for a topic whose ID is tid
     *
     * @param tId
     * @return
     */
    public List<Widget> findWidgetsForTopic(String tId){
        List<Widget> wl = new ArrayList<>();
        for (Widget w : widgets) {
            if (w.getTid().equals(tId)) {
                wl.add(w);
            }
        }
        wl.sort(new Comparator<Widget>() {
            @Override
            public int compare(Widget o1, Widget o2) {
                return o1.getWidgetOrder()-o2.getWidgetOrder();
            }
        });
        return wl;
    }

    /**
     * Updates widget whose id is wid encoded as JSON in
     * HTTP body. Returns 1 if successful, 0 otherwise
     *
     * @param wid
     * @param widget
     * @return 1 if successful, 0 otherwise
     */
    public Integer updateWidget(String wid, Widget widget) {
        Integer temp = null;
        for (Widget w : widgets) {
            if (w.getId().equals(wid)) {
                temp = w.getWidgetOrder();
                System.out.println("pre: "+temp);
                w.setName(widget.getName());
                w.setType(widget.getType());
                w.setWidgetOrder(widget.getWidgetOrder());
                w.setSize(widget.getSize());
                System.out.println("post"+w.getWidgetOrder());
                System.out.println("post temp"+temp);

                System.out.println("-------------------" + w.getId());
                for (Widget w1: widgets){
                    if(!w1.getId().equals(w.getId()) && w1.getWidgetOrder().equals(w.getWidgetOrder())){
                        w1.setWidgetOrder(temp);

                    }

                }
                return 1;
            }
        }

        return 0;
    }

    /**
     * Removes widget whose id is wid.
     * Returns 1 if successful, 0 otherwise
     *
     * @param wid
     * @return 1 if successful, 0 otherwise
     */
    public int deleteWidget(String wid){
        for (Widget w : widgets) {
            if (w.getId().equals(wid)) {
                widgets.remove(w);
                return 1;
            }
        }
        return 0;
    }

    /**
     * Returns collection of all widgets (optional)
     *
     * @return
     */
    public List<Widget> findAllWidgets() {
        return widgets;
    }

    /**
     * Returns a single widget instance whose id is equal to wid (optional)
     *
     * @param widgetId
     * @return
     */
    public Widget findWidgetById(String widgetId) {
        for (Widget w : widgets) {
            if (w.getId().equals(widgetId)) {
                return w;
            }
        }
        return null;
    }





}
