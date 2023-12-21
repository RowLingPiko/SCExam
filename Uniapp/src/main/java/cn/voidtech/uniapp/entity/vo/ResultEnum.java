package cn.voidtech.uniapp.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 *
 * @Project ACGBase
 * @Author RowLingKaslana
 * @Date 2023/11/3 14:33
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    OK(1, "成功"),
    Error(0, "失败"),
    ParamError(0, "参数有无"),
    ServiceError(0, "业务异常"),
    UnknownError(0, "未知异常"),
    LoginSucceed(1, "登录成功"),
    LoginError(0, "登录失败");

    private final Integer code;

    private final String msg;
}
