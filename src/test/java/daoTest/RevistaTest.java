package daoTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.LivroDao;
@ContextConfiguration(classes = { DBConfig.class , LivroDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RevistaTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
