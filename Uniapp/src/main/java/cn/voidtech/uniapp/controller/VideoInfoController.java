package cn.voidtech.uniapp.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import cn.voidtech.uniapp.service.VideoInfoService;
import cn.voidtech.uniapp.entity.domain.VideoInfoEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequestMapping("/videoInfo")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    /**
     * 添加
     *
     * @param videoInfo
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    public boolean save(@RequestBody VideoInfoEntity videoInfo) {
        return videoInfoService.save(videoInfo);
    }


    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return videoInfoService.removeById(id);
    }


    /**
     * 根据主键更新
     *
     * @param videoInfo
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    public boolean update(@RequestBody VideoInfoEntity videoInfo) {
        return videoInfoService.updateById(videoInfo);
    }


    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    public List<VideoInfoEntity> list() {
        return videoInfoService.list();
    }


    /**
     * 根据主键获取详细信息。
     *
     * @param id videoInfo主键
     * @return 详情
     */
    @GetMapping("/getInfo/{id}")
    public VideoInfoEntity getInfo(@PathVariable Serializable id) {
        return videoInfoService.getById(id);
    }


    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page<VideoInfoEntity> page(Page<VideoInfoEntity> page) {
        return videoInfoService.page(page);
    }
}