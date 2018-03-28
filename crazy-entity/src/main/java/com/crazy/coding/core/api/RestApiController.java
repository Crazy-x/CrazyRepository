package com.crazy.coding.core.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.crazy.coding.entity.common.PageResult;
import com.crazy.coding.entity.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Rest API 基础控制器接口 <br>
 * 包含应该实现的基础方法
 *
 * @param <T> 实体类
 * @author Alex
 */
public abstract class RestApiController<T> {

    /**
     * 分页查询，支持基础条件查询
     *
     * @param page   分页参数
     * @param entity 实体参数
     * @return 分页结果
     */
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基础条件查询")
    public ResponseEntity<PageResult> query(Page<T> page, T entity) {
        return null;
    }

    /**
     * 查询总数，支持基础条件查询
     *
     * @param entity 实体参数
     * @return 标准结果
     */
    @GetMapping({"/count"})
    public ResponseEntity<Result> count(T entity) {
        return null;
    }

    /**
     * 新建，自动生成的 ID 填充到 entity
     *
     * @param entity 实体参数
     * @return 标准结果
     */
    @ApiOperation(value = "新建", notes = "新建，自动生成的 ID 包含在返回结果集中")
    public ResponseEntity<Result> create(@RequestBody T entity) {
        return null;
    }

    /**
     * 更新，根据 ID 更新
     *
     * @param entity 实体参数
     * @return 标准结果
     */
    @ApiOperation(value = "更新", notes = "根据 ID 更新")
    public ResponseEntity<Result> update(@RequestBody T entity) {
        return null;
    }

    /**
     * 删除，根据 ID 删除
     *
     * @param id ID
     * @return 标准结果
     */
    @ApiOperation(value = "删除", notes = "根据 ID 删除")
    public ResponseEntity<Result> delete(@PathVariable int id) {
        return null;
    }

}
