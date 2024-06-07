/**
 * @Description: 单点登录
 * @Date: 2021/3/2
 */
@GetMapping("/quickLogin")
public String quickLogin(HttpServletRequest request, HttpServletResponse httpResponse, 
ModelMap mmap) {
    PropertiesUtils properties = new PropertiesUtils("ehcache/oauth.txt");
    OAuth20Config configInfo = new OAuth20Config(properties.getValue("oauth.client.id"),
        properties.getValue("oauth.client.secret"), properties.getValue("callBackUrl"),
        properties.getValue("oauth.authorize.url"), properties.getValue("oauth.accesstoken.
url"));
    IOAuth20Service service = new OAuthServiceBuilder(configInfo).build20Service();
    String code = request.getParameter("code");
    try {
        if (StringUtils.isEmpty(code)) {
            String redUrl = service.getAuthorizationUrl();
            // 跳转到认证中心，进行认证，获取code信息
            System.out.println("单点登录redUrl======" + redUrl);

            httpResponse.sendRedirect(redUrl);
            return null;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    String userId = "";
    // 应用已经发起过认证请求，code信息已经传递过来
    try {
        // 根据code信息使用SDK中的方法获取令牌信息
        Token accessToken = service.getAccessToken(code);
        // 根据令牌信息使用SDK中的方法获取用户登录信息
        UserInfo oauthUser = new UserInfo(accessToken);
        UserInfo loginUser = oauthUser.requestUserInfo(properties.getValue("oauth.userinfo.
url"));
        System.out.println(loginUser.getId());
        userId = loginUser.getId();
        // 保存Session
        System.out.println("单点登录userId======  " + userId);
        SysUser sysUser = userService.selectUserByLoginName(userId);
        if(sysUser == null){
              return "login";
        }
        // 保存Session
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getLoginName(),
"dddltoken-01", false);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        // 保存Session
        String sessionId = String.valueOf(UUID.randomUUID()).replace("-", "");
        HttpSession session = request.getSession();
        session.setAttribute("sessionId", sessionId);
        session.setAttribute("sysUser", sysUser);
    } catch (Exception e) {
        e.printStackTrace();
        return "login";
    }
    return "forward:/index";
}
