package com.flipchat.server.initializer;

import com.flipchat.server.handler.BasicChatServerHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class StringChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		ChannelPipeline pipeline = socketChannel.pipeline();
		
		pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		pipeline.addLast(new StringDecoder());
		pipeline.addLast(new StringEncoder());
		
		pipeline.addLast(new BasicChatServerHandler());
	}

}
