package com.tianyu.jty.business.controller;

import com.tianyu.jty.business.entity.GoodsAllTypeEntity;
import com.tianyu.jty.business.service.GoodsAllTypeService;
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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("business/goodsAllType")
public class GoodsAllTypeController extends BaseController {

    @Autowired
    private GoodsAllTypeService goodsAllTypeService;

    /**
     * 默认页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list() {

        return "goodsAllType/goodsAllTypeList";
    }

    /**
     * 商品类型集合(JSON)
     */
    @RequestMapping(value="list/json",method = RequestMethod.GET)
    @ResponseBody
    public List<GoodsAllTypeEntity> menuDate(){
        List<GoodsAllTypeEntity> typeList = goodsAllTypeService.getAllList();
        return typeList;
    }


    /**
     * 一级商品类型集合(JSON)
     */
    @RequestMapping(value="list/firstTypeList",method = RequestMethod.GET)
    @ResponseBody
    public List<GoodsAllTypeEntity> firstTypeList(){
        List<GoodsAllTypeEntity> typeList = goodsAllTypeService.getFirstTypeList();
        return typeList;
    }

    /**
     * 删除check
     */
    @RequiresPermissions("bus:type:delete")
    @RequestMapping(value = "canDel/{id}")
    @ResponseBody
    public String canDel(@PathVariable("id") Integer id) {
        GoodsAllTypeEntity entity = goodsAllTypeService.get(id);
        Integer pid = entity.getPid();
        //pid为null说明是一级商品类型，判断是否有二级类型是在这个类型下
        if(pid == null){
            boolean canDel = goodsAllTypeService.canDel(id);
            if(canDel){
                return "success";
            }else{
                return "no";
            }

        }else{
            //pid不为null为二级商品类型，判断是否有商品已经选了这个类型
            boolean canDel = false;
            if(canDel){
                return "success";
            }else{
                return "no";
            }
        }
    }



    /**
     * 删除
     */
    @RequiresPermissions("bus:type:delete")
    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id) {
        goodsAllTypeService.delete(id);
        return "success";
    }


    /**
     * 添加类型跳转
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String typeCreateForm(Model model) {
        model.addAttribute("goodsAllType", new GoodsAllTypeEntity());
        model.addAttribute("action", "create");
        return "goodsAllType/typeForm";
    }


    /**
     * 添加类型
     */
    @RequiresPermissions("bus:type:add")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@Valid GoodsAllTypeEntity goodsAllType, MultipartFile file1, MultipartFile file2) {

        if(!file1.isEmpty()) {
            if (file2.isEmpty()) {//添加的是一级类型
                String bannerBaseUrl = "http://192.168.1.205:8080/banner/";
                String fileName = file1.getOriginalFilename();
                String suffix  = fileName.substring(fileName.lastIndexOf("."));

                String picName = goodsAllType.getName() + suffix;
                System.out.println(picName);
                try {
                    FileUtils.uploadFile(file1.getBytes(), "E://all_images/banner/", picName);
                } catch (Exception e) {
                }
                goodsAllType.setBanner(bannerBaseUrl + picName);
            } else {//添加的是二级类型
                //1先添加二级类型的banner
                String bannerBaseUrl = "http://192.168.1.205:8080/banner/second_banner/";
                String fileName = file1.getOriginalFilename();
                String suffix  = fileName.substring(fileName.lastIndexOf("."));

                String picName = goodsAllType.getName() + suffix;
                try {
                    FileUtils.uploadFile(file1.getBytes(), "E://all_images/banner/second_banner/", picName);
                } catch (Exception e) {
                }
                goodsAllType.setBanner(bannerBaseUrl + picName);

                //2再添加二级类型的indexImg
                String indexImgBaseUrl = "http://192.168.1.205:8080/banner/index/";
                String fileName2 = file2.getOriginalFilename();
                String suffix2  = fileName2.substring(fileName2.lastIndexOf("."));

                String picName2 = goodsAllType.getName() + suffix2;
                try {
                    FileUtils.uploadFile(file2.getBytes(), "E://all_images/banner/index/", picName2);
                } catch (Exception e) {
                }
                goodsAllType.setIndexImg(indexImgBaseUrl + picName2);
            }
        }

        goodsAllTypeService.save(goodsAllType);

        return "success";
    }


}
