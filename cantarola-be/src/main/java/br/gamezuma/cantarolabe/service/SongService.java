package br.gamezuma.cantarolabe.service;

import br.gamezuma.cantarolabe.domain.Sequences;
import br.gamezuma.cantarolabe.domain.SequencesRepository;
import br.gamezuma.cantarolabe.domain.Song;
import br.gamezuma.cantarolabe.domain.SongRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lucas.nascimento on 18/08/17.
 */
@Service
public class SongService {

    @Value("${lotterySongsAmount:3}")
    Integer lotterySongsAmount;

    @Autowired
    SongRepository songRepository;

    @Autowired
    SequencesRepository sequencesRepository;

    public List<Song> lottery() {
        return Stream.generate(this::randomSong).limit(lotterySongsAmount).collect(Collectors.toList());
    }

    private Song randomSong() {
        long lastSequence = sequencesRepository.getNextSequence(Sequences.SequenceNames.SONGS);
        long randomLoterry = RandomUtils.nextLong(0, lastSequence + 1);

        return songRepository.findBySequence(randomLoterry);
    }

}
