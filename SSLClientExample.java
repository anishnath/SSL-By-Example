package ssl;
//ani
import java.io.OutputStream;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
Visit the channel http://youtube.com/zarigatongy
*/
//Writing SSL Client in Java 
public class SSLClientExample {

	/*
	 * Where do we find the trustores ?
	 */
	final static String pathToStores = "/tmp/ssl/client"; // The Directory
	final static String trustStoreFile = "keystore1.jks";    //The FileName
	final static String passwd = "123456";  //The Password

	/*
	 * Where is the Server and the Port
	 */
	final static String theServerName = "localhost";
	final static int theServerPort = 12345;

	/*
	 * Turn on SSL debugging?
	 */
	static boolean debug = false;

	/*
	 * Define the client side of the test.
	 */
	void doClientSide() throws Exception {

		SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory
				.getDefault();
		SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(theServerName,
				12345);
		
		OutputStream sslOS = sslSocket.getOutputStream();
		sslOS.write("Hello SSL Server".getBytes()); // Write to the Server
		sslOS.flush();
		sslSocket.close();
	}

	public static void main(String[] args) throws Exception {
		String trustFilename = pathToStores + "/"+ trustStoreFile;
		
		System.setProperty("javax.net.ssl.trustStore", trustFilename);
		System.setProperty("javax.net.ssl.trustStorePassword", passwd);
		 if (debug)
	            System.setProperty("javax.net.debug", "all");
		 
		// java -Djavax.net.ssl.trustStore=/tmp/trustFilename -Djavax.net.ssl.trustStorePassword=123456 SSLClientExample 
		 new SSLClientExample().doClientSide();
		 

	}

}
