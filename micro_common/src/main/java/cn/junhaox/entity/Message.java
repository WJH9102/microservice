package cn.junhaox.entity;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/21 14:54
 * @Email ibytecode2020@gmail.com
 */
public class Message implements java.io.Serializable {
    private Boolean flag;
    private Integer code;
    private Object data;

    public Message() {
    }

    public Message(Boolean flag, Integer code) {
        this.flag = flag;
        this.code = code;
    }

    public Message(Boolean flag, Integer code, Object data) {
        this.flag = flag;
        this.code = code;
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
