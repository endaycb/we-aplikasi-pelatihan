/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  root
 * Created: Mar 1, 2017
 */

CREATE TABLE `institusi` (
  `id` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `kode` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `npwp` varchar(255) NOT NULL,
  `telepon` varchar(255) NOT NULL,
  `website` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mysvqkt3vjkgtmhbiu0grxdsq` (`kode`),
  UNIQUE KEY `UK_7gy0kknv1ask47ey22f4igip6` (`website`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 CREATE TABLE `materi` (
  `id` varchar(255) NOT NULL,
  `kode` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_61lgf31ivihw8ysmi0br0hmge` (`kode`),
  UNIQUE KEY `UK_dfxqy8yuvsa5d4fplj97raoly` (`nama`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `peserta` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `kode` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `id_institusi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4pf6h2ver6d4igrrq6vvo4dbv` (`email`),
  UNIQUE KEY `UK_mfmn2awj91w6bwey0mi82q4ja` (`kode`),
  KEY `FKkg5kh804wy3ap1krnw35k2soi` (`id_institusi`),
  CONSTRAINT `FKkg5kh804wy3ap1krnw35k2soi` FOREIGN KEY (`id_institusi`) REFERENCES `institusi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `kelas` (
  `id` varchar(255) NOT NULL,
  `kode` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_f0eqws1p6pc8wgh1jcf2ki99t` (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 CREATE TABLE `kelas_detail_materi` (
  `id` varchar(255) NOT NULL,
  `urutan` int(11) NOT NULL,
  `id_kelas` varchar(255) NOT NULL,
  `id_materi` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKilo6xn8p362598523ixcsxc9s` (`id_kelas`),
  KEY `FK9go7y9if9q9rldqj7ps0wh69g` (`id_materi`),
  CONSTRAINT `FK9go7y9if9q9rldqj7ps0wh69g` FOREIGN KEY (`id_materi`) REFERENCES `materi` (`id`),
  CONSTRAINT `FKilo6xn8p362598523ixcsxc9s` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `kelas_detail_peserta` (
  `id_kelas` varchar(255) NOT NULL,
  `id_peserta` varchar(255) NOT NULL,
  KEY `FKfku97pjgjmt34xean99cclqd5` (`id_peserta`),
  KEY `FK1ifr01tf5cgmwrt41qrogsqt7` (`id_kelas`),
  CONSTRAINT `FK1ifr01tf5cgmwrt41qrogsqt7` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id`),
  CONSTRAINT `FKfku97pjgjmt34xean99cclqd5` FOREIGN KEY (`id_peserta`) REFERENCES `peserta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;