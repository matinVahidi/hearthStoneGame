package hearth.stone;

import java.io.*;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountManager extends Game{

    private static Hashtable<String, String> verifyData = null;


    public static int addPlayer(String name, String pass){
        setVerifyData();

        if (!isNameValid(name)) return 1;
        else if (!isPassValid(pass)) return 2;

        verifyData.put(name, pass);
        player = new Human(name);
        saveData();
        return 3;
    }


    public static boolean enterAccount(String name, String pass){
        setVerifyData();

        try {
            if (verifyData.get(name).equals(pass)){
                player = (Human) input(player.getName());
                saveData();
                return true;
            }
        }catch (Exception e){
            System.out.println("Exception in enterAccount");
        }

        return false;
    }


    public static void deleteAccount(){
        verifyData.remove(player.getName());

        File oldFile = new File("players/" + player.getName() + ".txt");
        oldFile.delete();
        player = null;

        saveData();
    }


    public static boolean setPass(String pass){
        if (!isPassValid(pass))
            return false;

        verifyData.put(player.getName(), pass);
        saveData();
        return true;
    }


    public static boolean setName(String name){
        if (!isNameValid(name))
            return false;

        String pass = verifyData.remove(player.getName());
        verifyData.put(name, pass);

        File oldFile = new File("players/" + player.getName() + ".txt");
        oldFile.delete();
        player.setName(name);

        saveData();

        return true;
    }


    private static void setVerifyData(){
        if (verifyData != null)
            return;

        try {
            verifyData = (Hashtable<String, String>) input("verifyData");
        }
        catch (FileNotFoundException e){
            verifyData = new Hashtable<>();
        }
    }


    private static void saveData(){
        try {
            output(verifyData, "verifyData");
            output(player, player.getName());
        }catch (Exception e){
            System.out.println("Exception in saveData");
        }
    }


    private static Object input(String fileName)
            throws IOException, ClassNotFoundException {

        String filePass = "players/" + fileName + ".txt";

        FileInputStream fI = new FileInputStream(filePass);
        ObjectInputStream oI = new ObjectInputStream(fI);
        Object obj = oI.readObject();
        oI.close();
        fI.close();

        return obj;


    }


    private static void output(Object obj, String fileName)
            throws IOException{

        String filePass = "players/" + fileName + ".txt";

        FileOutputStream fO = new FileOutputStream(filePass);
        ObjectOutputStream oO = new ObjectOutputStream(fO);
        oO.writeObject(obj);
        oO.close();
        fO.close();
    }


    private static boolean isNameValid(String name){
        String regex = "[^/\\<>*?:\"|]*";

        if (!followsPattern(regex, name)) return false;

        if (verifyData.get(name) == null) return true;

        return false;
    }


    private static boolean isPassValid(String pass){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";


        if (!followsPattern(regex, pass)) return false;
        return true;
    }


    private static boolean followsPattern(String regex, String str){
        Pattern p = Pattern.compile(regex);

        if (str == null) {
            return false;
        }

        Matcher m = p.matcher(str);

        return m.matches();
    }




}
