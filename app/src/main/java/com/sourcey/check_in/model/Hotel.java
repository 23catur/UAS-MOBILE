package com.sourcey.check_in.model;

public class Hotel {
    private String id_hotel;
    private String nama_hotel;
    private String alamat;
    private int rating;
    private String detail_informasi;
    private String kelengkapan;
    private String ukuran_ruangan;
    private String wifi;
    private  String foto;
    private int stok_ruangan;
    private String max_orang;

    public Hotel(String id_hotel, String nama_hotel, String alamat, int rating, String detail_informasi,  String kelengkapan, String ukuran_ruangan, String wifi, String foto, int stok_ruangan, String max_orang) {
        this.id_hotel = id_hotel;
        this.nama_hotel = nama_hotel;
        this.alamat = alamat;
        this.rating = rating;
        this.detail_informasi = detail_informasi;
        this.kelengkapan = kelengkapan;
        this.ukuran_ruangan = ukuran_ruangan;
        this.wifi = wifi;
        this.foto = foto;
        this.stok_ruangan = stok_ruangan;
        this.max_orang = max_orang;
    }

    public Hotel() {

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getStok_ruangan() {
        return stok_ruangan;
    }

    public void setStok_ruangan(int stok_ruangan) {
        this.stok_ruangan = stok_ruangan;
    }

    public String getDetail_informasi() {
        return detail_informasi;
    }

    public void setDetail_informasi(String detail_informasi) {
        this.detail_informasi = detail_informasi;
    }

    public String getMax_orang() {
        return max_orang;
    }

    public void setMax_orang(String max_orang) {
        this.max_orang = max_orang;
    }

    public String getKelengkapan() {
        return kelengkapan;
    }

    public void setKelengkapan(String kelengkapan) {
        this.kelengkapan = kelengkapan;
    }

    public String getUkuran_ruangan() {
        return ukuran_ruangan;
    }

    public void setUkuran_ruangan(String ukuran_ruangan) {
        this.ukuran_ruangan = ukuran_ruangan;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
