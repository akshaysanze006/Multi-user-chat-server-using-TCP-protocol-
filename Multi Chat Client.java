import java.io.*; 
import java.net.*; 
public class Client implements Runnable

{ 
Thread t1=null,t2=null; 
public static int portno=2222; 
Socket client; 
BufferedReader br,buf; 
PrintWriter out; 
String str,a; 
public Client() //constructor 
{ 
try 
{ str=" "; 
client=new Socket("127.0.0.1",portno); 
System.out.println("connecting via port no .. "+portno); 
buf=new BufferedReader(new  
InputStreamReader(client.getInputStream())); 
br=new BufferedReader(new InputStreamReader(System.in)); 
out=new PrintWriter(client.getOutputStream(),true); 
System.out.println("enter your username"); 
str=br.readLine(); 
out.println(str); 
} 
catch(Exception e) 
{ 
System.out.println("error :"+e); 
} 
} 
public void run() 
{ 
while(true) 
{ 
if(Thread.currentThread()==t1) 
{ 
try 
{ 
str=br.readLine(); 
out.println(str); 
} 
catch(Exception e) 
{ System.out.println("error :"+e);

} 
} 
else 
{ try 
{ 
a=buf.readLine(); 
System.out.println(a); 
} 
catch(Exception e) 
{ System.out.println("error :"+e); 
} 
} 
if(str.equals("quit")) 
{ break; 
} 
} 
} 
 public static void main(String args[]) 
{ 
Client s=new Client(); 
s.t1=new Thread(s); 
s.t2=new Thread(s); 
s.t1.start(); 
s.t2.start(); 
}} 
