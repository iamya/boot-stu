package my.se.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Server {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup pGroop = new NioEventLoopGroup();
        EventLoopGroup cGroup = new NioEventLoopGroup();

        ServerBootstrap sbs = new ServerBootstrap();

        sbs.group(pGroop, cGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        //添加特殊字符解析,解决拆包粘包问题
                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("_$".getBytes())));
                        //添加字符串解析,将获取的buf对象直接转化成字符串
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new ServerHandler());
                    }
                });

        ChannelFuture f = sbs.bind(8765).sync();

        f.channel().closeFuture().sync();
        f.addListener(ChannelFutureListener.CLOSE); //接收消息后断开通道
        pGroop.shutdownGracefully();
        cGroup.shutdownGracefully();
    }
}
