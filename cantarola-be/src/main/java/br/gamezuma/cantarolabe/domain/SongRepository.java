package br.gamezuma.cantarolabe.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lucas.nascimento on 17/08/17.
 */
public interface SongRepository extends MongoRepository<Song,String> {

    Song findBySequence(Long sequence);

}
