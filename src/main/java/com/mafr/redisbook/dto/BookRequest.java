package com.mafr.redisbook.dto;

import lombok.Data;

@Data
public class BookRequest {

    private String isbn;
    private String judul;
    private String penulis;
    private String deskripsi;
    private String kategori;

    public BookRequest(
            String isbn,
        String judul,
        String penulis,
        String deskripsi,
        String kategori
    ) {
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
    }
}
