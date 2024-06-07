package com.car.manage.controller;

import com.car.manage.common.constants.Constants;
import com.car.manage.common.constants.New;
import com.car.manage.system.entity.Abnormal;
import com.car.manage.system.search.AbnormalSearch;
import com.car.manage.system.service.AbnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * 短消息.
 */
@Controller
@RequestMapping("/car/abnormal")
public class AbnormalController {
    @Autowired
    private AbnormalService abnormalService;

    /**
     * 首页.
     *
     * @param map map
     * @return index
     */
    @RequestMapping(method = RequestMethod.OPTIONS, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Model map) {
        List<Abnormal> abnormalList = abnormalService.findAll();
        map.addAttribute("abnormalList", abnormalList);
        return "car/abnormalManager/index";
    }



    /**
     * 首页.
     *
     * @param map 存放所有通知信息.
     * @param abnormalSearch 分页查询条件
     * @return 首页页面.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Map<String, Object> map, AbnormalSearch abnormalSearch) {
        abnormalSearch.setSize(Constants.PAGE_SIZE);
        abnormalSearch.setPage(0);
        Page<Abnormal> pages = abnormalService.findAll(abnormalSearch);
        List<Abnormal> abnormals = pages.getContent();
        Integer totalPages = pages.getTotalPages();
        Long totalElements = pages.getTotalElements();
        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        map.put("abnormals", abnormals);
        return "car/abnormalManager/index";

    }




    /**
     * 首页.
     *
     * @param map 存放所有通知信息.
     * @param abnormalSearch 分页查询条件
     * @return 手机首页页面.
     */
    @RequestMapping(value = "/mobile", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String mobileIndex(Model map, AbnormalSearch abnormalSearch) {
        abnormalSearch.setSize(Constants.PAGE_SIZE);
        abnormalSearch.setPage(0);
        Page<Abnormal> pages = abnormalService.findAll(abnormalSearch);
/*        List<Abnormal> abnormals = pages.getContent();
        Integer totalPages = pages.getTotalPages();
        Long totalElements = pages.getTotalElements();*/
/*        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        map.put("abnormals", abnormals);*/
        map.addAttribute("pages", pages);
        return "mobile/abnormal/index";

    }



    /**
     * 分页条件查询.
     *
     * @param abnormalSearch 条件查询
     * @return page集合
     */
    @RequestMapping(value = "/pageSearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Abnormal> pageSearch(AbnormalSearch abnormalSearch) {
        Page<Abnormal> pages = abnormalService.findPage(abnormalSearch);
        return pages;
    }







    /**
     * 手机端分页查询.
     *
     * @return list
     */
    @RequestMapping(value = "/mobile/queryAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Abnormal> query3() {
        List<Abnormal> list = abnormalService.findAll();
        return list;
    }


    /**
     * 根据id删除通知.
     *
     * @param id         id
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView.
     * @return ModelAndView<RefuseReason>
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        abnormalService.delete(id);
        attributes.addFlashAttribute(Constants.INFO, "删除成功!");
        return new ModelAndView("redirect:/car/abnormalManager");
    }

    /**
     * 创建通知.
     *
     * @param map map
     * @return 创建页面
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String create(Map<String, Object> map) {
        return "/car/abnormalManager/create";
    }

    /**
     * 保存通知.
     *
     * @param abnormal 通知
     * @param attributes   attributes
     * @return index
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String save(@Validated(New.class) Abnormal abnormal, RedirectAttributes attributes) {
        Boolean exist = abnormalService.isExist(-1L, abnormal.getLicense());
        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "通知消息已存在!");
            attributes.addFlashAttribute("refuseReason", abnormal);
            return "redirect:/car/abnormalManager/new";
        }
        abnormalService.create(abnormal);
        attributes.addFlashAttribute(Constants.INFO, "添加成功!");
        return "redirect:/car/abnormalManager";
    }

    /**
     * 更新通知.
     *
     * @param id  refuseReason id
     * @param map map
     * @return edit
     */
    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("abnormal", abnormalService.findById(id));
        return "/car/abnormalManager/edit";
    }


    /**
     *
     * @param abnormalId Long abnormalId
     * @param map map
     * @return details
     */
    @RequestMapping(value = "{abnormalId}/queryId", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String queryId(@PathVariable("abnormalId") Long abnormalId, Map<String, Object> map) {
        map.put("abnormal", abnormalService.findById(abnormalId));
        return "/mobile/abnormal/details";
    }





    /**
     * 通知验证.
     *
     * @param abnormal 原因bean
     * @param attributes   A RedirectAttributes model is empty when the method is called and is never
     *                     used unless the method returns a redirect view name or a RedirectView.
     * @return to index page
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public String update(Abnormal abnormal, RedirectAttributes attributes) {
        Boolean exist = abnormalService.isExist(abnormal.getId(), abnormal.getLicense());
        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "审核拒绝原因已存在!");
            attributes.addFlashAttribute("abnormal", abnormal);
            return "redirect:/car/abnormalManager/new";
        }
        abnormalService.update(abnormal);
        attributes.addFlashAttribute(Constants.INFO, "更新成功!");
        return "redirect:/car/abnormalManager";
    }



    /**
     * 分页条件查询.
     *
     * @param abnormalSearch 分页条件查询.
     * @param map          map
     * @return 通知主页面.
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Abnormal> query(Map<String, Object> map, AbnormalSearch abnormalSearch) {
        Page<Abnormal> pages = abnormalService.findAll(abnormalSearch);
        return pages;
    }

}
