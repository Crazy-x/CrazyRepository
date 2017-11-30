package com.example.demo.entity.common;

import org.apache.ibatis.session.RowBounds;

public class Pagination extends RowBounds {

    private int page = 1;
    private int size = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
