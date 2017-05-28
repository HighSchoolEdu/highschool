package com.highschool.web;
import com.highschool.entity.HighSchool;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/highschools")
@Controller
@RooWebScaffold(path = "highschools", formBackingObject = HighSchool.class)
public class HighSchoolController {


    @RequestMapping(value = "/listForm", produces = "text/html")
    public String listConditionForm(@RequestParam(value = "category", required = false) String category, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        List<String> listString=HighSchool.findHighSchoolByCondition();
        for(String str:listString){
            System.out.println("str"+str);
        }
        Map<String,String> stringList=new HashMap<String,String>();
        stringList.put("earObstacle","視覺障礙");
        stringList.put("listenObstacle","聽語障礙");
        stringList.put("lambBrainObstacle","肢障腦麻病弱");
        stringList.put("emotionObstacle","情緒行為障礙");
        stringList.put("learnObstacle","學習障礙");
        stringList.put("autism","自閉症");
        stringList.put("otherObstacle","其他障礙");
        stringList.put("normal","不分類");
        uiModel.addAttribute("obstacles",stringList);
        uiModel.addAttribute("categorys",listString);

        return "highschools/listForm";
    }


    @RequestMapping(value = "/listResult",produces = "text/html",method = {RequestMethod.POST,RequestMethod.GET})
    public String listCondition(@RequestParam(value = "category", required = false) String category,@RequestParam(value = "obstacle", required = false) String obstacle, Model uiModel) {

            System.out.println("obstacle : "+obstacle);
            List<HighSchool> highSchools=HighSchool.findHighSchoolByCondition(category,obstacle);

            uiModel.addAttribute("highschools", highSchools);

        return "highschools/listOb";
    }


}
