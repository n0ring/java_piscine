package edu.school21.sockets.app;

import edu.school21.sockets.server.Server;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Server server = new Server(8081);
		server.startServer();
	}
}
