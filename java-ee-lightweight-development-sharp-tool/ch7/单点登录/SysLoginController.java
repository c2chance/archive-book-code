/**
 * @Description: �����¼
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
            // ��ת����֤���ģ�������֤����ȡcode��Ϣ
            System.out.println("�����¼redUrl======" + redUrl);

            httpResponse.sendRedirect(redUrl);
            return null;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    String userId = "";
    // Ӧ���Ѿ��������֤����code��Ϣ�Ѿ����ݹ���
    try {
        // ����code��Ϣʹ��SDK�еķ�����ȡ������Ϣ
        Token accessToken = service.getAccessToken(code);
        // ����������Ϣʹ��SDK�еķ�����ȡ�û���¼��Ϣ
        UserInfo oauthUser = new UserInfo(accessToken);
        UserInfo loginUser = oauthUser.requestUserInfo(properties.getValue("oauth.userinfo.
url"));
        System.out.println(loginUser.getId());
        userId = loginUser.getId();
        // ����Session
        System.out.println("�����¼userId======  " + userId);
        SysUser sysUser = userService.selectUserByLoginName(userId);
        if(sysUser == null){
              return "login";
        }
        // ����Session
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getLoginName(),
"dddltoken-01", false);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        // ����Session
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
