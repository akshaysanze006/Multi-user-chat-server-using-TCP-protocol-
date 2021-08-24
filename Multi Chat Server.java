import java.io.*; 
import java.net.*; 
public class Server implements Runnable 
{ 
Thread t; 
ServerSocket svr;

Socket client; 
public static Clientthreads[] ths=new Clientthreads[15];  
public Server(int portno) //constructor 
{ 
try 
{ 
svr=new ServerSocket(portno); 
for(int i=0;i<15;i++) 
ths[i]=null; 
} 
catch(Exception e) 
{ 
System.out.println("error :"+e); 
} 
} 
public void run() 
{ 
try 
{ int i=0; 
while(true) 
{ 
client=svr.accept(); 
BufferedReader br=new BufferedReader(new  
InputStreamReader(client.getInputStream())); 
String names=br.readLine(); 
if(ths[i]==null) 
{ (ths[i]=new Clientthreads(client,ths,names,i)).start(); 
System.out.println("Connected to "+names); 
i++; 
} 
} 
} 
catch(Exception e) 
{ 
System.out.println("Error !!:"+e); 
} 
} 
public static void main(String args[]) 
{ 
Server s=new Server(2222);

s.t=new Thread(s); 
s.t.start(); 
} 
} 
class Clientthreads extends Thread 
{ 
BufferedReader buf; 
PrintWriter out; 
String str,a; 
String sendmsg[]; 
Socket client; 
Clientthreads[] ths; 
int id; 
public static String[] names=new String[15]; 
public Clientthreads(Socket client,Clientthreads[] threads,String name,int i) { 
try 
{ 
this.client=client; 
ths=threads; 
this.names[i]=name; 
this.id=i; 
buf=new BufferedReader(new InputStreamReader(client.getInputStream())); out=new PrintWriter(client.getOutputStream(),true); 
for(int g=0;ths[g]!=null;g++) 
if(!(names[id].equals(names[g]))) 
ths[g].out.println("A new user"+names[id]+" has entered"); 
} 
catch(Exception e) 
{ System.out.println("Error :"+e); 
} 
} 
public void run()


{ ths[id].out.println("Login Successful!! : "+names[id]); 
while(true) 
{ 
try 
{ 
str=buf.readLine(); 
if(str.equals("quit")) 
{ 
for(int g=0;ths[g]!=null;g++) 
if(!(names[id].equals(names[g]))) 
ths[g].out.println("The user  
"+names[id]+" has left "); 
ths[id]=null; 
break; 
} 
sendmsg=str.split("//"); 
String nm=sendmsg[0]; 
for(int g=0;ths[g]!=null;g++) 
if(nm.equals(names[g])) 
ths[g].out.println(names[id]+" ::  
"+sendmsg[1]); 
} 
catch(Exception e) 
{ System.out.println("error :"+e); 
} 
} 
} 
} 
