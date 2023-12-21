package cn.voidtech.uniapp.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import cn.voidtech.uniapp.service.WorkInfoService;
import cn.voidtech.uniapp.entity.domain.WorkInfoEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequestMapping("/workInfo")
public class WorkInfoController {

    @Autowired
    private WorkInfoService workInfoService;

    /**
     * 添加
     *
     * @param workInfo
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    public boolean save(@RequestBody WorkInfoEntity workInfo) {
        return workInfoService.save(workInfo);
    }


    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return workInfoService.removeById(id);
    }


    /**
     * 根据主键更新
     *
     * @param workInfo
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    public boolean update(@RequestBody WorkInfoEntity workInfo) {
        return workInfoService.updateById(workInfo);
    }


    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    public List<WorkInfoEntity> list() {
        return workInfoService.list();
    }


    /**
     * 根据主键获取详细信息。
     *
     * @param id workInfo主键
     * @return 详情
     */
    @GetMapping("/getInfo/{id}")
    public WorkInfoEntity getInfo(@PathVariable Serializable id) {
        return workInfoService.getById(id);
    }


    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page<WorkInfoEntity> page(Page<WorkInfoEntity> page) {
        return workInfoService.page(page);
    }
}