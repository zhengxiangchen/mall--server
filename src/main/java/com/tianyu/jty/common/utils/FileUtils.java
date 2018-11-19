package com.tianyu.jty.common.utils;

import bsh.commands.dir;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {

    private static Logger logger = Logger.getLogger(FileUtils.class);
	
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }



    public static boolean deleteFile(String fileName){
        File file = new File(fileName);
        if(file.isFile() && file.exists()){
            Boolean succeedDelete = file.delete();
            if(succeedDelete){
                logger.info("删除单个文件"+fileName+"成功！");
                return true;
            }
            else{
                logger.info("删除单个文件"+fileName+"失败！");
                return false;
            }
        }else{
            logger.info("删除单个文件"+fileName+"失败！");
            return false;
        }
    }


    public static void deleteDirectory(String path) throws Exception{
        File file = new File(path);
        org.apache.commons.io.FileUtils.deleteDirectory(file);
    }


}
