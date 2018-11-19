package com.tianyu.jty.business.controller;

import com.alibaba.fastjson.JSONArray;
import com.tianyu.jty.business.entity.GoodsAllTypeEntity;
import com.tianyu.jty.business.entity.GoodsEntity;
import com.tianyu.jty.business.service.GoodsAllTypeService;
import com.tianyu.jty.business.service.GoodsService;
import com.tianyu.jty.common.persistence.Page;
import com.tianyu.jty.common.persistence.PropertyFilter;
import com.tianyu.jty.common.utils.FileUtils;
import com.tianyu.jty.common.web.BaseController;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("business/goods")
public class GoodsController extends BaseController {

    private static String BASE_PATH = "E://all_images/goods/";
    private static String BASE_URL = "http://192.168.1.205:8080/goods/";

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsAllTypeService goodsAllTypeService;


    /**
     * 默认页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list() {
        return "goods/goodsList";
    }


    /**
     * 获取所有商品
     */
    @RequestMapping(value="json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getData(HttpServletRequest request){
        Page<GoodsEntity> page = getPage(request);
        List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
        page = goodsService.search(page, filters);
        return getEasyUIData(page);
    }


    /**
     * 添加商品跳转
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String goodsCreateForm(Model model) {
        model.addAttribute("goods", new GoodsEntity());
        model.addAttribute("action", "create");
        return "goods/goodsForm";
    }


    /**
     * 添加商品
     */
    @RequiresPermissions("bus:goods:add")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@Valid GoodsEntity goods, @RequestParam MultipartFile file1, @RequestParam MultipartFile[] file2,
                         @RequestParam MultipartFile file3, @RequestParam MultipartFile[] file4, @RequestParam MultipartFile[] file5) {
        //将页面传过来的商品规格格式化为jsonarray格式
        String spec = goods.getGoodsSpec();
        String[] array = spec.split(",");
        JSONArray specArray = new JSONArray();
        for (int i = 0; i < array.length; i++){
            specArray.add(array[i]);
        }
        goods.setGoodsSpec(specArray.toJSONString());

        //将页面传过来的商品价格格式化为jsonarray格式
        String price = goods.getGoodsPrice();
        String[] arr = price.split(",");
        JSONArray priceArray = new JSONArray();
        for (int j = 0; j < arr.length; j++){
            priceArray.add(arr[j]);
        }
        goods.setGoodsPrice(priceArray.toJSONString());

        //去查该商品属于哪个一级商品类型
        String secondTypeId=  goods.getGoodsSecondTypeId();
        GoodsAllTypeEntity secondType = goodsAllTypeService.get(Integer.valueOf(secondTypeId));
        String firstTypeName = goodsAllTypeService.get(secondType.getPid()).getName();

        //拼接图片存储的路径
        //E://all_images/goods/海产品/鱿鱼系列/手撕鱿鱼/
        StringBuffer filePath = new StringBuffer();
        filePath.append(BASE_PATH);
        filePath.append(firstTypeName);
        filePath.append("/");
        filePath.append(secondType.getName());
        filePath.append("/");
        filePath.append(goods.getGoodsName());
        filePath.append("/");

        //图片访问地址
        //http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/
        StringBuffer urlPath = new StringBuffer();
        urlPath.append(BASE_URL);
        urlPath.append(firstTypeName);
        urlPath.append("/");
        urlPath.append(secondType.getName());
        urlPath.append("/");
        urlPath.append(goods.getGoodsName());
        urlPath.append("/");

        //开始--保存商品首页图片
        String fileName1 = file1.getOriginalFilename();
        String suffix1  = fileName1.substring(fileName1.lastIndexOf("."));

        String goodsIndexImg = "首页" + suffix1;

        try {
            FileUtils.uploadFile(file1.getBytes(), filePath.toString(), goodsIndexImg);
        } catch (Exception e) {
        }
        goods.setGoodsIndexImg(urlPath.toString() + goodsIndexImg);
        //结束--保存商品首页图片


        //开始--保存商品介绍图片
        String fileName3 = file3.getOriginalFilename();
        String suffix3  = fileName3.substring(fileName3.lastIndexOf("."));

        String goodsIntroduce = "介绍" + suffix3;

        try {
            FileUtils.uploadFile(file3.getBytes(), filePath.toString(), goodsIntroduce);
        } catch (Exception e) {
        }
        goods.setGoodsIntroduce(urlPath.toString() + goodsIntroduce);
        //结束--保存商品介绍图片

        //开始--保存商品轮播图
        JSONArray imgArray = new JSONArray();
        for(int k = 1; k <= file2.length; k++){
            MultipartFile file = file2[k-1];
            String fileName2 = file.getOriginalFilename();
            String suffix2 = fileName2.substring(fileName2.lastIndexOf("."));
            String goodsImg = k + suffix2;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath.toString(), goodsImg);
            } catch (Exception e) {
            }
            imgArray.add(urlPath.toString() + goodsImg);
        }
        String imgArrayToString = imgArray.toString().replace("\\","");
        goods.setGoodsImgs(imgArrayToString);
        //结束--保存商品轮播图

        //开始--保存商品详情图
        JSONArray introduceImgsArray = new JSONArray();
        for(int k = 1; k <= file4.length; k++){
            MultipartFile file = file4[k-1];
            String fileName4 = file.getOriginalFilename();
            String suffix4 = fileName4.substring(fileName4.lastIndexOf("."));
            String introduceImg = "详情" + k + suffix4;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath.toString(), introduceImg);
            } catch (Exception e) {
            }
            introduceImgsArray.add(urlPath.toString() + introduceImg);
        }
        String introduceImgsArrayToString = introduceImgsArray.toString().replace("\\","");
        goods.setGoodsIntroduceImgs(introduceImgsArrayToString);
        //结束--保存商品详情图

        //开始--保存商品实拍图
        JSONArray realImgsArray = new JSONArray();
        for(int k = 1; k <= file5.length; k++){
            MultipartFile file = file5[k-1];
            String fileName5 = file.getOriginalFilename();
            String suffix5 = fileName5.substring(fileName5.lastIndexOf("."));
            String realImg = "实拍" + k + suffix5;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath.toString(), realImg);
            } catch (Exception e) {
            }
            realImgsArray.add(urlPath.toString() + realImg);
        }
        String realImgsArrayToString = realImgsArray.toString().replace("\\","");
        goods.setGoodsRealImgs(realImgsArrayToString);
        //结束--保存商品实拍图
        goodsService.save(goods);
        return "success";
    }


    /**
     * 删除
     */
    @RequiresPermissions("bus:goods:delete")
    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id) throws Exception{
        GoodsEntity goods = goodsService.get(id);
        String secondTypeId=  goods.getGoodsSecondTypeId();
        GoodsAllTypeEntity secondType = goodsAllTypeService.get(Integer.valueOf(secondTypeId));
        String firstTypeName = goodsAllTypeService.get(secondType.getPid()).getName();
        //拼接存储了商品图片的目录
        //E://all_images/goods/海产品/鱿鱼系列/手撕鱿鱼/
        StringBuffer filePath = new StringBuffer();
        filePath.append(BASE_PATH);
        filePath.append(firstTypeName);
        filePath.append("/");
        filePath.append(secondType.getName());
        filePath.append("/");
        filePath.append(goods.getGoodsName());
        filePath.append("/");

        FileUtils.deleteDirectory(filePath.toString());

        goodsService.delete(id);
        return "success";
    }


    /**
     * 修改商品跳转
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String goodsUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("goods", goodsService.get(id));
        model.addAttribute("action", "update");
        return "goods/goodsForm";
    }


    /**
     * 修改商品
     */
    @RequiresPermissions("bus:goods:update")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@Valid @ModelAttribute("goods") GoodsEntity goods, @RequestParam MultipartFile file1, @RequestParam MultipartFile[] file2,
                         @RequestParam MultipartFile file3, @RequestParam MultipartFile[] file4, @RequestParam MultipartFile[] file5) throws Exception{
        //将html传过来的引号还原
        String goodsPrice = StringEscapeUtils.unescapeHtml4(goods.getGoodsPrice());
        String goodsSpec = StringEscapeUtils.unescapeHtml4(goods.getGoodsSpec());
        goods.setGoodsPrice(goodsPrice);
        goods.setGoodsSpec(goodsSpec);

        //去查该商品属于哪个一级商品类型
        String secondTypeId=  goods.getGoodsSecondTypeId();
        GoodsAllTypeEntity secondType = goodsAllTypeService.get(Integer.valueOf(secondTypeId));
        String firstTypeName = goodsAllTypeService.get(secondType.getPid()).getName();

        //拼接图片存储的路径
        //E://all_images/goods/海产品/鱿鱼系列/手撕鱿鱼/
        StringBuffer filePath = new StringBuffer();
        filePath.append(BASE_PATH);
        filePath.append(firstTypeName);
        filePath.append("/");
        filePath.append(secondType.getName());
        filePath.append("/");
        filePath.append(goods.getGoodsName());
        filePath.append("/");

        //图片访问地址
        //http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/
        StringBuffer urlPath = new StringBuffer();
        urlPath.append(BASE_URL);
        urlPath.append(firstTypeName);
        urlPath.append("/");
        urlPath.append(secondType.getName());
        urlPath.append("/");
        urlPath.append(goods.getGoodsName());
        urlPath.append("/");

        //开始--保存商品首页图片
        if(!file1.isEmpty()){
            //第一步：删除原有图片
            String index_img_path_before = goods.getGoodsIndexImg();
            String index_img_name_before = index_img_path_before.substring(index_img_path_before.lastIndexOf("/")+1,index_img_path_before.length());
            FileUtils.deleteFile(filePath.toString() + index_img_name_before);

            //第二步：保存
            String fileName1 = file1.getOriginalFilename();
            String suffix1  = fileName1.substring(fileName1.lastIndexOf("."));

            String goodsIndexImg = "首页" + suffix1;

            try {
                FileUtils.uploadFile(file1.getBytes(), filePath.toString(), goodsIndexImg);
            } catch (Exception e) {
            }
            goods.setGoodsIndexImg(urlPath.toString() + goodsIndexImg);
        }
        //结束--保存商品首页图片


        //开始--保存商品介绍图片
        if(!file3.isEmpty()){
            //第一步：删除原有图片
            String index_introduce_path_before = goods.getGoodsIntroduce();
            String index_introduce_name_before = index_introduce_path_before.substring(index_introduce_path_before.lastIndexOf("/")+1,index_introduce_path_before.length());
            FileUtils.deleteFile(filePath.toString() + index_introduce_name_before);

            //第二步：保存
            String fileName3 = file3.getOriginalFilename();
            String suffix3  = fileName3.substring(fileName3.lastIndexOf("."));

            String goodsIntroduce = "介绍" + suffix3;

            try {
                FileUtils.uploadFile(file3.getBytes(), filePath.toString(), goodsIntroduce);
            } catch (Exception e) {
            }
            goods.setGoodsIntroduce(urlPath.toString() + goodsIntroduce);
        }
        //结束--保存商品介绍图片

        //开始--保存商品轮播图
        if(!file2[0].isEmpty()){
            //第一步：删除原有图片
            JSONArray beforeImgs = JSONArray.parseArray(StringEscapeUtils.unescapeHtml4(goods.getGoodsImgs()));
            for(int i = 0; i < beforeImgs.size(); i++){
                String path = beforeImgs.get(i).toString();
                String name = path.substring(path.lastIndexOf("/")+1,path.length());
                FileUtils.deleteFile(filePath.toString() + name);
            }

            //第二步：保存
            JSONArray imgArray = new JSONArray();
            for(int k = 1; k <= file2.length; k++){
                MultipartFile file = file2[k-1];
                String fileName2 = file.getOriginalFilename();
                String suffix2 = fileName2.substring(fileName2.lastIndexOf("."));
                String goodsImg = k + suffix2;
                try {
                    FileUtils.uploadFile(file.getBytes(), filePath.toString(), goodsImg);
                } catch (Exception e) {
                }
                imgArray.add(urlPath.toString() + goodsImg);
            }
            String imgArrayToString = imgArray.toString().replace("\\","");
            goods.setGoodsImgs(imgArrayToString);
        }else{
            //还原html传过来的引号
            String goods_imgs = StringEscapeUtils.unescapeHtml4(goods.getGoodsImgs());
            goods.setGoodsImgs(goods_imgs);
        }
        //结束--保存商品轮播图

        //开始--保存商品详情图
        if(!file4[0].isEmpty()){
            //第一步：删除原有图片
            JSONArray beforeImgs = JSONArray.parseArray(StringEscapeUtils.unescapeHtml4(goods.getGoodsIntroduceImgs()));
            for(int i = 0; i < beforeImgs.size(); i++){
                String path = beforeImgs.get(i).toString();
                String name = path.substring(path.lastIndexOf("/")+1,path.length());
                FileUtils.deleteFile(filePath.toString() + name);
            }

            //第二步：保存
            JSONArray introduceImgsArray = new JSONArray();
            for(int k = 1; k <= file4.length; k++){
                MultipartFile file = file4[k-1];
                String fileName4 = file.getOriginalFilename();
                String suffix4 = fileName4.substring(fileName4.lastIndexOf("."));
                String introduceImg = "详情" + k + suffix4;
                try {
                    FileUtils.uploadFile(file.getBytes(), filePath.toString(), introduceImg);
                } catch (Exception e) {
                }
                introduceImgsArray.add(urlPath.toString() + introduceImg);
            }
            String introduceImgsArrayToString = introduceImgsArray.toString().replace("\\","");
            goods.setGoodsIntroduceImgs(introduceImgsArrayToString);
        }else{
            //还原html传过来的引号
            String goods_introduce_imgs = StringEscapeUtils.unescapeHtml4(goods.getGoodsIntroduceImgs());
            goods.setGoodsIntroduceImgs(goods_introduce_imgs);
        }
        //结束--保存商品详情图

        //开始--保存商品实拍图
        if(!file5[0].isEmpty()){
            //第一步：删除原有图片
            JSONArray beforeImgs = JSONArray.parseArray(StringEscapeUtils.unescapeHtml4(goods.getGoodsRealImgs()));
            for(int i = 0; i < beforeImgs.size(); i++){
                String path = beforeImgs.get(i).toString();
                String name = path.substring(path.lastIndexOf("/")+1,path.length());
                FileUtils.deleteFile(filePath.toString() + name);
            }

            //第二步：保存
            JSONArray realImgsArray = new JSONArray();
            for(int k = 1; k <= file5.length; k++){
                MultipartFile file = file5[k-1];
                String fileName5 = file.getOriginalFilename();
                String suffix5 = fileName5.substring(fileName5.lastIndexOf("."));
                String realImg = "实拍" + k + suffix5;
                try {
                    FileUtils.uploadFile(file.getBytes(), filePath.toString(), realImg);
                } catch (Exception e) {
                }
                realImgsArray.add(urlPath.toString() + realImg);
            }
            String realImgsArrayToString = realImgsArray.toString().replace("\\","");
            goods.setGoodsRealImgs(realImgsArrayToString);
        }else {
            //还原html传过来的引号
            String goods_real_imgs = StringEscapeUtils.unescapeHtml4(goods.getGoodsRealImgs());
            goods.setGoodsRealImgs(goods_real_imgs);
        }
        //结束--保存商品实拍图

        goodsService.update(goods);

        return "success";
    }

}
