package cn.voidtech.uniapp.controller;

import cn.voidtech.uniapp.entity.domain.WorkInfoEntity;
import cn.voidtech.uniapp.entity.dto.SearchDTO;
import cn.voidtech.uniapp.entity.vo.Result;
import cn.voidtech.uniapp.entity.vo.ResultEnum;
import cn.voidtech.uniapp.mapper.WorkInfoMapper;
import cn.voidtech.uniapp.service.UserService;
import cn.voidtech.uniapp.service.VideoService;
import cn.voidtech.uniapp.service.WorkInfoService;
import com.mybatisflex.core.query.QueryWrapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import static cn.voidtech.uniapp.entity.domain.table.WorkInfoEntityTableDef.WORK_INFO_ENTITY;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/19 22:46
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@RestController
public class BasicController {
    @RequestMapping("/")
    public String basic(){
        return "uniapp";
    }

    @Autowired
    private UserService userService;
    @RequestMapping("/us")
    @CircuitBreaker(name = "delay", fallbackMethod = "errorFallBack")
    public String vs(){
        return userService.basic();
    }

    @Autowired
    private VideoService videoService;
    @RequestMapping("/vs")
    @CircuitBreaker(name = "delay", fallbackMethod = "errorFallBack")
    public String us(){
        return videoService.basic();
    }

    @Autowired
    private WorkInfoService workInfoService;
    @RequestMapping("search")
    @CircuitBreaker(name = "delay", fallbackMethod = "errorFallBack")
    public List<WorkInfoEntity> search(@RequestBody SearchDTO searchDTO) {
        System.out.println(searchDTO.getKeyword());
        return workInfoService.list(QueryWrapper.create().where(WORK_INFO_ENTITY.NAME.like(searchDTO.getKeyword())));
    }

    @Autowired
    private WorkInfoMapper workInfoMapper;

    @PostMapping("work/add")
    public Result<Object> test(@RequestBody WorkInfoEntity workInfoEntity) {
        try {
            workInfoMapper.insert(workInfoEntity, true);
        } catch (Exception e) {
            return Result.setRespone(ResultEnum.Error, e.getMessage());
        }
        return Result.OK();
    }

    public String errorFallBack(Exception e){
        return "Connection Error";
    }
}
