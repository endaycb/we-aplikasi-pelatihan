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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mashiro
 */

@RestController
public class InstitusiController {
    
    @Autowired
    private InstitusiDao institusiDao;
    
    @RequestMapping(value = "/institusi", method = RequestMethod.GET)
    @ResponseBody
    public Page<Institusi> getInstitusi(Pageable pageable){
        return institusiDao.findAll(pageable);
    }
}
