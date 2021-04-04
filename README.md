# office-user
## 此项目为spring boot
### 学习目标
- spring boot学习
- 用户模块逻辑
- 网关实现
- redis
- spring MVC  
    已使用
- maven  
    已使用
- jwt  
    已经实现JWT登录验证
    ```
    导入token依赖jar包
    访问接口时：必须要在Headers头加上Authorization
    测试代码：
    只需加上注解方可实现token校验
        @UserLoginToken
        @GetMapping("/getMessage")
        public String getMessage(){
            return "你已通过验证";
        }
    ```
- Swagger2
- MyBatis  
    已使用
- Shiro
- Dubbo
- Email使用
- 手机发送短信
