package edu.school21.sockets.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	final int END_WORK = -1;
	private int port;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private BufferedReader in;
	private BufferedWriter out;

	public Server(int port) {
		this.port = port;
	}

	public void startServer() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server started");
			clientSocket = serverSocket.accept();
			if (clientSocket.isConnected()) {
				out.write("Hello from Server!\n");
				out.flush();
			}
			else {
				System.err.println("Connect fail");
			}
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			serverWork();
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

	private void signUp() {
		System.out.println("signUp start");
	}

	private int onMainPage() throws IOException {
		String request = in.readLine();
		System.out.println(request);
		if (request.equals("signUp")) {
			signUp();
		}
		return END_WORK;
	}

	private void serverWork() throws IOException {
		while (true) {
			if (onMainPage() == END_WORK) {
				break ;
			}
		}
		closeConnection();
	}

	public void closeConnection() throws IOException {
		clientSocket.close();
		serverSocket.close();
	}
}
