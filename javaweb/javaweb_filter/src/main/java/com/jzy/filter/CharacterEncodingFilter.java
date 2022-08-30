package com.jzy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/12
 * Time: 下午 2:41
 * Description:
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    //初始化
    //web服务器启动的时候，初始化就会执行，随时等待过滤
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("已经初始化了");
    }

    @Override
    //Chain：链
    /**
     * chain 链
     * 1.过滤器中的代码，在过滤特定请求的时候会执行
     * 2.必须让过滤器继续通行
     *   chain.doFilter(request, response);
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        System.out.println("CharacterEncodingFilter执行前");
        //让请求继续走，如果不写程序到这里就被拦截停止了！
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("CharacterEncodingFilter执行后");
    }

    @Override
    //销毁
    public void destroy() {
        System.out.println("已经销毁了");
    }
}
