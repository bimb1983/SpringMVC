package com.nb.bimb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-08 16:21
 **/
@Controller
@RequestMapping("/up")
public class UpFileController {
    @RequestMapping("/file")
    public String file(Model model){
        return "up/upfile";
    }

    @RequestMapping(value="/fileSave",method= RequestMethod.POST)
    public String fileSave(Model model, MultipartFile[] files, HttpServletRequest request) throws Exception{

        //文件存放的位置
        String path=request.getServletContext().getRealPath("/files");
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getSize());
            System.out.println("--------------------------");
            File tempFile=new File(path, file.getOriginalFilename());
            file.transferTo(tempFile);
        }

        System.out.println(path);
        return "up/upfile";
    }
}
