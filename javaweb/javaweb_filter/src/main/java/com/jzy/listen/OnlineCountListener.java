package com.jzy.listen;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/12
 * Time: 下午 3:28
 * Description:
 */
public class OnlineCountListener implements HttpSessionListener {
    @Override
    /**
     * 创建session监听，一旦创建session就会触发这个事件
     * @param se
     */
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId());
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if (onlineCount==null){
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);

    }

    @Override
    /**
     * 销毁session监听，一旦销毁session就会触发这个事件
     * @param se
     */
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if (onlineCount==null){
            onlineCount = new Integer(0);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
    /**
     * session的销毁
     * 1.手动销毁  getSession().invalidate();
     * 2.自动销毁
     *     <session-config>
     *         <session-timeout>1</session-timeout>
     *     </session-config>
     *
     * 3.关闭服务器
     */
}
