package pl.pw.mini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import pl.pw.mini.PupilUser.Gender;

public class SimpleDB {
	private Map<String,Integer> usrToHash; // mapa loginu na hash hasla
	private Map<String,PupilUser> userData; // mapa hashu hasla na PupilUsera
	private Map<Integer,Set<Subject>> usrToFavSubj; // mapa loginu na ulubione przedmioty
	private Map<Integer,Set<Subject>> usrToFavSubt; // mapa loginu na ulubione podprzedmioty
	private Map<Integer,Set<PupilUser>> usrToFriends;
	public SimpleDB(){
		usrToHash = new HashMap<>();
		userData = new HashMap<>();
		usrToFavSubj = new HashMap<>();
		usrToFavSubt = new HashMap<>();
		usrToFriends = new HashMap<>();
	}
	
	private int hashCode(String passwd) {
		int hash = 7;
		for (int i = 0; i < passwd.length(); i++) {
		    hash = hash*31 + passwd.charAt(i);
		}
		return hash;
	}
	
	
	
	public void read_usrdata_db() throws FileNotFoundException {
		String strCurrentLine;
    	BufferedReader objReader = new BufferedReader(new FileReader("eclipse-enter/TutorDemo/databases/usrData"));
    	   try {
			while ((strCurrentLine = objReader.readLine()) != null) {
			   String[] data = strCurrentLine.split(";");
			   PupilUser nextpupil = new PupilUser(data[0],Integer.parseInt(data[1]),Gender.valueOf(data[2]),Integer.parseInt(data[3]));
			   userData.put(data[0],nextpupil);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean userExists(String username) {
		return usrToHash.keySet().contains(username);
	}
	
	public void read_usr_db() throws FileNotFoundException {
		String strCurrentLine;
    	BufferedReader objReader = new BufferedReader(new FileReader("eclipse-enter/TutorDemo/databases/usrToHash"));
    	   try {
			while ((strCurrentLine = objReader.readLine()) != null) {
			   String[] data = strCurrentLine.split(";");
			   usrToHash.put(data[0], Integer.parseInt(data[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 protected PupilUser CredentialsCheck(String username,String paswd) throws FileNotFoundException{
		 if(this.usrToHash.containsKey(username)) {
			 if(this.usrToHash.get(username) == hashCode(paswd)){
				 return this.userData.get(username);
			 }
		 }
		 return null;
	    }
	 protected boolean addUser(String username,String paswd,Gender gender, int age) throws IOException{
		 if(!usrToHash.containsKey(username)) {
			 PupilUser new_pupil = new PupilUser(username,0,gender,age);
			 usrToHash.put(username,hashCode(paswd));
			 FileWriter myWriter = new FileWriter("eclipse-enter/TutorDemo/databases/usrData",true);
			 BufferedWriter bw = new BufferedWriter(myWriter);
			 bw.write(username+";"+0+";"+gender.toString().toUpperCase()+";"+age);
			 bw.newLine();
			 bw.close();
			 FileWriter myWriter2 = new FileWriter("eclipse-enter/TutorDemo/databases/usrToHash",true);
			 BufferedWriter bw2 = new BufferedWriter(myWriter2);
			 bw2.write(username+";"+hashCode(paswd));
			 bw2.newLine();
			 bw2.close();
			 return true;
		 }
		 return false;
	 }
	
	
	
}
