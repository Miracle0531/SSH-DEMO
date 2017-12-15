package com.itheima.utils;

import java.util.UUID;

/**
 * 随机字符串的工具类
 *
 * @author TJR
 * @version 1.0, 2017-12-15 14:39
 */
@SuppressWarnings("all")
public class UUIDUtils {
    /**
     * 获取随机产生的字符串
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
