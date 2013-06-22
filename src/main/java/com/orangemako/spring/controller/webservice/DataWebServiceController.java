package com.orangemako.spring.controller.webservice;

import com.orangemako.spring.domain.Item;
import com.orangemako.spring.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Basic Persistence Controller.
 *
 * @author Kevin Leong
 */
@Controller
@RequestMapping("data")
public class DataWebServiceController {
    private static final Logger LOG = LoggerFactory.getLogger(DataWebServiceController.class);

    @Resource
    ItemService itemService;

    @RequestMapping(value = "item/all", method = RequestMethod.GET)
    public @ResponseBody
    List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping(value = "item/id/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Item getItemById(@PathVariable("id") String itemId) {
        return itemService.getById(itemId);
    }

    @RequestMapping(value = "item/insert", method = RequestMethod.POST)
    public @ResponseBody
    int insertItem(@RequestBody Item item) {
        return itemService.insertItem(item);
    }
}
