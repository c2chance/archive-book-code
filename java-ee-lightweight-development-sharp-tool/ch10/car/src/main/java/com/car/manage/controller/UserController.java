package com.car.manage.controller;

import com.car.manage.common.constants.Constants;
import com.car.manage.common.constants.New;
import com.car.manage.system.entity.User;
import com.car.manage.system.search.UserSearch;
import com.car.manage.system.service.RoleService;
import com.car.manage.system.service.UserService;
import com.car.manage.utils.CryptographyUtil;
import com.car.manage.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * 系统后台用户操作接口.
 */
@Controller
@RequestMapping("/car/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 后台用户首页信息.
     *
     * @param map        存放所有用户信息.
     * @param userSearch 查询条件
     * @return 后台用户首页页面.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Map<String, Object> map, UserSearch userSearch) {
        userSearch.setSize(Constants.PAGE_SIZE);
        userSearch.setPage(0);
        Page<User> pages = userService.findAll(userSearch);
        List<User> users = pages.getContent();
        Integer totalPages = pages.getTotalPages();
        Long totalElements = pages.getTotalElements();
        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        map.put("users", users);
        return "car/user/index";

    }

    /**
     * 后台用户首页信息.
     *
     * @return 后台用户首页页面.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "car/user/add";

    }


    /**
     * 分页条件查询.
     *
     * @param userSearch 条件查询
     * @return users
     */
    @RequestMapping(value = "/userSearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<User> pageSearch(UserSearch userSearch) {
        Page<User> pages = userService.findAll(userSearch);
        return pages;
    }


    /**
     * 新增用户.
     *
     * @param user       页面输入的用户对象.
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView..
     * @return 响应结果.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@Validated(New.class) User user, RedirectAttributes attributes) {

        Boolean exist = userService.isExist(-1L, user.getUsername());
        if (user.getOrganization().getId() == null) {
            attributes.addFlashAttribute(Constants.ERROR, "请选择单位!");
            attributes.addFlashAttribute("user", user);
            return "redirect:/car/users/add";
        }

        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "名称已存在!");
            attributes.addFlashAttribute("user", user);
            return "redirect:/car/users/add";
        }

        String password = CryptographyUtil.md5(user.getPassword(), Constants.SALT);
        user.setPassword(password);

        userService.create(user);
        attributes.addFlashAttribute(Constants.INFO, "添加成功!");
        return "redirect:/car/users";
    }

    /**
     * 更新用户信息.
     *
     * @param id  用户选择的对象id
     * @param map 向页面传递参数
     * @return 响应结果.
     */
    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("user", userService.findById(id));
        return "/car/user/edit";
    }

    /**
     * 更新保存用户信息.
     *
     * @param user       页面响应的用户对象
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView..
     * @return 跳转页面
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public String update(User user, RedirectAttributes attributes) {
        User user1 = userService.findByUsername(user.getUsername());
        if (user1 != null) {
            if (user1.getId() != user.getId()) {
                attributes.addFlashAttribute(Constants.ERROR, "名称已存在!");
                attributes.addFlashAttribute("user", user);
                return "redirect:/car/users/" + user.getId() + "/edit";
            }
        }

        User reason = userService.findById(user.getId());
        if (!user.getPassword().equals(reason.getPassword())) {
            String password = CryptographyUtil.md5(user.getPassword(), Constants.SALT);
            user.setPassword(password);
        }

        userService.update(user);
        attributes.addFlashAttribute(Constants.INFO, "更新成功!");
        return "redirect:/car/users";
    }

    /**
     * 删除用户信息.
     *
     * @param id 页面选择的用户id.
     * @return 响应结果.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message<User> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new Message<>();
    }

    /**
     * 条件分页查询.
     *
     * @param userSearch userSearch.
     * @return Message<User>  message.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message<Page<User>> findPage(UserSearch userSearch) {
        Page<User> page = userService.findPage(userSearch);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Page<User> :" + page.toString());
        }
        return new Message<>(Boolean.TRUE, page);
    }

    /**
     * 根据id删除角色.
     *
     * @param id         id
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView.
     * @return Message<Role>
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        userService.delete(id);
        attributes.addFlashAttribute(Constants.INFO, "删除成功!");
        return new ModelAndView("redirect:/car/users");
    }

    /**
     * 分配权限.
     *
     * @param id  用户选择的对象id
     * @param map 向页面传递参数
     * @return 响应结果.
     */
    @RequestMapping(value = "{id}/allot", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String allot(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("user", userService.findById(id));
        map.put("roles", roleService.findAll());
        return "/car/user/allot";
    }

    /**
     * 分配权限.
     *
     * @param id   用户对象id
     * @param role 角色id数组
     * @return 响应结果.
     */
    @RequestMapping(value = "/allot", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String allot(Long id, Long[] role) {
        userService.allot(id, role);

        return "redirect:/car/users";
    }
}
