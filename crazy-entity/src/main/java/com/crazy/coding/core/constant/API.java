package com.crazy.coding.core.constant;

public interface API {

    String QUERY_NAME = "分页查询";
    String QUERY_DESC = "分页查询，支持基础条件查询";

    String LOAD_NAME = "全部加载";
    String LOAD_DESC = "全部加载，支持基础条件查询";

    String COUNT_NAME = "查询总数";
    String COUNT_DESC = "查询总数，支持基础条件查询";

    String CREATE_NAME = "新建";
    String CREATE_DESC = "新建，自动生成的 ID 包含在返回结果集中";

    String UPDATE_NAME = "更新";
    String UPDATE_DESC = "根据 ID 更新";

    String DELETE_NAME = "删除";
    String DELETE_DESC = "根据 ID 删除";
    
}
