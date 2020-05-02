package edu.znzz.cg.tools;

import java.util.HashMap;

/**
 * ���巵�ز�������
 * @author chen gen
 *
 */
public class AjaxResult extends HashMap<String, Object> {
	public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";
    
    public enum Type
    {
        /** �ɹ� */
        SUCCESS(200),
        /** ���� */
        WARN(301),
        /** ���� */
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
     * ��ʼ��һ���´����� AjaxResult ����
     * 
     * @param type ״̬����
     * @param msg ��������
     * @param data ���ݶ���
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
     * ���巵�سɹ���Ϣ
     * @param msg
     * @param data
     * @return AjaxResult
     */
    public static AjaxResult success(String msg, Object data) {
    	return new AjaxResult(Type.SUCCESS, msg, data);
    }
    
    /**
     * ���徯����Ϣ
     * @param msg
     * @param data
     * @return AjaxResult
     */
    public static AjaxResult warn(String msg, Object data) {
    	return new AjaxResult(Type.WARN, msg, data);
    }
    
    /**
     * ���������Ϣ
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
