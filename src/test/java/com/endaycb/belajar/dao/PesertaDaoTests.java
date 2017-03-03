/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.model.Kelas;
import com.endaycb.belajar.model.Peserta;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
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
public class PesertaDaoTests {
    
    @Autowired
    PesertaDao pesertaDao;
    
    @Autowired
    KelasDao kelasDao;
    
    @Test
    public void testCariPesertaByNamaInstitusi(){
        String namaInstitusi = "%bisnis%";
        List<Peserta> daftarPeserta = pesertaDao.cariPesertaByNamaInstitusi(namaInstitusi);
        
        Assert.assertNotNull(daftarPeserta);
        Assert.assertEquals(2, daftarPeserta.size());
    }
    
    @Test
    public void testCariKelasYangDiHadiriByNamaPeserta(){
        String nama = "%greenda%";
        List<Kelas> daftarKelas = kelasDao.cariKelasYangDihadiriPesertaBernama(nama);
        
        Assert.assertNotNull(daftarKelas);
        Assert.assertEquals(1, daftarKelas.size());
        
    }
}
