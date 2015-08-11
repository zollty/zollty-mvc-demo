/*
 * @(#)SimpleJsonUtils.java
 */
package com.zollty.mvcdemo.tool.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zollty.util.StringUtils;

/**
 * @author zollty
 * @since 2013-12-10
 */
public class SimpleJsonUtils {

    private SimpleJsonUtils(){
    }
    
    /**
     * json 只能是类似：{"resultType": "000", "errorCode": "0x0001"}的简单格式。 即，只能有最外层一个{}，值的类型全部都是string，不能有内部对象和数组。
     * 
     * @param json
     */
    public static Map<String, String> simpleJsonToMap(String json) {
        Map<String, String> map = new HashMap<String, String>();
        char[] chars = json.toCharArray();
        int a = -1;
        int b = -1;
        String key = null;
        String value = null;
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '\"' && chars[i - 1] != '\\') {
                if (a == -1){
                    a = i;
                }
                else {
                    b = i;
                    if (key == null){
                        key = json.substring(a + 1, b);
                    }
                    else {
                        value = json.substring(a + 1, b).replace("\\\"", "\"");
                        map.put(key, value);
                        key = value = null;
                    }
                    a = b = -1;
                }
                continue;
            }
        }
        return map;
    }

    /**
     * 解析简单json字符串，格式为：<br>
     * []<br>
     * [{jsonObject}]<br>
     * [{jsonObject},{jsonObject}]<br>
     * [{jsonObject},{jsonObject},{jsonObject}]<br>
     * [{jsonObject},{jsonObject},....,{jsonObject}]<br>
     * 最极端的情况为：[]，返回一个emptyList
     * 
     * @param json
     */
    public static List<Map<String, String>> parseSimpleJsonArray(String jsonText) {
        String tempJsonStr = jsonText.substring(1, jsonText.length() - 1);
        if (StringUtils.isBlank(tempJsonStr)) {
            return Collections.emptyList();
        }
        char[] chars = tempJsonStr.toCharArray();
        int pos1 = 0;
        int pos2 = 0;
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{') {
                pos1 = i;
            }
            if (chars[i] == '}') {
                pos2 = i;
                String subStr = tempJsonStr.substring(pos1, pos2 + 1);
                list.add(simpleJsonToMap(subStr));
            }
        }

        return list;
    }

    /**
     * 组装成的简单json格式为：{"resultType": "000", "errorCode": "0x0001"}，（全部都用双引号包裹） 且默认Map<String, String>的string全都不包含特殊字符
     * 
     * @see #simpleMapToJson(String)
     * @author zollty
     */
    public static String simpleMapToJson(Map<String, String> map) {
        StringBuilder strb = new StringBuilder();
        strb.append("{");
        Iterator<Map.Entry<String, String>> entryIter = map.entrySet().iterator();
        Map.Entry<String, String> entry;
        boolean first = true;
        while (entryIter.hasNext()) {
            if (!first) {
                strb.append(", ");
            } else {
                first = false;
            }
            entry = entryIter.next();
            strb.append("\"").append(entry.getKey()).append("\": ").append("\"").append(entry.getValue()).append("\"");
        }
        strb.append("}");

        return strb.toString();
    }

    /**
     * 特殊字符转义 1、json标准中，value和name不能包含引号和斜杠 例如，value = a"b\c\d，替换后 为 a\"b\\c\\d 2、将java的特殊字符转换成字符串，比如字符(\n)转换成字符串("\n")
     */
    public static String escapeValueOrName(String valueOrName) {
        if (valueOrName == null) {
            return valueOrName;
        }
        valueOrName = valueOrName.replace("\\", "\\\\");
        valueOrName = valueOrName.replace("\"", "\\\"");
        valueOrName = valueOrName.replace("\n", "\\n");
        valueOrName = valueOrName.replace("\r", "\\r");
        valueOrName = valueOrName.replace("\t", "\\t");
        valueOrName = valueOrName.replace("\b", "\\b");
        valueOrName = valueOrName.replace("\f", "\\f");
        return valueOrName;
    }

}