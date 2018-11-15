package com.tianyu.jty.business.controller;

import com.tianyu.jty.business.entity.GoodsAllTypeEntity;
import com.tianyu.jty.business.service.GoodsAllTypeService;
import com.tianyu.jty.common.utils.FileUtils;
import com.tianyu.jty.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("business/goodsAllType")
public class GoodsAllTypeController extends BaseController {

    private static String BANNER_PATH = "E://all_images/banner/";
    private static String SECOND_BANNER_PATH = "E://all_images/banner/second_banner/";
    private static String INDEX_IMG_PATH = "E://all_images/banner/index/";

    private static String BANNER_URL = "http://192.168.1.205:8080/banner/";
    private static String SECOND_BANNER_URL = "http://192.168.1.205:8080/banner/second_banner/";
    private static String INDEX_IMG_URL = "http://192.168.1.205:8080/banner/index/";

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
        GoodsAllTypeEntity entity = goodsAllTypeService.get(id);
        Integer pid = entity.getPid();
        //pid为null说明是一级商品类型
        if(pid == null){
            //删除本地的一级类型banner图片
            String bannerUrl = entity.getBanner();
            String bannerName = bannerUrl.substring(bannerUrl.lastIndexOf("/") + 1, bannerUrl.length());
            FileUtils.deleteFile(BANNER_PATH + bannerName);
        }else{
            //第一步：删除本地二级类型banner图片
            String bannerUrl = entity.getBanner();
            String bannerName = bannerUrl.substring(bannerUrl.lastIndexOf("/") + 1, bannerUrl.length());
            FileUtils.deleteFile(SECOND_BANNER_PATH + bannerName);

            //第一步：删除本地原先的indexImg图片
            String indexImgUrl = entity.getIndexImg();
            String indexImgName = indexImgUrl.substring(indexImgUrl.lastIndexOf("/") + 1, indexImgUrl.length());
            FileUtils.deleteFile(INDEX_IMG_PATH + indexImgName);
        }
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
     * 修改类型跳转
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String typeUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("goodsAllType", goodsAllTypeService.get(id));
        model.addAttribute("action", "update");
        return "goodsAllType/typeForm";
    }

    /**
     * 修改类型
     */
    @RequiresPermissions("bus:type:update")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@Valid @ModelAttribute("goodsAllType") GoodsAllTypeEntity goodsAllType, MultipartFile file1, MultipartFile file2) {
        //banner没有进行变化
        if(file1.isEmpty()){
            //还是原来的banner
            //goodsAllType.setBanner(goodsAllTypeService.get(goodsAllType.getId()).getBanner());
        }else{
            //banner已经改变
            Integer pid = goodsAllType.getPid();
            //修改的是一级类型的banner
            if(pid == null){
                //第一步：删除本地原先的一级类型banner图片
                String bannerUrl = goodsAllType.getBanner();
                String bannerName = bannerUrl.substring(bannerUrl.lastIndexOf("/") + 1, bannerUrl.length());
                FileUtils.deleteFile(BANNER_PATH + bannerName);
                //第二步：保存新的一级类型banner图片到本地
                String fileName = file1.getOriginalFilename();
                String suffix  = fileName.substring(fileName.lastIndexOf("."));

                String picName = goodsAllType.getName() + suffix;
                try {
                    FileUtils.uploadFile(file1.getBytes(), BANNER_PATH, picName);
                } catch (Exception e) {
                }
                //第三步：给类型对象设置新的banner地址
                goodsAllType.setBanner(BANNER_URL + picName);
            }else{
                //修改的是二级类型的banner
                //第一步：删除本地原先的二级类型banner图片
                String bannerUrl = goodsAllType.getBanner();
                String bannerName = bannerUrl.substring(bannerUrl.lastIndexOf("/") + 1, bannerUrl.length());
                FileUtils.deleteFile(SECOND_BANNER_PATH + bannerName);
                //第二步：保存新的二级类型banner图片到本地
                String fileName = file1.getOriginalFilename();
                String suffix  = fileName.substring(fileName.lastIndexOf("."));

                String picName = goodsAllType.getName() + suffix;
                try {
                    FileUtils.uploadFile(file1.getBytes(), SECOND_BANNER_PATH, picName);
                } catch (Exception e) {
                }
                //第三步：给类型对象设置新的banner地址
                goodsAllType.setBanner(SECOND_BANNER_URL + picName);
            }
        }

        if(file2.isEmpty()){
            //还是原来的indexImg
//            goodsAllType.setBanner(goodsAllTypeService.get(goodsAllType.getId()).getIndexImg());
        }else{
            //indexImg已经改变
            //第一步：删除本地原先的indexImg图片
            String indexImgUrl = goodsAllType.getIndexImg();
            String indexImgName = indexImgUrl.substring(indexImgUrl.lastIndexOf("/") + 1, indexImgUrl.length());
            FileUtils.deleteFile(INDEX_IMG_PATH + indexImgName);
            //第二步：保存新的indexImg图片到本地
            String fileName = file2.getOriginalFilename();
            String suffix  = fileName.substring(fileName.lastIndexOf("."));

            String picName = goodsAllType.getName() + suffix;
            try {
                FileUtils.uploadFile(file2.getBytes(), INDEX_IMG_PATH, picName);
            } catch (Exception e) {
            }
            //第三步：给类型对象设置新的indexImg地址
            goodsAllType.setIndexImg(INDEX_IMG_URL + picName);
        }
        goodsAllTypeService.update(goodsAllType);

        return "success";
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
                String fileName = file1.getOriginalFilename();
                String suffix  = fileName.substring(fileName.lastIndexOf("."));

                String picName = goodsAllType.getName() + suffix;
                System.out.println(picName);
                try {
                    FileUtils.uploadFile(file1.getBytes(), BANNER_PATH, picName);
                } catch (Exception e) {
                }
                goodsAllType.setBanner(BANNER_URL + picName);
            } else {//添加的是二级类型
                //1先添加二级类型的banner
                String fileName = file1.getOriginalFilename();
                String suffix  = fileName.substring(fileName.lastIndexOf("."));

                String picName = goodsAllType.getName() + suffix;
                try {
                    FileUtils.uploadFile(file1.getBytes(), SECOND_BANNER_PATH, picName);
                } catch (Exception e) {
                }
                goodsAllType.setBanner(SECOND_BANNER_URL + picName);

                //2再添加二级类型的indexImg
                String fileName2 = file2.getOriginalFilename();
                String suffix2  = fileName2.substring(fileName2.lastIndexOf("."));

                String picName2 = goodsAllType.getName() + suffix2;
                try {
                    FileUtils.uploadFile(file2.getBytes(), INDEX_IMG_PATH, picName2);
                } catch (Exception e) {
                }
                goodsAllType.setIndexImg(INDEX_IMG_URL + picName2);
            }
        }

        goodsAllTypeService.save(goodsAllType);

        return "success";
    }


    /**
     * 查看跳转
     */
    @RequestMapping(value = "look/{id}", method = RequestMethod.GET)
    public String look(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("goodsAllType", goodsAllTypeService.get(id));
        model.addAttribute("action", "look");
        return "goodsAllType/typeForm";
    }


}
