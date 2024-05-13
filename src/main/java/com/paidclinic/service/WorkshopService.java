package com.paidclinic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paidclinic.entity.CartItem;
import com.paidclinic.entity.Workshop;
import com.paidclinic.repository.ProductRepository;
import com.paidclinic.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkshopService
{
    @Autowired
    private WorkshopRepository workshopRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Workshop> getWorkshops()
    {
        return workshopRepository.findAll();
    }

    public boolean convertCookies(String param, RedirectAttributes redirectAttributes)
    {
        try
        {
            var jsonString = param.split("=")[1];
            var objectMapper = new ObjectMapper();
            var items = objectMapper.readValue(jsonString, CartItem[].class);
            redirectAttributes.addFlashAttribute("items", items);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public List<CartItem> convertItemsToProduct(CartItem[] items)
    {
        try
        {
            var products = new ArrayList<CartItem>();
            for (var item : items)
            {
                item.setCost(productRepository.getProductsByTitle(item.getProductName()).getCost());
                products.add(item);
            }

            return products;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public int getSum(List<CartItem> items)
    {
        var sum = 0;
        for (var item : items)
        {
            sum += item.getCost();
        }

        return sum;
    }
}

