package br.gamezuma.cantarolabe.domain;

/**
 * Created by lucas.nascimento on 17/08/17.
 */
public interface SequencesRepositoryCustom {

    long getNextSequence(Sequences.SequenceNames sequenceName);

}
