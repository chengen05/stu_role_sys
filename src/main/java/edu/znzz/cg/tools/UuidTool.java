package edu.znzz.cg.tools;

import java.util.UUID;

/**
 * uuid����
 * @author chen gen
 * ���ɲ����ظ���32����
 */
public class UuidTool {
	public static String getUuid() {
		
		UUID uuid=UUID.randomUUID();

        String uuidStr=uuid.toString();

        return uuidStr;
	}
}
