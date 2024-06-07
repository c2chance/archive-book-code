package com.car.manage.system.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;

/**
 * 发送短信.
 */
public interface SmsService {
    /**
     * 发送短信.
     *
     * @param phone   phone
     * @param request request
     */
    void sendSms(String phone, SendSmsRequest request);

    /**
     * 发送短信带返回值.
     *
     * @param phone   phone
     * @param request request
     * @return boolean
     */
    Boolean sendSms2(String phone, SendSmsRequest request);
}
