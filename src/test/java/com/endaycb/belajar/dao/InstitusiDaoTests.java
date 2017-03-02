/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.model.Institusi;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author MASHIRO
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Sql("insert-sample-institusi.sql")
public class InstitusiDaoTests {
    @Autowired
    private InstitusiDao institusiDao;
    
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }
    
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
    
    @Before
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    
    @After
    public void afterMethod(){
        System.out.println("After Method");
    }
    
    @Test
    public void testCariById(){
        
        Institusi institusi = institusiDao.findOne("ITS-001");
        
        //cek institusi dengan id Artivisi <- dari insert-sample-institusi.sql
        Assert.assertNotNull(institusi);
        
        //cek null
        Assert.assertNotNull("xyz");
    }
    
    @Test
    public void testHitungRecord(){
        Assert.assertEquals(2L, institusiDao.count());
    }
    
    @Test
    public void testFindAll(){
        Iterable<Institusi> listInstitusi = institusiDao.findAll();
    }
    
    @Test
    public void testSimpan(){
        List<Institusi> listInstitusi = new ArrayList<>();
        
        Institusi institusi1 = new Institusi();
        institusi1.setNama("Bisnis Solusi Pranata");
        institusi1.setKode("BSP-001");
        institusi1.setAlamat("Kelapa Gading");
        institusi1.setTelepon("0214507673");
        institusi1.setWebsite("http://www.bsp-groups.com");
        institusi1.setNpwp("12345");
        
        listInstitusi.add(institusi1);
        
        Institusi institusi2 = new Institusi();
        institusi2.setNama("Bisnis Solusi Pranata2");
        institusi2.setKode("BSP-0021");
        institusi2.setAlamat("Kelapa Gading2");
        institusi2.setTelepon("02145076732");
        institusi2.setWebsite("http://www.bsp-groups2.com");
        institusi2.setNpwp("123456");
        
        listInstitusi.add(institusi2);
        
        institusiDao.save(listInstitusi);
        
        Assert.assertEquals(4L, institusiDao.count());
        for(Institusi i : institusiDao.findAll()){
            System.out.println(i.getId());
        }
    }
    
    @Test
    public void testPage(){
        
        Page<Institusi> pageInstitusi = institusiDao.findAll(new PageRequest(0,10));
        
        Assert.assertNotNull(pageInstitusi);
        Assert.assertEquals(1, pageInstitusi.getTotalPages());
        Assert.assertEquals(2, pageInstitusi.getTotalElements());
        Assert.assertEquals(2, pageInstitusi.getNumberOfElements());
       
      
    }
}
