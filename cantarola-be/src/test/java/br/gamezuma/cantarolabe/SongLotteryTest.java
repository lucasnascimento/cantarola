package br.gamezuma.cantarolabe;

import br.gamezuma.cantarolabe.domain.SongRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongLotteryTest {

	@Autowired
	SongRepository songRepository;

	SongsFactory songsFactory;

	@Test
	public void lotteryTest() {
		createSongs();
	}

	private void createSongs() {
	}

}
