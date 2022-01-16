package com.kami.study.coursework.controller;

import com.kami.study.coursework.model.Album;
import com.kami.study.coursework.model.Artist;
import com.kami.study.coursework.model.Genre;
import com.kami.study.coursework.model.Song;
import com.kami.study.coursework.service.AlbumService;
import com.kami.study.coursework.service.ArtistService;
import com.kami.study.coursework.service.GenreService;
import com.kami.study.coursework.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    private final SongService songService;
    private final GenreService genreService;
    private final ArtistService artistService;
    private final AlbumService albumService;
    private int page;

    @Autowired
    public MainController(SongService songService, GenreService genreService, ArtistService artistService, AlbumService albumService) {
        this.songService = songService;
        this.genreService = genreService;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping(value = "/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(value = "/allSongs")
    public ModelAndView allSongs(@RequestParam(defaultValue = "1") int page) {
        this.page = page;
        List<Song> songs = songService.allSongs(page);
        int songsCount = songService.songsCount();
        int pagesCount = (songsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allSongs");
        modelAndView.addObject("songsList", songs);
        modelAndView.addObject("page", page);
        modelAndView.addObject("songsCount", songsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @GetMapping(value = "/allSongs/{id}")
    public ModelAndView songInfo(@RequestParam(defaultValue = "1") int page, @PathVariable("id") int id) {
        this.page = page;
        List<Song> songs = songService.allSongs(page);
        Song activeSong = songService.getById(id);
        int songsCount = songService.songsCount();
        int pagesCount = (songsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allSongs");
        modelAndView.addObject("songsList", songs);
        modelAndView.addObject("activeSong", activeSong);
        modelAndView.addObject("page", page);
        modelAndView.addObject("songsCount", songsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @GetMapping(value = "/allGenres")
    public ModelAndView allGenres(@RequestParam(defaultValue = "1") int page) {
        this.page = page;
        List<Genre> genres = genreService.allGenres(page);
        int genresCount = genreService.genresCount();
        int pagesCount = (genresCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allGenres");
        modelAndView.addObject("genresList", genres);
        modelAndView.addObject("page", page);
        modelAndView.addObject("genresCount", genresCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @GetMapping(value = "/allGenres/{id}")
    public ModelAndView genreInfo(@RequestParam(defaultValue = "1") int page, @PathVariable("id") int id) {
        this.page = page;
        List<Genre> genres = genreService.allGenres(page);
        Genre activeGenre = genreService.getById(id);
        List<Song> songsWithGenre = songService.getByGenre(activeGenre.getId(), page);
        int genresCount = genreService.genresCount();
        int pagesCount = (genresCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allGenres");
        modelAndView.addObject("genresList", genres);
        modelAndView.addObject("activeGenre", activeGenre);
        modelAndView.addObject("songsWithGenre", songsWithGenre);
        modelAndView.addObject("page", page);
        modelAndView.addObject("genresCount", genresCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @GetMapping(value = "/allArtists")
    public ModelAndView allArtists(@RequestParam(defaultValue = "1") int page) {
        this.page = page;
        List<Artist> artists = artistService.allArtists(page);
        int artistsCount = artistService.artistsCount();
        int pagesCount = (artistsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allArtists");
        modelAndView.addObject("artistsList", artists);
        modelAndView.addObject("page", page);
        modelAndView.addObject("artistsCount", artistsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @GetMapping(value = "/allArtists/{id}")
    public ModelAndView artistInfo(@RequestParam(defaultValue = "1") int page, @PathVariable("id") int id) {
        this.page = page;
        List<Artist> artists = artistService.allArtists(page);
        Artist activeArtist = artistService.getById(id);
        int artistsCount = artistService.artistsCount();
        int pagesCount = (artistsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allArtists");
        modelAndView.addObject("artistsList", artists);
        modelAndView.addObject("activeArtist", activeArtist);
        modelAndView.addObject("page", page);
        modelAndView.addObject("artistsCount", artistsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @GetMapping(value = "/album/{id}")
    public ModelAndView albumInfo(@PathVariable int id) {
        Album album = albumService.getById(id);
        List<Song> songsInAlbum = songService.getByAlbum(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("album");
        modelAndView.addObject("album", album);
        modelAndView.addObject("songsInAlbum", songsInAlbum);
        return modelAndView;
    }

    @GetMapping(value = "/editSong/{id}")
    public ModelAndView editSong(@PathVariable int id) {
        Song song = songService.getById(id);
        List<Genre> genres = genreService.allGenres();
        List<Album> albums = albumService.allAlbums();
        List<Artist> artists = artistService.allArtists();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editSong");
        modelAndView.addObject("song", song);
        modelAndView.addObject("genreList", genres);
        modelAndView.addObject("albumsList", albums);
        modelAndView.addObject("artistList", artists);
        return modelAndView;
    }

    @PostMapping(value = "/editSong/{id}")
    public ModelAndView editSong(@ModelAttribute("song") Song song, @RequestParam(defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allSongs/?page=" + page);
        songService.edit(song);
        return modelAndView;
    }

    @GetMapping(value = "/editArtist/{id}")
    public ModelAndView editArtist(@PathVariable int id) {
        Artist artist = artistService.getById(id);
        List<Genre> genres = genreService.allGenres();
        List<Album> albums = albumService.allAlbums();
        List<Song> songs = songService.allSongs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editArtist");
        modelAndView.addObject("artist", artist);
        modelAndView.addObject("albumsList", albums);
        modelAndView.addObject("genreList", genres);
        modelAndView.addObject("songList", songs);
        return modelAndView;
    }

    @PostMapping(value = "/editArtist/{id}")
    public ModelAndView editArtist(@ModelAttribute("artist") Artist artist, @RequestParam(defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allArtists/?page=" + page);
        artistService.edit(artist);
        return modelAndView;
    }

    @GetMapping(value = "/editGenre/{id}")
    public ModelAndView editGenre(@PathVariable int id) {
        Genre genre = genreService.getById(id);
        List<Song> songs = songService.allSongs();
        List<Album> albums = albumService.allAlbums();
        List<Artist> artists = artistService.allArtists();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editGenre");
        modelAndView.addObject("genre", genre);
        modelAndView.addObject("albumsList", albums);
        modelAndView.addObject("songList", songs);
        modelAndView.addObject("artistList", artists);
        return modelAndView;
    }

    @PostMapping(value = "/editGenre/{id}")
    public ModelAndView editGenre(@ModelAttribute("genre") Genre genre, @RequestParam(defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allGenres/?page=" + page);
        genreService.edit(genre);
        return modelAndView;
    }

    @GetMapping(value = "/editAlbum/{id}")
    public ModelAndView editAlbum(@PathVariable int id) {
        Album album = albumService.getById(id);
        List<Genre> genres = genreService.allGenres();
        List<Artist> artists = artistService.allArtists();
        List<Song> songs = songService.allSongs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAlbum");
        modelAndView.addObject("album", album);
        modelAndView.addObject("artistList", artists);
        modelAndView.addObject("genreList", genres);
        modelAndView.addObject("songList", songs);
        return modelAndView;
    }

    @PostMapping(value = "/editAlbum/{id}")
    public ModelAndView editAlbum(@ModelAttribute("album") Album album) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/album/{id}");
        albumService.edit(album);
        return modelAndView;
    }

    @GetMapping(value = "/addSong")
    public ModelAndView addSong(@ModelAttribute("song") Song song) {
        ModelAndView modelAndView = new ModelAndView();
        List<Genre> genres = genreService.allGenres();
        List<Album> albums = albumService.allAlbums();
        List<Artist> artists = artistService.allArtists();
        modelAndView.setViewName("addSong");
        modelAndView.addObject("albumsList", albums);
        modelAndView.addObject("genreList", genres);
        modelAndView.addObject("artistList", artists);
        modelAndView.addObject("song", song);
        return modelAndView;
    }

    @PostMapping(value = "/addSong")
    public ModelAndView addSong(@ModelAttribute("song") Song song, BindingResult bindingResult, @RequestParam(defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allSongs/?page=" + page);
        songService.add(song);
        return modelAndView;
    }

    @GetMapping(value = "/addArtist")
    public ModelAndView addArtist(@ModelAttribute("artist") Artist artist) {
        ModelAndView modelAndView = new ModelAndView();
        List<Genre> genres = genreService.allGenres();
        List<Album> albums = albumService.allAlbums();
        List<Song> songs = songService.allSongs();
        modelAndView.setViewName("addArtist");
        modelAndView.addObject("artist", artist);
        modelAndView.addObject("albumsList", albums);
        modelAndView.addObject("genreList", genres);
        modelAndView.addObject("songList", songs);
        return modelAndView;
    }

    @PostMapping(value = "/addArtist")
    public ModelAndView addSArtist(@ModelAttribute("song") Artist artist, BindingResult bindingResult, @RequestParam(defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allArtists/?page=" + page);
        artistService.add(artist);
        return modelAndView;
    }

    @GetMapping(value = "/addGenre")
    public ModelAndView addGenre(@ModelAttribute("genre") Genre genre) {
        ModelAndView modelAndView = new ModelAndView();
        List<Song> songs = songService.allSongs();
        List<Album> albums = albumService.allAlbums();
        List<Artist> artists = artistService.allArtists();
        modelAndView.setViewName("addGenre");
        modelAndView.addObject("genre", genre);
        modelAndView.addObject("albumsList", albums);
        modelAndView.addObject("songList", songs);
        modelAndView.addObject("artistList", artists);
        return modelAndView;
    }

    @PostMapping(value = "/addGenre")
    public ModelAndView addGenre(@ModelAttribute("genre") Genre genre, BindingResult bindingResult, @RequestParam(defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allGenres/?page=" + page);
        genreService.add(genre);
        return modelAndView;
    }

    @GetMapping(value = "/addAlbum")
    public ModelAndView addAlbum(@ModelAttribute("album") Album album) {
        ModelAndView modelAndView = new ModelAndView();
        List<Genre> genres = genreService.allGenres();
        List<Artist> artists = artistService.allArtists();
        List<Song> songs = songService.allSongs();
        modelAndView.setViewName("addAlbum");
        modelAndView.addObject("album", album);
        modelAndView.addObject("artistList", artists);
        modelAndView.addObject("genreList", genres);
        modelAndView.addObject("songList", songs);
        return modelAndView;
    }

    @PostMapping(value = "/addAlbum")
    public ModelAndView addAlbum(@ModelAttribute("album") Album album, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        albumService.add(album);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteSong(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Song song = songService.getById(id);
        songService.delete(song);
        return modelAndView;
    }
}