import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.redis.JedisClient;
import com.redis.model.User;
import com.redis.service.UserService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-config.xml")
@Log4j
public class TestRedis {

	@Autowired
	private JedisClient _jedisClient;
	
	@Autowired
    UserService userService;
	
	@Test
	public void test() {
		_jedisClient.set("testKey", "123456");
		System.out.println(_jedisClient.get("testKey"));
		
		_jedisClient.del("testKey");
		System.out.println("删除key后再取值：" + _jedisClient.get("testKey"));
	}
	
	@Test
	public void testuser() {
		User user= userService.selectUserById(1);
		log.info("用户：" + user);
		
	}
}
