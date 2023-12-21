package cn.voidtech.userservice.domain;

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
@Table(value = "image_info")
public class ImageInfoEntity {

    /**
     * 唯一标识
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 文件名
     */
    @Column(value = "filename")
    private String filename;

    /**
     * 路径名
     */
    @Column(value = "url")
    private String url;

    /**
     * 是否删除
     */
    @Column(value = "delete")
    private Boolean delete;


}
