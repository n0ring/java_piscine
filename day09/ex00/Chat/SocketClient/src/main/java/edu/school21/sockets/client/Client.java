package edu.school21.sockets.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private BufferedReader in;
	private BufferedWriter out;
	private Socket clientSocket;
	private static BufferedReader reader;

	public Client() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void startClient() {
		try {
			clientSocket = new Socket("localhost", 8081);
			if (clientSocket.isConnected()) {
				System.out.println("Client connected");
			}
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			showInterface();

//			socket.close();
		} catch (
				IOException e) {
			e.printStackTrace();
		}
	}

	private void showInterface() throws IOException {
		String requst;
		String serverString = in.readLine();
		System.out.println("Interface: " + serverString);

		System.out.println("> ");
		requst = reader.readLine();
		out.write(requst + "\n");
		out.flush();
	}


}
