/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author HL
 */
public class FileDAO {
    
    public static String readFile(String fileName)
    {   String data = "";
        File ff = new File(fileName);
        if(ff.exists()){
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(ff);
            bf = new BufferedReader(f);
            while(bf.ready())
            {
                data += bf.readLine() + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(bf != null) bf.close();
                if(f != null) f.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        } else { data = "No Description"; }
        return data;
    }
    
    public static boolean writeFile(String fileName, String data)
    {
        boolean check = false;
        File f = null;
        PrintWriter pw = null;
        try {
            f = new File(fileName);
            pw = new PrintWriter(f);
            pw.println(data);
            pw.flush();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(pw != null) pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }
    
    public static void copyFile(String source, String folderDes, String destination) throws Exception{
        byte[] rs = null;
        File f = null;
        FileInputStream fi = null;
        FileOutputStream fo = null;
        f = new File(source);
        if(f.exists())
        {
            fi = new FileInputStream(f);
            int sizeFile = fi.available();
            rs = new byte[sizeFile];
            fi.read(rs);
            fi.close();
            f = new File(folderDes);
            if(!f.isDirectory())
                f.mkdir();
            else{
                File ff = new File(folderDes + "/" + destination);
                if(f.exists())
                    if(ff.isFile())
                        ff.delete();
                fo = new FileOutputStream(ff);
                fo.write(rs);
                fo.flush();
                fo.close();
            } 
        }else throw new Exception(" File is not existed.!");
    }
    
    public static boolean deleteFile(String fileName) throws Exception{
        File f = new File(fileName);
        return f.delete();
    }
   
}
