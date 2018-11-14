package com.tianyu.jty.business.controller;

import com.tianyu.jty.business.entity.MiniUserEntity;
import com.tianyu.jty.business.service.MiniUserService;
import com.tianyu.jty.common.persistence.Page;
import com.tianyu.jty.common.persistence.PropertyFilter;
import com.tianyu.jty.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("business/miniUser")
public class MiniUserController extends BaseController {

    @Autowired
    private MiniUserService miniUserService;

    /**
     * 默认页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list() {

        return "miniUser/miniUserList";
    }


    /**
     * 获取小程序用户json
     */
    @RequestMapping(value="json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getData(HttpServletRequest request) {
        Page<MiniUserEntity> page = getPage(request);
        List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
        page = miniUserService.search(page, filters);
        return getEasyUIData(page);
    }

}
