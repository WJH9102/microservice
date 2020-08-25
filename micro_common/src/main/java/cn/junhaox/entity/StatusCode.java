package cn.junhaox.entity;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/21 14:55
 * @Email ibytecode2020@gmail.com
 */
public enum StatusCode implements java.io.Serializable {
    // 响应状态码，成功
    OK("成功", 20000),
    // 响应状态码，失败
    ERROR("失败", 50000),
    // http请求状态码
    HTTP_OK_CODE("响应成功", 200);
    private String desc;
    private Integer code;
    StatusCode(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
