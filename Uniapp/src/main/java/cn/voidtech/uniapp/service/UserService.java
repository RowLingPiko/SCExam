package cn.voidtech.uniapp.service;

import cn.voidtech.uniapp.entity.dto.LoginDTO;
import cn.voidtech.uniapp.entity.dto.RegisterDTO;
import cn.voidtech.uniapp.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/19 22:45
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@FeignClient("user-Service")
public interface UserService {
    @RequestMapping("/")
    String basic();

    @PostMapping("user/login")
    Result<Object> login(@RequestBody LoginDTO loginDTO);

    @PostMapping("user/register")
    Result<Object> register(@RequestBody RegisterDTO registerDTO);

    @PostMapping(value = "image/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<Object> uploadAvatar(@RequestPart("file") MultipartFile file);
}
