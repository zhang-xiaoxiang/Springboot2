package com.example.plus.result;

import org.springframework.jdbc.support.incrementer.PostgresSequenceMaxValueIncrementer;

/**
 * ResultData:封装数据且以json格式返回
 *
 * @author zhangxiaoxiang
 * @date: 2019/06/25
 */
public class ResultData {


    /**
     * 成功返回
     *
     * @param msg 成功返回信息
     * @return
     */
    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData("");
        return result;
    }

    /**
     * @param msg  成功返回信息
     * @param data 返回数据
     * @return
     */
    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 失败返回
     *
     * @param msg 错误信息
     * @return
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(500);
        result.setMsg(msg);
        result.setData("");
        return result;
    }

    /**
     * 失败返回
     *
     * @param code 带状态码
     * @param msg  错误信息
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData("");
        return result;
    }

    /**
     * 身份验证失败返回
     *
     * @param msg 失败信息
     * @return
     */
    public static Result noVerify(String msg) {
        Result result = new Result();
        result.setCode(401);
        result.setMsg(msg);
        result.setData("");
        return result;
    }

    /**
     * 通过service处理结果条件判断返回
     *
     * @return
     */
    public static Result conditions(Object object) {
        //处理mybatis的service通用接口判断
        if (object instanceof Boolean) {
            boolean flag = (boolean) object;
            if (flag){
                return ResultData.success("处理成功!");
            }else {
                return ResultData.error("处理失败!");
            }
        }
        //使用常规操作返回对象的service判断  处理的逻辑是只要查询是可以的,不惯时候有数据
      return ResultData.success("处理成功!");

    }

    public static void main(String[] args) {
        Boolean b = false;
        Result conditions = ResultData.conditions(1);
        System.out.println(conditions);

    }


}
