package com.springapp.mvc;

import freemarker.template.SimpleSequence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.SQLException;


@Controller
@RequestMapping("/")
public class HelloController {

    @Resource(name="RecordService")
    private RecordService recordService;

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public ModelAndView listRecords(ModelMap model) throws SQLException {
        model.addAttribute("names", new SimpleSequence(recordService.getRecords()));
        return new ModelAndView("list", model);
    }
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public ModelAndView addRecord(ModelMap model) throws SQLException {
        return new ModelAndView("add", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "new")
    public ModelAndView addRecord(ModelMap model, @RequestParam(value = "name") String name
            , @RequestParam(value = "age") int age) throws SQLException {
        Record record = new Record();
        record.setName(name);
        record.setAge(age);
        recordService.addRecord(record);
        return new ModelAndView("add", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "shutdown")
    public ModelAndView shutdown(ModelMap model) throws SQLException {
        recordService.shutdown();
        return new ModelAndView("add", model);
    }
}