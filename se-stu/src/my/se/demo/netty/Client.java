package my.se.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Client {

    public static void main(String[] args) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bs = new Bootstrap();

        bs.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //添加特殊字符解析,解决拆包粘包问题
                        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("_$".getBytes())));
                        //添加字符串解析,将获取的buf对象直接转化成字符串
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new ClientHandler());
                    }
                });

        ChannelFuture f = bs.connect("127.0.0.1", 8765).sync();

        f.channel().writeAndFlush(Unpooled.copiedBuffer("Hello, Who are you ?_$".getBytes()));
        f.channel().writeAndFlush(Unpooled.copiedBuffer("Hello, Who are you ?_$".getBytes()));

        f.channel().closeFuture().sync();

        group.shutdownGracefully();


    }
}
