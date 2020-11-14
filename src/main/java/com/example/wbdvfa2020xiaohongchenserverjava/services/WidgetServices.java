package com.example.wbdvfa2020xiaohongchenserverjava.services;

import com.example.wbdvfa2020xiaohongchenserverjava.models.Widget;
import com.example.wbdvfa2020xiaohongchenserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.*;

@Service
public class WidgetServices {

    @Autowired
    WidgetRepository widgetRepository;

    /**
     * Creates a new Widget instance and saves it to a
     * widgets table for a topic whose ID is tid. Returns
     * new widget inserted in the database
     *
     * @param tid    topic id
     * @param widget widget
     * @return new widget
     */
    public Widget createWidget(String tid, Widget widget) {
        widget.setTopicId(tid);
        return widgetRepository.save(widget);
    }

    /**
     * Returns collection of all widgets for a topic whose ID is tid
     *
     * @param tId
     * @return
     */
    public List<Widget> findWidgetsForTopic(String tId) {
        return widgetRepository.findWidgetsForTopic(tId);
    }

    /**
     * Updates widget whose id is wid encoded as JSON in
     * HTTP body. Returns 1 if successful, 0 otherwise
     *
     * @param wid
     * @param newWidget
     * @return 1 if successful, 0 otherwise
     */
    public Widget updateWidget(Integer wid, Widget newWidget) {
        Optional optional = widgetRepository.findById(wid);
        if (optional.isPresent()) {
            newWidget.setId(wid);
            return widgetRepository.save(newWidget);
        } else {
            return null;
        }

    }

    /**
     * Removes widget whose id is wid.
     * Returns 1 if successful, 0 otherwise
     *
     * @param wid
     * @return 1 if successful, 0 otherwise
     */
    public void deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
    }

    /**
     * Returns collection of all widgets (optional)
     *
     * @return
     */
    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }

    /**
     * Returns a single widget instance whose id is equal to wid (optional)
     *
     * @param widgetId
     * @return
     */
    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).get();
    }


}
