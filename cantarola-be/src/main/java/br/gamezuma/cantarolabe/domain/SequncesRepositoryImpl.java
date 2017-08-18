package br.gamezuma.cantarolabe.domain;

import br.gamezuma.cantarolabe.exception.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by lucas.nascimento on 17/08/17.
 */
@Component
public class SequncesRepositoryImpl implements SequencesRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long getNextSequence(Sequences.SequenceNames sequenceName) {
        //get sequence id
        Query query = new Query(where("_id").is(sequenceName));

        //increase sequence id by 1
        Update update = new Update();
        update.inc("seq", 1);

        //return new increased id
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        Sequences sequence = mongoTemplate.findAndModify(query,update,options,Sequences.class);

        //if no id, throws SequenceException
        //optional, just a way to tell user when the sequence id is failed to generate.
        if (sequence == null) {
            throw new SequenceException("Unable to get sequence id for sequenceName: " + sequenceName);
        }

        return sequence.getSequence();
    }
}
