package com.kami.study.coursework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "songs")
public class Song implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "title")
    String title;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "song_genre_id")
    Genre genre;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "song_album_id")
    Album album;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "artist_songs",
            joinColumns =
                    {@JoinColumn(name = "song_id",
                            referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "artist_id",
                            referencedColumnName = "id")})
    Artist artist;
    @Column(name = "release_date")
    Date releaseDate;
    @Column(name = "longevity")
    Time longevity;

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

//    public int getSongGenreId() {
//        return songGenreId;
//    }
//
//    public void setSongGenreId(int songGenreId) {
//        this.songGenreId = songGenreId;
//    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    //    public int getSongArtistId() {
//        return songArtistId;
//    }
//
//    public void setSongArtistId(int songArtistId) {
//        this.songArtistId = songArtistId;
//    }

    public Date getReleaseDate() {
        return releaseDate;

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        if (releaseDate == null) {
//            return sdf.format(java.time.LocalDate.now());
//        }
//        return sdf.format(releaseDate);
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Time getLongevity() {
        return longevity;

    }

    public void setLongevity(Time longevity) {
        this.longevity = longevity;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
