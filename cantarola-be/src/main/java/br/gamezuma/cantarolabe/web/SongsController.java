package br.gamezuma.cantarolabe.web;

import br.gamezuma.cantarolabe.domain.Song;
import br.gamezuma.cantarolabe.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lucas.nascimento on 18/08/17.
 */
@RestController("/songs")
public class SongsController {

    @Autowired
    SongService songService;

    @GetMapping("/lottery")
    public List<Song> lottery(){
        return songService.lottery();
    }

}
