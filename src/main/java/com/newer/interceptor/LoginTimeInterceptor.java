package com.newer.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class LoginTimeInterceptor extends HandlerInterceptorAdapter{

    private int openTime;
    private int closeTime;

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar cal=Calendar.getInstance();
        //获取当前小时值
        int hour=cal.get(Calendar.HOUR_OF_DAY);

        if(hour>=openTime && hour<=closeTime){
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/error.jsp");
            return false;
        }

    }
}
