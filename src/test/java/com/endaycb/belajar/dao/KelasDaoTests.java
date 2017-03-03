/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.model.Kelas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author MASHIRO
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@SqlGroup({
    @Sql("insert-sample-institusi.sql"),
    @Sql("insert-sample-materi.sql"),
    @Sql("insert-sample-peserta.sql"),
    @Sql("insert-sample-kelas.sql")
})
public class KelasDaoTests {
    
    @Autowired
    KelasDao kelasDao;
    
    @Test
    public void testCariKelasBerdasarkanId(){
        String id = "abc";
        List<Kelas> kelas = kelasDao.findById(id);
        
        Assert.assertNotNull(kelas);
        Assert.assertEquals(1, kelas.size());
    }
    
    @Test
    public void testCariKelasBerdasarkanNama(){
        String nama = "java web";
        List<Kelas> daftarKelas = kelasDao.findByNamaContainingIgnoreCase(nama);
        Assert.assertNotNull(daftarKelas);
        Assert.assertEquals(1, daftarKelas.size());
    }
    
    @Test
    public void testCariKelasBerdasarkanTanggal() throws ParseException{
        SimpleDateFormat formatterTanggal = new SimpleDateFormat("yyyy-MM-dd");
//        String tanggalMulai = "2016-01-01";
//        String tanggalSelesai = "2016-01-10";
//        
//        List<Kelas> daftarKelas = kelasDao.findByTanggalMulaiGreaterThanEqualAndTanggalSelesaiLessThanEqual(
//                                            formatterTanggal.parse(tanggalMulai), 
//                                            formatterTanggal.parse(tanggalSelesai)
//                                           );
        
//        Date tanggalAwal = formatterTanggal.parse("2016-01-01");
//        Date tanggalAkhir = formatterTanggal.parse("2016-01-03");

        Date tanggalAwal = Date.from(
                        LocalDate.parse("2016-01-01")
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
                        );
        
        Date tanggalAkhir = Date.from(
                        LocalDate.parse("2016-01-03")
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
                        );
        
        List<Kelas> daftarKelas = kelasDao.findByTanggalMulaiBetween(tanggalAwal, tanggalAkhir);
        
        Assert.assertNotNull(daftarKelas);
        Assert.assertEquals(1, daftarKelas.size());
       
//        Date tanggalAkhir2 = Date.from(
//                        LocalDate.parse("2016-01-03")
//                        .plusMonths(4L)
//                        .atStartOfDay()
//                        .atZone(ZoneId.systemDefault())
//                        .toInstant()
//                        );
//        
//        System.out.println(tanggalAkhir2);
    }
    
}
