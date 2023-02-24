package com.mafr.redisbook.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Book")
@Data
public class Book {
    private String id;
    private String isbn;
    private String judul;
    private String penulis;
    private String deskripsi;
    private String kategori;

    public Book(String id, String judul, String isbn, String penulis, String deskripsi, String kategori) {
        this.id = id;
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
    }

}
