package pojo;

public class Brand {
    // id 主键
    private Integer id;
    // 品牌名称
    private String brandname;
    // 企业名称
    private String companyname;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;

    public Brand() {
    }

    public Brand(Integer id, String brandname, String companyname, Integer ordered, String description, Integer status) {
        this.id = id;
        this.brandname = brandname;
        this.companyname = companyname;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandname;
    }

    public void setBrandName(String brandName) {
        this.brandname = brandName;
    }

    public String getCompanyName() {
        return companyname;
    }

    public void setCompanyName(String companyName) {
        this.companyname = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
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
    //逻辑视图
    public String getStatusStr(){
        if (status == null){
            return "未知";
        }
        return status == 0 ? "禁用":"启用";
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandname + '\'' +
                ", companyName='" + companyname + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
