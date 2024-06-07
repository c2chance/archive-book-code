package com.car.manage.controller;

import com.car.manage.common.constants.Constants;
import com.car.manage.common.constants.New;
import com.car.manage.system.entity.Notice;
import com.car.manage.system.search.NoticeSearch;
import com.car.manage.system.service.NoticeManagerService;
import com.car.manage.view.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * 短消息管理.
 */
@Controller
@RequestMapping("/car/noticeManager")
public class NoticeManagerController {
    @Autowired
    private NoticeManagerService noticeManagerService;

    /**
     * 首页.
     *
     * @param map map
     * @return index
     */
    @RequestMapping(method = RequestMethod.OPTIONS, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Model map) {
        List<Notice> noticeList = noticeManagerService.findAll();
        map.addAttribute("noticeList", noticeList);
        return "car/noticeManager/index";
    }



    /**
     * 首页.
     *
     * @param map 存放所有短消息信息.
     * @param noticeSearch 分页查询条件
     * @return 首页页面.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Map<String, Object> map, NoticeSearch noticeSearch) {
        noticeSearch.setSize(Constants.PAGE_SIZE);
        noticeSearch.setPage(0);
        Page<Notice> pages = noticeManagerService.findAll(noticeSearch);
        List<Notice> notices = pages.getContent();
        Integer totalPages = pages.getTotalPages();
        Long totalElements = pages.getTotalElements();
        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        map.put("notices", notices);
        return "car/noticeManager/index";

    }




    /**
     * 首页.
     *
     * @param map 存放所有短消息信息.
     * @param noticeSearch 分页查询条件
     * @return 手机首页页面.
     */
    @RequestMapping(value = "/mobile", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String mobileIndex(Model map, NoticeSearch noticeSearch) {
        noticeSearch.setSize(Constants.PAGE_SIZE);
        noticeSearch.setPage(0);
        Page<Notice> pages = noticeManagerService.findAll(noticeSearch);
/*        List<Notice> notices = pages.getContent();
        Integer totalPages = pages.getTotalPages();
        Long totalElements = pages.getTotalElements();*/
/*        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        map.put("notices", notices);*/
        map.addAttribute("pages", pages);
        return "mobile/notice/index";

    }


    /**
     * 手机端分页查询.
     *
     * @return list
     */
    @RequestMapping(value = "/mobile/queryAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Notice> query3() {
        List<Notice> list = noticeManagerService.findAll();
        return list;
    }


    /**
     * 根据id删除短消息.
     *
     * @param id         id
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView.
     * @return ModelAndView<RefuseReason>
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        noticeManagerService.delete(id);
        attributes.addFlashAttribute(Constants.INFO, "删除成功!");
        return new ModelAndView("redirect:/car/noticeManager");
    }


    /**
     * 违章查询.
     *
     * @param vId vId
     * @return url
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message deleteIds(@RequestParam(value = "vId") String vId) {
        Message message = new Message();
        message.setSuccess(Boolean.TRUE);
        message.setData("审核成功!");
        return message;
    }







    /**
     * 创建短消息.
     *
     * @param map map
     * @return 创建页面
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String create(Map<String, Object> map) {
        return "/car/noticeManager/create";
    }

    /**
     * 保存短消息.
     *
     * @param notice 短消息
     * @param attributes   attributes
     * @return index
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String save(@Validated(New.class) Notice notice, RedirectAttributes attributes) {
        Boolean exist = noticeManagerService.isExist(-1L, notice.getTitle());
        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "短消息消息已存在!");
            attributes.addFlashAttribute("refuseReason", notice);
            return "redirect:/car/noticeManager/new";
        }
        noticeManagerService.create(notice);
        attributes.addFlashAttribute(Constants.INFO, "添加成功!");
        return "redirect:/car/noticeManager";
    }

    /**
     * 更新短消息.
     *
     * @param id  refuseReason id
     * @param map map
     * @return edit
     */
    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("notice", noticeManagerService.findById(id));
        return "/car/noticeManager/edit";
    }


    /**
     *
     * @param noticeId Long noticeId
     * @param map map
     * @return details
     */
    @RequestMapping(value = "{noticeId}/queryId", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String queryId(@PathVariable("noticeId") Long noticeId, Map<String, Object> map) {
        map.put("notice", noticeManagerService.findById(noticeId));
        return "/mobile/notice/details";
    }





    /**
     * 短消息验证.
     *
     * @param notice 原因bean
     * @param attributes   A RedirectAttributes model is empty when the method is called and is never
     *                     used unless the method returns a redirect view name or a RedirectView.
     * @return to index page
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public String update(Notice notice, RedirectAttributes attributes) {
        Boolean exist = noticeManagerService.isExist(notice.getId(), notice.getTitle());
        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "审核拒绝原因已存在!");
            attributes.addFlashAttribute("notice", notice);
            return "redirect:/car/noticeManager/new";
        }
        noticeManagerService.update(notice);
        attributes.addFlashAttribute(Constants.INFO, "更新成功!");
        return "redirect:/car/noticeManager";
    }



    /**
     * 分页条件查询.
     *
     * @param noticeSearch 分页条件查询.
     * @param map          map
     * @return 短消息主页面.
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Notice> query(Map<String, Object> map, NoticeSearch noticeSearch) {
        Page<Notice> pages = noticeManagerService.findAll(noticeSearch);
        return pages;
    }

}
