package com.example.searchfile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class FilesController {
    @Autowired
    FilesService filesService;

    @RequestMapping("/scan")
    @ResponseBody
    public FilesFolder check() throws IOException {
       return filesService.businessLogic( );
    }


    @RequestMapping("/search")
    @ResponseBody
    public Object find()
    {
        List<FilesFolder> ff= filesService.findALl();
        if(ff!=null && ff.size()!=0)
        {
            return ff;
        }else{
            return "nodataexist";
        }
    }
    @RequestMapping("/search/name/{filename}")
    @ResponseBody
    public Object findbyname(@PathVariable(name="filename") String  filename) throws Exception {
        List<FileName> fn= filesService.findByName(filename);
        if(fn!=null && fn.size()!=0)
        {
            return fn;
        }else{
            return "nodataexist";
        }
    }
    @RequestMapping("/search/type/{filetype}")
    @ResponseBody
    public Object findbytype(@PathVariable(name="filetype") String  filetype)throws Exception
    {
       List<FileExtension> fe= filesService.findByType(filetype);
        if(fe!=null && fe.size()!=0)
        {
            return fe;
        }else{
            return "nodataexist";
        }
    }
    @RequestMapping("/search/metadata")
    public ModelAndView getAllDetails()throws Exception
    {
        ModelAndView mv = new ModelAndView("search");
        ModelAndView mv1 = new ModelAndView("nodata");
        List<FilesFolder> ff=filesService.findALl();
        if(ff!=null) {
            mv.addObject("allDetails", ff);
            return mv;
        }else
        {
            return mv1;
        }
    }

    @RequestMapping("/search/metadatasearch")
    public  String metadatasearch(@RequestParam(value = "keyword",required = false) String keyword, Model model)throws Exception
    {
       List<FileName> fn=filesService.findByName(keyword);
       if(fn!=null && fn.size()!=0) {
           model.addAttribute("allDetails", fn);
           return "view";
       }else
       {
         //  model.addAttribute("allDetails", fn);
           return "nodata";
       }
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }


    @ExceptionHandler({Exception.class})
    public String handleException() {
        return "bad_request";
    }


}
