import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        // [중요] 이 로그가 보여야 파일이 제대로 저장된 것입니다.
        System.out.println(">>> 🚀 [새로운 코드 실행 중] 정상적으로 업데이트 됨 🚀 <<<");

        System.out.println("Logs from your program will appear here!");

        int port = 6379;

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            // 1. 소켓 객체 생성 (아직 바인딩 X)
            serverSocket = new ServerSocket();

            // 2. 포트 재사용 옵션 설정 (가장 중요! 바인딩 전에 해야 함)
            serverSocket.setReuseAddress(true);

            // 3. 포트 바인딩 (6379)
            serverSocket.bind(new InetSocketAddress(port));

            // 4. 클라이언트 연결 대기 (Blocking)
            clientSocket = serverSocket.accept();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }
}