package com.lixiaohan.learn.service.Impl;

import com.lixiaohan.learn.service.BaseService;
import org.msgpack.MessagePack;
import org.msgpack.annotation.Message;
import org.springframework.stereotype.Service;

/**
 * Created by lixiaohan on 2017/12/15.
 */
@Service
public class BaseServiceImpl implements BaseService {
    public void sayHello() {
        System.out.println("Hello World");
    }

    @Message
    public static class MyMessage{
        String name;
        String value;
        String version;

        @Override
        public String toString() {
            return "MyMessage{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    ", version='" + version + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception{
        MyMessage myMessage = new MyMessage();
        myMessage.name = "msg";
        myMessage.version = "1";
        myMessage.value = "1";
        MessagePack pack = new MessagePack();
        byte[] bytes = pack.write(myMessage);
        MyMessage data = pack.read(bytes, MyMessage.class);
        System.out.println(data);
    }

    public static void test1() {
        throw new RuntimeException("test1");
    }

}
