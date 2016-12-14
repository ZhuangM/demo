package com.up.demo.io;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioUtil {
	private static final String FILE_PATH = "files" + File.separator + "test01.txt";
	
	public static void main(String[] args) {
		System.out.println(readFromFile(FILE_PATH));
	}

	@SuppressWarnings("resource")
	public static String readFromFile(String path) {
		StringBuilder sb = new StringBuilder();
		try {
			RandomAccessFile file = new RandomAccessFile(path, "rw");
			FileChannel channel = file.getChannel();
			ByteBuffer buff = ByteBuffer.allocate(48);
			int bytesRead = channel.read(buff);
			while (-1 != bytesRead) {
				buff.flip();
				while (buff.hasRemaining()) {
					byte[] temp = new byte[buff.remaining()];
					buff.get(temp, 0, buff.remaining()); // 从下标0开始，从缓存中往temp中写入buff.remaining()长度的字节
					sb.append(new String(temp, "UTF-8"));
				}
				buff.clear();
				bytesRead = channel.read(buff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}