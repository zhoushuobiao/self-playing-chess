package com.ab.lxoa.base;
/**
 * http状态码常量类
 * <br>包含返回错误信息类型编码
 * @author zouj
 * @date 2015-12-10
 * @since 1.0.0
 */
public class HttpCodeConstant {
	/**
	 * token失效状态码 300
	 */
	public static final Integer TOKEN_INVALID = 666;

	/** 查询成功成功*/
	public static final Integer GET_SUCCESS = 200;
	/** 创建修改成功返回状态码 201*/
	public static final Integer POST_PUT_SUCCESS = 201;
	/** 删除成功返回状态码 204 */
	public static final Integer DELETE_SUCCESS = 204;
	/** 用户未登录 401 */
	public static final Integer UNAUTHORIZED = 401;
	/** 未授权返回状态码 403*/
	public static final Integer FORBIDDEN = 403;
	/** 接口失效返回状态码 405*/
	public static final Integer METHOD_NOT_ALLOWED = 405;
	/** 请求类型错误返回状态码 415*/
	public static final Integer UNPROCESSABLE_MEDIA_TYPE = 415;
	/** 校验错误返回状态码 422*/
	public static final Integer UNPROCESSABLE_ENTITY = 422;
	/** 字段的值非法 */
	public static final String ERROR_CODE_INVALID = "invalid";
	/** 缺失必须的字段 */
	public static final String ERROR_CODE_REQUIRED = "required";
	/** 字段的值代表的资源不存在 */
	public static final String ERROR_CODE_NOT_EXIST = "not_exist";
	/** 字段的值代表的资源已经存在 */
	public static final String ERROR_CODE_ALREADY_EXIST = "already_exist";
	/** 非法创建资源 */
	public static final String ERROR_CODE_CREATE_FAIL = "create_fail";
	/** 没有权限       */
	public static final String ERROR_CODE_FORBIDDEN = "without_permission";
	/**成功*/
	public static final String SUCCESS_UPDATE = "success";

	private HttpCodeConstant(){
		//私有构造方法
	}
}
