package test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.comment.config.CommentConfig;
import com.example.comment.dto.Comment;
import com.example.comment.dto.User;
import com.example.comment.repo.CommentRepo;
import com.example.comment.repo.UserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommentConfig.class})
public class StartTest {
	static Logger logger = LoggerFactory.getLogger(StartTest.class);
	@Autowired
	CommentRepo cmtRepo;
	UserRepo userRepo;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionTemplate template;
	
		
	
	@Test
	public void testRepo() {
		assertThat(cmtRepo, is(notNullValue()));
	}
	
	@Test
	public void testDs() throws SQLException{
		assertThat(ds, is(notNullValue()));
		Connection con = ds.getConnection();
		assertThat(con, is(notNullValue()));
	}
	
	@Test
	public void testTemplate(){
		assertThat(template, is(notNullValue()));
	}

	@Test
	public void testInsert(){
		Comment comment = new Comment(0,"hong","what?");
		int result = cmtRepo.insert(comment);
		logger.trace("comment no:{}", comment.getCommentNo());
		assertThat(result, is(notNullValue()));
	}
	
	@Test
	public void testAddUser(){
		User user = new User("junsuk","1234");
		int result = userRepo.addUser(user);
		assertThat(result, is(notNullValue()));
	}
}
