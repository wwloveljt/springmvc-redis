import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.redis.model.User;
import com.redis.service.imp.UserServiceImpl;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-config.xml")
@Log4j
public class TestRedis {

    @Autowired
    UserServiceImpl UserService;
	
	@Test
	public void testQuery() {
		User user =   UserService.selectUserById(1);
		log.info(user.toString());
	}
}
