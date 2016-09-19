insert into tuser(user_id, pass) values ('hong', '1234');
insert into tuser(user_id, pass) values ('admin', 'admin');
insert into tcomment(comment_no, user_id, content)
values(seq_comment.nextval, 'hong', 'hello');
