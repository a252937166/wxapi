package com.ouyang.controller;

import com.ouyang.model.User;
import com.ouyang.service.UserService;
import com.ouyang.util.FastDFSClientWrapper;
import com.ouyang.util.FastDFSFile;
import com.ouyang.util.FileManager;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Created by Duning Ouyang on 2017/4/9.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private FastDFSClientWrapper dfsClient;
    @RequestMapping(value = "/select")
    public ModelAndView insert(HttpServletRequest request) {
        ModelAndView result = new ModelAndView("index");
        List<User> userList = userService.getAll();
        request.getSession().setAttribute("aaa",1111);
        result.addObject("userList",userList);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer add(@RequestParam("file") MultipartFile attach,HttpServletRequest request)
            throws IOException, MyException {
        // 获取文件后缀名
//        String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".")+1);
//        FastDFSFile file = new FastDFSFile(attach.getBytes(),ext);
//        NameValuePair[] meta_list = new NameValuePair[4];
//        meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
//        meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
//        meta_list[2] = new NameValuePair("fileExt", ext);
//        meta_list[3] = new NameValuePair("fileAuthor", "WangLiang");
//        String filePath = FileManager.upload(file,meta_list);
        Integer session = (Integer) request.getSession().getAttribute("aaa");
        return session;
    }

}
