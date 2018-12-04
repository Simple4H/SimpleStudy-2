package com.simple.controller;

import com.simple.common.ServerResponse;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Create By S I M P L E On 2018/12/04 14:35:17
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
@Controller
public class UserController {

    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @RequestMapping(value = "/register")
    public String index() {
        return "register";
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse register(User user, MultipartFile file) {
        if (file != null) {
            String newFileName = UUID.randomUUID().toString() + ".jpg";
            String path = "src/main/resources/static/image";
            File fileRoot = new File(path);
            if (!fileRoot.exists()) {
                fileRoot.mkdir();
            }
            File targetFile = new File(fileRoot.getAbsolutePath(), newFileName);
            try {
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String savePath = "/image/" + newFileName;
            user.setDetail(savePath);
        }
        return iUserService.register(user);
    }

    @RequestMapping(value = "image", method = RequestMethod.GET)
    public String a() {
        return "image";
    }

    @RequestMapping(value = "image.do", method = RequestMethod.POST)
    public String img(Integer id, Model model) {
        ServerResponse<User> userServerResponse = iUserService.info(id);
        if (userServerResponse.isSuccess()) {
            String username = userServerResponse.getData().getUsername();
            String imagePath = userServerResponse.getData().getDetail();
            model.addAttribute("username", username);
            model.addAttribute("imagePath", imagePath);
        }
        return "info";
    }
}
