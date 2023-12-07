package com.Syhaun.mapper;

import com.Syhaun.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User selectById(int id);
}
