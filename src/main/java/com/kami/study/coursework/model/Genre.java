package com.kami.study.coursework.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genres")
public class Genre implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "genre")
    String genre;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "song_genre_id")
//    List<Song> song;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

//    public List<Song> getSong() {
//        return song;
//    }
//
//    public void setSong(List<Song> song) {
//        this.song = song;
//    }
}
