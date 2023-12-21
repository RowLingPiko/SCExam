package cn.voidtech.userservice.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import cn.voidtech.userservice.service.ImageInfoService;
import cn.voidtech.userservice.domain.ImageInfoEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequestMapping("/imageInfo")
public class ImageInfoController {

    @Autowired
    private ImageInfoService imageInfoService;

    /**
     * 添加
     *
     * @param imageInfo
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    public boolean save(@RequestBody ImageInfoEntity imageInfo) {
        return imageInfoService.save(imageInfo);
    }


    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return imageInfoService.removeById(id);
    }


    /**
     * 根据主键更新
     *
     * @param imageInfo
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    public boolean update(@RequestBody ImageInfoEntity imageInfo) {
        return imageInfoService.updateById(imageInfo);
    }


    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    public List<ImageInfoEntity> list() {
        return imageInfoService.list();
    }


    /**
     * 根据主键获取详细信息。
     *
     * @param id imageInfo主键
     * @return 详情
     */
    @GetMapping("/getInfo/{id}")
    public ImageInfoEntity getInfo(@PathVariable Serializable id) {
        return imageInfoService.getById(id);
    }


    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page<ImageInfoEntity> page(Page<ImageInfoEntity> page) {
        return imageInfoService.page(page);
    }
}