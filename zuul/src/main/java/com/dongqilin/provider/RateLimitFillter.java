package com.dongqilin.provider;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * @description: 限流
 * @author: dongql
 * @date: 2019/1/11 11:08
 */
@Component
public class RateLimitFillter extends ZuulFilter {
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);//每秒放100个令牌
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        if(!RATE_LIMITER.tryAcquire()){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("没拿到令牌");
            }catch (Exception e){}

            return null;
        }
        return null;
    }
}
