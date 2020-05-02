package edu.znzz.cg.words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cn.zsmy.constant.BaseConstant;


/**
 * ��ʼ�����дʿ⣬�����дʼ��뵽HashMap�У�����DFA�㷨ģ��
 * 
*/

public class SensitiveWordInit {
    private String ENCODING = "UTF-8";    //�ַ�����
    @SuppressWarnings("rawtypes")
    public HashMap sensitiveWordMap;
    
    public SensitiveWordInit(){
        super();
    }
    
    @SuppressWarnings("rawtypes")
    public Map initKeyWord(String foldName){
        try {
            //��ȡ���дʿ�
            Set<String> keyWordSet = readSensitiveWordFile(foldName);
            //�����дʿ���뵽HashMap��
            addSensitiveWordToHashMap(keyWordSet);
            //spring��ȡapplication��Ȼ��application.setAttribute("sensitiveWordMap",sensitiveWordMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveWordMap;
    }

    /**
     * ��ȡ���дʿ⣬�����дʷ���HashSet�У�����һ��DFA�㷨ģ�ͣ�<br>
     * �� = {
     *      isEnd = 0
     *      �� = {<br>
     *           isEnd = 1
     *           �� = {isEnd = 0
     *                �� = {isEnd = 1}
     *                }
     *           ��  = {
     *                  isEnd = 0
     *                   �� = {
     *                        isEnd = 1
     *                       }
     *               }
     *           }
     *      }
     *  �� = {
     *      isEnd = 0
     *      �� = {
     *          isEnd = 0
     *          �� = {
     *              isEnd = 0
     *              �� = {
     *                   isEnd = 1
     *                  }
     *              }
     *          }
     *      }
     * @param keyWordSet  ���дʿ�
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        sensitiveWordMap = new HashMap(keyWordSet.size());     //��ʼ�����д��������������ݲ���
        String key = null;  
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        //����keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while(iterator.hasNext()){
            key = iterator.next();    //�ؼ���
            nowMap = sensitiveWordMap;
            for(int i = 0 ; i < key.length() ; i++){
                char keyChar = key.charAt(i);       //ת����char��
                Object wordMap = nowMap.get(keyChar);       //��ȡ
                
                if(wordMap != null){        //������ڸ�key��ֱ�Ӹ�ֵ
                    nowMap = (Map) wordMap;
                }
                else{     //���������򹹽�һ��map��ͬʱ��isEnd����Ϊ0����Ϊ���������һ��
                    newWorMap = new HashMap<String,String>();
                    newWorMap.put("isEnd", "0");     //�������һ��
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }
                
                if(i == key.length() - 1){
                    nowMap.put("isEnd", "1");    //���һ��
                }
            }
        }
    }

    
    
    /**  
     * ��ȡ���дʿ��е����ݣ���������ӵ�set������  
     * @return  
     * @version 1.0  
     */  
    private Set<String> readSensitiveWordFile(String foldName) throws Exception {  
        Set<String> set = new HashSet<String>();  
        InputStreamReader read = null;  
        BufferedReader bufferedReader = null;  
        try {  
            File file = new File(foldName);    //��ȡ�ļ�
            if (file.isDirectory()) {  
                File[] files = file.listFiles();  
                if (null != files && files.length > 0) {  
                    for (File sensitivefile : files) {  
                        read = new InputStreamReader(new FileInputStream(sensitivefile), ENCODING);  
                        bufferedReader = new BufferedReader(read);  
      
                        String txt = null;  
                        while ((txt = bufferedReader.readLine()) != null) { // ��ȡ�ļ������ļ����ݷ��뵽set��  
                            if(txt.split("\\|").length > 0){
                                set.add(txt.split("\\|")[0]);  
                            }
                        }  
                    }  
                } else {  
                    BaseConstant.MY_LOG.error("���дʿ��ļ�������");  
                }  
            } else {  
                BaseConstant.MY_LOG.debug("���дʿ��ļ�������");  
            }  
        } catch (Exception e) {  
            throw e;  
        } finally {  
            if (null != read) {  
                read.close(); // �ر��ļ���  
            }  
        }
        BaseConstant.MY_LOG.debug("���ļ��ж�ȡ�����дʵ�������"+set.size());
        return set;  
    }  
}