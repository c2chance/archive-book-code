package com.car.manage.controller;


import com.car.manage.common.constants.Constants;
import com.car.manage.dto.OrganizationTreeNode;
import com.car.manage.system.entity.Organization;
import com.car.manage.system.service.OrganizationService;
import com.car.manage.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 组织机构相关接口.
 */
@Controller
@RequestMapping("/car/organization")
public class OrganizationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private OrganizationService organizationService;

    /**
     * 首页.
     *
     * @return index
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return "car/organization/index";
    }

    /**
     * 获取tree数据.
     *
     * @return data
     */
    @RequestMapping(value = "/treeData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrganizationTreeNode> getData() {
        List<Organization> organizationList = organizationService.findAll();
        List<OrganizationTreeNode> list;

        if (organizationList != null && organizationList.size() > 0) {
            list = OrganizationTreeNode.convert(organizationList);
        } else {
            Organization organization = new Organization();
            organization.setName(Constants.ROOT);
            organizationService.create(organization);
            List<Organization> orgList = organizationService.findAll();
            list = OrganizationTreeNode.convert(orgList);
        }
        return list;
    }

    /**
     * 根据id删除组织.
     *
     * @param id id
     * @return Message<Organization>  message
     */
    @RequestMapping(value = "/deleteTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message<Organization> delete(Long id) {
        Message<Organization> message = new Message<>();

        List<Long> list = organizationService.findIdsByParentId(id);
        if (list != null && list.size() != 0) {
            message.setData("请先删除下一层级！");
            message.setSuccess(Boolean.FALSE);

            /*organizationService.deleteByParentId(list);
            List<Organization> organization = organizationService.findByIds(list);
            if (organization != null && organization.size() != 0) {
                message.setData("删除失败！");
                message.setSuccess(Boolean.FALSE);
            } else {
                message.setData("删除成功！");
                message.setSuccess(Boolean.TRUE);
            }*/
        } else {
            organizationService.delete(id);
            message.setData("删除成功！");
            message.setSuccess(Boolean.TRUE);
        }
        return message;
    }

    /**
     * 添加organization.
     *
     * @param name 节点名称
     * @param pId  父类id
     * @return Message<Organization> message
     */
    @RequestMapping(value = "/addTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message<Organization> create(String name, Long pId) {
        Message<Organization> message = new Message<>();
        Boolean exist = organizationService.isExistByParentAndName(pId, name);
        if (exist) {
            message.setSuccess(Boolean.FALSE);
            message.setData("名称已存在！");
            return message;
        }
        Organization organization = new Organization();

        if (pId != null) {
            Organization getInfo = organizationService.findById(pId);
            organization.setParent(getInfo);
        }
        organization.setName(name);
        organizationService.create(organization);
        organization = organizationService.findById(organization.getId());
        if (organization != null) {
            message.setSuccess(Boolean.TRUE);
            message.setData(organization.getId());
        } else {
            message.setSuccess(Boolean.FALSE);
            message.setData("添加失败！");
        }
        return message;
    }

    /**
     * 重命名节点.
     *
     * @param name 名称
     * @param id   id
     * @param pId  pId
     * @return organization
     */
    @RequestMapping(value = "/renameTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message<Organization> rename(String name, Long id, Long pId) {
        Message<Organization> message = new Message<>();
        Boolean exist = organizationService.isExist(id, pId, name);
        if (exist) {
            message.setSuccess(Boolean.FALSE);
            message.setData("名称已存在！");
            return message;
        }
        Organization organization = new Organization();
        organization.setName(name);
        organization.setId(id);
        organization.setParent(organizationService.findById(pId));
        Organization entity = organizationService.update(organization);
        if (entity != null) {
            message.setSuccess(Boolean.TRUE);
            message.setData("重命名成功！");
        } else {
            message.setSuccess(Boolean.FALSE);
            message.setData("重命名失败！");
        }
        return message;
    }

    /**
     * 根据id查找组织.
     *
     * @param id 组织id
     * @return organization organization bean
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message<Organization> findById(@PathVariable Long id) {
        Organization organization = organizationService.findById(id);
        return new Message<>(Boolean.TRUE, organization);
    }


    /**
     * 更新organization.
     *
     * @param organization organization bean
     * @return Message<Organization> message
     */
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message update(@RequestBody Organization organization) {
        organizationService.update(organization);
        return new Message<>();
    }

    /**
     * 返回所有组织list.
     *
     * @return Message<Student> message
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message<List<Organization>> findAll() {
        List<Organization> list = organizationService.findAll();
        return new Message<>(Boolean.TRUE, list);
    }

    /**
     * 根据name查询组织机构.
     *
     * @param name name.
     * @return Message<Organization>
     */
    @RequestMapping(value = "/findByName/{name}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message<Organization> findByName(@PathVariable String name) {
        Organization org = organizationService.findByName(name);
        return new Message<>(Boolean.TRUE, org);
    }

    /**
     * 组建Ztree.
     *
     * @return ztree node list
     */
    @RequestMapping(value = "/tree", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrganizationTreeNode> findTree() {
        List<Organization> organizations = organizationService.findAll();

        return OrganizationTreeNode.convert(organizations);
    }
}
