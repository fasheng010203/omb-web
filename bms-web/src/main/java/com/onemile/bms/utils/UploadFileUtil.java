package com.onemile.bms.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author ericma
 */
public class UploadFileUtil {

	protected static final Logger logger = LoggerFactory.getLogger(UploadFileUtil.class);

    public  static String  uploadFile(MultipartFile file, String prefix,String filePath){

            String name = file.getOriginalFilename();
			if(!StringUtils.hasLength(name)){
				return null;
			}
		    String userStr = ToolUtil.getRandomString(6);

            int index = name.lastIndexOf(".");
            String suffix = "";
            if(index !=-1){
                suffix = name.substring(index);
            }
            String timeStr =new SimpleDateFormat("MMddHHmmss").format(new Date());
            String newName =  prefix+"_"+timeStr+"_"+userStr+suffix;

            try {
                //暂时先上传到本地
                String dir=filePath;
				File fileDir = new File(dir);
				if (!fileDir.exists()){
					fileDir.mkdirs();
					logger.debug("---------目录不存在-------:"+dir+"已创建");
				}
                File saveFile=new File(dir+"/"+newName);
				file.transferTo(saveFile);
				logger.info("---------文件上传成功-------");

            } catch (IOException e) {
                newName=null;
				logger.error("==========上传失败=======",e);
            }

        return newName;
    }


}
