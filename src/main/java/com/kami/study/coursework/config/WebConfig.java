package com.kami.study.coursework.config;

import com.kami.study.coursework.service.AlbumService;
import com.kami.study.coursework.service.ArtistService;
import com.kami.study.coursework.service.GenreService;
import com.kami.study.coursework.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kami.study.coursework")
public class WebConfig implements WebMvcConfigurer {
    private final SongService songService;
    private final GenreService genreService;
    private final ArtistService artistService;
    private final AlbumService albumService;

    @Autowired
    public WebConfig(SongService songService, GenreService genreService, ArtistService artistService, AlbumService albumService) {
        this.songService = songService;
        this.genreService = genreService;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new GenreConverter(genreService));
        registry.addConverter(new ArtistConverter(artistService));
        registry.addConverter(new SongConverter(songService));
        registry.addConverter(new AlbumConverter(albumService));
    }

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
