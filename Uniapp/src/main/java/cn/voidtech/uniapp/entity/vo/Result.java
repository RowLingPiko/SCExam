package cn.voidtech.uniapp.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

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
@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private final String tag = "By RowLingKaslana";
    private Integer code;
    private String msg;
    private T data;

    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public static Result<Object> customRespone(Integer code, String msg, Object data) {
        return new Result<>(code, msg, data);
    }

    //通过枚举响应信息(不带数据)
    public static Result<Object> setRespone(ResultEnum resultEnum) {
        return new Result<>(resultEnum, null);
    }

    //通过枚举响应信息(带数据)
    public static Result<Object> setRespone(ResultEnum resultEnum, Object data) {
        return new Result<>(resultEnum, data);
    }

    //成功的响应信息(不带数据)
    public static Result<Object> OK() {
        return new Result<>(ResultEnum.OK, null);
    }

    //成功的响应信息(带数据)
    public static Result<Object> OK(Object data) {
        return new Result<>(ResultEnum.OK, data);
    }

    //失败的响应信息
    public static Result<Object> Error() {
        return new Result<>((ResultEnum.Error), null);
    }
}
