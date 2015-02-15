package ssl;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

/**
Visit the channel http://youtube.com/zarigatongy
*/
public class SSLClient {
	public static void main(String[] arstring) {
		try {
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory
					.getDefault();
			SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(
					"localhost", 1234);

			InputStream inputstream = System.in;
			InputStreamReader inputstreamreader = new InputStreamReader(
					inputstream);
			BufferedReader bufferedreader = new BufferedReader(
					inputstreamreader);

			OutputStream outputstream = sslsocket.getOutputStream();
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(
					outputstream);
			BufferedWriter bufferedwriter = new BufferedWriter(
					outputstreamwriter);

			String string = null;
			while ((string = bufferedreader.readLine()) != null) {
				bufferedwriter.write(string + '\n');
				bufferedwriter.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}