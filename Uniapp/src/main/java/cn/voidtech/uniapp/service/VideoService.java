package cn.voidtech.uniapp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/19 22:46
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@FeignClient("video-Service")
public interface VideoService {
    @RequestMapping("/")
    String basic();

    @PostMapping(name = "uploadVideo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String,Object> uploadVideo(@RequestPart("file") MultipartFile file);
}
