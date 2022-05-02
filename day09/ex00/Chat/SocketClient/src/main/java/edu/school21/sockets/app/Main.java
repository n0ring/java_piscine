package edu.school21.sockets.app;

import edu.school21.sockets.client.Client;

import java.io.*;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		client.startClient();
	}
}
