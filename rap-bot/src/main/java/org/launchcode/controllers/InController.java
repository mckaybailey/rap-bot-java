package org.launchcode.controllers;

import org.launchcode.models.data.BlogDao;
import org.launchcode.models.forms.Blog;
import org.launchcode.models.forms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("in")
public class InController {
    @Autowired
    private org.launchcode.models.data.UserDao userDao;

    @Autowired
    private BlogDao blogDao;

    @RequestMapping(value = "blog", method = RequestMethod.GET)
    public String thesong(Model model, @RequestParam("id") int blog_id){
        Blog theblog = blogDao.findOne(blog_id);
        model.addAttribute("blog",theblog);
        return "loggedin/rapbot";

    }
    @RequestMapping(value = "blog", method = RequestMethod.POST)
    public String thesongp(Model model, @RequestParam String blog_id, @RequestParam String blog){
        int id = Integer.valueOf(blog_id);
        Blog theblog = blogDao.findOne(id);
        theblog.setDescription(blog);
        blogDao.save(theblog);
        int pathid = theblog.getId();
        return "redirect:/in/blog?id="+pathid;

    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showsongs(@RequestParam("id") int owner_id, Model model){
        model.addAttribute("title", "songs page");
        List<Blog> allblogs = (List<Blog>) blogDao.findAll();
        List<Blog> userblogs = new ArrayList();
        for(Blog ind : allblogs){
            if(ind.getOwner_id()== owner_id){
                userblogs.add(ind);
            }
        }
        model.addAttribute(new Blog());
        model.addAttribute("blogs",userblogs);
        model.addAttribute("owner", owner_id);
        return"loggedin/main";
    }
    @RequestMapping(value = "newsong", method = RequestMethod.GET)
    public String newsongs(@RequestParam("id") int owner_id, Model model){
        model.addAttribute("title", "songs page");
        Blog newblog = new Blog("new song", "the body",owner_id);
        blogDao.save(newblog);
        List<Blog> allblogs = (List<Blog>) blogDao.findAll();
        List<Blog> userblogs = new ArrayList();
        for(Blog ind : allblogs){
            if(ind.getOwner_id()== owner_id){
                userblogs.add(ind);
            }
        }
        model.addAttribute(new Blog());
        model.addAttribute("blogs",userblogs);
        model.addAttribute("owner", owner_id);
        return"loggedin/main";
    }
    @RequestMapping(value = "delete-task", method = RequestMethod.POST)
    public String delete(Model model, @RequestParam String blogids, @RequestParam int owner_id){
        Integer numberv = Integer.valueOf(blogids);
        Blog deletedb = blogDao.findOne(numberv);
        blogDao.delete(deletedb);
        return "redirect:?id="+owner_id;
    }
    @RequestMapping(value = "change_name", method = RequestMethod.POST)
    public String changename(Model model, @RequestParam String title, @RequestParam String blogid, @RequestParam String owner_id){
        Integer numberv = Integer.valueOf(blogid);
        Integer Id = Integer.valueOf(owner_id);
        Blog changedb = blogDao.findOne(numberv);
        changedb.setName(title);
        blogDao.save(changedb);
        return "redirect:?id="+Id;
    }
}
