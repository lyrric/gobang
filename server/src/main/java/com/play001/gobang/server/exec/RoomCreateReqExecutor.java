package com.play001.gobang.server.exec;

import com.play001.gobang.server.service.ClientService;
import com.play001.gobang.server.service.GameService;
import com.play001.gobang.server.service.RoomService;
import com.play001.gobang.support.annotation.MsgAnnotation;
import com.play001.gobang.support.entity.Room;
import com.play001.gobang.support.entity.msg.client.ClientMsgType;
import com.play001.gobang.support.entity.msg.client.RoomCreateReqMsg;
import com.play001.gobang.support.entity.msg.client.RoomEnterReqMsg;
import com.play001.gobang.support.entity.msg.server.RoomCreateResMsg;
import com.play001.gobang.support.entity.msg.server.RoomEnterResMsg;
import org.apache.log4j.Logger;


/**
 * 创建房间
 */
@MsgAnnotation(msgType = ClientMsgType.ROOM_CREATE_REQ)
public class RoomCreateReqExecutor extends BaseExecutor {

    private final Logger logger = Logger.getLogger(RoomCreateReqExecutor.class);

    @Override
    public void run() {
        RoomCreateResMsg resMsg = new RoomCreateResMsg(null, System.currentTimeMillis());
        try {
            RoomCreateReqMsg reqMsg = (RoomCreateReqMsg)baseMsg;
            String username =  reqMsg.getUser().getUsername();
            Room room = RoomService.add(username);
            resMsg.setRoomId(room.getRoomId());
        }catch (Exception e){
            e.printStackTrace();
            resMsg.setErrMsg("进入房间失败!");
        }
        //返回结果给客户端
        channel.writeAndFlush(resMsg);

    }
}
