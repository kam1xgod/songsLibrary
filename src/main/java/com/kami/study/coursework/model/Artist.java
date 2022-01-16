package com.kami.study.coursework.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "artist_albums",
            joinColumns =
                    {@JoinColumn(name = "artist_id",
                            referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "album_id",
                            referencedColumnName = "id")})
    List<Album> albums;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbum() {
        return albums;
    }

    public void setAlbum(List<Album> albums) {
        this.albums = albums;
    }
}
