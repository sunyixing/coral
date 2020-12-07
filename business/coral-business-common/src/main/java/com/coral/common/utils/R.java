/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.coral.common.utils;

import com.coral.common.error.ErrorMsgEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回工具类
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:29 2019-08-30
 **/
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String msg = ErrorMsgEnum.CODE_SUCCESS.getMsg();

	private int code = ErrorMsgEnum.CODE_SUCCESS.getCode();

	private T data;

	public R() {
		super();
	}

	public R(T data) {
		super();
		this.data = data;
	}

	public R(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public R(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public R(Throwable e) {
		super();
		this.msg = e.getMessage();
		this.code = ErrorMsgEnum.CODE_ERROR.getCode();
	}

	public static R ok(){
		return new R();
	}

    /**
     * 调用成功返回，含数据
     * @param data 数据
     * @return 返回类R
     */
	public static R ok(Object data){
		R r = new R<Object>();
		r.data = data;
		return r;
	}

	public static R ok(String msg){
		R r = new R<Object>();
		r.msg = msg;
		return r;
	}

	public static R ok(String key, Object data){
		R r = new R<Object>();
		Map<String, Object> map = new HashMap();
		map.put(key, data);
		r.data = map;
		return r;
	}

	public static R error(){
		R r = new R<Object>();
		r.msg = ErrorMsgEnum.CODE_ERROR.getMsg();
		r.code = ErrorMsgEnum.CODE_ERROR.getCode();
        return r;
    }

    /**
     * 调用失败返回
     * @param msg 具体错误信息
     * @return 返回类R
     */
	public static R error(String msg){
        R r = new R<Object>();
        r.code = ErrorMsgEnum.CODE_ERROR.getCode();
        r.msg = msg;
        return r;
    }

	public static R error(String msg, Object data){
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ERROR.getCode();
		r.msg = msg;
		r.data = data;
		return r;
	}

	public static R error(int code, String msg){
		R r = new R<Object>();
		r.code = code;
		r.msg = msg;
		return r;
	}

	public static R error(Object data){
		R r = new R<Object>();
		r.msg = ErrorMsgEnum.CODE_ERROR.getMsg();
		r.code = ErrorMsgEnum.CODE_ERROR.getCode();
		return r;
	}

	public static R error(int code, String msg, Object data){
		R r = new R<Object>();
		r.code = code;
		r.msg = msg;
		r.data = data;
		return r;
	}


	public static R paramFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_PARAM.getCode();
		r.msg = msg;
		return r;
	}

	public static R ipFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_IP_NOT_ALLOWED.getCode();
		r.msg = msg;
		return r;
	}

	public static R orderFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ORDER.getCode();
		r.msg = msg;
		return r;
	}

	public static R orderFail(String msg, Object data) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ORDER.getCode();
		r.msg = msg;
		r.data = data;
		return r;
	}

	public static R orderCloseFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ORDER_CLOSE.getCode();
		r.msg = msg;
		return r;
	}

	public static R orderCloseFail(String msg, Object data) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ORDER_CLOSE.getCode();
		r.msg = msg;
		r.data = data;
		return r;
	}

	public static R orderNonFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ORDER_NON.getCode();
		r.msg = msg;
		return r;
	}

	public static R orderNonFail(String msg, Object data) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ORDER_NON.getCode();
		r.msg = msg;
		r.data = data;
		return r;
	}

	public static R notLoginFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_NOT_LOGIN.getCode();
		r.msg = msg;
		return r;
	}

	public static R errorPwdFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_ERROR_PASSWORD.getCode();
		r.msg = msg;
		return r;
	}

	public static R tokenFail(String msg) {
		R r = new R<Object>();
		r.code = ErrorMsgEnum.CODE_TOKEN.getCode();
		r.msg = msg;
		return r;
	}

	public static boolean success(R r){
		return r.code == ErrorMsgEnum.CODE_SUCCESS.getCode();
	}


	/**
     * 适配框架原有代码中的put方法
     * @param key 无用key
     * @param data 对应返回类中的data
     * @return 返回类R
     */
	public R put(String key,T data){
	    this.data =data;
	    return this;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public R setData(T data) {
		this.data = data;
		return this;
	}
}