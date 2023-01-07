package boy.learning.pojo;

/**
 * 品牌
 */

public class Brand {
/**
 * ctrl + alt + l 格式化代码
 *  ctrl shift + ↑ 移动一行代码
 *  alt  列编辑
 *  alt ctrl shift  多行同时编辑
 *  alt + insert 快速生成
 */

    // id 主键
    private Integer id;
    // 品牌名称
    private String brandName;
    // 公司名称
    private String companyName;
    // 排序
    private int ordered;
    // 描述
    private String description;
    // 状态
    private Integer status;

    public Brand(Integer id, String brandName, String companyName, int ordered, String description, Integer status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
