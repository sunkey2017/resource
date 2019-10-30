package org.smallbun.framework.toolkit;

import com.alibaba.fastjson.JSONArray;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * @ClassName afafd
 * @Description
 * @Author jiangsida
 * @VERSION 1.0
 */

public class ArraytoObjectUtil {

    /**
     * 声明一个泛型方法数组转换对象
     * @param args
     * @param clazz
     * @param <T>
     * @return
     */
    public  static  <T> T arraytoObject(String[] args, Class<T> clazz) throws IllegalAccessException, InstantiationException {

        if (clazz == null || args == null) {
            throw new IllegalArgumentException();
        }

        T t = clazz.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields == null || declaredFields.length > args.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            Class<?> type = declaredFields[i].getType();
            if (type == int.class) {
                declaredFields[i].set(t, Integer.parseInt(args[i].substring(1, args[i].length() - 1).isEmpty()?"0":args[i].substring(1, args[i].length() - 1)));
            }
            else if (type == String.class) {
                declaredFields[i].set(t, args[i].substring(1, args[i].length() - 1).isEmpty()?null:args[i].substring(1, args[i].length() - 1));
            }
            else if (type == Double.class) {
                declaredFields[i].set(t, Double.parseDouble(args[i].substring(1, args[i].length() - 1).isEmpty()? "0":args[i].substring(1, args[i].length() - 1)));
            }

        }

        return  t;
    }
}
