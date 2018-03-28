package com.crazy.coding.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.crazy.coding.entity.User;
import com.crazy.coding.mapper.UserMapper;
import com.crazy.coding.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Crazy
 * @since 2017-11-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
