package com.crazy.coding.entity.common;


/**
 * Rest API 标准分页返回结果装饰类
 *
 * @author alex
 */
public class PageResult extends Result {

    private int current = 1;

    private int size = 10;

    private int total;

    private int pages;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
