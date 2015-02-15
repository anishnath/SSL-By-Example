package ssl;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
Visit the channel http://youtube.com/zarigatongy
*/

public class SSLServer {
	public static void main(String[] arstring) {
		try {
			
			/**
			 * Keystore Formats Supported by Java
			 * 	1. JKS (Java Key Store) Ð this is a Java format
			 *  2. PKCS12 Ð this is an industry standard
			 *  
			 */
			
			/**
			 * The steps to creating a keystore that represents a user,
			 * application or hostname are as follows:
			 */
			
			/**
			 * 1) Generate a key pair (public / private key)

				2) Generate a Certificate Signing Request (CSR) from the key pair

				3) Get the CSR signed by the trusted CA (output of this is a certificate) 

				4) Import the certificate produced by the CA that bears your details 
				(CA's response to your signing request) into the key store

				5) Import the CA's own certificate into your keystore as a trusted certificate
			 */
			
			
			SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory
					.getDefault();
			SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory
					.createServerSocket(1234,1,InetAddress.getByName("localhost"));
			
			SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();

			InputStream inputstream = sslsocket.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(
					inputstream);
			BufferedReader bufferedreader = new BufferedReader(
					inputstreamreader);

			String string = null;
			while ((string = bufferedreader.readLine()) != null) {
				System.out.println(string);
				System.out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
