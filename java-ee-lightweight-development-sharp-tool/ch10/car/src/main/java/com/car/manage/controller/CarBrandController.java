package com.car.manage.controller;

import com.car.manage.common.constants.Constants;
import com.car.manage.common.constants.New;
import com.car.manage.system.entity.CarBrand;
import com.car.manage.system.search.CarBrandSearch;
import com.car.manage.system.service.CarBrandService;
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
 * 汽车品牌管理.
 */
@Controller
@RequestMapping("/car/carBrand")
public class CarBrandController {
    @Autowired
    private CarBrandService carBrandService;

    /**
     * 首页.
     *
     * @param map map
     * @return index
     */
    @RequestMapping(method = RequestMethod.OPTIONS, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Model map) {
        List<CarBrand> carBrandList = carBrandService.findAll();
        map.addAttribute("carBrandList", carBrandList);
        return "car/CarBrand/index";
    }



    /**
     * 汽车管理列表
     *
     * @param map 存放所有汽车品牌信息
     * @param carBrandSearch 分页查询条件
     * @return 列表
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index(Map<String, Object> map, CarBrandSearch carBrandSearch) {
        carBrandSearch.setSize(Constants.PAGE_SIZE);
        carBrandSearch.setPage(0);
        Page<CarBrand> pages = carBrandService.findAll(carBrandSearch);
        List<CarBrand> carbrands = pages.getContent();
        Integer totalPages = pages.getTotalPages();
        Long totalElements = pages.getTotalElements();
        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        map.put("carbrands", carbrands);
        return "car/carBrand/index";
    }




    /**
     * 首页.
     *
     * @param map 存放所有汽车信息.
     * @param carBrandSearch 分页查询条件
     * @return 手机首页页面.
     */
    @RequestMapping(value = "/mobile", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String mobileIndex(Model map, CarBrandSearch carBrandSearch) {
        carBrandSearch.setSize(Constants.PAGE_SIZE);
        carBrandSearch.setPage(0);
        Page<CarBrand> pages = carBrandService.findAll(carBrandSearch);
/*        List<CarBrand> carBrands = pages.getContent();
        Integer totalPages = pages.getTotalPages();
        Long totalElements = pages.getTotalElements();*/
/*        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        map.put("carBrands", carBrands);*/
        map.addAttribute("pages", pages);
        return "mobile/carBrand/index";

    }


    /**
     * 手机端分页查询.
     *
     * @return list
     */
    @RequestMapping(value = "/mobile/queryAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CarBrand> query3() {
        List<CarBrand> list = carBrandService.findAll();
        return list;
    }


    /**
     * 根据ID删除汽车品牌
     *
     * @param id         id
     * @param attributes A RedirectAttributes model is empty when the method is called and is never
     *                   used unless the method returns a redirect view name or a RedirectView.
     * @return ModelAndView<RefuseReason>
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
    	carBrandService.delete(id);
        attributes.addFlashAttribute(Constants.INFO, "删除成功!");
        return new ModelAndView("redirect:/car/carBrand");
    }

    /**
     * 新增汽车品牌
     *
     * @param map
     * @return 创建页面
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String create(Map<String, Object> map) {
        return "/car/carBrand/create";
    }

    /**
     * 保存汽车品牌
     *
     * @param carBrand 汽车
     * @param attributes
     * @return index
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String save(@Validated(New.class) CarBrand carBrand, RedirectAttributes attributes) {
        Boolean exist = carBrandService.isExist(-1L, carBrand.getCarsBrand());
        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "汽车品牌已存在!");
            attributes.addFlashAttribute("refuseReason", carBrand);
            return "redirect:/car/carBrand/new";
        }
        carBrandService.create(carBrand);
        attributes.addFlashAttribute(Constants.INFO, "添加成功!");
        return "redirect:/car/carBrand";
    }

    /**
     * 更新汽车品牌信息
     *
     * @param id
     * @param map
     * @return edit
     */
    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("carbrand", carBrandService.findById(id));
        return "/car/CarBrand/edit";
    }


    /**
     *
     * @param carBrandId Long carBrandId
     * @param map map
     * @return details
     */
    @RequestMapping(value = "{carBrandId}/queryId", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String queryId(@PathVariable("carBrandId") Long carBrandId, Map<String, Object> map) {
        map.put("carBrand", carBrandService.findById(carBrandId));
        return "/mobile/carBrand/details";
    }





    /**
     * 汽车品牌更新
     *
     * @param carBrand
     * @param attributes   A RedirectAttributes model is empty when the method is called and is never
     *                     used unless the method returns a redirect view name or a RedirectView.
     * @return to index page
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public String update(CarBrand carBrand, RedirectAttributes attributes) {
        Boolean exist = carBrandService.isExist(carBrand.getId(), carBrand.getCarsBrand());
        if (exist) {
            attributes.addFlashAttribute(Constants.ERROR, "汽车品牌已存在！");
            attributes.addFlashAttribute("carBrand", carBrand);
            return "redirect:/car/CarBrand/new";
        }
        carBrandService.update(carBrand);
        attributes.addFlashAttribute(Constants.INFO, "更新成功!");
        return "redirect:/car/carBrand";
    }



    /**
     * 分页条件查询
     *
     * @param carBrandSearch 分页条件查询
     * @param map
     * @return 汽车品牌管理列表
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<CarBrand> query(Map<String, Object> map, CarBrandSearch carBrandSearch) {
        Page<CarBrand> pages = carBrandService.findAll(carBrandSearch);
        return pages;
    }

}
