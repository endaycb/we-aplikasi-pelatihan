/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author root
 */

@Entity 
@Table(name = "kelas")
public class Kelas {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid", 
            strategy = "uuid2"
    )
    private String id;
    
    @Column(
            nullable = false,
            unique = true
    )
    private String kode;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(
            name = "tanggal_mulai", 
            nullable = false
    )
    @Temporal(TemporalType.DATE)
    private Date tanggalMulai;
    
    @Column(
            name = "tanggal_selesai", 
            nullable = false
    )
    @Temporal(TemporalType.DATE)
    private Date tanggalSelesai;
    
    @OneToMany(
            mappedBy = "materi", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true
    )
    private List<KelasDetailMateri> daftarMateri = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
            name = "kelas_detail_peserta",
            joinColumns =  @JoinColumn(name = "id_kelas"),
            inverseJoinColumns = @JoinColumn(name = "id_peserta")
    )
    private List<Peserta> daftarPeserta = new ArrayList<>();
}
