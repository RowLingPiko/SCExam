package cn.voidtech.gatewayserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/20 17:18
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@RestController
public class GateWayController {
    @RequestMapping("/fallback")
    public String fallback() {
        return "fallback";
    }
}
