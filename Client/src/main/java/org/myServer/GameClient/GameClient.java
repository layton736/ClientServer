package org.myServer.GameClient;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class GameClient extends WebSocketClient {
	public GameClient(URI serverUri) {
		super(serverUri);
	}

	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Exception arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		System.out.println("Client sagt: Es ist offen!");

	}

	public static void main(String[] args) {

		try {
			GameClient client;
			client = new GameClient(new URI("ws://localhost:8080"));

			try {
				client.connectBlocking();
				client.send("Hallo Welt");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
}
