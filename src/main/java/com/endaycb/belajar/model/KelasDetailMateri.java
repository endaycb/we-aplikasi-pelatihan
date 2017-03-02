/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author root
 */

@Entity
@Table(name = "kelas_detail_materi")
public class KelasDetailMateri {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "id_kelas", nullable = false)
    private Kelas kelas;
    
    @ManyToOne
    @JoinColumn(name = "id_materi", nullable = false)
    private Materi materi;
    
    @Column(nullable = false)
    private Integer urutan;
}
