package org.myServer.GameServer;

import org.java_websocket.WebSocket;

public class SocketManager {

	WebSocket[] socket;
	int MAX_CLIENTS = 8;

	public SocketManager() {

		socket = new WebSocket[MAX_CLIENTS];

	}

	public boolean addSocket(WebSocket ws) {

		int index = 0;
		boolean wasSaved = false;
		while (index < socket.length) {

			if (socket[index] == null) {
				socket[index] = ws;
				wasSaved = true;
				break;

			}
			index++;

		}

		return wasSaved;

	}

	public void clear() {

		for (int i = 0; i < socket.length; i++) {
			socket[i].close();
			
		}
		
	}

}
