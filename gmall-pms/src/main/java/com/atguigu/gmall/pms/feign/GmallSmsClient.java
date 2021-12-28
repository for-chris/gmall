package com.atguigu.gmall.pms.feign;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.sms.api.GmallSmsApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author chris
 * @Time 2021/12/28 16:40
 * @Descripition
 */
@FeignClient("sms-service")
public interface GmallSmsClient extends GmallSmsApi {

}
