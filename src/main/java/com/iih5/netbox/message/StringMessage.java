package com.iih5.netbox.message;

import com.alibaba.fastjson.JSON;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 字符串消息
 */
public class StringMessage extends Message {
    private String content;
    private byte encrypt;
    public StringMessage(short id) {
        super(id);
    }
    /**
     * 获取消息内容
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取加密类型 0=不加密，默认为0，其他用户自定义
     * @return
     */
    public byte getEncrypt() {
        return encrypt;
    }

    /**
     * 设置加密类型，0=不加密，默认为0，其他用户自定义
     * @param encrypt
     */
    public void setEncrypt(byte encrypt) {
        this.encrypt = encrypt;
    }

    /**
     * 把消息内容转换为Bean对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T parseObject(Class<T> clazz) {
        return  JSON.parseObject(content,clazz);
    }

    /**
     * 把消息内容转换为数组列表
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> parseArray(Class<T> clazz) {
        return JSON.parseArray(content,clazz);
    }

    /**
     * 返回内容二进制数据
     * @return
     */
    public byte[] toArray() {
        return content.getBytes(Charset.forName("UTF-8"));
    }

}
