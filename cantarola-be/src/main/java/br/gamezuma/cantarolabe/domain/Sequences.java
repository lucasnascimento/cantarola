package br.gamezuma.cantarolabe.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by lucas.nascimento on 17/08/17.
 */
@Data
public class Sequences {

    public enum SequenceNames{
        SONGS
    }

    @Id
    private SequenceNames id;
    private Long sequence;
}
