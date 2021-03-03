package cn.itcast.controller;

import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static cn.itcast.utils.Zip.unzip;

@RestController
public class UploadController {
    @Autowired
    private AccountService service;
//
//    @RequestMapping("/fileupload2")
//    public String fileupload2(@RequestParam("upload") File upload) throws Exception{
//        System.out.println("上传文件2");
//        String filename = upload.getName();
//        System.out.println(filename);
//        return "list";
//    }
//
//    @RequestMapping("/fileupload3")
//    public String fileupload3(HttpServletRequest request ,MultipartFile upload) throws Exception{
//        System.out.println("文件上传3");
//        String path = request.getSession().getServletContext().getRealPath("/uploads/");
//        File file = new File(path);
//        if(!file.exists()){
//            file.mkdir();
//        }
//
//
//        String filename = upload.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//        filename = uuid+"_"+filename;
//        upload.transferTo(new File(path,filename));
//        return "list";
//    }

    @RequestMapping("/fileupload4")

    public String fileupload4(MultipartFile uploadFile) throws Exception{
//        try{
//            File z = unzip(uploadFile);
//            FileInputStream zip = new FileInputStream(z);
//            BufferedReader reader = null;
//            StringBuffer sbf = new StringBuffer();
//            try{
//                reader = new BufferedReader(new InputStreamReader(zip,Charset.forName("GBK")));
//                String tempStr;
//                while((tempStr = reader.readLine()) != null){
//                    sbf.append(tempStr);
//                }
//                reader.close();
//                System.out.println(sbf.toString());
//            }catch (IOException e){
//                e.printStackTrace();
//            }finally {
//                if(reader != null){
//                    try{
//                        reader.close();
//                    }catch (IOException e1){
//                        e1.printStackTrace();
//                    }
//                }
//            }
//            System.out.println("============");
//            System.out.println(sbf.toString());
//        }catch (IOException E){
//            E.printStackTrace();
//        }

        String path = "C://tt//aa//cc//ee//";
        if(new File(path).isDirectory()){
            return "list";
        }
        File pathdir = new File(path);
        if(!pathdir.exists()){
            pathdir.mkdirs();
        }
        File file = new File(path + uploadFile.getOriginalFilename());

        uploadFile.transferTo(file);
        System.out.println(file.getName());
        System.out.println(file.getPath());
        return "list";
    }



}
