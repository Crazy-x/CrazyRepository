package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Crazy
 * @since 2017-11-29
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> findUserList();
}