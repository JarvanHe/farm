package com.he.farm.common;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        return new Result( ResultCode.SUCCESS );
    }

    public static <T> Result <T> genSuccessResult(T data) {
        return new Result( ResultCode.SUCCESS ).setData( data );
    }



    //接口 请求成功 响应码 0
    public static Result apiSuccess() {
        return new Result( ResultCode.API_SUCCESS ).setMessage("请求成功 !");
    }

    //接口 请求成功 响应码 0
    public static <T> Result <T> apiSuccess(T data) {
        return new Result( ResultCode.API_SUCCESS ).setMessage("请求成功 !").setData( data );
    }



    public static Result genFailResult() {
        return new Result( ResultCode.FAILURE );
    }

    public static Result genFailResult(String message) {
        return new Result( ResultCode.FAILURE ).setMessage( message );
    }

    /**
     * 接口请求错误
     * @return
     */
    public static Result apiError() {
        return new Result( ResultCode.API_ERROR ).setMessage( "请求失败!" );
    }

    /**
     * 接口请求错误
     * @param data  返回数据
     * @param <T>
     * @return
     */
    public static  <T> Result <T>  apiError(T data) {
        return new Result( ResultCode.API_ERROR ).setMessage( "请求失败!" ).setData(data);
    }

    /**
     * 服务内部错误
     * @return
     */
    public static Result serverError(){
        return new Result( ResultCode.INTERNAL_SERVER_ERROR );
    }


    public static void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding( "UTF-8" );
        response.setHeader( "Content-type", "application/json;charset=UTF-8" );
        response.setStatus( 200 );
        try {
            response.getWriter().write( JSON.toJSONString( result ) );
        } catch (IOException ex) {
        }
    }

}
