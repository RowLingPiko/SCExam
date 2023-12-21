package cn.voidtech.userservice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(value = "user_info")
public class UserInfoEntity {

    /**
     * 唯一标识
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 登录账号
     */
    @Column(value = "username")
    private String username;

    /**
     * 登录密码
     */
    @Column(value = "password")
    private String password;

    /**
     * 昵称
     */
    @Column(value = "nickname")
    private String nickname;

    /**
     * 头像
     */
    @Column(value = "avatar")
    private String avatar;


}
