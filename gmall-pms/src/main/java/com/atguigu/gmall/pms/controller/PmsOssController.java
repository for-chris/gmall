package com.atguigu.gmall.pms.controller;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.atguigu.gmall.common.bean.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @Author chris
 * @Time 2021/12/26 21:50
 * @Descripition
 */
@RestController
@RequestMapping("pms/oss")
public class PmsOssController {
    String accessId = "LTAI5tG8ZCPgGNcXZeeXHNDR";
    String accessKey = "mOyPK6v5qSrQ8UmEvUBQZn9t0sqrsl";
    String endpoint = "oss-cn-shanghai.aliyuncs.com";
    String bucket = "chris-gmall";
    String host = "https://" + bucket + "." + endpoint;
//    String callbackUrl = "http://88.88.88.88:8888";
    //指定日期格式
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //用户上传文件时指定的前缀
    String dir = sdf.format(new Date());
    @GetMapping("policy")
    public ResponseVo<Object> policy() throws UnsupportedEncodingException {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            Map<String, String> respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            // respMap.put("expire", formatISO8601Date(expiration));
            return ResponseVo.ok(respMap);
    }
}
