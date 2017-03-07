/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.controller;

import com.endaycb.belajar.dao.InstitusiDao;
import com.endaycb.belajar.model.Institusi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mashiro
 */

@RestController
@RequestMapping("/institusi")
public class InstitusiController {
    
    @Autowired
    private InstitusiDao institusiDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public Page<Institusi> getAll(Pageable pageable){
        return institusiDao.findAll(pageable);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Institusi getById(@PathVariable("id") String id){
        return institusiDao.findOne(id);
    }
}