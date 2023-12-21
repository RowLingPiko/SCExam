package cn.voidtech.uniapp.controller;

import cn.voidtech.uniapp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/20 14:50
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("video/upload")
    public Map<String, Object> uploadV(@RequestPart("file") MultipartFile file){
        return videoService.uploadVideo(file);
    }
}
