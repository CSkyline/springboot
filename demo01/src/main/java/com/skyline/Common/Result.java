package com.skyline.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code; //1:success 0:fail
    private String msg; //tips message
    private Object data; // result data

    public static Result success(Object data){return new Result(1,"success",data);}
    public static Result success(String msg){return new Result(1,msg,null);}
    public static Result success(){
        return new Result(1,"success",null);
    }

    public static Result error(String msg){
        return new Result(0,msg,null);
    }
    public static Result error(){return new Result(0,"fail",null);}

    public String toString(){
        return "Result{" +
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                "}";
    }
}
