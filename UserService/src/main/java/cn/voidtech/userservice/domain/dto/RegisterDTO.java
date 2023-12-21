package cn.voidtech.userservice.domain.dto;

import lombok.Data;

/**
 * @author RowLingKaslana
 * @project ACGBase
 * @date 2023/12/11 9:26
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Data
public class RegisterDTO {
    private String nickname;
    private String username;
    private String password;
    private String avatar;
}
