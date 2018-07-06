package org.myServer.GameServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class GameServer extends WebSocketServer {

	SocketManager sockets;

	public GameServer(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onClose(WebSocket ws, int arg1, String arg2, boolean arg3) {
		broadcast("Server Closed");
		sockets.clear();
	}

	@Override
	public void onError(WebSocket ws, Exception err) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onMessage(WebSocket ws, String message) {
		System.out.println("Erhalten: " + message);
	}

	@Override
	public void onMessage(WebSocket conn, ByteBuffer message) {
		// TODO Auto-generated method stub
		super.onMessage(conn, message);
	}

	@Override
	public void onOpen(WebSocket ws, ClientHandshake arg1) {
		System.out.println("Verbunden mit ");
		InetAddress address = ws.getLocalSocketAddress().getAddress();
		System.out.println(address);
		sockets.addSocket(ws);
	}

	@Override
	public void onStart() {
		System.out.println("Server is waiting...");
		sockets = new SocketManager();
	}

	public static void main(String[] args) {

		GameServer server = new GameServer(new InetSocketAddress("localhost", 8080));

		server.start();
	}
}
