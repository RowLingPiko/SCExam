package cn.voidtech.uniapp.entity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

/**
 * 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "work_info")
public class WorkInfoEntity {

    /**
     * 唯一标识
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 封面图
     */
    @Column(value = "poster")
    private String poster;

    /**
     * 稿件名
     */
    @Column(value = "name")
    private String name;

    /**
     * 作者名
     */
    @Column(value = "author")
    private String author;

    /**
     * 视频简介
     */
    @Column(value = "detail")
    private String detail;

    /**
     * 关联视频的id
     */
    @Column(value = "relationvid")
    private Integer relationvid;

    /**
     * 发布时间
     */
    @Column(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.util.Date createTime;


}
