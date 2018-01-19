package backend.utils;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import org.hibernate.Session;
import java.util.List;

@SuppressWarnings("unchecked")
public class DataUtils {
    public List<AnimalsEntity> getAnimals(){
        List<AnimalsEntity> animals=null;
        try(Session session=Connections.getSession()){
            animals=session.createQuery("from AnimalsEntity ").list();
        }
        return animals;
    }
    public List<DrugsEntity> getDrugs(){
        List<DrugsEntity> drugs=null;
        try(Session session=Connections.getSession()){
            drugs=session.createQuery("from DrugsEntity ").list();
        }
        return drugs;
    }
//    public List<CollisionData> checkCollisions(List<DrugsEntity> drugs){
//        String query=
//        try(Session session=Connections.getSession()){
//            session.createQuery("select DrugsEntity,CollisionGroupsEntity .comment,CollisionSeveritiesEntity .severityText" +
//                    " from DosageCollisionsEntity join DrugsEntity on DosageCollisionsEntity .drugId=DrugsEntity .drugId " +
//                    "join CollisionGroupsEntity on DosageCollisionsEntity .collisionGroupId=CollisionSeveritiesEntity ")
//        }
//    }
}
