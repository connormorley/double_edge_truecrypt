package gui;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Interface {
	
	static String[] p = new String[]{"rg+szPCjcjre+9/nAMCXtshD2/0G5c0yVgLsE7I2H4s=", "a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s=", "aVfxQ0DFP2yimnZjBv9vMNTz7JgDN2AgZqqdO7uvgX0=", "acBP/ZhnTx2GzwRgvBuxfUFRJ2OvvavdRCMuG7MGKfE=", "rklL6kYkdmdDRwjRVDskQDlYAUj2h5Bappv1rbSPgJA="};
	static String[] a = new String[5];
	static String[] b = new String[5];
	static int attempts;
	static String pass;
	static boolean flag;
	
	public static void check() throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		flag = true;
		ArrayList<String> entriesArray = new ArrayList<String>(Arrays.asList(a));
		int counter = 0;
		for(String ent : entriesArray)
		{
		hashemup(ent, counter);
		counter++;
		if(flag == false)
		{
			JOptionPane.showMessageDialog(null, "Incorrect Input", "Failure", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		}
		String comp = a[0] + a[1] + a[2] + a[3] + a[4];
		hashemup(comp, 0, true);
		frontPage.mount(pass);
		JOptionPane.showMessageDialog(null, "Hidden password is : " + pass, "Well Done", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void hashemup(String password, int counter) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
	MessageDigest sha256 = MessageDigest.getInstance("SHA-256");        
    byte[] passBytes = password.getBytes("UTF-8");
    byte[] passHash = sha256.digest(password.getBytes("UTF-8"));
    String tester = Base64.getEncoder().encodeToString(passHash);
    System.out.println(tester);
    System.out.println(p[counter]);
    if(tester.equals(p[counter]))
    	System.out.println("pass");
    else
    {
    	attempts++;
    	try {
			FileWriter writer = new FileWriter(frontPage.props, false);
			writer.write(Integer.toString(attempts));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	flag = false;
    	if(attempts >= 10)
    		frontPage.sendNotification();
    }
    return;
	}
	
	public static void hashemup(String password, int counter, boolean trigger) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
	MessageDigest sha256 = MessageDigest.getInstance("SHA-256");        
    byte[] passBytes = password.getBytes("UTF-8");
    byte[] passHash = sha256.digest(password.getBytes("UTF-8"));
    String tester = Base64.getEncoder().encodeToString(passHash);
    pass = tester;
    return;
	}
}
