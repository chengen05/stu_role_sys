package edu.znzz.cg.tools;

import java.util.UUID;

/**
 * uuid工具
 * @author chen gen
 * 生成不可重复的32主键
 */
public class UuidTool {
	public static String getUuid() {
		
		UUID uuid=UUID.randomUUID();

        String uuidStr=uuid.toString();

        return uuidStr;
	}
}
