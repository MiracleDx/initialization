package com.dongx.initialization.sys;

import lombok.Data;

/**
 * ServerReponse
 *
 * @author: dongx
 * Description: 服务响应
 * Created in: 2018-05-13 10:49
 * Modified by:
 */
@Data
public class ServerResponse<T> {
	
	public static final Integer SUCCESS = 0;
	public static final Integer FAILED = 1;
	
	private Integer code;
	
	private String message;
	
	private String url;
	
	private T data;
	
}
