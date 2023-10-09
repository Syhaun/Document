package com.tc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//响应码 1成功 0 失败
    private String msg; //响应信息 描述字符串
    private Object data; //返回的数据类型

    public static Result success() {
        //增删改成功响应
        return new Result(1,"succedd",null);
    }
    public static Result success(Object data) {
        return new Result(1,"succedd",data);
    }
    public static Result error(String msg) {
        return new Result(0,msg,null);
    }
}
