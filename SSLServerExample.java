package ssl;

//ani
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/**
Visit the channel http://youtube.com/zarigatongy
*/

//Writing SSL Server in Java 
public class SSLServerExample {

	/*
	 * Where do we find the keystore Information ?
	 */
	final static String pathToStores = "/tmp/ssl/server"; // The Directory
	final static String keyStoreFile = "server2.keystore"; // The FileName
	final static String passwd = "123456"; // The Password

	/*
	 * Which Port to Listen SSL Connections
	 */
	final static int theServerPort = 12345;

	/*
	 * Turn on SSL debugging?
	 */
	static boolean debug = false;

	void doServerSide() throws Exception {
		SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory
				.getDefault();
		SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf
				.createServerSocket(theServerPort);

		SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
		InputStream sslIS = sslSocket.getInputStream();
		
		//For Writing Back to the Client
		OutputStream sslOS = sslSocket.getOutputStream();

		//Read from the Client
        BufferedReader bufferedreader = new BufferedReader( new InputStreamReader(sslIS));

        String string = null;
        while ((string = bufferedreader.readLine()) != null) {
            System.out.println(string);
            System.out.flush();
        }
		
		
		sslSocket.close();
	}

	public static void main(String[] args) throws Exception {
		String trustFilename = pathToStores + "/" + keyStoreFile;

		System.setProperty("javax.net.ssl.keyStore", trustFilename);
		System.setProperty("javax.net.ssl.keyStorePassword", passwd);
		if (debug)
			System.setProperty("javax.net.debug", "all");

		// java -Djavax.net.ssl.keyStore=/tmp/trustFilename
		// -Djavax.net.ssl.keyStorePassword=123456 SSLServerExample
		new SSLServerExample().doServerSide();

	}

}
