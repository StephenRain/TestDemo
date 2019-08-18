package com.example.demo.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * NIO:面向缓冲区 Buffer: 负责NIO中数据的存取，本质就是数组
 *  有不同类型的数据的缓冲区，除了boolean之外
 *  有：
 *  ByteBuffer
 *  CharBuffer
 *  ShortBuffer
 *  IntBuffer
 *  LongBuffer
 *  FloatBuffer
 *  DuobleBuffer
 *
 *  使用allocate()获取缓冲区
 *
 *  直接缓冲区：在物理内存中有个缓冲区，省去物理内存-》JVM 拷贝的过程。
 *      效率高，适合大内存数据。
 *  间接缓冲区：将缓冲区建立在JVM内存中。
 *
 *
 *
 */
public class NIOBufferDemo {


    /**
     * 缓冲区的四个核心属性
     * capacity:容量
     * limit: 界限，后面数据无法读取
     * position: 缓冲区正在操作数据的位置
     */
    @Test
    public void bufferDemo() {
        // 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        String src = "abcde";

        // 利用 put 方法 存入数据到缓冲区
        byteBuffer.put(src.getBytes());

        // 切换到读取数据模式
        byteBuffer.flip();

        // 读取数据到指定数组
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println("new String(dst,0,dst.length) = " + new String(dst, 0, dst.length));

        // 重复读数据 rewind
        byteBuffer.rewind();

        // 清空缓冲区,但是缓冲区中数据依然存在，但是处于被遗忘状态
        byteBuffer.clear();

        System.out.println("byteBuffer = " + byteBuffer.position());
        System.out.println("byteBuffer = " + byteBuffer.limit());
        System.out.println("byteBuffer = " + byteBuffer.capacity());

        // mark ：标记position的位置
        byteBuffer.mark();
        // 充值mark标记的位置
        byteBuffer.reset();

    }

    public static void main(String[] args) {




    }



}
