package hearth.stone;

import java.io.*;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameAccountManager extends Game{

    private static Hashtable<String, String> verifyData = null;


    public static String getName(){
        return player.getName();
    }


    public static String getPass(){
        return verifyData.get(player.getName());
    }


    public static int addPlayer(String name, String pass){
        setVerifyData();

        if (!isNameValid(name)) return 1;
        else if (!isPassValid(pass)) return 2;

        verifyData.put(name, pass);
        player = new Human(name);
        saveData();
        return 3;
    }


    public static int enterAccount(String name, String pass){
        setVerifyData();

        try {
            if (verifyData.get(name).equals(pass)){
                player = (Human) input(name);
                saveData();
                return 1;
            }
        }catch (NullPointerException e){
            return 2;
        }
        catch (Exception e){
            System.out.println("Exception in enterAccount");
        }

        return 3;
    }


    public static void deleteAccount(){
        verifyData.remove(player.getName());

        File oldFile = new File("players/" + player.getName() + ".txt");
        oldFile.delete();
        player = null;

        saveData();
    }


    public static int setPass(String pass){
        if (verifyData.get(player.getName()).equals(pass))
            return 1;

        if (!isPassValid(pass))
            return 2;

        verifyData.put(player.getName(), pass);
        saveData();
        return 3;
    }


    public static int setName(String name){
        if (player.getName().equals(name))
            return 1;

        if (!isNameValid(name))
            return 2;

        String pass = verifyData.remove(player.getName());
        verifyData.put(name, pass);

        File oldFile = new File("players/" + player.getName() + ".txt");
        oldFile.delete();
        player.setName(name);

        saveData();

        return 3;
    }


    private static void setVerifyData(){
        if (verifyData != null)
            return;

        try {
            verifyData = (Hashtable<String, String>) input("verifyData");
        }
        catch (FileNotFoundException e){
            verifyData = new Hashtable<>();
        }catch (Exception e){
            System.out.println("Exception in setVerifyData");
        }
    }


    public static void exit(){
        saveData();
        System.exit(1);
    }


    private static void saveData(){
        try {
            output(verifyData, "verifyData");
            if (player != null)
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

        if (name.equals("")) return false;

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
