package cn.voidtech.uniapp.controller;

import cn.voidtech.uniapp.entity.dto.LoginDTO;
import cn.voidtech.uniapp.entity.dto.RegisterDTO;
import cn.voidtech.uniapp.entity.vo.Result;
import cn.voidtech.uniapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/20 14:54
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("user/login")
    public Result<Object> login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }

    @PostMapping("user/register")
    public Result<Object> register(@RequestBody RegisterDTO registerDTO){
        return userService.register(registerDTO);
    }

    @RequestMapping("image/upload")
    public Result<Object> uploadAvatar(MultipartFile file){
        return userService.uploadAvatar(file);
    }

}
