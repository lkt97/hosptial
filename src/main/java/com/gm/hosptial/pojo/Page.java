package com.gm.hosptial.pojo;

import java.util.List;

/**
 * @author lkt
 * @create 2019/10/28 9:22
 */
public class Page {


    //总记录数
    private Integer totalRecords;
    //总页数
    private Integer totalPages;
    //当前页
    private Integer currentPage;
    //首页
    private Integer firstPage;
    //尾页
    private Integer lastPage;
    //前一页
    private Integer prePage;
    //后一页
    private Integer nextPage;

    private Integer beginIndex;

    private String office;

    private String doctor;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(Integer beginIndex) {
        this.beginIndex = beginIndex;
    }

    //每页显示记录数
    private Integer pageSize;
    //数据
    private List<?> datas;

    @Override
    public String toString() {
        return "Page{" +
                "totalRecords=" + totalRecords +
                ", totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", pageSize=" + pageSize +
                ", datas=" + datas +
                '}';
    }

    public Page() {
    }

    public Page(Integer totalRecords, Integer currentPage, Integer pageSize, List<?> datas) {
        this.totalRecords = totalRecords;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.datas = datas;
        this.totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize : (totalRecords / pageSize) + 1;
    }

    //////////////////定义并实现功能方法///////////////////////
    /*
    首页
     */
    public Integer getFirstPage() {
        return 1;
    }

    /*
    尾页
     */
    public Integer getLastPage() {
        return totalPages;
    }

    /*
    上一页
     */
    public Integer getPrePage() {
        return currentPage - 1 < 1 ? 1 : currentPage - 1;
    }

    /*
    下一页
     */
    public Integer getNextPage() {
        return currentPage + 1 > totalPages ? totalPages : currentPage + 1;
    }
    ////////////////////seter and geter///////////////////////////

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getDatas() {
        return datas;
    }

    public void setDatas(List<?> datas) {
        this.datas = datas;
    }
}
