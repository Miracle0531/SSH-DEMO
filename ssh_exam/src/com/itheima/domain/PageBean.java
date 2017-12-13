package com.itheima.domain;

import java.util.List;

/**
 * 分页信息的实体类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:10
 */
public class PageBean<T> {

    /**
     * 创建分页属性信息
     */
    /** 当前页数 */
    private int pageNum;
    /** 总页数 */
    private int tatalPage;
    /** 总条数 */
    private int totalCount;
    /** 每页条数 */
    private int currentCount;
    /** 每页显示的条数 */
    private List<T> currentContent;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTatalPage() {
        return tatalPage;
    }

    public void setTatalPage(int tatalPage) {
        this.tatalPage = tatalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public List<T> getCurrentContent() {
        return currentContent;
    }

    public void setCurrentContent(List<T> currentContent) {
        this.currentContent = currentContent;
    }
}
