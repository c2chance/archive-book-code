package com.car.manage.dto;

import com.car.manage.system.entity.Organization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

/**
 * tree node.
 */
public class OrganizationTreeNode {
    private Long id;
    @JsonProperty("pId")
    private Long pId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * pId 获取.
     *
     * @return pId
     */
    public Long getpId() {
        return pId;
    }

    /**
     * pId 生成.
     *
     * @param pId pid
     */
    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * convert organization list to tree node list.
     *
     * @param organizations organization list
     * @return tree node list
     */
    public static List<OrganizationTreeNode> convert(List<Organization> organizations) {
        return organizations.stream().map(OrganizationTreeNode::convertNode).collect(Collectors.toList());
    }

    private static OrganizationTreeNode convertNode(Organization organization) {
        OrganizationTreeNode node = new OrganizationTreeNode();
        node.setId(organization.getId());
        node.setName(organization.getName());

        if (organization.getParent() == null) {
            node.setpId(0L);
        } else {
            node.setpId(organization.getParent().getId());
        }

        return node;
    }
}
