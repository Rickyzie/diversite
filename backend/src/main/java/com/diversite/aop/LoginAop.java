package com.diversite.aop;

import com.diversite.service.user.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAop {
    @Autowired
    private UserService userService;
//    //提高作用域
//    private Object proceed;
//    private String username;
//    private String password;
//    private HttpSession session;
//    //定义切点为controller包下的UserController类里的login()方法
//    @Pointcut("execution(* cn.wqk.springbootaop.controller.UserController.login(..))")
//    public void pointCut(){}
//    //前置通知，在前置通知里一般是给变量赋值
//    @Before("pointCut()")
//    public void before(JoinPoint joinPoint){
//        System.out.println("前置通知-----------------------");
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args=joinPoint.getArgs();
//        System.out.println("类："+className);
//        System.out.println("方法："+methodName);
//        System.out.println("传入参数：");
//        for (int i=0;i<args.length;i++){
//            System.out.println("参数"+(i+1)+"："+args[i]);
//        }
//        //将第一个参数赋值给username
//        username=(String) args[0];
//        //将第二个参数赋值给password
//        password=(String) args[1];
//        //第三个参数赋值给session，让我们能够从session中取到uid
//        session=(HttpSession)args[2];
//        System.out.println("前置通知完--------------------");
//    }
//    //环绕通知
//    /**
//     * 环绕通知：
//     *       proceed为执行方法后返回的值
//     */
//    @Around("pointCut()")
//    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("环绕通知：---------------------");
//        //获得方法执行后的返回值
//        proceed = pjp.proceed();
//        //System.out.println("执行的方法后的返回值："+proceed+"");
//        String status = (String) session.getAttribute("status");
//        if (status.equals("login")){
//            User user = (User) session.getAttribute("user");
//            Integer uid = user.getUid();
//            System.out.println(uid);
//            int logId = userLogService.insertUserLog(uid);
//            session.setAttribute("logId",logId);
//        }
//        System.out.println("环绕通知完--------------------");
//        return proceed;
//    }
}

