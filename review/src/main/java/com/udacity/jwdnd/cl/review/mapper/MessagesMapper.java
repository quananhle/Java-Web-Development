package com.udacity.jwdnd.cl.review.mapper;

import com.udacity.jwdnd.cl.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessagesMapper {
    /**
    CREATE TABLE IF NOT EXISTS MESSAGES (
            messageid INT PRIMARY KEY auto_increment,
            username VARCHAR NOT NULL,
            messagetext VARCHAR NOT NULL
    );
    **/
    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getMessages();

    @Insert("INSERT INTO MESSAGES (username, messages) VALUES(#{username}, #{messages})")
    @Options(useGeneratedKeys = true, keyProperty = "messageID")
    int insertMessage(ChatMessage chatMessage);

}

