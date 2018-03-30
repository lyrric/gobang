package com.play001.gobang.server.service;

import com.play001.gobang.server.entity.ClientData;
import io.netty.channel.Channel;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 已登录客户数据
 */
public class ClientService {

    private static Logger logger = Logger.getLogger(ClientService.class);

    //已登陆客户端 key为用户名
    private static Map<String, ClientData> clients = new HashMap<>();
    //添加客服端
    public static void add(String username, ClientData client){
        clients.put(username, client);
    }
    //移除客户端
    public static void removeByUsername(String username){
        clients.remove(username);
    }
    //移除
    public static void removeByChannel(Channel channel){
        clients.forEach((key, value)->{
            if(value.getChannel().id().equals(channel.id())){
                clients.remove(key);
                logger.info(value.getUsername()+", 下线了");
            }
        });
    }
    //获取
    public static ClientData getByUsername(String username){
        return clients.get(username);
    }
    public static void enterRoom(String username, Integer roomId){
        clients.get(username).setRoomId(roomId);
    }
}
