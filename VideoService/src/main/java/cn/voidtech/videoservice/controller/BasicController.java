package cn.voidtech.videoservice.controller;

import cn.voidtech.videoservice.domain.VideoInfoEntity;
import cn.voidtech.videoservice.mapper.VideoInfoMapper;
import cn.voidtech.videoservice.utils.VideoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/19 22:44
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@RestController
public class BasicController {
    @RequestMapping("/")
    public String basic(){
        System.out.println();
        return "video-Service";
    }

    @Autowired
    private VideoInfoMapper videoInfoMapper;

    @Value("${file.path}")
    String base;

    @PostMapping(name = "uploadVideo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String,Object> uploadVideo(@RequestPart("file") MultipartFile file){
        HashMap<String, Object> result = new HashMap<>();
        String originalFilename = file.getOriginalFilename();
        String fileType = file.getContentType();
        String localName = String.valueOf(UUID.randomUUID());

        if (!Objects.equals(fileType, "video/mp4")) {
            result.put("msg", "文件类型错误");
            return result;
        }
        File localFile = new File(base + "\\video\\" + localName + ".mp4");
        try {
            if (localFile.exists()) {
                result.put("msg", "文件已存在");
                return result;
            }
            file.transferTo(localFile);
        } catch (IOException e) {
            result.put("msg", "文件传输异常");
            return result;
        }

        VideoUtil.getTargetThumbnail(base + "\\video\\" + localName + ".mp4", base + "\\image\\" + localName + ".jpg", 5);

        VideoInfoEntity entity = VideoInfoEntity.builder()
                .filename(originalFilename)
                .url("http://localhost:8080/api/Res/video/" + localName + ".mp4")
                .poster("http://localhost:8080/api/Res/image/" + localName + ".jpg")
                .build();


        videoInfoMapper.insert(entity, true);

        result.put("vid", String.valueOf(entity.getId()));
        result.put("poster", entity.getPoster());
        result.put("url", entity.getUrl());
        result.put("msg", "上传成功");
        return result;
    }
}
