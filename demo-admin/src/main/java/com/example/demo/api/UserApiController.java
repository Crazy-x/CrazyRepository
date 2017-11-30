package com.example.demo.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.core.api.RestApiController;
import com.example.demo.core.constant.API;
import com.example.demo.entity.User;
import com.example.demo.entity.common.PageResult;
import com.example.demo.entity.common.Result;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResponseEntityBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * User API 控制器
 * </p>
 *
 * @author Crazy
 * @since 2017-11-29
 */
@Api(value = "User API", description = " API")
@RestController
@RequestMapping("/api/user")
public class UserApiController extends RestApiController<User> {

    @Autowired
    private UserService userService;

    @GetMapping({"", "/query"})
    @ApiOperation(value = API.QUERY_NAME, notes = API.QUERY_DESC)
    public ResponseEntity<PageResult> query(Page<User> page, User entity) {
        return ResponseEntityBuilder.build(userService.selectPage(page, new EntityWrapper<User>(entity)));
    }

    @GetMapping({"/count"})
    @ApiOperation(value = API.COUNT_NAME, notes = API.COUNT_DESC)
    public ResponseEntity<Result> count(User entity) {
        return ResponseEntityBuilder.build(userService.selectCount(new EntityWrapper<User>(entity)));
    }

    @PostMapping({"", "/create"})
    @ApiOperation(value = API.CREATE_NAME, notes = API.CREATE_DESC)
    public ResponseEntity<Result> create(@RequestBody User entity) {
        return ResponseEntityBuilder.build(userService.insert(entity), entity);
    }

    @PutMapping({"/{id}", "/update"})
    @ApiOperation(value = API.UPDATE_NAME, notes = API.UPDATE_DESC)
    public ResponseEntity<Result> update(@RequestBody User entity) {
        return ResponseEntityBuilder.build(userService.updateById(entity));
    }

    @DeleteMapping({"/{id}", "/delete/{id}"})
    @ApiOperation(value = API.DELETE_NAME, notes = API.DELETE_DESC)
    public ResponseEntity<Result> delete(@PathVariable int id) {
        return ResponseEntityBuilder.build(userService.deleteById(id));
    }
}
