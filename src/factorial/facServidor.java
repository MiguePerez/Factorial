package factorial;

import java.net.*;
import java.io.*;
import java.math.*;
import java.util.Scanner;

public class facServidor {
	public static void main(String[] args){

	     try {


	    

		Scanner micky = new Scanner(System.in);		
		//System.out.println("teclea la IP de la otra persona");
		String ip = "192.168.9.151";
		//System.out.println("teclea su puerto");
		int tuPuerto = 5; //Integer.parseInt(micky.nextLine());
		//System.out.println("teclea el puerto de la otra persona");
		int puerto2 = 4; //Integer.parseInt(micky.nextLine());
		
	

		InetAddress maqChat = InetAddress.getByName(ip);
		Socket socket = new Socket(maqChat, puerto2);
				
		ServerSocket sConexion = new ServerSocket(tuPuerto);
		Socket sDato = sConexion.accept();
		
		InputStream fEntrada = socket.getInputStream();
		BufferedReader socketInput = new BufferedReader(new InputStreamReader(fEntrada));
		OutputStream fSalida = sDato.getOutputStream();
		PrintWriter salidaS = new PrintWriter(new OutputStreamWriter(fSalida));
			
		System.out.println("La conexion esta lista");
			

		//System.out.println("El numero:");
		String recibido = socketInput.readLine();
		//System.out.println(recibido);

		//System.out.println("Factorial:");
		BigInteger numero = BigInteger.valueOf(Integer.parseInt(recibido));
		BigInteger factorial= BigInteger.valueOf(1);
		    while ( numero!= BigInteger.valueOf(0)) {
		      factorial = new BigInteger(factorial.multiply(numero).toString());//factorial*numero;
		      numero = new BigInteger(factorial.subtract(BigInteger.valueOf(1)).toString());//numero--;
		    }
		String enviado =String.valueOf(factorial);
		//System.out.println(enviado);
		salidaS.println(enviado);
		salidaS.flush();
	  
		socket.close();
		
      }
	   catch (Exception ex){
		ex.printStackTrace();
      }
    }
  }
