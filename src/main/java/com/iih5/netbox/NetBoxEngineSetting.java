/*
 * Copyright 2016 xueyi (1581249005@qq.com)
 *
 * The Smart-NetBox Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.iih5.netbox;


import com.iih5.netbox.core.GlobalConstant;
import com.iih5.netbox.core.MessageType;
import com.iih5.netbox.core.ProtocolConstant;
import com.iih5.netbox.core.TransformType;
import com.iih5.netbox.message.Message;

public class NetBoxEngineSetting {
	/**默认端口*/
    private int port=9230;
    /**netty Boss线程数*/
    private int bossThreadSize=1;
    /**netty Work线程数*/
    private int workerThreadSize=4;
    /**玩家管理线程数*/
    private int playerThreadSize=16;
    /**Request扫描路径*/
    private String basePackage="com";

//    /**数据协议类型*/
//    private int messageType= MessageType.BYTE_TYPE;
//    /**启动TCP服务*/
//    private int transformType= TransformType.TCP;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBossThreadSize() {
        return bossThreadSize;
    }

    public void setBossThreadSize(int bossThreadSize) {
        this.bossThreadSize = bossThreadSize;
    }

    public int getWorkerThreadSize() {
        return workerThreadSize;
    }

    public void setWorkerThreadSize(int workerThreadSize) {
        this.workerThreadSize = workerThreadSize;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setMessageType(int messageType) {
        GlobalConstant.messageType =messageType;
    }

    public void setTransformType(int transformType) {
        GlobalConstant.transformType = transformType;
    }

    public int getTransformType() {
        return  GlobalConstant.transformType;
    }

    public int getPlayerThreadSize() {
        return playerThreadSize;
    }

    public void setPlayerThreadSize(int playerThreadSize) {
        this.playerThreadSize = playerThreadSize;
    }

    public boolean isDebug() {
        return GlobalConstant.debug;
    }
    public void setDebug(boolean debug) {
        GlobalConstant.debug = debug;
    }

    public int getCodecType() {
        return ProtocolConstant.TCP_CODEC_TYPE;
    }

    public void setCodecType(int codecType) {
        ProtocolConstant.TCP_CODEC_TYPE = codecType;
    }
}
