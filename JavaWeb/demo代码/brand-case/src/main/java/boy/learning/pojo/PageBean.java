package boy.learning.pojo;


import java.util.List;

/**
 * 分页查询的javabean
 */
public class PageBean<T> {
    private int totalCount;//总记录数
    private List<T> rows;//当前页数据

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                '}';
    }
}
