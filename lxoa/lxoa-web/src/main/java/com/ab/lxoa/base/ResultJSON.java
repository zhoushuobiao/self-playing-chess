package com.ab.lxoa.base;

/**
 * @ClassName:  ResultJSON   
 * @Description: 返回数据格式
 * @author: 周硕飙
 * @date:   2017年11月8日 下午5:59:54   
 */
public class ResultJSON {
    /**状态码*/
    private Integer status;
    /**返回信息*/
    private String message;
    /**返回数据*/
    private Object data;
    
    public static ResultJSON forbidden() {
    	return new ResultJSON(HttpCodeConstant.FORBIDDEN,HttpCodeConstant.ERROR_CODE_FORBIDDEN,null);
    }
    
    public static ResultJSON invalid(String param){
    	return new ResultJSON(HttpCodeConstant.UNPROCESSABLE_ENTITY,HttpCodeConstant.ERROR_CODE_INVALID,param + HttpCodeConstant.ERROR_CODE_INVALID);
    }
    
    public static ResultJSON required(String param){
    	return new ResultJSON(HttpCodeConstant.UNPROCESSABLE_ENTITY,HttpCodeConstant.ERROR_CODE_REQUIRED,param + HttpCodeConstant.ERROR_CODE_REQUIRED);
    }
    
    public static ResultJSON not_exist(String param){
    	return new ResultJSON(HttpCodeConstant.UNPROCESSABLE_ENTITY,HttpCodeConstant.ERROR_CODE_NOT_EXIST,param + HttpCodeConstant.ERROR_CODE_NOT_EXIST);
    }
    
    public ResultJSON(int status,String message,Object data){
    	this.status = status;
    	this.message = message;
    	this.data = data;
    }
    public ResultJSON(){
        status = HttpCodeConstant.GET_SUCCESS;
        message = HttpCodeConstant.SUCCESS_UPDATE;
        data = null;
    }
    public ResultJSON(int status){
    	this.status = status;
    	this.message = HttpCodeConstant.SUCCESS_UPDATE;
    	this.data = null;
    }
    public ResultJSON(Object data){
    	this.status = HttpCodeConstant.GET_SUCCESS;
    	this.message = HttpCodeConstant.SUCCESS_UPDATE;
    	this.data = data;
    }
 
    public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    
}
