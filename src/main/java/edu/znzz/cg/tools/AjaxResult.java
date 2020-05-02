package edu.znzz.cg.tools;

import java.util.HashMap;

/**
 * 定义返回操作类型
 * @author chen gen
 *
 */
public class AjaxResult extends HashMap<String, Object> {
	public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";
    
    public enum Type
    {
        /** 成功 */
        SUCCESS(200),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }
    
    private Type type;
    
    private int code;
    
    private String msg;
    
    private Object data;
    
   
    /**
     * 初始化一个新创建的 AjaxResult 对象
     * 
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResult(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        if(msg != null || data != "") 
        {
            super.put(MSG_TAG, msg);
        }

        if (data != null || data != "")
        {
            super.put(DATA_TAG, data);
        }
    }
    
    /**
     * 定义返回成功消息
     * @param msg
     * @param data
     * @return AjaxResult
     */
    public static AjaxResult success(String msg, Object data) {
    	return new AjaxResult(Type.SUCCESS, msg, data);
    }
    
    /**
     * 定义警告消息
     * @param msg
     * @param data
     * @return AjaxResult
     */
    public static AjaxResult warn(String msg, Object data) {
    	return new AjaxResult(Type.WARN, msg, data);
    }
    
    /**
     * 定义错误消息
     * @param msg
     * @param data
     * @return AjaxResult
     */
    public static AjaxResult error(String msg, Object data) {
    	return new AjaxResult(Type.ERROR, msg, data);
    }

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
    
}
