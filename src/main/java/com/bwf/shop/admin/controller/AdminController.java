package com.bwf.shop.admin.controller;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.service.IAdminService;
import com.bwf.shop.admin.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService  adminService;

    @Autowired
    private RoleService roleService;

    //员工管理页面
    @RequestMapping("/admin")
    public String admin(AdminSearchBo bo , Model model){
        //获取员工列表
        List<Admin> adminList = adminService.getAdminList(bo);

        //获取角色列表
        List<Role> roleList = roleService.getAllRoleList();

        model.addAttribute("adminList",adminList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("bo",bo);
        return "admin/admin";
    }

    //添加员工表单页面
    @RequestMapping("add")
    public  String add (Model model){
        List<Role> roleList = roleService.getAllRoleList();
        model.addAttribute("roleList",roleList);
        return  "admin/add";
    }

    //验证员工的账户名称是否已经存在
    @RequestMapping("/validAdminName")
    @ResponseBody
    public String validAdminName(String admin_name){
        Admin admin = adminService.getAdminByName(admin_name);
        return admin == null ?"1":"0";
    }

    //添加员工执行
    @RequestMapping("/save")
    public String save(AdminAddBo bo, Model model){
        Boolean result = adminService.addAdmin(bo);
        //判断员工是否添加成功
        if (result) {
            model.addAttribute("messages",new String[]{"员工添加执行成功"});
            model.addAttribute("back","/admin/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"员工添加执行失败"});
            model.addAttribute("solution","请联系管理员");
            model.addAttribute("back","/admin/add");
            return "common/error";
        }
    }

    //修改员工表单页面
    @RequestMapping("/update")
    public String update(Integer admin_id,Model model){
        // 根据id 查询要修改的员工
        Admin admin = adminService.getAdminById(admin_id);

        // 获取所有角色
        List<Role> roleList = roleService.getAllRoleList();
        model.addAttribute("roleList",roleList);
        model.addAttribute("admin",admin);
        return "admin/update";

    }


    //修改员工执行
    @RequestMapping("/alter")
    public String alter(AdminUpdateBo bo, Model model){
        Boolean result = adminService.updateAdmin(bo);
        //判断员工是否修改成功
        if (result) {
            model.addAttribute("messages",new String[]{"员工修改执行成功"});
            model.addAttribute("back","/admin/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"员工修改执行失败"});
            model.addAttribute("solution","请联系管理员");
            model.addAttribute("back","/admin/admin");
            return "common/error";
        }
    }

    //删除员工
    @RequestMapping("delete")
    public String delete (Integer admin_id,Integer [] ids, Model model){

        Boolean result=false;
        if (admin_id != null) {
            result= adminService.deleteOne(admin_id);
        }

        if (ids!= null) {
            result= adminService.deleteList(ids);
        }

        //判断员工是否修改成功
        if (result) {
            model.addAttribute("messages",new String[]{"员工删除执行成功"});
            model.addAttribute("back","/admin/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"员工删除执行失败"});
            model.addAttribute("solution","请联系管理员");
            model.addAttribute("back","/admin/admin");
            return "common/error";
        }
    }
}
