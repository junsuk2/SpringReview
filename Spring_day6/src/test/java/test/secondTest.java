package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.comment.config.CommentConfig;
import com.example.comment.dto.User;
import com.example.comment.repo.UserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommentConfig.class})
@Sql({"/dbschema/comment_schema.sql","/dbschema/comment_data.sql"})
public class secondTest {

	@Autowired
	UserRepo userRepo;
	
	@Test
	public void testAddUser(){
		User user = new User("young","3456");
		int result = userRepo.addUser(user);
		assertThat(result, is(1));
	}

}
