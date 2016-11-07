package factorial;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class facCliente {
	public static void main(String[] args){

	
	  try{

		Scanner micky = new Scanner(System.in);
		System.out.println("teclee su puerto");
		int tuPuerto = Integer.parseInt(micky.nextLine());
		System.out.println("teclea el puerto de la otra persona");
		int puerto2 = Integer.parseInt(micky.nextLine());


		ServerSocket sConexion = new ServerSocket(tuPuerto);
		
		System.out.println("Confirmando conexion ...");
		Socket sDato = sConexion.accept();		
		System.out.println("La conexion esta establecida");
		

		InetAddress maqChat = sDato.getInetAddress();
		Socket socket = new Socket(maqChat, puerto2);
		

		InputStream fEntrada = socket.getInputStream();
		BufferedReader socketInput = new BufferedReader(new InputStreamReader(fEntrada));
		OutputStream fSalida = sDato.getOutputStream();
		PrintWriter salidaS = new PrintWriter(new OutputStreamWriter(fSalida));		


		System.out.println("Teclea su numero favorito:"); 
		String enviado = micky.nextLine();
		System.out.println("");
		salidaS.println(enviado);
		salidaS.flush(); 
		
		System.out.println("El factorial:");
		String recibido = socketInput.readLine();
		System.out.println(recibido);
		
	     

		socket.close();
		
      }
	catch (Exception ex){
	   ex.printStackTrace();
      }
     }	
    }