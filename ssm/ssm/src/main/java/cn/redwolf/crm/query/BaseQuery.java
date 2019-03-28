package cn.redwolf.crm.query;

public class BaseQuery {
//    当前页
    private Integer page=0;
//    当前页总共多少
    private Integer rows=5;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
