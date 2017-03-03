/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.model.Kelas;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author MASHIRO
 */
public interface KelasDao extends PagingAndSortingRepository<Kelas, String>{
    public List<Kelas> findById(String id);
    public List<Kelas> findByNamaContainingIgnoreCase(String nama);
    public List<Kelas> findByTanggalMulaiBetween(Date tanggalAwal, Date tanggalAkhir);
    public List<Kelas> findByTanggalMulaiGreaterThanEqualAndTanggalSelesaiLessThanEqual(Date tanggalMulai, Date tanggalSelesai);
  
    
    //native query
    @Query(value = "SELECT * "
            + "FROM kelas "
            + "INNER JOIN kelas_detail_peserta ON kelas.id = kelas_detail_peserta.id_kelas "
            + "INNER JOIN peserta ON kelas_detail_peserta.id_peserta = peserta.id "
            + "WHERE peserta.nama LIKE :nama",
            nativeQuery = true)
    public List<Kelas> cariKelasYangDihadiriPesertaBernama(@Param("nama") String nama);
}
