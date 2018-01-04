package com.service.hive.filter;


import com.netflix.ribbon.ext.support.RibbonFilterContextHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class BlueGreenZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            Object blueOrGreen = request.getParameter("blue-green");

            RibbonFilterContextHolder.clearCurrentContext();
            if (blueOrGreen != null && blueOrGreen.equals("blue")) {
                RibbonFilterContextHolder.getCurrentContext().add("blue-green", "blue");
            } else {
                RibbonFilterContextHolder.getCurrentContext().add("blue-green", "green");
            }

        } catch (Exception e) {
            ReflectionUtils.rethrowRuntimeException(e);
        }
        return null;
    }
}

