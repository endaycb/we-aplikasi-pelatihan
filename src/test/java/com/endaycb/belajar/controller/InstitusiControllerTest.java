/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.controller;

import com.endaycb.belajar.dao.InstitusiDao;
import com.endaycb.belajar.model.Institusi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author mashiro
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "../dao/insert-sample-institusi.sql")
@WebAppConfiguration
public class InstitusiControllerTest {
    
    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final String url = "http://localhost:9090/institusi";
    
    @Autowired
    private InstitusiDao institusiDao;
    
    @After
    public void afterTest(){
        institusiDao.delete("ITS-001");
        institusiDao.delete("ITS-002"); 
    }
    
    @Test
    public void testGetAll(){
        Map<String, Object> daftarInstitusi = restTemplate.getForObject(url, Map.class);
        
        Assert.assertNotNull(daftarInstitusi);
        Assert.assertTrue(daftarInstitusi.get("totalElements").equals(2));
        System.out.println(daftarInstitusi.get("2"));
    }
    
}
