package cn.voidtech.userservice.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.voidtech.userservice.domain.ImageInfoEntity;
import cn.voidtech.userservice.domain.UserInfoEntity;
import cn.voidtech.userservice.domain.dto.LoginDTO;
import cn.voidtech.userservice.domain.dto.RegisterDTO;
import cn.voidtech.userservice.domain.vo.Result;
import cn.voidtech.userservice.domain.vo.ResultEnum;
import cn.voidtech.userservice.mapper.ImageInfoMapper;
import cn.voidtech.userservice.mapper.UserInfoMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static cn.voidtech.userservice.domain.table.UserInfoEntityTableDef.USER_INFO_ENTITY;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/19 22:43
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@RestController
public class BasicController {
    @RequestMapping("/")
    public String basic() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "user-Service";
    }

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 用户登录
     * @param loginDTO
     * @return
     */
    @PostMapping("user/login")
    public Result<Object> login(@RequestBody LoginDTO loginDTO) {
        UserInfoEntity entity = userInfoMapper.selectOneByQuery(QueryWrapper.create()
                .select(USER_INFO_ENTITY.NICKNAME, USER_INFO_ENTITY.AVATAR, USER_INFO_ENTITY.ID, USER_INFO_ENTITY.USERNAME)
                .where(USER_INFO_ENTITY.USERNAME.eq(loginDTO.getUsername())).and(USER_INFO_ENTITY.PASSWORD.eq(loginDTO.getPassword())));

        if (ObjectUtil.isEmpty(entity)) {
            return Result.Error();
        } else {
            return Result.OK(entity);
        }
    }

    /**
     * 用户注册
     * @param registerDTO
     * @return
     */
    @PostMapping("user/register")
    public Result<Object> register(@RequestBody RegisterDTO registerDTO) {
        System.out.println(registerDTO);
        List<UserInfoEntity> info = userInfoMapper.selectListByQuery(QueryWrapper.create().where(USER_INFO_ENTITY.USERNAME.eq(registerDTO.getUsername())));
        if (!ObjectUtil.isEmpty(info)) {
            return Result.setRespone(ResultEnum.Error, "用户已存在");
        }

        System.out.println(info);
        try {
            userInfoMapper.insert(UserInfoEntity.builder()
                    .avatar(registerDTO.getAvatar())
                    .nickname(registerDTO.getNickname())
                    .username(registerDTO.getUsername())
                    .password(registerDTO.getPassword())
                    .build(), true);
        } catch (Exception e) {
            return Result.Error();
        }

        UserInfoEntity entity = userInfoMapper.selectOneByQuery(QueryWrapper.create()
                .select(USER_INFO_ENTITY.NICKNAME, USER_INFO_ENTITY.AVATAR, USER_INFO_ENTITY.ID, USER_INFO_ENTITY.USERNAME)
                .where(USER_INFO_ENTITY.USERNAME.eq(registerDTO.getUsername())).and(USER_INFO_ENTITY.PASSWORD.eq(registerDTO.getPassword())));

        if (ObjectUtil.isEmpty(entity)) {
            return Result.Error();
        } else {
            return Result.OK(entity);
        }
    }

    @Autowired
    private ImageInfoMapper imageInfoMapper;

    @Value("${file.base}")
    private String base;

    /**
     * 头像上传
     * @param file
     * @return
     */
    @PostMapping(value = "image/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<Object> uploadAvatar(@RequestPart("file") MultipartFile file) {


        Result<Object> result = new Result<>();

        result.setCode(201);

        String originalFilename = file.getOriginalFilename();
        String fileType = file.getContentType();
        String localname = String.valueOf(UUID.randomUUID());


        if (!Objects.equals(fileType, "image/png")) {
            result.setMsg("文件类型错误");
            return result;
        }
        File localFile = new File(base + "\\avatar\\" + localname + ".png");
        try {
            if (localFile.exists()) {
                result.setMsg("文件已存在");
                return result;
            }
            file.transferTo(localFile);
        } catch (IOException e) {
            result.setMsg("文件传输异常");
            return result;
        }

        ImageInfoEntity infoEntity = ImageInfoEntity.builder()
                .filename(originalFilename)
                .url("http://localhost:8080/api/Res/avatar/" + localname + ".png")
                .build();


        imageInfoMapper.insert(infoEntity, true);

        return Result.OK(infoEntity.getUrl());
    }
}
