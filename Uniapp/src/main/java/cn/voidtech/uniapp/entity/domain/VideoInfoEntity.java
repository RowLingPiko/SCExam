package cn.voidtech.uniapp.entity.domain;

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
@Table(value = "video_info")
public class VideoInfoEntity {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    @Column(value = "filename")
    private String filename;

    @Column(value = "url")
    private String url;

    @Column(value = "poster")
    private String poster;

    @Column(value = "upload_time")
    private java.util.Date uploadTime;

    @Column(value = "delete")
    private Boolean delete;


}
