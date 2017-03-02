/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.model.Institusi;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author MASHIRO
 */
public interface InstitusiDao extends PagingAndSortingRepository<Institusi, String>{
    
}
