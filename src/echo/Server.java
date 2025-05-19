package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//천호동
public class Server {

	public static void main(String[] args) throws IOException{
	
		//서버소켓생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인드
		serverSocket.bind(new InetSocketAddress("192.168.0.96", 10001));
		
		//서버시작
		System.out.println("<서버시작>");
		System.out.println("===========================================");
		
		
		//-------반복
		while(true) {
			//연결대기-->연결
			System.out.println("[연결을 기다리고 있습니다.]");
			Socket socket = serverSocket.accept();
			
			System.out.println("[클라이언트가 연결 되었습니다.]");
			
			///////////////////////////////////////
			//socket 출장(Thread)가서  ServerThread->run(빨대 만들고 대화해)
			Thread st = new ServerThread(socket);
			st.start();
			///////////////////////////////////////
		}
		//-------반복
		
		/*
		System.out.println("================================");
		System.out.println("<서버종료>");
		
	
		//자원정리
		br.close();
		bw.close();
		socket.close();
		serverSocket.close();
		*/
	}

}
