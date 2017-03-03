/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.simpletest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author MASHIRO
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {
    
    @Test
    public void printDate() throws ParseException{
        String string = "2010/01/02";
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse(string);
        System.out.println(format.format(date)); // Sat Jan 02 00:00:00 GMT 2010
       

    }
}
