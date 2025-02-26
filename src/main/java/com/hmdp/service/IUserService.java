package com.mydp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mydp.dto.LoginFormDTO;
import com.mydp.dto.Result;
import com.mydp.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    Result sign();

    Result signCount();

}
