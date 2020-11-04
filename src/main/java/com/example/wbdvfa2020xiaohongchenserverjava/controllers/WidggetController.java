package com.example.wbdvfa2020xiaohongchenserverjava.controllers;

import com.example.wbdvfa2020xiaohongchenserverjava.models.Widget;
import com.example.wbdvfa2020xiaohongchenserverjava.services.WidgetServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidggetController {

    WidgetServices widgetServices = new WidgetServices();

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable("tid") String tid, @RequestBody Widget widget) {
        return widgetServices.createWidget(tid, widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid) {
        return widgetServices.findWidgetsForTopic(tid);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") String wid, @RequestBody Widget widget) {
        return widgetServices.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") String wid) {
        return widgetServices.deleteWidget(wid);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets(){
        return widgetServices.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") String wid){
        return widgetServices.findWidgetById(wid);
    }

}
