package br.gamezuma.cantarolabe.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by lucas.nascimento on 17/08/17.
 */
@Data
@Builder
public class Song {
    @Id
    private String id;
    private Long sequence;
    private String title;
    private String artist;
    private String genre;
    private Integer trackNumber;
    private Integer releaseYear;
    private String url;
}
