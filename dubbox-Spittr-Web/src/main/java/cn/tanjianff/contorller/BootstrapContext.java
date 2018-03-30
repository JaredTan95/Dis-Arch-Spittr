package cn.tanjianff.contorller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tanjian on 2017/6/15.
 */
public class BootstrapContext {
    private static ClassPathXmlApplicationContext context;
    private BootstrapContext(){

    }
    public static ClassPathXmlApplicationContext getContext() throws Exception{
       if(context==null){
           synchronized (BootstrapContext.class){
               if(context==null){
                   context = new ClassPathXmlApplicationContext(new String[]{"dubbo-Spittr-consumer-web.xml"});
               }
           }
       }
       return context;
    }

}
