package com.kami.study.coursework.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "title")
    String title;
    @Column(name = "release_date")
    Date releaseDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "artist_albums",
            joinColumns =
                    {@JoinColumn(name = "album_id",
                            referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "artist_id",
                            referencedColumnName = "id")})
    Artist artist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}