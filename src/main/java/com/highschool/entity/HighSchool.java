package com.highschool.entity;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Query;
import java.util.List;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "HighSchool")
@RooDbManaged(automaticallyDelete = true)
public class HighSchool {

    public static List<String> findHighSchoolByCondition() {
        String jpaQuery = "SELECT o.category FROM HighSchool o group by o.category";
        return (List<String>) entityManager().createQuery(jpaQuery).getResultList();
    }

    public static List<HighSchool> findHighSchoolByCondition(String category,String obstacle) {
        String jpaQuery = "SELECT o FROM HighSchool o where 1=1 ";

        if(!"".equals(category) && category!=null) {
            jpaQuery = jpaQuery + " and o.category=:category ";
        }


        if(!"".equals(obstacle) && obstacle!=null) {
            if("earObstacle".equals(obstacle.trim())){
                 jpaQuery = jpaQuery + " and o.earObstacle !=0 and o.earObstacle !=null ";
            }else if("listenObstacle".equals(obstacle.trim())) {
                jpaQuery = jpaQuery + " and o.listenObstacle !=0 and o.listenObstacle !=null ";
            }else if("lambBrainObstacle".equals(obstacle.trim())){
                jpaQuery = jpaQuery + " and o.lambBrainObstacle !=0 and o.lambBrainObstacle !=null ";
            }else if("emotionObstacle".equals(obstacle.trim())) {
                jpaQuery = jpaQuery + " and o.emotionObstacle !=0 and o.emotionObstacle !=null ";
            }else if("learnObstacle".equals(obstacle.trim())){
                jpaQuery = jpaQuery + " and o.learnObstacle !=0 and o.learnObstacle !=null ";
            }else if("autism".equals(obstacle.trim())){
                jpaQuery = jpaQuery + " and o.autism !=0 and o.autism !=null ";
            }else if("otherObstacle".equals(obstacle.trim())){
                jpaQuery = jpaQuery + " and o.otherObstacle !=0 and o.otherObstacle !=null ";
            }else if("normal".equals(obstacle.trim())){
                jpaQuery = jpaQuery + " and o.noCategory !=0 and o.noCategory !=null ";
            }

        }


        Query query=entityManager().createQuery(jpaQuery);
        if(!"".equals(category) && category!=null) {
            query.setParameter("category", category);
        }



        return (List<HighSchool>) query.getResultList();
    }
}
