package com.sourcey.check_in.model;

public class Kamar {
    private String id_kamar;
    private String id_hotel;
    private String nama_hotel;
    private String nama_ruangan;
    private String max_orang;
    private int stok_ruangan;
    private String ukuran_ruangan;
    private String kelengkapan;
    private String wifi;
    private String tipe_ruangan;
    private String deskripsi_ruangan;
    private String foto1;
    private String foto2;

    public Kamar(String id_kamar, String id_hotel, String nama_hotel, String nama_ruangan, String max_orang, int stok_ruangan, String ukuran_ruangan, String kelengkapan, String wifi, String tipe_ruangan, String deskripsi_ruangan, String foto1, String foto2) {
        this.id_kamar = id_kamar;
        this.id_hotel = id_hotel;
        this.nama_hotel = nama_hotel;
        this.nama_ruangan = nama_ruangan;
        this.max_orang = max_orang;
        this.stok_ruangan=stok_ruangan;
        this.ukuran_ruangan = ukuran_ruangan;
        this.kelengkapan = kelengkapan;
        this.wifi = wifi;
        this.tipe_ruangan = tipe_ruangan;
        this.deskripsi_ruangan = deskripsi_ruangan;
        this.foto1 = foto1;
        this.foto2 = foto2;

    }

    public Kamar() {

    }

    public String getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(String id_kamar) {
        this.id_kamar = id_kamar;
    }

    public String getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(String id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNama_hotel() {
        return nama_hotel;
    }

    public void setNama_hotel(String nama_hotel) {
        this.nama_hotel = nama_hotel;
    }

    public String getNama_ruangan() {
        return nama_ruangan;
    }

    public void setNama_ruangan(String nama_ruangan) {
        this.nama_ruangan = nama_ruangan;
    }

    public String getMax_orang() {
        return max_orang;
    }

    public void setMax_orang(String max_orang) {
        this.max_orang = max_orang;
    }

    public int getStok_ruangan() {
        return stok_ruangan;
    }

    public void setStok_ruangan(int stok_ruangan) {
        this.stok_ruangan = stok_ruangan;
    }


    public String getUkuran_ruangan() {
        return ukuran_ruangan;
    }

    public void setUkuran_ruangan(String ukuran_ruangan) {
        this.ukuran_ruangan = ukuran_ruangan;
    }

    public String getKelengkapan() {
        return kelengkapan;
    }

    public void setKelengkapan(String kelengkapan) {
        this.kelengkapan = kelengkapan;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getTipe_ruangan() {
        return tipe_ruangan;
    }

    public void setTipe_ruangan(String tipe_ruangan) {
        this.tipe_ruangan = tipe_ruangan;
    }



    public String getDeskripsi_ruangan() {
        return deskripsi_ruangan;
    }

    public void setDeskripsi_ruangan(String deskripsi_ruangan) {
        this.deskripsi_ruangan = deskripsi_ruangan;
    }


    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }
}
