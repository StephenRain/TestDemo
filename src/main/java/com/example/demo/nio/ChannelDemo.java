package com.example.demo.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通道：用于源节点和目标节点的连接，在Java NIO中负责缓冲区数据的传输
 *  不存储数据，因此配合缓冲区进行传输
 *
 *  java.nio.channels.Channel接口
 *      FileChannel
 *      SocketChannel
 *      ServerSocketChannel
 *      DatagramChannel
 *
 *   1、获取通道
 *   FileInputStream/
 *   RandomAccessFile
 *
 *
 *      在JDK1.7中NIO2中针对各个通道提供了静态方法 open()
 *                                  Files工具类的newByteChannel()
 *
 */
public class ChannelDemo {


    /**
     *  通过通道来复制数据 (非直接缓冲区)
     * @throws Exception
     */
    @Test
    public void copyByChannel() throws Exception {
        System.out.println("true = " + true);
        FileInputStream fis = new FileInputStream("1.png");
        FileOutputStream fos = new FileOutputStream("2.png");

        FileChannel channel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (channel.read(buf) != -1) {
            buf.flip();
            fosChannel.write(buf);
            buf.clear();
        }

        channel.close();
        fosChannel.close();
        fos.close();
        fis.close();
    }

    /**
     * 使用直接缓冲区完成文件的复制
     */
    @Test
    public void copyByChannelDirect() throws IOException {

        FileChannel inChannel = FileChannel.open(Paths.get("1.png"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.png"),
                StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
    }


    /**
     * 通道之间的数据传输 （直接缓冲区）
     */
    @Test
    public void channelTransfer () throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("1.png"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("4.png"),
                StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.close();
        inChannel.close();
    }


    /**
     * 分散读取：将通道中的数据分散到多个缓冲区中，
     *      依次填满
     * 聚焦写入：将多个缓冲区的数据聚集到通道中
     */





}
