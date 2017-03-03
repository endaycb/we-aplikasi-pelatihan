/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.model.Peserta;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author MASHIRO
 */


public interface PesertaDao extends PagingAndSortingRepository<Peserta, String>{
    
    //JPQL query
    @Query("select p from Peserta p where p.institusi.nama like :nama") //like 
    public List<Peserta> cariPesertaByNamaInstitusi(@Param("nama") String nama);

}
