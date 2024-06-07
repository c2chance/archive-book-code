package com.car.manage.controller;

import com.car.manage.common.constants.Constants;
import com.car.manage.common.constants.New;
import com.car.manage.dto.PermissionDTO;
import com.car.manage.system.entity.Permission;
import com.car.manage.system.entity.Role;
import com.car.manage.system.service.PermissionService;
import com.car.manage.system.service.RoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * 角色相关接口.
 */
@Controller
@RequestMapping("/car/roles")
public class RoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 首页.
     *
     * @param map map
     * @return index
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Model map) {
        List<Role> roles = roleService.findAll();
        map.addAttribute("roles", roles);
        return "car/role/index";
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
        roleService.delete(id);
        attributes.addFlashAttribute(Constants.INFO, "删除成功!");
        return new ModelAndView("redirect:/car/roles");
    }

    /**
     * 创建角色.
     *
     * @param map map
     * @return path
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String create(Map<String, Object> map) {
        List<Permission> permissions = permissionService.findAll();
        map.put("permissions", PermissionDTO.convert(permissions));
        return "/car/role/create";
    }

    /**
     * 创建角色.
     *
     * @param role       role
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView.
     * @return 列表页面
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String save(@Validated(New.class) Role role, RedirectAttributes attributes) {
        Boolean exist = roleService.isExist(-1L, role.getName());

        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "名称已存在!");
            attributes.addFlashAttribute("role", role);
            return "redirect:/car/roles/new";
        }

        roleService.create(role);
        attributes.addFlashAttribute(Constants.INFO, "添加成功!");
        return "redirect:/car/roles";
    }

    /**
     * 更新角色.
     *
     * @param id  role id
     * @param map map
     * @return edit
     */
    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("role", roleService.findById(id));
        List<Permission> permissions = permissionService.findAll();
        map.put("permissions", PermissionDTO.convert(permissions));
        return "/car/role/edit";
    }

    /**
     * 更新角色.
     *
     * @param role       角色bean
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView.
     * @return to index page
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public String update(Role role, RedirectAttributes attributes) {
        Boolean exist = roleService.isExist(role.getId(), role.getName());

        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "名称已存在!");
            attributes.addFlashAttribute("role", role);
            return "redirect:/car/roles/new";
        }

        roleService.update(role);
        attributes.addFlashAttribute(Constants.INFO, "更新成功!");
        return "redirect:/car/roles";
    }

    /**
     * 判断id不为指定id的名称是否存在.
     *
     * @param name 指定的名称
     * @param id   id
     * @return true 存在，否则 false
     */
    @RequestMapping(value = "/checkName", method = RequestMethod.GET)
    @ResponseBody
    public Boolean checkName(@RequestParam("name") String name,
                             @RequestParam(value = "id", defaultValue = "-1") Long id) {
        return roleService.isExist(id, name);
    }
}
