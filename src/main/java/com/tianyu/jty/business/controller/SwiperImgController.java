package com.tianyu.jty.business.controller;

import com.tianyu.jty.business.entity.SwiperImgEntity;
import com.tianyu.jty.business.service.SwiperImgService;
import com.tianyu.jty.common.persistence.Page;
import com.tianyu.jty.common.persistence.PropertyFilter;
import com.tianyu.jty.common.utils.FileUtils;
import com.tianyu.jty.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("business/swiper")
public class SwiperImgController extends BaseController{

    private static String SWIPER_PATH = "E://all_images/swiper/";
    private static String SWIPER_URL = "http://192.168.1.205:8080/swiper/";

    @Autowired
    private SwiperImgService swiperImgService;


    /**
     * 默认页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list() {

        return "swiper/swiperList";
    }


    /**
     * 获取所有swiper
     */
    @RequestMapping(value="json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getData(HttpServletRequest request) {
        Page<SwiperImgEntity> page = getPage(request);
        List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
        page = swiperImgService.search(page, filters);
        return getEasyUIData(page);
    }


    /**
     * 添加swiper跳转
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String swiperCreateForm(Model model) {
        model.addAttribute("swiper", new SwiperImgEntity());
        model.addAttribute("action", "create");
        return "swiper/swiperForm";
    }


    /**
     * 添加swiper
     */
    @RequiresPermissions("bus:swiper:add")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@Valid SwiperImgEntity swiper, MultipartFile file) {
        //无图片上传点击添加提示用户添加失败：无图片上传
        if(file.isEmpty()){
            return "no";
        }else{
            String fileName = file.getOriginalFilename();
            String suffix  = fileName.substring(fileName.lastIndexOf("."));

            String picName = "swiper_" + (int)(Math.random()*100) + suffix;
            try {
                FileUtils.uploadFile(file.getBytes(), SWIPER_PATH, picName);
            } catch (Exception e) {
            }
            swiper.setImgPath(SWIPER_URL + picName);
            swiperImgService.save(swiper);
        }
        return "success";
    }



    /**
     * 删除swiper
     */
    @RequiresPermissions("bus:swiper:delete")
    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id) {
        String swiper_url = swiperImgService.get(id).getImgPath();
        String swiperName = swiper_url.substring(swiper_url.lastIndexOf("/") + 1, swiper_url.length());
        FileUtils.deleteFile(SWIPER_PATH + swiperName);
        swiperImgService.delete(id);
        return "success";
    }




}
