INSERT INTO kelas (id, kode, nama, tanggal_mulai, tanggal_selesai) VALUES ('abc', 'JWB-001', 'Java Web Basic', '2016-01-01', '2016-01-05');

INSERT INTO kelas_detail_materi (id, id_kelas, id_materi, urutan) VALUES ('x001', 'abc', 'jfu-001', 1);
INSERT INTO kelas_detail_materi (id, id_kelas, id_materi, urutan) VALUES ('x002', 'abc', 'jfu-002', 2);
INSERT INTO kelas_detail_materi (id, id_kelas, id_materi, urutan) VALUES ('x003', 'abc', 'jsi-001', 3);

INSERT INTO kelas_detail_peserta (id_kelas, id_peserta) VALUES ('abc', 'PST-001');
INSERT INTO kelas_detail_peserta (id_kelas, id_peserta) VALUES ('abc', 'PST-003');
INSERT INTO kelas_detail_peserta (id_kelas, id_peserta) VALUES ('abc', 'PST-004');